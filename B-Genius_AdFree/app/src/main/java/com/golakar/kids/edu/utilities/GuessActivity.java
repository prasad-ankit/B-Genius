/**Project Under : Golakar Kids Apps
 * You can not modify & redistribute without permission from the author
 * Project published on Golakar Technology platform April, 2014
 * Release Template for the buyer august 2015
 */
package com.golakar.kids.edu.utilities;

import java.util.Locale;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import ksz.test.b_genius.R;


public class GuessActivity extends Activity implements TextToSpeech.OnInitListener
{
	private char[] alphabet = {
			'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
			'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'
			};
	private int currentAlphabetIndex = 0;
	private final String ACTIVITY_NAME = "GolGuess";
	// Navigation Buttons
	private Button golNext = null; 
	private Button golPrevious = null;
	// Image Views
	private ImageView alphabetIcon = null; 
	private ImageView questionIcon = null; 
	private TextView golFooterCaption = null;
	private TextToSpeech tts = null;
	private boolean isTtsActive = false;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess);
      
        
        Typeface font = Typeface.createFromAsset(getAssets(), "BankGothic.ttf");
 		((TextView) findViewById(R.id.footerCaption)).setTypeface(font);
   
        Log.i(ACTIVITY_NAME, "Passed setContentView");       
        
        enableImageButtonEvents();
        initializeTTS();
        initializeAlphabet();
        updateAlphabet(currentAlphabetIndex);

        Log.i(ACTIVITY_NAME, "onCreate() complete");
    }
    
    private void enableImageButtonEvents()
    {
      // Previous Image Button  
      golPrevious = (Button) findViewById(R.id.prevButton);
        
        if (golPrevious != null)
        {
        	golPrevious.setOnClickListener(new OnClickListener() {

        	     @Override
        	     public void onClick(View v) 
        	     {
					currentAlphabetIndex--;
					
					if (currentAlphabetIndex < 0)
					{
						currentAlphabetIndex = 25;
					}
					
					updateAlphabet(currentAlphabetIndex);
          	     }
        	    });
        }
        
        // Next Image Button        
        golNext = (Button) findViewById(R.id.nextButton);
        
        if (golNext !=null)
        {
	        golNext.setOnClickListener(new OnClickListener() {
	        	
	        	@Override
				public void onClick(View view)
				{
					currentAlphabetIndex++;
					
					if (currentAlphabetIndex > 25)
					{
						currentAlphabetIndex = 0;
					}
					
					updateAlphabet(currentAlphabetIndex);
				}
			});        
        }            	
    }
    
    private void initializeTTS()
    {
     
        tts = new TextToSpeech(this, this);
    }
    
    public void onInit(int status) 
    {
       if (status == TextToSpeech.SUCCESS) 
        {
            
            int result = tts.setLanguage(Locale.US);
            // Try this someday for some interesting results.
            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) 
            {
               // Language data is missing or the language is not supported.
                Log.e(ACTIVITY_NAME, "Language is not available.");
            }
            else 
            {
            	isTtsActive = true;
            }
        } 
        else 
        {
            // Initialization failed.
            Log.e(ACTIVITY_NAME, "Could not initialize TextToSpeech.");
        }
    }    
    
    @SuppressWarnings("deprecation")
	private void speakAlphabet(int currentIndex)
    {
    	if (tts != null && isTtsActive)
    	{
    	   char alphabet = this.alphabet[currentIndex];
    	   tts.speak(String.valueOf(alphabet),
    	            TextToSpeech.QUEUE_FLUSH,
    	            null);
    	}
    }
    
    @SuppressWarnings("deprecation")
	private void speakWord(String word)
    {
    	if (tts != null && isTtsActive)
    	{
    	   tts.speak(String.valueOf(word),
    	            TextToSpeech.QUEUE_FLUSH, 
    	            null);
    	}
    }     
    
    @Override
    public void onDestroy() 
    {
          if (tts != null) 
        {
        	tts.stop();
        	tts.shutdown();
        }

        super.onDestroy();
    }  
    
    private void initializeAlphabet()
    {
    	golFooterCaption = (TextView) findViewById(R.id.footerCaption);
    	golFooterCaption.setClickable(true);
    	golFooterCaption.setVisibility(View.INVISIBLE);
    	golFooterCaption.setOnClickListener(new OnClickListener() {

      	     @Override
      	     public void onClick(View v) 
      	     {
      	    	speakWord(String.valueOf(golFooterCaption.getText()));
        	 }
      	    });     	    	
    	
    	alphabetIcon = (ImageView) findViewById(R.id.alphabet_icon); 
    	alphabetIcon.setClickable(true);
    	alphabetIcon.setOnClickListener(new OnClickListener() {

	   	     @Override
	   	     public void onClick(View v) 
	   	     {
	   	    	speakAlphabet(currentAlphabetIndex);
	     	 }
	   	    });    	
   	
    	questionIcon = (ImageView) findViewById(R.id.question_icon);
    	questionIcon.setClickable(true);
    	questionIcon.setOnClickListener(new OnClickListener() {

      	     @Override
      	     public void onClick(View v) 
      	     {
      	        // Convert question into apple, speak apple and make bottom caption visible.
      	    	showImageForQuestion(currentAlphabetIndex);
      	    	speakWord(String.valueOf(golFooterCaption.getText()));
      	    	golFooterCaption.setVisibility(View.VISIBLE);
        	 }
      	    });     	

    }
    
    private void showImageForQuestion(int index)
    {
    	// This is the current alphabet
    	char currentAlphabet = alphabet[index];

    	switch (currentAlphabet)
    	{
    			case 'a': 
    				       questionIcon.setImageResource(R.drawable.letter_a);
			    			break;
    			case 'b': 
							 questionIcon.setImageResource(R.drawable.letter_b);
							 break;
    			case 'c': 
							 questionIcon.setImageResource(R.drawable.letter_c);
							 break;
    			case 'd': 
							 questionIcon.setImageResource(R.drawable.letter_d);
							 break;    			
    			case 'e': 
							 questionIcon.setImageResource(R.drawable.letter_e);
							 break;    			
    			case 'f':
							 questionIcon.setImageResource(R.drawable.letter_f);
							 break;    			
    			case 'g': 
							 questionIcon.setImageResource(R.drawable.letter_g);
							 break;    			
    			case 'h':
							 questionIcon.setImageResource(R.drawable.letter_h);
							 break;     			
    			case 'i':
							 questionIcon.setImageResource(R.drawable.letter_i);
							 break;     			
    			case 'j': 
							 questionIcon.setImageResource(R.drawable.letter_j);
							 break;     			
    			case 'k':
							 questionIcon.setImageResource(R.drawable.letter_k);
							 break;     			
    			case 'l': 
							 questionIcon.setImageResource(R.drawable.letter_l);
							 break;     			
    			case 'm':
							 questionIcon.setImageResource(R.drawable.letter_m);
							 break; 
    			case 'n':
							 questionIcon.setImageResource(R.drawable.letter_n);
							 break; 
    			case 'o': 
							 questionIcon.setImageResource(R.drawable.letter_o);
							 break;     			
    			case 'p':
							 questionIcon.setImageResource(R.drawable.letter_p);
							 break;     			
    			case 'q': 
							 questionIcon.setImageResource(R.drawable.letter_q);
							 break;     			
    			case 'r': 
							 questionIcon.setImageResource(R.drawable.letter_r);
							 break;     			
    			case 's':
							 questionIcon.setImageResource(R.drawable.letter_s);
							 break;     			
    			case 't':
							 questionIcon.setImageResource(R.drawable.letter_t);
							 break;     		
    			case 'u':
							 questionIcon.setImageResource(R.drawable.letter_u);
							 break;     			
    			case 'v':
							 questionIcon.setImageResource(R.drawable.letter_v);
							 break;     			
    			case 'w':
							 questionIcon.setImageResource(R.drawable.letter_w);
							 break;     			
    			case 'x': 
							 questionIcon.setImageResource(R.drawable.letter_x);
							 break;     			
    			case 'y':
							 questionIcon.setImageResource(R.drawable.letter_y);
							 break;     			
    			case 'z':
							 questionIcon.setImageResource(R.drawable.letter_z);
							 break;     			
    	}    	
    	
    }
    
    private void updateAlphabet(int index)
    {
    	// This is the current alphabet
    	char currentAlphabet = alphabet[index];
    	golFooterCaption.setVisibility(View.INVISIBLE);
    	questionIcon.setImageResource(R.drawable.question);
    	
    	switch (currentAlphabet)
    	{
    			case 'a': golFooterCaption.setText(String.valueOf(getResources().getString(R.string.a)));  
			    			alphabetIcon.setImageResource(R.drawable.alphabet_a);
			    			break;
    			case 'b': golFooterCaption.setText(String.valueOf(getResources().getString(R.string.b)));  
							 alphabetIcon.setImageResource(R.drawable.alphabet_b);
							 break;
    			case 'c': golFooterCaption.setText(String.valueOf(getResources().getString(R.string.c)));
							 alphabetIcon.setImageResource(R.drawable.alphabet_c);
							 break;
    			case 'd': golFooterCaption.setText(String.valueOf(getResources().getString(R.string.d)));
							 alphabetIcon.setImageResource(R.drawable.alphabet_d);
							 break;    			
    			case 'e': golFooterCaption.setText(String.valueOf(getResources().getString(R.string.e)));
							 alphabetIcon.setImageResource(R.drawable.alphabet_e);
							 break;    			
    			case 'f': golFooterCaption.setText(String.valueOf(getResources().getString(R.string.f)));
							 alphabetIcon.setImageResource(R.drawable.alphabet_f);
							 break;    			
    			case 'g': golFooterCaption.setText(String.valueOf(getResources().getString(R.string.g)));
							 alphabetIcon.setImageResource(R.drawable.alphabet_g);
							 break;    			
    			case 'h': golFooterCaption.setText(String.valueOf(getResources().getString(R.string.h)));
							 alphabetIcon.setImageResource(R.drawable.alphabet_h);
							 break;     			
    			case 'i': golFooterCaption.setText(String.valueOf(getResources().getString(R.string.i)));
							 alphabetIcon.setImageResource(R.drawable.alphabet_i);
							 break;     			
    			case 'j': golFooterCaption.setText(String.valueOf(getResources().getString(R.string.j)));
							 alphabetIcon.setImageResource(R.drawable.alphabet_j);
							 break;     			
    			case 'k': golFooterCaption.setText(String.valueOf(getResources().getString(R.string.k)));
							 alphabetIcon.setImageResource(R.drawable.alphabet_k);
							 break;     			
    			case 'l': golFooterCaption.setText(String.valueOf(getResources().getString(R.string.l)));
							 alphabetIcon.setImageResource(R.drawable.alphabet_l);
							 break;     			
    			case 'm': golFooterCaption.setText(String.valueOf(getResources().getString(R.string.m)));
							 alphabetIcon.setImageResource(R.drawable.alphabet_m);
							 break; 
    			case 'n': golFooterCaption.setText(String.valueOf(getResources().getString(R.string.n)));
							 alphabetIcon.setImageResource(R.drawable.alphabet_n);
							 break; 
    			case 'o': golFooterCaption.setText(String.valueOf(getResources().getString(R.string.o)));
							 alphabetIcon.setImageResource(R.drawable.alphabet_o);
							 break;     			
    			case 'p': golFooterCaption.setText(String.valueOf(getResources().getString(R.string.p)));
							 alphabetIcon.setImageResource(R.drawable.alphabet_p);
							 break;     			
    			case 'q': golFooterCaption.setText(String.valueOf(getResources().getString(R.string.q)));
							 alphabetIcon.setImageResource(R.drawable.alphabet_q);
							 break;     			
    			case 'r': golFooterCaption.setText(String.valueOf(getResources().getString(R.string.r)));
							 alphabetIcon.setImageResource(R.drawable.alphabet_r);
							 break;     			
    			case 's': golFooterCaption.setText(String.valueOf(getResources().getString(R.string.s)));
							 alphabetIcon.setImageResource(R.drawable.alphabet_s);
							 break;     			
    			case 't': golFooterCaption.setText(String.valueOf(getResources().getString(R.string.t)));
							 alphabetIcon.setImageResource(R.drawable.alphabet_t);
							 break;     		
    			case 'u': golFooterCaption.setText(String.valueOf(getResources().getString(R.string.u)));
							 alphabetIcon.setImageResource(R.drawable.alphabet_u);
							 break;     			
    			case 'v': golFooterCaption.setText(String.valueOf(getResources().getString(R.string.v)));
							 alphabetIcon.setImageResource(R.drawable.alphabet_v);
							 break;     			
    			case 'w': golFooterCaption.setText(String.valueOf(getResources().getString(R.string.w)));
							 alphabetIcon.setImageResource(R.drawable.alphabet_w);
							 break;     			
    			case 'x': golFooterCaption.setText(String.valueOf(getResources().getString(R.string.x)));
							 alphabetIcon.setImageResource(R.drawable.alphabet_x);
							 break;     			
    			case 'y': golFooterCaption.setText(String.valueOf(getResources().getString(R.string.y)));
							 alphabetIcon.setImageResource(R.drawable.alphabet_y);
							 break;     			
    			case 'z': golFooterCaption.setText(String.valueOf(getResources().getString(R.string.z)));
							 alphabetIcon.setImageResource(R.drawable.alphabet_z);
							 break;     			
    	}
    }    
}
