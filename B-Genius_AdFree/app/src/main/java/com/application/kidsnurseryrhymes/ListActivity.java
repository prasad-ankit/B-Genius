package com.application.kidsnurseryrhymes;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.application.kidsnurseryrhymes.adapter.CustomList;
import com.startapp.android.publish.StartAppSDK;

import ksz.test.b_genius.R;

public class ListActivity extends Activity {
	TextView categories;
	protected AlphaAnimation fadeIn;
	protected AlphaAnimation fadeOut;

		ListView list;
	  String[] web = {
	      "Rhythem",
	      "Poem"
	  } ;
	  
	  @Override
	  protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    requestWindowFeature(1);
	    StartAppSDK.init(this, AppConstants.DEVELOPER_ID, AppConstants.APP_ID, true);
	    setContentView(R.layout.categories);
	    

	 		
	        //Locate the Banner Ad in activity_main.xml
	  		// Load ads into Banner Ads
	  		//adView.loadAd(adRequest);
	  		Animation shake = AnimationUtils.loadAnimation(ListActivity.this, R.anim.shake);
	  		findViewById(R.id.textView1).startAnimation(shake);
	  		categories = (TextView)findViewById(R.id.textView1);
	  		CustomList adapter = new CustomList(ListActivity.this, web);
	  		list=(ListView)findViewById(R.id.listView1);
	        list.setAdapter(adapter);
	        list.setOnItemClickListener(new AdapterView.OnItemClickListener() 
	        {
	                @Override
	                public void onItemClick(AdapterView<?> parent, View view,
	                                        int position, long id) 
	                {
	                	if(position == 0)
	                	{
							Intent in = new Intent(getApplicationContext(),MainRhymeActivity.class);
							startActivity(in);
							overridePendingTransition(R.anim.rightin, R.anim.rightout);
							
	                	}
	                	else if (position == 1)
	                	{
							Intent in1 = new Intent(getApplicationContext(),MainPoemActivity.class);
							startActivity(in1);
							overridePendingTransition(R.anim.rightin, R.anim.rightout);
							
	                	}
						
	                }
	            });
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

		super.onBackPressed();
	}
}
