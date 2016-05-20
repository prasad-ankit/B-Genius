package ksz.test.b_genius;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import com.application.kidsnurseryrhymes.SplashActivity;

public class MainActivity extends AppCompatActivity {

    Animation anim,anim2,anim3,anim4,anim5;
    Button b1,b2,b3,b4,b5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Snackbar.make(view, "Hello B-Genius Learning", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.abc_slide_in_bottom);
        anim.setDuration(500);
        anim.setStartOffset(1000);

        anim2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.abc_slide_in_bottom);
        anim2.setDuration(500);
        anim2.setStartOffset(1250);

        anim3 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.abc_slide_in_bottom);
        anim3.setDuration(500);
        anim3.setStartOffset(1500);

        anim4 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.abc_slide_in_bottom);
        anim4.setDuration(500);
        anim4.setStartOffset(1750);

        anim5 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.abc_slide_in_bottom);
        anim5.setDuration(500);
        anim5.setStartOffset(2000);

        b1 = (Button)findViewById(R.id.bubble_btn);
        b2 = (Button)findViewById(R.id.cal_button);
        b3 = (Button)findViewById(R.id.calender_button);
        b4 = (Button)findViewById(R.id.calender2_button);
        b5 = (Button)findViewById(R.id.button5);



        b1.startAnimation(anim);
        b2.startAnimation(anim2);
        b3.startAnimation(anim3);
        b4.startAnimation(anim4);
        b5.startAnimation(anim5);


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

       // unbindDrawables(findViewById(R.id.dashboard));
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
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        AudioManager audioManager = (AudioManager) getApplicationContext().getSystemService(Context.AUDIO_SERVICE);

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        if (id == R.id.action_volume_up) {

            audioManager.adjustVolume(AudioManager.ADJUST_RAISE, AudioManager.FLAG_PLAY_SOUND);
        }

        if (id == R.id.action_volume_down) {

            audioManager.adjustVolume(AudioManager.ADJUST_LOWER, AudioManager.FLAG_PLAY_SOUND);
        }


        return super.onOptionsItemSelected(item);
    }


    public void goto_preschoolapp(View view)
    {
        Intent intent = new Intent(this, com.golakar.kids.edu.SplashActivity2.class);
        startActivity(intent);
        //Intent intent = new Intent();
        //intent.setComponent(new ComponentName("in.mait.placementor", "in.mait.placementor.About"));
        //startActivity(intent);

    }

    public void goto_catchorange(View view)
    {

    }

    public void goto_happygirl2(View view)
    {

    }

    public void goto_nursery(View view)
    {
        Intent intent = new Intent(this, SplashActivity.class);
        startActivity(intent);
    }

    public void goto_braintraining(View view)
    {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://codecanyon.net/item/brain-training-remember-skill-facebook-admod/15573194"));
        startActivity(intent);
    }


}
