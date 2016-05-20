package com.oldenweb;

import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Joint;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;
import com.badlogic.gdx.utils.SnapshotArray;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

// Class
public class Main extends ApplicationAdapter {
	// const
	static final float SCREEN_WIDTH = 1920; // default screen width
	static final float SCREEN_HEIGHT = 1440; // default screen height
	static final float PPM = 32; // pixels per meter in Box2D world
	final boolean SHOW_DEBUG = false; // show debug
	final float CAMERA_OFFSET_X = 0; // camera offset left
	final float CAMERA_OFFSET_Y = 0; // camera offset top
	final float BRIGHTNESS_PRESSED = 0.9f; // button brightness when pressed
	final float HERO_MOVE_SPEED = 10; // hero move speed
	final float HERO_ANIMATION_SPEED = 0.006f; // hero animation speed
	final float JUMP_POWER = 17; // orange jump power
	final int ORANGES_LIMIT = 10; // max number of oranges to game over
	final float ADD_INTERVAL = 1.5f; // time interval to add a new orange

	// vars
	static Stage stage;
	static World world;
	static AssetManager assetManager;
	static InputListener controlListener;
	static float ratio;
	static Array<Body> destroyBodies;
	static Array<Joint> destroyJoints;
	OrthographicCamera cam;
	JsonValue map;
	float mapWidth;
	float mapHeight;
	boolean keyUp;
	boolean keyLeft;
	boolean keyRight;
	boolean isSigned;
	Preferences pref;
	Box2DDebugRenderer debug;
	String screenColor;
	SpriteBatch batch;
	int currentWidth;
	int currentHeight;
	Viewport viewport;
	InterfaceListener nativePlatform;
	float taskDelay;
	Music sndBg;
	boolean gamePaused;
	Act controlLeft;
	Act controlRight;
	Act btnSignIn;
	Act btnSignOut;
	Act btnSound;
	Act btnMute;
	Act btnPause;
	Group groupPause;
	int score;
	String screen = ""; // screen

	Act hero;
	Act basket;
	Act hit;
	Act txtScore;
	Group groupGameOver;
	TextureAtlas numbers;
	Array<Act> clouds;
	Animation heroAnimation;
	int numOranges;

	// Constructor
	public Main(InterfaceListener nativePlatform) {
		this.nativePlatform = nativePlatform;
	}

	@Override
	public void create() {
		batch = new SpriteBatch();
		controlListener = new CONTROL();
		destroyBodies = new Array<Body>();
		destroyJoints = new Array<Joint>();
		currentWidth = Gdx.graphics.getWidth();
		currentHeight = Gdx.graphics.getHeight();
		assetManager = new AssetManager();
		Gdx.input.setCatchBackKey(true); // prevent back on mobile

		// load assets
		Lib.loadAssets(false);

		// debug
		if (SHOW_DEBUG)
			debug = new Box2DDebugRenderer();

		// preferences
		pref = Gdx.app.getPreferences("preferences");

		// send score
		if (pref.contains("score"))
			nativePlatform.saveScore(pref.getInteger("score"));

		// camera & viewport
		cam = new OrthographicCamera(SCREEN_WIDTH / PPM, SCREEN_HEIGHT / PPM);
		viewport = new FillViewport(SCREEN_WIDTH, SCREEN_HEIGHT);

		// world
		world = new World(new Vector2(0, -10f), true);
		world.setContactListener(new CONTACT());

		// stage
		stage = new Stage(viewport, batch);
		Gdx.input.setInputProcessor(stage);

		// sound bg
		sndBg = assetManager.get("sndBg.mp3", Music.class);
		bgSound();

		// numbers
		numbers = assetManager.get("number.atlas", TextureAtlas.class);

		// heroAnimation
		heroAnimation = new Animation(HERO_ANIMATION_SPEED, assetManager.get("hero.atlas", TextureAtlas.class).getRegions(),
				PlayMode.LOOP);

		showScreen("main");
	}

