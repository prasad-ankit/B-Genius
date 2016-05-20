package com.application.kidsnurseryrhymes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.startapp.android.publish.StartAppSDK;

import ksz.test.b_genius.R;

public class SplashActivity extends Activity
{
	/** StartAppAd object declaration */

		protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    StartAppSDK.init(this, AppConstants.DEVELOPER_ID, AppConstants.APP_ID, true);
    setContentView(R.layout.splashactivity);
    
    Thread background = new Thread()
    {
    	 public void run() {
             
    	try {
            // Thread will sleep for 5 seconds
            sleep(1*1000);
             
            // After 5 seconds redirect to another intent
            Intent i=new Intent(getBaseContext(),ListActivity.class);
            startActivity(i);
             
            //Remove activity
            finish();
             
        } catch (Exception e) {
         
        }
    }
};
    background.start();
  }
  @Override
  public void onResume() {
  	super.onResume();

  }

  @Override
  public void onPause() {
  	super.onPause();

  }

  @Override
  public void onBackPressed() {
	overridePendingTransition(R.anim.rightin, R.anim.rightout);
  	super.onBackPressed();
  }
}

