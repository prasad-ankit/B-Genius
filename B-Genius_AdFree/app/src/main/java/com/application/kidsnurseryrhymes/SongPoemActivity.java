package com.application.kidsnurseryrhymes;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.startapp.android.publish.StartAppSDK;

import ksz.test.b_genius.R;

public class SongPoemActivity extends Activity
{
  public static String[] heading;
  public static String[] lyrics;
  public static int[] playlist ;
  int get;
  private final Handler handler = new Handler();
  ImageView play;
  private int mediaFileLengthInMilliseconds;
  private MediaPlayer mediaPlayer;
  Runnable notification;
  SeekBar seekbar;
  TextView endtime;
  TextView song;
  TextView starttime;
  TextView title;
  	
	static
  {
    String[] arrayOfString1 = new String[10];
    arrayOfString1[0] = "One Two Buckle My";
    arrayOfString1[1] = "Baa Baa Black Sheep";
    arrayOfString1[2] = "Can You Sit in a Circle";
    arrayOfString1[3] = "Little Digger Dog";
    arrayOfString1[4] = "One Two Buckle My";
    arrayOfString1[5] = "Greasy Grimy Gopher Guts";
    arrayOfString1[6] = "Four Little Paper Dolls";
    arrayOfString1[7] = "Here Is A Choo-Choo Train";
    arrayOfString1[8] = "Teddy Bear";
    arrayOfString1[9] = "The Old Woman";
    heading = arrayOfString1;
    
    String[] arrayOfString2 = new String[10];
    arrayOfString2[0] = "One,   two,     <br>  Buckle my shoe;   <br>  Three,   four,     <br>  Knock at the door;   <br>  Five,   six,   Pick up sticks;   <br>  Seven,   eight,     <br>  Lay them straight   <br>  Nine,   ten,     <br>  A good,   fat hen;   <br>  ";
    arrayOfString2[1] = "Baa baa black sheep, have you any wool?  <br>  Yes sir, yes sir, three bags full.  <br>  One for my master, one for my dame  <br>  One for the little boy who lives down the lane  <br>  Baa baa black sheep, have you any wool?   <br>  Yes sir, yes sir, three bags full. ";
    arrayOfString2[2] = "One, two, three, four, five, six, seven, eight, nine, ten  <br>  Can you sit in a circle before I count to ten again   <br>  Let's see how fast you are today,  <br>  can you sit in a circle before I say  <br>  One, two, three, four, five, six, seven, eight, nine, ten  ";
    arrayOfString2[3] = "I have a little doggy, his paws are really big  <br>   And when he goes outside he likes to dig and dig and dig  <br>   He drops his bone into the hole and covers it in a snap  <br>   Puts one paw on the other then lies down to take a nap ";
    arrayOfString2[4] = "Five little men made out of snow    <br>    Each with a hat and a big red bow  <br>    Out came the sun and he stayed all day   <br> One little snowman melted away, and he said,  <br>  'Oops- I'm a puddle!' ";
    arrayOfString2[5] = "Great green globs of greasy, grimy gopher guts,  <br>  Mutilated monkey meat.  <br>Dirty little birdie feet.  <br>   Great green globs of greasy, grimy gopher guts  <br>   And me without my spoon. ";
    arrayOfString2[6] = "Four little paper dolls in a row  <br>  One said, 'Sorry, but I have to go'  <br>     Three little paper dolls in a row  <br>  One said, 'Sorry, but I have to go'  <br>  Two little paper dolls in a row  <br>  One said, 'Sorry, but I have to go'  <br>    One paper doll said, 'Where are my friends?'  <br>  They all came back'.. And this is the end ";
    arrayOfString2[7] = "Here is a choo-choo train,    <br> Chugging down the track  <br> Now it's going faster,  <br>   Now the bell is ringing, <br> Now the whistle blows,  <br>    What a lot of noise it makes  <br>Everywhere it goes ";
    arrayOfString2[8] = "Teddy bear,   teddy bear,     <br>  Turn around.   <br>  Teddy bear,   teddy bear,     <br>  Touch the ground.   <br>  Teddy bear,   teddy bear,     <br>  Go upstairs.   <br>   Teddy bear,   teddy bear,     <br>  Say your prayers.   <br>  Teddy bear,   teddy bear,     <br>  Turn out the light.   <br>  Teddy bear,   teddy bear,     <br>  Say good night.";
    arrayOfString2[9] = "There was an old woman who lived in a shoe. <br> She had so many children, she didn't know what to do; <br> She gave them some broth and a bid slice of bread; <br> kissed them all soundly and sent them to bed.";
    lyrics = arrayOfString2;
    
    int[] arrayOfInt = new int[10];
    arrayOfInt[0] = R.raw.onetwobuck;
    arrayOfInt[1] = R.raw.baa_baa_black_sheep;
    arrayOfInt[2] = R.raw.can_you_sit_in_a_circle_ver;
    arrayOfInt[3] = R.raw.digger_dog;
    arrayOfInt[4] = R.raw.five_little_snowmen;
    arrayOfInt[5] = R.raw.greasy_grimy_gopher_guts;
    arrayOfInt[6] = R.raw.four_little_paper_dolls;
    arrayOfInt[7] = R.raw.here_is_a_choochoo_train;
    arrayOfInt[8] = R.raw.teddy_bear;
    arrayOfInt[9] = R.raw.the_old_women;
    playlist = arrayOfInt; 
  }