	// showScreen
	void showScreen(String screen) {
		clearScreen();
		this.screen = screen;

		if (screen.equals("main")) { // MAIN
			// load screen
			map = new JsonReader().parse(Gdx.files.internal(screen + ".hmp"));
			Lib.addLayer(null, map, stage.getRoot());

			// clouds
			clouds = Lib.getActors("cloud", stage.getRoot());
			for (int i = 0; i < clouds.size; i++)
				clouds.get(i).body.setLinearVelocity((float) (-0.1f - Math.random() * 0.9f), 0);

			// sign buttons
			btnSignIn = Lib.getActors("btnSignIn", stage.getRoot()).first();
			btnSignOut = Lib.getActors("btnSignOut", stage.getRoot()).first();
			setSigned(isSigned);

			// sound buttons
			btnSound = Lib.getActors("btnSound", stage.getRoot()).first();
			btnMute = Lib.getActors("btnMute", stage.getRoot()).first();
			if (pref.getBoolean("mute", false)) {
				btnMute.setVisible(false);
				btnSound.setVisible(true);
			} else {
				btnSound.setVisible(false);
				btnMute.setVisible(true);
			}
		} else if (screen.equals("game")) { // GAME
			// load screen
			map = new JsonReader().parse(Gdx.files.internal("game.hmp"));
			Timer.schedule(TIMER, 1, ADD_INTERVAL);

			// sky
			Lib.addLayer("sky", map, stage.getRoot());

			// clouds
			clouds = Lib.addLayer("cloud", map, stage.getRoot());
			for (int i = 0; i < clouds.size; i++)
				clouds.get(i).body.setLinearVelocity((float) (-0.1f - Math.random() * 0.9f), 0);

			// platform
			Lib.addLayer("platform", map, stage.getRoot());

			// hero
			hero = Lib.addLayer("hero", map, stage.getRoot()).first();
			hero.animation = heroAnimation;

			// basket
			basket = Lib.addLayer("basket", map, stage.getRoot()).first();

			// hit
			hit = Lib.addLayer("hit", map, stage.getRoot()).first();

			// txtScore
			txtScore = Lib.addLayer("score", map, stage.getRoot()).first();

			// controls
			controlLeft = Lib.addLayer("controlLeft", map, stage.getRoot()).first();
			controlRight = Lib.addLayer("controlRight", map, stage.getRoot()).first();
			btnPause = Lib.addLayer("btnPause", map, stage.getRoot()).first();

			// groupGameOver
			groupGameOver = Lib.addGroup("groupGameOver", map, stage.getRoot());

			// groupPause
			groupPause = Lib.addGroup("groupPause", map, stage.getRoot());
			btnSound = groupPause.findActor("btnSoundPause");
			btnMute = groupPause.findActor("btnMutePause");
			if (pref.getBoolean("mute", false)) {
				btnMute.setVisible(false);
				btnSound.setVisible(true);
			} else {
				btnSound.setVisible(false);
				btnMute.setVisible(true);
			}

			// controls animation
			controlLeft.addAction(Actions.sequence(Actions.delay(3), Actions.alpha(0, 1)));
			controlRight.addAction(Actions.sequence(Actions.delay(3), Actions.alpha(0, 1)));
		}

		// map config
		mapWidth = map.getInt("map_width", 0);
		mapHeight = map.getInt("map_height", 0);
		screenColor = map.getString("map_color", null);

		// stage keyboard focus
		Act a = new Act("");
		stage.addActor(a);
		a.addListener(controlListener);
		stage.setKeyboardFocus(a);

		render();
	}

	// clearScreen
	void clearScreen() {
		screen = "";
		screenColor = null;
		gamePaused = false;
		keyUp = false;
		keyLeft = false;
		keyRight = false;
		score = 0;
		numOranges = 0;
		TIMER.cancel();

		// clear world
		if (world != null) {
			world.clearForces();
			world.getJoints(destroyJoints);
			world.getBodies(destroyBodies);
		}
		render();

		// clear stage
		stage.clear();
	}

	@Override
	public void render() {
		// screen color
		if (screenColor != null) {
			Color color = Color.valueOf(screenColor);
			Gdx.gl.glClearColor(color.r, color.g, color.b, 1);
		}

		// clear
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		// current screen render
		if (screen.equals("game"))
			renderGame();
		else if (!screen.isEmpty()) {
			// camera position
			stage.getRoot().setPosition((SCREEN_WIDTH - mapWidth) * 0.5f, (SCREEN_HEIGHT - mapHeight) * 0.5f);
			cam.position.set((SCREEN_WIDTH * 0.5f - stage.getRoot().getX()) / PPM,
					(SCREEN_HEIGHT * 0.5f - stage.getRoot().getY()) / PPM, 0);
			cam.update();

			// world render
			world.step(1 / 30f, 8, 3);

			// stage render
			stage.act(Gdx.graphics.getDeltaTime());
			stage.draw();

			// clouds
			for (int i = 0; i < clouds.size; i++)
				if (clouds.get(i).body.getPosition().x * PPM < -clouds.get(i).getWidth() * 0.5f) {
					clouds.get(i).body.setTransform((mapWidth + clouds.get(i).getWidth() * 0.5f) / PPM,
							clouds.get(i).body.getPosition().y, clouds.get(i).body.getAngle());
					clouds.get(i).body.setLinearVelocity((float) (-0.1f - Math.random() * 0.9f), 0);
				}
		}

		// destroy
		if (!world.isLocked()) {
			for (int i = 0; i < destroyJoints.size; i++)
				world.destroyJoint(destroyJoints.get(i));
			for (int i = 0; i < destroyBodies.size; i++)
				world.destroyBody(destroyBodies.get(i));
			destroyJoints.clear();
			destroyBodies.clear();
		}

		// debug render
		if (SHOW_DEBUG)
			debug.render(world, cam.combined);
	}

