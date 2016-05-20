package com.badlogic.gdx.scenes.scene2d;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Table.Debug;
import com.badlogic.gdx.scenes.scene2d.utils.FocusListener.FocusEvent;
import com.badlogic.gdx.scenes.scene2d.utils.FocusListener.FocusEvent.Type;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.Pools;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.SnapshotArray;
import com.badlogic.gdx.utils.viewport.ScalingViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class Stage extends InputAdapter
  implements Disposable
{
  static boolean debug;
  private boolean actionsRequestRendering = true;
  private final Batch batch;
  private boolean debugAll;
  private final Color debugColor = new Color(0.0F, 1.0F, 0.0F, 0.85F);
  private boolean debugInvisible;
  private boolean debugParentUnderMouse;
  private ShapeRenderer debugShapes;
  private Table.Debug debugTableUnderMouse = Table.Debug.none;
  private boolean debugUnderMouse;
  private Actor keyboardFocus;
  private Actor mouseOverActor;
  private int mouseScreenX;
  private int mouseScreenY;
  private boolean ownsBatch;
  private final Actor[] pointerOverActors = new Actor[20];
  private final int[] pointerScreenX = new int[20];
  private final int[] pointerScreenY = new int[20];
  private final boolean[] pointerTouched = new boolean[20];
  private final Group root;
  private Actor scrollFocus;
  private final Vector2 tempCoords = new Vector2();
  private final SnapshotArray touchFocuses = new SnapshotArray(true, 4, Stage.TouchFocus.class);
  private Viewport viewport;

  public Stage()
  {
    this(new ScalingViewport(Scaling.stretch, Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), new OrthographicCamera()), new SpriteBatch());
    this.ownsBatch = true;
  }

  public Stage(Viewport paramViewport)
  {
    this(paramViewport, new SpriteBatch());
    this.ownsBatch = true;
  }

  public Stage(Viewport paramViewport, Batch paramBatch)
  {
    if (paramViewport == null)
      throw new IllegalArgumentException("viewport cannot be null.");
    if (paramBatch == null)
      throw new IllegalArgumentException("batch cannot be null.");
    this.viewport = paramViewport;
    this.batch = paramBatch;
    this.root = new Group();
    this.root.setStage(this);
    paramViewport.update(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), true);
  }

  private void disableDebug(Actor paramActor1, Actor paramActor2)
  {
    if (paramActor1 == paramActor2);
    while (true)
    {
      return;
      paramActor1.setDebug(false);
      if (!(paramActor1 instanceof Group))
        continue;
      SnapshotArray localSnapshotArray = ((Group)paramActor1).children;
      int i = localSnapshotArray.size;
      for (int j = 0; j < i; j++)
        disableDebug((Actor)localSnapshotArray.get(j), paramActor2);
    }
  }

  private void drawDebug()
  {
    if (this.debugShapes == null)
    {
      this.debugShapes = new ShapeRenderer();
      this.debugShapes.setAutoShapeType(true);
    }
    Object localObject1;
    Object localObject2;
    if ((this.debugUnderMouse) || (this.debugParentUnderMouse) || (this.debugTableUnderMouse != Table.Debug.none))
    {
      screenToStageCoordinates(this.tempCoords.set(Gdx.input.getX(), Gdx.input.getY()));
      localObject1 = hit(this.tempCoords.x, this.tempCoords.y, true);
      if (localObject1 == null)
        return;
      if ((this.debugParentUnderMouse) && (((Actor)localObject1).parent != null))
        localObject1 = ((Actor)localObject1).parent;
      if (this.debugTableUnderMouse != Table.Debug.none)
        break label282;
      ((Actor)localObject1).setDebug(true);
      localObject2 = localObject1;
      label141: if ((this.debugAll) && ((localObject2 instanceof Group)))
        ((Group)localObject2).debugAll();
      disableDebug(this.root, (Actor)localObject2);
      label172: Gdx.gl.glEnable(3042);
      this.debugShapes.setProjectionMatrix(this.viewport.getCamera().combined);
      this.debugShapes.begin();
      this.root.drawDebug(this.debugShapes);
      this.debugShapes.end();
      return;
    }
    while (true)
    {
      if ((localObject2 != null) && (!(localObject2 instanceof Table)))
      {
        localObject2 = ((Actor)localObject2).parent;
        continue;
      }
      if (localObject2 == null)
        break;
      ((Table)localObject2).debug(this.debugTableUnderMouse);
      break label141;
      if (!this.debugAll)
        break label172;
      this.root.debugAll();
      break label172;
      label282: localObject2 = localObject1;
    }
  }

  private Actor fireEnterAndExit(Actor paramActor, int paramInt1, int paramInt2, int paramInt3)
  {
    screenToStageCoordinates(this.tempCoords.set(paramInt1, paramInt2));
    Actor localActor = hit(this.tempCoords.x, this.tempCoords.y, true);
    if (localActor == paramActor)
      return paramActor;
    InputEvent localInputEvent = (InputEvent)Pools.obtain(InputEvent.class);
    localInputEvent.setStage(this);
    localInputEvent.setStageX(this.tempCoords.x);
    localInputEvent.setStageY(this.tempCoords.y);
    localInputEvent.setPointer(paramInt3);
    if (paramActor != null)
    {
      localInputEvent.setType(InputEvent.Type.exit);
      localInputEvent.setRelatedActor(localActor);
      paramActor.fire(localInputEvent);
    }
    if (localActor != null)
    {
      localInputEvent.setType(InputEvent.Type.enter);
      localInputEvent.setRelatedActor(paramActor);
      localActor.fire(localInputEvent);
    }
    Pools.free(localInputEvent);
    return localActor;
  }

  public void act()
  {
    act(Math.min(Gdx.graphics.getDeltaTime(), 0.03333334F));
  }

  public void act(float paramFloat)
  {
    int i = this.pointerOverActors.length;
    int j = 0;
    if (j < i)
    {
      Actor localActor = this.pointerOverActors[j];
      if (this.pointerTouched[j] == 0)
        if (localActor != null)
        {
          this.pointerOverActors[j] = null;
          screenToStageCoordinates(this.tempCoords.set(this.pointerScreenX[j], this.pointerScreenY[j]));
          InputEvent localInputEvent = (InputEvent)Pools.obtain(InputEvent.class);
          localInputEvent.setType(InputEvent.Type.exit);
          localInputEvent.setStage(this);
          localInputEvent.setStageX(this.tempCoords.x);
          localInputEvent.setStageY(this.tempCoords.y);
          localInputEvent.setRelatedActor(localActor);
          localInputEvent.setPointer(j);
          localActor.fire(localInputEvent);
          Pools.free(localInputEvent);
        }
      while (true)
      {
        j++;
        break;
        this.pointerOverActors[j] = fireEnterAndExit(localActor, this.pointerScreenX[j], this.pointerScreenY[j], j);
      }
    }
    Application.ApplicationType localApplicationType = Gdx.app.getType();
    if ((localApplicationType == Application.ApplicationType.Desktop) || (localApplicationType == Application.ApplicationType.Applet) || (localApplicationType == Application.ApplicationType.WebGL))
      this.mouseOverActor = fireEnterAndExit(this.mouseOverActor, this.mouseScreenX, this.mouseScreenY, -1);
    this.root.act(paramFloat);
  }

  public void addAction(Action paramAction)
  {
    this.root.addAction(paramAction);
  }

  public void addActor(Actor paramActor)
  {
    this.root.addActor(paramActor);
  }

  public boolean addCaptureListener(EventListener paramEventListener)
  {
    return this.root.addCaptureListener(paramEventListener);
  }

  public boolean addListener(EventListener paramEventListener)
  {
    return this.root.addListener(paramEventListener);
  }

  public void addTouchFocus(EventListener paramEventListener, Actor paramActor1, Actor paramActor2, int paramInt1, int paramInt2)
  {
    Stage.TouchFocus localTouchFocus = (Stage.TouchFocus)Pools.obtain(Stage.TouchFocus.class);
    localTouchFocus.listenerActor = paramActor1;
    localTouchFocus.target = paramActor2;
    localTouchFocus.listener = paramEventListener;
    localTouchFocus.pointer = paramInt1;
    localTouchFocus.button = paramInt2;
    this.touchFocuses.add(localTouchFocus);
  }

  public void calculateScissors(Rectangle paramRectangle1, Rectangle paramRectangle2)
  {
    this.viewport.calculateScissors(this.batch.getTransformMatrix(), paramRectangle1, paramRectangle2);
    if ((this.debugShapes != null) && (this.debugShapes.isDrawing()));
    for (Matrix4 localMatrix4 = this.debugShapes.getTransformMatrix(); ; localMatrix4 = this.batch.getTransformMatrix())
    {
      this.viewport.calculateScissors(localMatrix4, paramRectangle1, paramRectangle2);
      return;
    }
  }

  public void cancelTouchFocus()
  {
    cancelTouchFocusExcept(null, null);
  }

  public void cancelTouchFocus(Actor paramActor)
  {
    InputEvent localInputEvent = (InputEvent)Pools.obtain(InputEvent.class);
    localInputEvent.setStage(this);
    localInputEvent.setType(InputEvent.Type.touchUp);
    localInputEvent.setStageX(-2.147484E+009F);
    localInputEvent.setStageY(-2.147484E+009F);
    SnapshotArray localSnapshotArray = this.touchFocuses;
    Stage.TouchFocus[] arrayOfTouchFocus = (Stage.TouchFocus[])localSnapshotArray.begin();
    int i = 0;
    int j = localSnapshotArray.size;
    while (i < j)
    {
      Stage.TouchFocus localTouchFocus = arrayOfTouchFocus[i];
      if ((localTouchFocus.listenerActor == paramActor) && (localSnapshotArray.removeValue(localTouchFocus, true)))
      {
        localInputEvent.setTarget(localTouchFocus.target);
        localInputEvent.setListenerActor(localTouchFocus.listenerActor);
        localInputEvent.setPointer(localTouchFocus.pointer);
        localInputEvent.setButton(localTouchFocus.button);
        localTouchFocus.listener.handle(localInputEvent);
      }
      i++;
    }
    localSnapshotArray.end();
    Pools.free(localInputEvent);
  }

  public void cancelTouchFocusExcept(EventListener paramEventListener, Actor paramActor)
  {
    InputEvent localInputEvent = (InputEvent)Pools.obtain(InputEvent.class);
    localInputEvent.setStage(this);
    localInputEvent.setType(InputEvent.Type.touchUp);
    localInputEvent.setStageX(-2.147484E+009F);
    localInputEvent.setStageY(-2.147484E+009F);
    SnapshotArray localSnapshotArray = this.touchFocuses;
    Stage.TouchFocus[] arrayOfTouchFocus = (Stage.TouchFocus[])localSnapshotArray.begin();
    int i = 0;
    int j = localSnapshotArray.size;
    while (i < j)
    {
      Stage.TouchFocus localTouchFocus = arrayOfTouchFocus[i];
      if (((localTouchFocus.listener != paramEventListener) || (localTouchFocus.listenerActor != paramActor)) && (localSnapshotArray.removeValue(localTouchFocus, true)))
      {
        localInputEvent.setTarget(localTouchFocus.target);
        localInputEvent.setListenerActor(localTouchFocus.listenerActor);
        localInputEvent.setPointer(localTouchFocus.pointer);
        localInputEvent.setButton(localTouchFocus.button);
        localTouchFocus.listener.handle(localInputEvent);
      }
      i++;
    }
    localSnapshotArray.end();
    Pools.free(localInputEvent);
  }

  public void clear()
  {
    unfocusAll();
    this.root.clear();
  }

  public void dispose()
  {
    clear();
    if (this.ownsBatch)
      this.batch.dispose();
  }

  public void draw()
  {
    Camera localCamera = this.viewport.getCamera();
    localCamera.update();
    if (!this.root.isVisible());
    do
    {
      return;
      Batch localBatch = this.batch;
      if (localBatch == null)
        continue;
      localBatch.setProjectionMatrix(localCamera.combined);
      localBatch.begin();
      this.root.draw(localBatch, 1.0F);
      localBatch.end();
    }
    while (!debug);
    drawDebug();
  }

  public boolean getActionsRequestRendering()
  {
    return this.actionsRequestRendering;
  }

  public Array getActors()
  {
    return this.root.children;
  }

  public Batch getBatch()
  {
    return this.batch;
  }

  public Camera getCamera()
  {
    return this.viewport.getCamera();
  }

  public Color getDebugColor()
  {
    return this.debugColor;
  }

  public float getHeight()
  {
    return this.viewport.getWorldHeight();
  }

  public Actor getKeyboardFocus()
  {
    return this.keyboardFocus;
  }

  public Group getRoot()
  {
    return this.root;
  }

  public Actor getScrollFocus()
  {
    return this.scrollFocus;
  }

  public Viewport getViewport()
  {
    return this.viewport;
  }

  public float getWidth()
  {
    return this.viewport.getWorldWidth();
  }

  public Actor hit(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    this.root.parentToLocalCoordinates(this.tempCoords.set(paramFloat1, paramFloat2));
    return this.root.hit(this.tempCoords.x, this.tempCoords.y, paramBoolean);
  }

  public boolean keyDown(int paramInt)
  {
    if (this.keyboardFocus == null);
    for (Object localObject = this.root; ; localObject = this.keyboardFocus)
    {
      InputEvent localInputEvent = (InputEvent)Pools.obtain(InputEvent.class);
      localInputEvent.setStage(this);
      localInputEvent.setType(InputEvent.Type.keyDown);
      localInputEvent.setKeyCode(paramInt);
      ((Actor)localObject).fire(localInputEvent);
      boolean bool = localInputEvent.isHandled();
      Pools.free(localInputEvent);
      return bool;
    }
  }

  public boolean keyTyped(char paramChar)
  {
    if (this.keyboardFocus == null);
    for (Object localObject = this.root; ; localObject = this.keyboardFocus)
    {
      InputEvent localInputEvent = (InputEvent)Pools.obtain(InputEvent.class);
      localInputEvent.setStage(this);
      localInputEvent.setType(InputEvent.Type.keyTyped);
      localInputEvent.setCharacter(paramChar);
      ((Actor)localObject).fire(localInputEvent);
      boolean bool = localInputEvent.isHandled();
      Pools.free(localInputEvent);
      return bool;
    }
  }

  public boolean keyUp(int paramInt)
  {
    if (this.keyboardFocus == null);
    for (Object localObject = this.root; ; localObject = this.keyboardFocus)
    {
      InputEvent localInputEvent = (InputEvent)Pools.obtain(InputEvent.class);
      localInputEvent.setStage(this);
      localInputEvent.setType(InputEvent.Type.keyUp);
      localInputEvent.setKeyCode(paramInt);
      ((Actor)localObject).fire(localInputEvent);
      boolean bool = localInputEvent.isHandled();
      Pools.free(localInputEvent);
      return bool;
    }
  }

  public boolean mouseMoved(int paramInt1, int paramInt2)
  {
    if ((paramInt1 < this.viewport.getScreenX()) || (paramInt1 >= this.viewport.getScreenX() + this.viewport.getScreenWidth()));
    do
      return false;
    while ((Gdx.graphics.getHeight() - paramInt2 < this.viewport.getScreenY()) || (Gdx.graphics.getHeight() - paramInt2 >= this.viewport.getScreenY() + this.viewport.getScreenHeight()));
    this.mouseScreenX = paramInt1;
    this.mouseScreenY = paramInt2;
    screenToStageCoordinates(this.tempCoords.set(paramInt1, paramInt2));
    InputEvent localInputEvent = (InputEvent)Pools.obtain(InputEvent.class);
    localInputEvent.setStage(this);
    localInputEvent.setType(InputEvent.Type.mouseMoved);
    localInputEvent.setStageX(this.tempCoords.x);
    localInputEvent.setStageY(this.tempCoords.y);
    Object localObject = hit(this.tempCoords.x, this.tempCoords.y, true);
    if (localObject == null)
      localObject = this.root;
    ((Actor)localObject).fire(localInputEvent);
    boolean bool = localInputEvent.isHandled();
    Pools.free(localInputEvent);
    return bool;
  }

  public boolean removeCaptureListener(EventListener paramEventListener)
  {
    return this.root.removeCaptureListener(paramEventListener);
  }

  public boolean removeListener(EventListener paramEventListener)
  {
    return this.root.removeListener(paramEventListener);
  }

  public void removeTouchFocus(EventListener paramEventListener, Actor paramActor1, Actor paramActor2, int paramInt1, int paramInt2)
  {
    SnapshotArray localSnapshotArray = this.touchFocuses;
    for (int i = -1 + localSnapshotArray.size; i >= 0; i--)
    {
      Stage.TouchFocus localTouchFocus = (Stage.TouchFocus)localSnapshotArray.get(i);
      if ((localTouchFocus.listener != paramEventListener) || (localTouchFocus.listenerActor != paramActor1) || (localTouchFocus.target != paramActor2) || (localTouchFocus.pointer != paramInt1) || (localTouchFocus.button != paramInt2))
        continue;
      localSnapshotArray.removeIndex(i);
      Pools.free(localTouchFocus);
    }
  }

  public Vector2 screenToStageCoordinates(Vector2 paramVector2)
  {
    this.viewport.unproject(paramVector2);
    return paramVector2;
  }

  public boolean scrolled(int paramInt)
  {
    if (this.scrollFocus == null);
    for (Object localObject = this.root; ; localObject = this.scrollFocus)
    {
      screenToStageCoordinates(this.tempCoords.set(this.mouseScreenX, this.mouseScreenY));
      InputEvent localInputEvent = (InputEvent)Pools.obtain(InputEvent.class);
      localInputEvent.setStage(this);
      localInputEvent.setType(InputEvent.Type.scrolled);
      localInputEvent.setScrollAmount(paramInt);
      localInputEvent.setStageX(this.tempCoords.x);
      localInputEvent.setStageY(this.tempCoords.y);
      ((Actor)localObject).fire(localInputEvent);
      boolean bool = localInputEvent.isHandled();
      Pools.free(localInputEvent);
      return bool;
    }
  }

  public void setActionsRequestRendering(boolean paramBoolean)
  {
    this.actionsRequestRendering = paramBoolean;
  }

  public void setDebugAll(boolean paramBoolean)
  {
    if (this.debugAll == paramBoolean)
      return;
    this.debugAll = paramBoolean;
    if (paramBoolean)
    {
      debug = true;
      return;
    }
    this.root.setDebug(false, true);
  }

  public void setDebugInvisible(boolean paramBoolean)
  {
    this.debugInvisible = paramBoolean;
  }

  public void setDebugParentUnderMouse(boolean paramBoolean)
  {
    if (this.debugParentUnderMouse == paramBoolean)
      return;
    this.debugParentUnderMouse = paramBoolean;
    if (paramBoolean)
    {
      debug = true;
      return;
    }
    this.root.setDebug(false, true);
  }

  public void setDebugTableUnderMouse(Table.Debug paramDebug)
  {
    if (paramDebug == null)
      paramDebug = Table.Debug.none;
    if (this.debugTableUnderMouse == paramDebug)
      return;
    this.debugTableUnderMouse = paramDebug;
    if (paramDebug != Table.Debug.none)
    {
      debug = true;
      return;
    }
    this.root.setDebug(false, true);
  }

  public void setDebugTableUnderMouse(boolean paramBoolean)
  {
    if (paramBoolean);
    for (Table.Debug localDebug = Table.Debug.all; ; localDebug = Table.Debug.none)
    {
      setDebugTableUnderMouse(localDebug);
      return;
    }
  }

  public void setDebugUnderMouse(boolean paramBoolean)
  {
    if (this.debugUnderMouse == paramBoolean)
      return;
    this.debugUnderMouse = paramBoolean;
    if (paramBoolean)
    {
      debug = true;
      return;
    }
    this.root.setDebug(false, true);
  }

  public void setKeyboardFocus(Actor paramActor)
  {
    if (this.keyboardFocus == paramActor)
      return;
    FocusListener.FocusEvent localFocusEvent = (FocusListener.FocusEvent)Pools.obtain(FocusListener.FocusEvent.class);
    localFocusEvent.setStage(this);
    localFocusEvent.setType(FocusListener.FocusEvent.Type.keyboard);
    Actor localActor = this.keyboardFocus;
    if (localActor != null)
    {
      localFocusEvent.setFocused(false);
      localFocusEvent.setRelatedActor(paramActor);
      localActor.fire(localFocusEvent);
    }
    if (!localFocusEvent.isCancelled())
    {
      this.keyboardFocus = paramActor;
      if (paramActor != null)
      {
        localFocusEvent.setFocused(true);
        localFocusEvent.setRelatedActor(localActor);
        paramActor.fire(localFocusEvent);
        if (localFocusEvent.isCancelled())
          setKeyboardFocus(localActor);
      }
    }
    Pools.free(localFocusEvent);
  }

  public void setScrollFocus(Actor paramActor)
  {
    if (this.scrollFocus == paramActor)
      return;
    FocusListener.FocusEvent localFocusEvent = (FocusListener.FocusEvent)Pools.obtain(FocusListener.FocusEvent.class);
    localFocusEvent.setStage(this);
    localFocusEvent.setType(FocusListener.FocusEvent.Type.scroll);
    Actor localActor = this.scrollFocus;
    if (localActor != null)
    {
      localFocusEvent.setFocused(false);
      localFocusEvent.setRelatedActor(paramActor);
      localActor.fire(localFocusEvent);
    }
    if (!localFocusEvent.isCancelled())
    {
      this.scrollFocus = paramActor;
      if (paramActor != null)
      {
        localFocusEvent.setFocused(true);
        localFocusEvent.setRelatedActor(localActor);
        paramActor.fire(localFocusEvent);
        if (localFocusEvent.isCancelled())
          setScrollFocus(localActor);
      }
    }
    Pools.free(localFocusEvent);
  }

  public void setViewport(Viewport paramViewport)
  {
    this.viewport = paramViewport;
  }

  public Vector2 stageToScreenCoordinates(Vector2 paramVector2)
  {
    this.viewport.project(paramVector2);
    paramVector2.y = (this.viewport.getScreenHeight() - paramVector2.y);
    return paramVector2;
  }

  public Vector2 toScreenCoordinates(Vector2 paramVector2, Matrix4 paramMatrix4)
  {
    return this.viewport.toScreenCoordinates(paramVector2, paramMatrix4);
  }

  public boolean touchDown(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt1 < this.viewport.getScreenX()) || (paramInt1 >= this.viewport.getScreenX() + this.viewport.getScreenWidth()));
    do
      return false;
    while ((Gdx.graphics.getHeight() - paramInt2 < this.viewport.getScreenY()) || (Gdx.graphics.getHeight() - paramInt2 >= this.viewport.getScreenY() + this.viewport.getScreenHeight()));
    this.pointerTouched[paramInt3] = true;
    this.pointerScreenX[paramInt3] = paramInt1;
    this.pointerScreenY[paramInt3] = paramInt2;
    screenToStageCoordinates(this.tempCoords.set(paramInt1, paramInt2));
    InputEvent localInputEvent = (InputEvent)Pools.obtain(InputEvent.class);
    localInputEvent.setType(InputEvent.Type.touchDown);
    localInputEvent.setStage(this);
    localInputEvent.setStageX(this.tempCoords.x);
    localInputEvent.setStageY(this.tempCoords.y);
    localInputEvent.setPointer(paramInt3);
    localInputEvent.setButton(paramInt4);
    Actor localActor = hit(this.tempCoords.x, this.tempCoords.y, true);
    if (localActor == null)
      if (this.root.getTouchable() == Touchable.enabled)
        this.root.fire(localInputEvent);
    while (true)
    {
      boolean bool = localInputEvent.isHandled();
      Pools.free(localInputEvent);
      return bool;
      localActor.fire(localInputEvent);
    }
  }

  public boolean touchDragged(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 0;
    this.pointerScreenX[paramInt3] = paramInt1;
    this.pointerScreenY[paramInt3] = paramInt2;
    this.mouseScreenX = paramInt1;
    this.mouseScreenY = paramInt2;
    if (this.touchFocuses.size == 0)
      return false;
    screenToStageCoordinates(this.tempCoords.set(paramInt1, paramInt2));
    InputEvent localInputEvent = (InputEvent)Pools.obtain(InputEvent.class);
    localInputEvent.setType(InputEvent.Type.touchDragged);
    localInputEvent.setStage(this);
    localInputEvent.setStageX(this.tempCoords.x);
    localInputEvent.setStageY(this.tempCoords.y);
    localInputEvent.setPointer(paramInt3);
    SnapshotArray localSnapshotArray = this.touchFocuses;
    Stage.TouchFocus[] arrayOfTouchFocus = (Stage.TouchFocus[])localSnapshotArray.begin();
    int j = localSnapshotArray.size;
    while (i < j)
    {
      Stage.TouchFocus localTouchFocus = arrayOfTouchFocus[i];
      if ((localTouchFocus.pointer == paramInt3) && (localSnapshotArray.contains(localTouchFocus, true)))
      {
        localInputEvent.setTarget(localTouchFocus.target);
        localInputEvent.setListenerActor(localTouchFocus.listenerActor);
        if (localTouchFocus.listener.handle(localInputEvent))
          localInputEvent.handle();
      }
      i++;
    }
    localSnapshotArray.end();
    boolean bool = localInputEvent.isHandled();
    Pools.free(localInputEvent);
    return bool;
  }

  public boolean touchUp(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = 0;
    this.pointerTouched[paramInt3] = false;
    this.pointerScreenX[paramInt3] = paramInt1;
    this.pointerScreenY[paramInt3] = paramInt2;
    if (this.touchFocuses.size == 0)
      return false;
    screenToStageCoordinates(this.tempCoords.set(paramInt1, paramInt2));
    InputEvent localInputEvent = (InputEvent)Pools.obtain(InputEvent.class);
    localInputEvent.setType(InputEvent.Type.touchUp);
    localInputEvent.setStage(this);
    localInputEvent.setStageX(this.tempCoords.x);
    localInputEvent.setStageY(this.tempCoords.y);
    localInputEvent.setPointer(paramInt3);
    localInputEvent.setButton(paramInt4);
    SnapshotArray localSnapshotArray = this.touchFocuses;
    Stage.TouchFocus[] arrayOfTouchFocus = (Stage.TouchFocus[])localSnapshotArray.begin();
    int j = localSnapshotArray.size;
    while (i < j)
    {
      Stage.TouchFocus localTouchFocus = arrayOfTouchFocus[i];
      if ((localTouchFocus.pointer == paramInt3) && (localTouchFocus.button == paramInt4) && (localSnapshotArray.removeValue(localTouchFocus, true)))
      {
        localInputEvent.setTarget(localTouchFocus.target);
        localInputEvent.setListenerActor(localTouchFocus.listenerActor);
        if (localTouchFocus.listener.handle(localInputEvent))
          localInputEvent.handle();
        Pools.free(localTouchFocus);
      }
      i++;
    }
    localSnapshotArray.end();
    boolean bool = localInputEvent.isHandled();
    Pools.free(localInputEvent);
    return bool;
  }

  public void unfocus(Actor paramActor)
  {
    cancelTouchFocus(paramActor);
    if ((this.scrollFocus != null) && (this.scrollFocus.isDescendantOf(paramActor)))
      this.scrollFocus = null;
    if ((this.keyboardFocus != null) && (this.keyboardFocus.isDescendantOf(paramActor)))
      this.keyboardFocus = null;
  }

  public void unfocusAll()
  {
    this.scrollFocus = null;
    this.keyboardFocus = null;
    cancelTouchFocus();
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.Stage
 * JD-Core Version:    0.6.0
 */