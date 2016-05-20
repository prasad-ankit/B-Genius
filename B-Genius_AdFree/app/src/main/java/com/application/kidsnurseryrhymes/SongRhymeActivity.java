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

public class SongRhymeActivity extends Activity
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
	    arrayOfString1[0] = "A B C D E F G";
	    arrayOfString1[1] = "Pussy Cat Pussy Cat";
	    arrayOfString1[2] = "Today is Monday";
	    arrayOfString1[3] = "The Farmer";
	    arrayOfString1[4] = "Twinkle Twinkle";
	    arrayOfString1[5] = "Willie Winkie";
	    arrayOfString1[6] = "Old King Cole";
	    arrayOfString1[7] = "Bluebird Through My Window";
	    arrayOfString1[8] = "One Two Three";
	    arrayOfString1[9] = "Clap Your Hands";
	    heading = arrayOfString1;
	    
	    String[] arrayOfString2 = new String[10];
	    arrayOfString2[0] = "A, B, C, D, E, F, G;  <br> H, I, J, K, L, M, N, O, P  <br>  Q R S, T U V,  <br> Double-U, X, Y and Z  <br>  Now I know my abc's,  <br>  Next time won't you sing with me.  ";
	    arrayOfString2[1] = "Pussy cat,   pussy cat,    <br>  where have you been?   <br>   been up to London to look at the queen.   <br>  Pussy cat,   pussy cat,    <br>  what did you do?   <br>  frightened a little mouse under her chair.   <br>  ";
	    arrayOfString2[2] = "Today is Monday, today is Monday <br> Monday string beans, all you hungry children  <br>  come and eat it up <br>  Today is Tuesday, today is Tuesday  <br>  Tuesday spaghetti, Monday string beans <br> All you hungry children, come and eat it up <br>    Today is Wednesday, today is Wednesday  <br> Wednesday soup, Tuesday spaghetti  <br>  Monday string beans, all you hungry children <br> Come and eat it up  <br>   Today is Thursday, today is Thursday <br>  Thursday roast beef, Wednesday soup <br>  Tuesday spaghetti, Monday string beans  <br>  All you hungry children, come and eat it up  <br>  Today is Friday, today is Friday <br> Friday fresh fish, Thursday roast beef <br> Wednesday soup <br> Tuesday spaghetti, Monday string beans <br> All you hungry children, come and eat it up <br>   Today is Saturday, today is Saturday <br> Saturday chicken, Friday fresh fish <br> Thursday roast beef, Wednesday soup <br> Tuesday spaghetti, Monday string beans <br> All you hungry children, come and eat it up <br>   Today is Sunday, today is Sunday <br> Sunday ice cream, Saturday chicken <br> Friday fresh fish, Thursday roast beef <br> Wednesday soup, Tuesday spaghetti <br> Monday string beans, all you hungry children <br> Come and eat it up ";
	    arrayOfString2[3] = "The farmer in the dell  <br>  The farmer in the dell  <br>  Hi-ho,   the derry-o  <br>  The farmer in the dell  <br>  The farmer takes a wife  <br>  The farmer takes a wife  <br>  Hi-ho,   the derry-o  <br>  The farmer takes a wife  <br>   The wife takes a dog  <br>  The wife takes a dog  <br>  Hi-ho,   the derry-o  <br>  The wife takes a dog  <br>  The dog takes a cat  <br>  The dog takes a cat  <br>  Hi-ho,   the derry-o  <br>  The dog takes a cat  <br>  The cat takes a rat  <br>  The cat takes a rat  <br>  Hi-ho,   the derry-o  <br>  The cat takes a rat  <br>  The rat takes the     \tcheese  <br>  The rat takes the cheese  <br>  Hi-ho,   the derry-o  <br>  The rat takes the cheese  <br>  The cheese stands alone  <br>  The cheese stands alone  <br>  Hi-Ho,   the     \tderry-o  <br>  The cheese stands alone  <br>  ";
	    arrayOfString2[4] = "Twinkle,   twinkle,   little star,     <br>  How I wonder what you are.   <br>       Up above the world so high,     <br>       Like a diamond in the sky.   <br>   When the blazing sun is gone,     <br>       When he nothing shines upon,     <br>   Then you show your little light,     <br>       Twinkle,   twinkle,   all the night.   <br>   Twinkle,   twinkle,   little star,     <br>       How I wonder what you are.   <br>           Then the traveller in the dark,     <br>       Thanks you for your tiny spark,     <br>       He could not see which way to go,     <br>       If you did not twinkle so.   <br>    In the dark blue sky you keep,     <br>       Why u through my curtains peep,     <br>    And you never shut your eye,     <br>       Till the sun is in the sky.   <br>     Twinkle,   twinkle,   little star.   <br>       How I wonder what you are. <br>     Twinkle,   twinkle,   little star.   <br>       How I wonder what you are.  <br>    Up above the world so high,     <br>       Like a diamond in the sky.   <br>   ";
	    arrayOfString2[5] = "Wee Willie Winkie runs through the town,     <br>  Upstairs and downstairs in his nightgown,     <br>  Wee Willie Winkie runs through the town,     <br>  Upstairs and downstairs in his nightgown,     <br>  Wee Willie Winkie runs through the town,     <br>  Upstairs and downstairs in his nightgown,     <br>  Tapping at the window and crying through the lock,     <br>  Are all the children in their beds,   it's past eight o'clock?";
	    arrayOfString2[6] = "Old King Cole was a merry old soul, <br> And a merry old soul was he; <br> He called for his pipe, and he called for his bowl <br> And he called for his fiddlers three. <br> Old King Cole was a merry old soul<br> And a merry old soul was he; <br> He called for his pipe, and he called for his bowl <br> And he called for his fiddlers three.";
	    arrayOfString2[7] = "Bluebird, bluebird, through my window, <br> Bluebird, bluebird, through my window, <br> Bluebird, bluebird, through my window, <br> Oh Johnny Im tired <br> Red bird, red bird, through my window  <br> Red bird, red bird, through my window  <br> Red bird, red bird, through my window  <br> Oh Johnny Im tired  <br>  Yellow bird, yellow bird, through my window <br>  Yellow bird, yellow bird, through my window <br>  Yellow bird, yellow bird, through my window <br>  Oh Johnny Im tired <br>  Purple bird, purple bird, through my window <br>  Purple bird, purple bird, through my window <br>  Purple bird, purple bird, through my window <br>  Oh Johnny Im tired";
	    arrayOfString2[8] = "One,   two,   three,   four,   five.   <br>  Once I caught a fish alive,     <br>  Five,   Six,   seven,   eight  <br>  Then I let it go away.   <br>  Why did you let it go?   <br>  Was it bit my finger so.   <br>  Which finger did it bite?   <br>  This little finger on the right.";
	    arrayOfString2[9] = "Clap your hands,   clap your hands,     <br>  Listen to the music and clap Your hands  <br>  Clap your hands,   clap your hands,     <br>  Listen to the music and clap Your hands  <br>  Turn around,   turn around,     <br>  Listen to the music and turn around.   <br>  Turn around,   turn around,     <br>  Listen to the music and turn around.   <br>  Jump up high,   jump up high,     <br>  Listen to the music and jump up high.   <br>  Jump up high,   jump up high,     <br>  Listen to the music and jump up high.   <br>  Wave your hand,   wave your hand,     <br>  Listen to the music and wave your hand.  <br>  Wave your hand,   wave your hand,     <br>  Listen to the music and wave your hand.";
	    lyrics = arrayOfString2;
	    
	   int[] arrayOfInt = new int[10];
	    arrayOfInt[0] = R.raw.alphabet_song;
	    arrayOfInt[1] = R.raw.pussey_cat;
	    arrayOfInt[2] = R.raw.today_is_monday;
	    arrayOfInt[3] = R.raw.the_farmer;
	    arrayOfInt[4] = R.raw.twinkle;
	    arrayOfInt[5] = R.raw.wille_wille;
	    arrayOfInt[6] = R.raw.old_king_cole;
	    arrayOfInt[7] = R.raw.bluebird_through_my_window;
	    arrayOfInt[8] = R.raw.one_two;
	    arrayOfInt[9] = R.raw.clap_your_hands;
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
          String str = String.valueOf("0" + k + "." +j);
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
    StartAppSDK.init(this, AppConstants.DEVELOPER_ID, AppConstants.APP_ID, true);
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
        //seekbar.setMax((int)mediaPlayer.getCurrentPosition());
        //handler.postDelayed(notification,100);
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