	// renderGame
	void renderGame() {
		if (!gamePaused) {
			Vector2 point = null;

			// groups
			groupPause.setPosition(-stage.getRoot().getX(), -stage.getRoot().getY());
			groupGameOver.setPosition(-stage.getRoot().getX(), -stage.getRoot().getY());

			// controlLeft
			point = stage.screenToStageCoordinates(new Vector2(0, Gdx.graphics.getHeight()));
			controlLeft.setPosition(point.x - stage.getRoot().getX(), point.y - stage.getRoot().getY());

			// controlRight
			point = stage.screenToStageCoordinates(new Vector2(Gdx.graphics.getWidth() - controlRight.getWidth() * ratio,
					Gdx.graphics.getHeight()));
			controlRight.setPosition(point.x - stage.getRoot().getX(), point.y - stage.getRoot().getY());

			// btnPause
			point = stage.screenToStageCoordinates(new Vector2(Gdx.graphics.getWidth() - (btnPause.getWidth() + 20) * ratio,
					(btnPause.getHeight() + 20) * ratio));
			btnPause.setPosition(point.x - stage.getRoot().getX(), point.y - stage.getRoot().getY());

			// clouds
			for (int i = 0; i < clouds.size; i++)
				if (clouds.get(i).body.getPosition().x * PPM < -clouds.get(i).getWidth() * 0.5f) {
					clouds.get(i).body.setTransform((mapWidth + clouds.get(i).getWidth() * 0.5f) / PPM,
							clouds.get(i).body.getPosition().y, clouds.get(i).body.getAngle());
					clouds.get(i).body.setLinearVelocity((float) (-0.1f - Math.random() * 0.9f), 0);
				}

			// txtScore
			txtScore.setY(txtScore.getY() + 10f);
			txtScore.setScale(txtScore.getScaleX() + 0.01f);
			txtScore.setAlpha(Math.max(txtScore.getAlpha() - 0.02f, 0));

			// world render
			world.step(1 / 30f, 8, 3);

			// basket and hit position
			basket.body.setTransform(hero.body.getPosition(), 0);
			hit.body.setTransform(hero.body.getPosition(), 0);

			// stage render
			stage.act(Gdx.graphics.getDeltaTime());

			// hero move and flip
			if (keyLeft) {
				hero.body.setLinearVelocity(-HERO_MOVE_SPEED, hero.body.getLinearVelocity().y);
				hero.setScaleX(-Math.abs(hero.getScaleX()));
			} else if (keyRight) {
				hero.body.setLinearVelocity(HERO_MOVE_SPEED, hero.body.getLinearVelocity().y);
				hero.setScaleX(Math.abs(hero.getScaleX()));
			} else {
				hero.body.setLinearVelocity(0, hero.body.getLinearVelocity().y);
				hero.stateTime = 0;
			}

			// camera position
			if (mapWidth < SCREEN_WIDTH)
				stage.getRoot().setX((SCREEN_WIDTH - mapWidth) * 0.5f);
			else
				stage.getRoot().setX(
						MathUtils.clamp(SCREEN_WIDTH * 0.5f - CAMERA_OFFSET_X - hero.getX(),
								SCREEN_WIDTH - mapWidth + viewport.getLeftGutterWidth() / ratio, -viewport.getLeftGutterWidth()
										/ ratio));
			if (mapHeight < SCREEN_HEIGHT)
				stage.getRoot().setY((SCREEN_HEIGHT - mapHeight) * 0.5f);
			else
				stage.getRoot().setY(
						MathUtils.clamp(SCREEN_HEIGHT * 0.5f - CAMERA_OFFSET_Y - hero.getY(), SCREEN_HEIGHT - mapHeight
								+ viewport.getTopGutterHeight() / ratio, -viewport.getTopGutterHeight() / ratio));
			cam.position.set((SCREEN_WIDTH * 0.5f - stage.getRoot().getX()) / PPM,
					(SCREEN_HEIGHT * 0.5f - stage.getRoot().getY()) / PPM, 0);
			cam.update();
		}

		stage.draw();
	}

