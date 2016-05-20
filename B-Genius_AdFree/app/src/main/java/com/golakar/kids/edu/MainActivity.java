/**Project Under : Golakar Kids Apps
 * You can not modify & redistribute without permission from the author
 * Project published on Golakar Technology platform April, 2014
 * Release Template for the buyer august 2015
 */
package com.golakar.kids.edu;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.golakar.kids.edu.menu.GolCenterMenu;
import com.golakar.kids.edu.utilities.AlphabetActivity;
import com.golakar.kids.edu.utilities.GolQuizActivity;
import com.golakar.kids.edu.utilities.GuessActivity;
import com.golakar.kids.edu.utilities.ImageGameStart;
import com.golakar.kids.edu.utilities.NumbersActivity;

import ksz.test.b_genius.R;


public class MainActivity extends Activity {
	Intent golakarApp;
	
	SharedPreferences mSharedPreferences;
	String marketLink;
	
	private static final int[] ITEM_DRAWABLES = { 
		R.drawable.golakar_abcd, R.drawable.golakar_1234,
		R.drawable.golakar_guess, R.drawable.golakar_quiz, 
		R.drawable.golakar_guess_images, 
		};
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dashboard);
		StartAnimations();
				
		GolCenterMenu goldashboardMenu = (GolCenterMenu) findViewById(R.id.golCenterMenu);
		initCenterMenu(goldashboardMenu, ITEM_DRAWABLES);
		

			// Market link for share app
			mSharedPreferences = getApplicationContext().getSharedPreferences("MyPref", 0);		
			marketLink = "https://play.google.com/store/apps/details?id=" + getPackageName(); 
		
		// Share event start
		final Button share = (Button) findViewById(R.id.share);
		share.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
				sharingIntent.setType("text/plain");
				//Your App Description with market link
				String shareBody = "Golakar Kids Education App \n\n" + marketLink;
				//Your app Name
				sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Golakar Android app");
				sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
				startActivity(Intent.createChooser(sharingIntent, "Share via"));

			}
		});
		

	
	//Rate App
			Button get = (Button) findViewById(R.id.home_btn_rate);
			get.setOnClickListener(new Button.OnClickListener() {
				public void onClick(View v) {
					Uri uri = Uri.parse("https://play.google.com/store/apps/details?id=YOUR_APP_PACKAGE_NAME");
					startActivity(new Intent(Intent.ACTION_VIEW, uri));
				}
			}); 		
			
		}
	
	
	
	private void StartAnimations() {
    	Animation anim = AnimationUtils.loadAnimation(this, R.anim.alpha);
		anim.reset();
		LinearLayout headerTop = (LinearLayout) findViewById(R.id.balloon);		
		headerTop.clearAnimation();
		headerTop.startAnimation(anim);

		anim = AnimationUtils.loadAnimation(this, R.anim.translate);
		anim.reset();
		ImageView iv = (ImageView) findViewById(R.id.logo);		
		iv.clearAnimation();
		iv.startAnimation(anim);

		anim = AnimationUtils.loadAnimation(this, R.anim.translate);
		anim.reset();
		RelativeLayout mainMenu = (RelativeLayout) findViewById(R.id.main_menu);
		mainMenu.setVisibility(View.VISIBLE);
		mainMenu.clearAnimation();
		mainMenu.startAnimation(anim);
				
    }
	
		private void initCenterMenu(GolCenterMenu menu, int[] itemDrawables) {
		    final int itemCount = itemDrawables.length;
		    for (int i = 0; i < itemCount; i++) {
		        ImageView item = new ImageView(this);
		        item.setImageResource(itemDrawables[i]);
		        final int position = i;
		        menu.addItem(item, new OnClickListener() {

		            @Override
		            public void onClick(View v) {
		            	switch(position){
						
						case 0:							
							Intent i=new Intent(MainActivity.this,AlphabetActivity.class);
							startActivity(i);							
							break;
						case 1:							
							Intent i1=new Intent(MainActivity.this,NumbersActivity.class);
							startActivity(i1);							
							break;
						
						case 2:							
							Intent i2=new Intent(MainActivity.this,GuessActivity.class);
							startActivity(i2);							
							break;
						case 3:							
							Intent i3=new Intent(MainActivity.this,GolQuizActivity.class);
							startActivity(i3);							
							break;
						case 4:							
							Intent i4=new Intent(MainActivity.this,ImageGameStart.class);
							startActivity(i4);
							//finish();														
							break;							
		            	} 												
		        		
					}
				});
		    }
		}
		
		@Override
	    public void onResume(){
			super.onResume();

	    }	
	    @Override
	    public void onPause() {
	        super.onPause();

	    }

	@Override
	protected void onDestroy() {
		super.onDestroy();

		unbindDrawables(findViewById(R.id.dashboard));
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
		public boolean onKeyDown(int keyCode, KeyEvent event) {
		
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			// Toast.makeText(appContext, "BAck", Toast.LENGTH_LONG).show();
			AlertDialog.Builder alert = new AlertDialog.Builder(
			MainActivity.this);
			//alert.setTitle(string.app_name);
			alert.setIcon(R.drawable.ic_launcher);
			alert.setMessage("Are You Sure, You Want To Quit App?");
		
			alert.setPositiveButton("Yes",
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog,
						int whichButton) {

						finish();
						}
								 
					});
		
			alert.setNegativeButton("NO",
					new DialogInterface.OnClickListener() {
		
						public void onClick(DialogInterface dialog, int which) {							 
							 
						}
					});
			alert.show();
			return true;
		}
		
		return super.onKeyDown(keyCode, event);
		
		}
		public void about(View view) {
			  golakarApp = new Intent(this, AboutUs.class);
			 	startActivity(golakarApp);
		    }
	}



