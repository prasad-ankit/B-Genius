/**Project Under : Golakar Kids Apps
 * You can not modify & redistribute without permission from the author
 * Project published on Golakar Technology platform April, 2014
 * Release Template for the buyer august 2015
 */

package com.golakar.kids.edu;

import ksz.test.b_genius.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;

public class SplashActivity2 extends Activity {

	private static final int SPLASH_TIME = 2 * 1000;// 2 seconds

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash_screen);

		new Handler().postDelayed(new Runnable() {

			@Override
			public void run() {

				Intent intent = new Intent(SplashActivity2.this,
				com.golakar.kids.edu.MainActivity.class);
				
				startActivity(intent);
				SplashActivity2.this.finish();

			}
		}, SPLASH_TIME);
		
		new Handler().postDelayed(new Runnable() {
			  @Override
			  public void run() {
			         } 
			    }, SPLASH_TIME);

	}

	@Override
	protected void onDestroy() {
		super.onDestroy();

		//unbindDrawables(findViewById(R.id.dashboard));
		System.gc();
	}

	private void unbindDrawables(View view) {
		if (view.getBackground() != null) {
			view.getBackground().setCallback(null);
		}
		if (view instanceof ViewGroup) {
			for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {
				unbindDrawables(((ViewGroup) view).getChildAt(i));
			}
			((ViewGroup) view).removeAllViews();
		}
	}
	
	@Override
	public void onBackPressed() {
		this.finish();
		super.onBackPressed();
	}
}