	@Override
	public void pause() {
		sndBg.pause();
		super.pause();
	}

	@Override
	public void resume() {
		super.resume();

		// finish load assets
		if (!assetManager.update())
			assetManager.finishLoading();

		bgSound();
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
		viewport.update(width, height);
		ratio = Math.max((float) viewport.getScreenWidth() / SCREEN_WIDTH, (float) viewport.getScreenHeight() / SCREEN_HEIGHT);

		if (!Gdx.graphics.isFullscreen()) {
			currentWidth = width;
			currentHeight = height;
		}
	}

	@Override
	public void dispose() {
		clearScreen();
		batch.dispose();
		stage.dispose();
		assetManager.clear();

		if (debug != null)
			debug.dispose();

		if (world != null)
			world.dispose();

		System.gc();
	}

	// setSigned
	public void setSigned(boolean signed) {
		isSigned = signed;
		btnSignIn.setVisible(!signed);
		btnSignOut.setVisible(signed);
	}

	// saveScore
	public boolean saveScore(int score) {
		if (!pref.contains("score") || score > pref.getInteger("score")) {
			pref.putInteger("score", score);
			pref.flush();
			return true;
		}

		return false;
	}

	// bgSound
	void bgSound() {
		if (!pref.getBoolean("mute", false)) {
			sndBg.setVolume(0.2f);
			sndBg.setLooping(true);
			sndBg.play();
		}
	}

	// CONTACT
	class CONTACT implements ContactListener {
		@Override
		public void beginContact(Contact contact) {
			Act actor1 = (Act) contact.getFixtureA().getBody().getUserData();
			Act actor2 = (Act) contact.getFixtureB().getBody().getUserData();
			Act otherActor;

			if (hero != null && hero.enabled) {
				// orange & hit
				if ((actor1.getName().equals("orange") && actor2.getName().equals("hit"))
						|| (actor2.getName().equals("orange") && actor1.getName().equals("hit"))) {
					otherActor = actor1.getName().equals("orange") ? actor1 : actor2;
					destroyBodies.add(otherActor.body);
					otherActor.remove();
					numOranges--;
					score += 10;

					// txtScore
					txtScore.setScale(1f);
					txtScore.setX(hit.getX() + hit.getWidth() - txtScore.getWidth() / 2);
					txtScore.setY(hit.getY());
					txtScore.setAlpha(1);

					// save score
					if (saveScore(score))
						nativePlatform.saveScore(score);

					// sound
					if (!pref.getBoolean("mute", false))
						assetManager.get("sndHit.mp3", Sound.class).play(0.5f);

					return;
				}

				// orange & ground
				if ((actor1.getName().equals("orange") && actor2.getName().equals("ground"))
						|| (actor2.getName().equals("orange") && actor1.getName().equals("ground"))) {
					otherActor = actor1.getName().equals("orange") ? actor1 : actor2;
					if (otherActor.body.getLinearVelocity().y < JUMP_POWER)
						otherActor.body.setLinearVelocity(otherActor.body.getLinearVelocity().x, JUMP_POWER);
					return;
				}

				// orange & orange
				if ((actor1.getName().equals("orange") && actor2.getName().equals("orange"))
						|| (actor2.getName().equals("orange") && actor1.getName().equals("orange"))) {
					if (actor1.body.getLinearVelocity().x == 0 && actor1.body.getLinearVelocity().y == 0)
						actor1.body.setLinearVelocity(actor1.body.getLinearVelocity().x, JUMP_POWER);
					if (actor2.body.getLinearVelocity().x == 0 && actor2.body.getLinearVelocity().y == 0)
						actor2.body.setLinearVelocity(actor2.body.getLinearVelocity().x, JUMP_POWER);
					return;
				}
			}
		}

		@Override
		public void endContact(Contact contact) {
		}

		@Override
		public void preSolve(Contact contact, Manifold oldManifold) {
		}

		@Override
		public void postSolve(Contact contact, ContactImpulse impulse) {
		}
	}

