/**Project Under : Golakar Kids Apps
 * You can not modify & redistribute without permission from the author
 * Project published on Golakar Technology platform April, 2014
 * Release Template for the buyer august 2015
 */
package com.golakar.kids.edu.utilities;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;

import com.golakar.kids.edu.MainActivity;
import ksz.test.b_genius.R;


public class NumbersActivity extends Activity {

	MediaPlayer mp = null;
	boolean Is_gTuner=false;	
	static int i = 0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_numbers);
		
		
	}
	
	public void processBack (View view)
	{
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
	}
	
	public void playNumber(View view) {
		final ImageView image;
		Log.v("Golakar ","Inside playNumber");
		
		
		if (!Is_gTuner)
		{
			if(mp!=null)
			{	
				mp.stop();
				mp.release();
			}
			Log.v("Golakar","Inside playNumber is false");
				image = (ImageView) findViewById(R.id.numberView);
				switch(view.getId())
				{
				case R.id.one:			 		
					mp=MediaPlayer.create(this,R.raw.gol_one);
			 		image.setImageResource(R.drawable.number_01);			 		
			 		i=0;	
			 		break;
				case R.id.two:			 		
					mp=MediaPlayer.create(this,R.raw.gol_two);
			 		image.setImageResource(R.drawable.number_02);			 		
			 		i=1;
			 		break;
			 		
				case R.id.three:			 		
					mp=MediaPlayer.create(this,R.raw.gol_three);
			 			image.setImageResource(R.drawable.number_03);			 		
			 			i=1;
			 		break;
				case R.id.four:			 		
					mp=MediaPlayer.create(this,R.raw.gol_four);
			 			image.setImageResource(R.drawable.number_04);			 		
			 			i=1;
			 		break;
				case R.id.five:			 		
					mp=MediaPlayer.create(this,R.raw.gol_five);
			 			image.setImageResource(R.drawable.number_05);			 		
			 			i=1;
			 		break;
				case R.id.six:			 		
					mp=MediaPlayer.create(this,R.raw.gol_six);
			 			image.setImageResource(R.drawable.number_06);			 		
			 			i=1;
			 		break;
				case R.id.seven:			 		
					mp=MediaPlayer.create(this,R.raw.gol_seven);
			 			image.setImageResource(R.drawable.number_07);			 		
			 			i=1;
			 		break;
				case R.id.eight:			 		
					mp=MediaPlayer.create(this,R.raw.gol_eight);
			 			image.setImageResource(R.drawable.number_08);			 		
			 			i=1;
			 		break;
				case R.id.nine:			 		
					mp=MediaPlayer.create(this,R.raw.gol_nine);
			 			image.setImageResource(R.drawable.number_09);			 		
			 			i=1;
			 		break;
				case R.id.ten:			 		
					mp=MediaPlayer.create(this,R.raw.gol_ten);
			 			image.setImageResource(R.drawable.number_10);			 		
			 			i=1;
			 			
			 		break;
						default:
			 		throw new RuntimeException("Unknow button ID");
				}
				
				if (mp!=null)
				{
					mp.start();
				
				}
		}
		else
		{
		
		}		
		
		Log.v("Golakar","Exit playNumber");
	}
	
	protected void onPause() {
	     super.onPause();

	      if(mp!= null)
          {
              mp.stop();
              mp.release();
              mp=null;
          }
       //   finish();
    
	 }
	 public boolean onKeyDown(int keyCode, KeyEvent event) 
	    {
	        if ((keyCode == KeyEvent.KEYCODE_BACK)) 
	        { 
	            if(mp!= null)
	            {
	                mp.stop();
	                mp.release();
	                mp=null;
	            }
	          finish();
	            return true;
	        }
	        return super.onKeyDown(keyCode, event);
	    }
}