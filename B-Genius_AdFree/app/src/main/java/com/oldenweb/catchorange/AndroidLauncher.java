package com.oldenweb.catchorange;

import java.util.Locale;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.google.example.games.basegameutils.GameHelper;
import com.oldenweb.InterfaceListener;
import com.oldenweb.Main;

import ksz.test.b_genius.R;

// AndroidLauncher
public class AndroidLauncher extends Activity implements InterfaceListener, GameHelper.GameHelperListener {
	Main app;
	int score = 0;
	boolean showLeaderboard;

	// GameHelper
	protected GameHelper mHelper;
	public static final int CLIENT_GAMES = GameHelper.CLIENT_GAMES;
	public static final int CLIENT_PLUS = GameHelper.CLIENT_PLUS;
	public static final int CLIENT_ALL = GameHelper.CLIENT_ALL;

	// AdMob

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main3);

		// run
		app = new Main(this);
		runOnUiThread(new Runnable() {
			@Override
			public void run() {
				AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
				config.useImmersiveMode = true;
				((ViewGroup) findViewById(R.id.app)).addView(initializeForView(app, config));
			}
		});

		// GameHelper
		if (getResources().getBoolean(R.bool.connect_games)) {
			mHelper = new GameHelper(this, CLIENT_GAMES);
			mHelper.enableDebugLog(false);
			mHelper.setup(this);
			mHelper.setMaxAutoSignInAttempts(0); // don't automatically sign in
		}

		// AdMob
		adMob();
	}

	@Override
	public void onSignInSucceeded() {
		// set signed
		Gdx.app.postRunnable(new Runnable() {
			@Override
			public void run() {
				app.setSigned(true);
			}
		});

		// save score to leaderboard
		if (score > 0)
			saveScore(score);
		score = 0;

		// show leaderboard
		if (showLeaderboard)
			startActivityForResult(
					Games.Leaderboards.getLeaderboardIntent(mHelper.getApiClient(), getString(R.string.leaderboard)), 9999);
		showLeaderboard = false;

		// get score from leaderboard
		Games.Leaderboards.loadCurrentPlayerLeaderboardScore(mHelper.getApiClient(), getString(R.string.leaderboard),
				LeaderboardVariant.TIME_SPAN_ALL_TIME, LeaderboardVariant.COLLECTION_PUBLIC).setResultCallback(
				new ResultCallback<Leaderboards.LoadPlayerScoreResult>() {
					@Override
					public void onResult(final Leaderboards.LoadPlayerScoreResult scoreResult) {
						if (scoreResult.getStatus().getStatusCode() == GamesStatusCodes.STATUS_OK && scoreResult != null
								&& scoreResult.getScore() != null) {
							Gdx.app.postRunnable(new Runnable() {
								@Override
								public void run() {
									// save score local
									app.saveScore((int) scoreResult.getScore().getRawScore());
								}
							});
						}
					}
				});
	}

	@Override
	public void onSignInFailed() {
		// set signed
		Gdx.app.postRunnable(new Runnable() {
			@Override
			public void run() {
				app.setSigned(false);
			}
		});
		showLeaderboard = false;
	}

	@Override
	protected void onStart() {
		super.onStart();
		if (getResources().getBoolean(R.bool.connect_games))
			mHelper.onStart(this);
	}

	@Override
	protected void onStop() {
		super.onStop();
		if (getResources().getBoolean(R.bool.connect_games))
			mHelper.onStop();
	}

	@Override
	protected void onActivityResult(int request, int response, Intent data) {
		super.onActivityResult(request, response, data);
		if (getResources().getBoolean(R.bool.connect_games))
			mHelper.onActivityResult(request, response, data);
	}

	@Override
	protected void onDestroy() {
		// destroy AdMob

		super.onDestroy();
	}

	// log
	void log(Object obj) {
		Log.d("@", String.valueOf(obj));
	}

	@Override
	public void saveScore(int score) {
		// called when game score has been changed
		this.score = score;

		if (getResources().getBoolean(R.bool.connect_games) && mHelper.getApiClient().isConnected()) {
			Games.Leaderboards.submitScore(mHelper.getApiClient(), getString(R.string.leaderboard), score);
			this.score = 0;
		}
	}

	@Override
	public void signIn() {
		// called when pressed "Sign In" to Google Play Game Services
		if (getResources().getBoolean(R.bool.connect_games))
			mHelper.beginUserInitiatedSignIn();
	}

	@Override
	public void signOut() {
		// called when pressed "Sign Out" from Google Play Game Services
		if (getResources().getBoolean(R.bool.connect_games)) {
			mHelper.signOut();
			onSignInFailed();
		}
	}

	@Override
	public void showLeaders() {
		// called when pressed "Leaders"
		if (getResources().getBoolean(R.bool.connect_games)) {
			showLeaderboard = true;

			if (mHelper.getApiClient().isConnected())
				onSignInSucceeded();
			else
				mHelper.beginUserInitiatedSignIn();
		}
	}

	@Override
	public void admobInterstitial() {

	}


	// adMob
	void adMob() {
		runOnUiThread(new Runnable() {
			@Override
			public void run() {

			}
		});
	}

	// MD5
	String MD5(String str) {
		try {
			java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
			byte[] array = md.digest(str.getBytes());
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < array.length; ++i)
				sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
			return sb.toString().toUpperCase(Locale.ENGLISH);
		} catch (java.security.NoSuchAlgorithmException e) {
		}
		return null;
	}
}