	// CONTROL
	class CONTROL extends InputListener {
		@Override
		public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
			if (((Act) event.getTarget()).enabled) {
				// each button
				if (event.getTarget().getName().substring(0, Math.min(3, event.getTarget().getName().length())).equals("btn")) {
					((Act) event.getTarget()).brightness = BRIGHTNESS_PRESSED;

					// sound
					if (!pref.getBoolean("mute", false))
						assetManager.get("sndBtn.mp3", Sound.class).play(0.9f);
				}

				if (screen.equals("game") && !gamePaused) {
					// controlLeft
					if (event.getTarget().getName().equals("controlLeft")) {
						keyLeft = true;
						return true;
					}

					// controlRight
					if (event.getTarget().getName().equals("controlRight")) {
						keyRight = true;
						return true;
					}
				}
			}

			return true;
		}

		@Override
		public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
			super.touchUp(event, x, y, pointer, button);
			if (((Act) event.getTarget()).enabled) {
				// controLeft
				if (event.getTarget().getName().equals("controlLeft")) {
					keyLeft = false;
					return;
				}

				// controLRight
				if (event.getTarget().getName().equals("controlRight")) {
					keyRight = false;
					return;
				}

				// each button
				if (event.getTarget().getName().substring(0, Math.min(3, event.getTarget().getName().length())).equals("btn"))
					((Act) event.getTarget()).brightness = 1;

				// if actor in focus
				if (stage.hit(event.getStageX(), event.getStageY(), true) == event.getTarget()) {
					// btnPause
					if (event.getTarget().getName().equals("btnPause")) {
						gamePaused = true;
						groupPause.setVisible(true);
						btnPause.setVisible(false);
						taskDelay = (TIMER.getExecuteTimeMillis() - TimeUtils.nanosToMillis(TimeUtils.nanoTime())) / 1000f;
						TIMER.cancel();
						return;
					}

					// btnSignIn
					if (event.getTarget().getName().equals("btnSignIn")) {
						nativePlatform.signIn();
						return;
					}

					// btnSignOut
					if (event.getTarget().getName().equals("btnSignOut")) {
						nativePlatform.signOut();
						return;
					}

					// btnLeaders
					if (event.getTarget().getName().equals("btnLeaders")) {
						nativePlatform.showLeaders();
						return;
					}

					// btnStart
					if (event.getTarget().getName().equals("btnStart")) {
						showScreen("game");
						return;
					}

					// btnSound, btnSoundPause
					if (event.getTarget().getName().equals("btnSound") || event.getTarget().getName().equals("btnSoundPause")) {
						pref.putBoolean("mute", false);
						pref.flush();
						btnMute.setVisible(true);
						btnSound.setVisible(false);
						bgSound();
						return;
					}

					// btnMute, btnMutePause
					if (event.getTarget().getName().equals("btnMute") || event.getTarget().getName().equals("btnMutePause")) {
						pref.putBoolean("mute", true);
						pref.flush();
						btnMute.setVisible(false);
						btnSound.setVisible(true);
						sndBg.pause();
						return;
					}

					// btnQuit
					if (event.getTarget().getName().equals("btnQuit")) {
						Gdx.app.exit();
						return;
					}

					// btnRestart, btnRestartPause
					if (event.getTarget().getName().equals("btnRestart") || event.getTarget().getName().equals("btnRestartPause")) {
						showScreen("game");
						return;
					}

					// btnResumePause
					if (event.getTarget().getName().equals("btnResumePause")) {
						gamePaused = false;
						bgSound();
						groupPause.setVisible(false);
						btnPause.setVisible(true);
						Timer.schedule(TIMER, taskDelay, ADD_INTERVAL);
						return;
					}

					// btnQuitPause, btnBack
					if (event.getTarget().getName().equals("btnQuitPause") || event.getTarget().getName().equals("btnBack")) {
						showScreen("main");
						return;
					}
				}
			}
		}

		@Override
		public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
			super.enter(event, x, y, pointer, fromActor);

			// mouse over button
			if (((Act) event.getTarget()).enabled
					&& event.getTarget().getName().substring(0, Math.min(3, event.getTarget().getName().length())).equals("btn"))
				((Act) event.getTarget()).brightness = BRIGHTNESS_PRESSED;
		}

		@Override
		public void exit(InputEvent event, float x, float y, int pointer, Actor toActor) {
			super.exit(event, x, y, pointer, toActor);

			// mouse out button
			if (event.getTarget().getName().substring(0, Math.min(3, event.getTarget().getName().length())).equals("btn"))
				((Act) event.getTarget()).brightness = 1;
		}

		@Override
		public boolean keyDown(InputEvent event, int keycode) {
			if (screen.equals("game") && !gamePaused)
				switch (keycode) {
				case Keys.UP:
					keyUp = true;
					break;
				case Keys.LEFT:
					keyLeft = true;
					break;
				case Keys.RIGHT:
					keyRight = true;
					break;
				}

			return true;
		}

		@Override
		public boolean keyUp(InputEvent event, int keycode) {
			switch (keycode) {
			case Keys.UP:
				keyUp = false;
				break;
			case Keys.LEFT:
				keyLeft = false;
				break;
			case Keys.RIGHT:
				keyRight = false;
				break;
			case Keys.ESCAPE: // exit from fullscreen mode
				if (Gdx.graphics.isFullscreen())
					Gdx.graphics.setDisplayMode(currentWidth, currentHeight, false);
				break;
			case Keys.ENTER: // switch to fullscreen mode
				if (!Gdx.graphics.isFullscreen())
					Gdx.graphics.setDisplayMode(Gdx.graphics.getDesktopDisplayMode().width,
							Gdx.graphics.getDesktopDisplayMode().height, true);
				break;
			case Keys.BACK: // back
				if (screen.equals("main"))
					Gdx.app.exit();
				else if (screen.equals("game"))
					showScreen("main");
				break;
			}

			return true;
		}
	}

	// log
	void log(Object obj) {
		if (Gdx.app.getType().equals(ApplicationType.Desktop))
			System.out.println(obj);
		else
			Gdx.app.log("@", obj.toString());
	}

	// TIMER
	Task TIMER = new Task() {
		@Override
		public void run() {
			// add orange
			Act actor = Lib.addLayer("orange", map, stage.getRoot()).first();
			actor.setZIndex(basket.getZIndex());
			actor.body.setTransform((float) ((SCREEN_WIDTH * 0.25f + (Math.random() * SCREEN_WIDTH * 0.5f)) / PPM),
					(stage.screenToStageCoordinates(new Vector2(0, 0)).y + 70) / PPM, 0);
			actor.body.setAngularVelocity((float) (-10f + Math.random() * 20f));
			actor.body.setLinearVelocity((float) (-10f + Math.random() * 20f), 0);

			// game over
			if (numOranges >= ORANGES_LIMIT) {
				hero.enabled = false;
				TIMER.cancel();
				hideElements();

				// sound
				if (!pref.getBoolean("mute", false))
					assetManager.get("sndGameOver.mp3", Sound.class).play(1f);

				// groupTimeUp
				showGroup(groupGameOver);
			}

			numOranges++;
		}
	};

	// showGroup
	void showGroup(Group group) {
		// add score numbers
		String str = String.valueOf(score);
		Array<Act> actors = new Array<Act>();
		int numbersWidth = 0;
		for (int i = 0; i < str.length(); i++) {
			Act actor = new Act("", 0, 570, numbers.findRegion(str.substring(i, i + 1)));
			actors.add(actor);
			group.addActor(actor);
			numbersWidth += actor.getWidth();
		}

		// set numbers position
		float x_pos = (SCREEN_WIDTH - numbersWidth) / 2;
		for (int i = 0; i < actors.size; i++) {
			actors.get(i).setX(x_pos);
			x_pos += actors.get(i).getWidth();
		}

		// show
		group.setVisible(true);
		SnapshotArray<Actor> allActors = group.getChildren();
		for (int i = 0; i < allActors.size; i++) {
			allActors.get(i).setScale(0, 0);
			if(i != allActors.size - 1)
				allActors.get(i).addAction(
						Actions.sequence(Actions.delay(i * 0.2f), Actions.scaleBy(1, 1, 1, Interpolation.elasticOut)));
			else
				allActors.get(i).addAction(
						Actions.sequence(Actions.delay(i * 0.2f), Actions.scaleBy(1, 1, 1, Interpolation.elasticOut), new Action() {
							@Override
							public boolean act(float delta) {
								// show AdMob Interstitial
								nativePlatform.admobInterstitial();
								return true;
							}
						}));
		}
	}

	// hideElements
	void hideElements() {
		// remove listeners
		controlLeft.removeListener(controlListener);
		controlRight.removeListener(controlListener);
		btnPause.removeListener(controlListener);

		btnPause.addAction(Actions.sequence(Actions.alpha(0, 0.2f), new Action() {
			@Override
			public boolean act(float delta) {
				btnPause.setVisible(false);
				return true;
			}
		}));
	}
}