  private void SeekBarProgressUpdater()
  {
    //seekbar.setProgress((int)(100.0F * (mediaPlayer.getCurrentPosition() / mediaFileLengthInMilliseconds)));
    if (mediaPlayer.isPlaying())
    {
      notification = new Runnable()
      {
        public void run()
        {
          SeekBarProgressUpdater();
          int i = mediaPlayer.getCurrentPosition();
          int j = i / 1000 % 60;
          int k = i / 60000 % 60;
          String str = String.valueOf("0" + k + "." + j);
          starttime.setText(str);
        }
      };
      seekbar.setProgress(mediaPlayer.getCurrentPosition());
      handler.postDelayed(notification, 100);
    }
}
  
  
  protected void onCreate(Bundle paramBundle)
  {
    requestWindowFeature(1);
    super.onCreate(paramBundle);
    StartAppSDK.init(this, AppConstants.DEVELOPER_ID, AppConstants.APP_ID, true); //TODO: Replace with your IDs
    setContentView(R.layout.songplayactivity);
    

    title = ((TextView)findViewById(R.id.heading));
    song = ((TextView)findViewById(R.id.songyrics));
    starttime = ((TextView)findViewById(R.id.starttimer));
    endtime = ((TextView)findViewById(R.id.endtimer));
    seekbar = ((SeekBar)findViewById(R.id.seekBar1));
    play = ((ImageView)findViewById(R.id.playpause));
    get = getIntent().getExtras().getInt("position");
    title.setText(heading[get]);
    String str = Html.fromHtml(lyrics[get]).toString();
    song.setText(str);
    
    mediaPlayer = MediaPlayer.create(getApplicationContext(), playlist[get]);
    play();
    //primarySeekBarProgressUpdater();
    seekbar.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View v, MotionEvent event)
      {
        if (mediaPlayer.isPlaying())
        {
          SeekBar localSeekBar = (SeekBar)v;
          int i = localSeekBar.getProgress();
          mediaPlayer.seekTo(i);
        }
        return false;
      }
    });
    mediaPlayer.setOnBufferingUpdateListener(new MediaPlayer.OnBufferingUpdateListener()
    {
      public void onBufferingUpdate(MediaPlayer paramMediaPlayer, int paramInt)
      {
        seekbar.setSecondaryProgress(paramInt);
      }
    });
    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
    {
      public void onCompletion(MediaPlayer paramMediaPlayer)
      {
        play.setImageResource(R.drawable.play_btn);
      }
    });
  }



public void onDestroy()
  {
    super.onDestroy();
    mediaPlayer.stop();
    mediaPlayer.release();
    mediaPlayer = null;
    handler.removeCallbacks(notification);
  }

  public void play()
  {
    play.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        mediaFileLengthInMilliseconds = mediaPlayer.getDuration();
        int i = mediaFileLengthInMilliseconds / 1000 % 60;
        int j = mediaFileLengthInMilliseconds / 60000 % 60;
        String str = String.valueOf("0" + j + "." + i);
        endtime.setText(str);
        seekbar.setMax(mediaPlayer.getDuration());
        if (!mediaPlayer.isPlaying())
        {
          mediaPlayer.start();
          //seekbar.setMax((int)mediaPlayer.getDuration());
          play.setImageResource(R.drawable.pause_btn);
          starttime.clearAnimation();
        }
        else
        {
          mediaPlayer.pause();
          
          AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
          localAlphaAnimation.setDuration(1000);
          localAlphaAnimation.setStartOffset(20);
          localAlphaAnimation.setRepeatCount(-1);
          starttime.startAnimation(localAlphaAnimation);
          play.setImageResource(R.drawable.play_btn);
        }
       SeekBarProgressUpdater();
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
	overridePendingTransition(R.anim.rightin, R.anim.rightout);
  	super.onBackPressed();
  }
}
