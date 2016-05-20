/**Project Under : Golakar Kids Apps
 * You can not modify & redistribute without permission from the author
 * Project published on Golakar Technology platform April, 2014
 * Release Template for the buyer august 2015
 */
package com.golakar.kids.edu.utilities;

import java.util.Random;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import ksz.test.b_genius.R;



public class GolQuizActivity extends Activity 
{
	private char[] alphabet = {
			'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
			'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'
			};
	private int quizAlphabetIndex = 0;
	private final String ACTIVITY_NAME = "GolQuiz";
	
	private TextView quizOption1 = null;
	private TextView quizOption2 = null;
	private TextView quizOption3 = null;	
	private ImageView letterIcon = null;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gol_quiz);
              
     // custom font
 		Typeface font = Typeface.createFromAsset(getAssets(), "BankGothic.ttf");
 		((TextView) findViewById(R.id.quiz_option1)).setTypeface(font); 
 		((TextView) findViewById(R.id.quiz_option2)).setTypeface(font);
 		((TextView) findViewById(R.id.quiz_option3)).setTypeface(font);
 		
   
        Log.i(ACTIVITY_NAME, "Passed setContentView");        
        poseRandomQuestion();
    }
    
    private void poseRandomQuestion()
    {
    	Random rnd = new Random();
    	// 0 - 23
    	int optionIndex1 = rnd.nextInt(24);
    	int optionIndex2 = rnd.nextInt(24);
    	int optionIndex3 = rnd.nextInt(24);
    	boolean stopFlag = true;
    	
    	while(stopFlag)
    	{
	    	if ( (optionIndex1 == optionIndex2) || 
	    		 (optionIndex2 == optionIndex3) || 
	    		 (optionIndex3 == optionIndex1))
	    	{
	    		optionIndex1 = rnd.nextInt(24);
	    		optionIndex2 = rnd.nextInt(24);
	    		optionIndex3 = rnd.nextInt(24);
	    	}
	    	else
	    	{
	    		stopFlag = false;
	    	}
    	}
    	
    	rnd = new Random();
    	// 0, 1, 2
    	int optionResult = rnd.nextInt(3);
    	int imageIndex = 0;
    	
    	switch(optionResult)
    	{
    		case 0: imageIndex = optionIndex1; break;
    		case 1: imageIndex = optionIndex2; break;
    		case 2: imageIndex = optionIndex3; break;
    	}
    	
        // Select a random letter    	 	  	
    	inflateUI(optionIndex1, optionIndex2, optionIndex3, imageIndex);
    	quizAlphabetIndex = imageIndex;
    }
    
    private void inflateUI(int optionIndex1, int optionIndex2, int optionIndex3, int imageIndex)
    {
    	// Determine ImageView
    	letterIcon = (ImageView) findViewById(R.id.letter_icon); 
    	letterIcon.setClickable(true);
    	fillLetterResource(imageIndex);
    	letterIcon.setOnClickListener(new OnClickListener() {

     	     @Override
     	     public void onClick(View v) 
     	     {
     	    	
       	     }
     	 });    
    	
    	quizOption1 = (TextView) findViewById(R.id.quiz_option1); 
    	quizOption1.setClickable(true);
    	quizOption1.setText(String.valueOf(retrieveWordFromLetter(optionIndex1)));
    	quizOption1.setOnClickListener(new OnClickListener() {

	   	     @Override
	   	     public void onClick(View v) 
	   	     {
	   	    	determineResult(quizOption1.getText(), alphabet[quizAlphabetIndex] );
	     	 }
	   	    });
    	
    	quizOption2 = (TextView) findViewById(R.id.quiz_option2); 
    	quizOption2.setClickable(true);
    	quizOption2.setText(String.valueOf(retrieveWordFromLetter(optionIndex2)));
    	quizOption2.setOnClickListener(new OnClickListener() {

	   	     @Override
	   	     public void onClick(View v) 
	   	     {
	   	    	
	   	    	determineResult(quizOption2.getText(), alphabet[quizAlphabetIndex] );
	     	 }
	   	    });    	 
    	
    	quizOption3 = (TextView) findViewById(R.id.quiz_option3); 
    	quizOption3.setClickable(true);
    	quizOption3.setText(String.valueOf(retrieveWordFromLetter(optionIndex3)));
    	quizOption3.setOnClickListener(new OnClickListener() {

	   	     @Override
	   	     public void onClick(View v) 
	   	     {
	   	    	
	   	    	determineResult(quizOption3.getText(), alphabet[quizAlphabetIndex] );
	     	 }
	   	    });   
    }
        
    
    private void determineResult(CharSequence selectedWord, char displayLetter)
    {
    	char firstChar = Character.toLowerCase(selectedWord.charAt(0));
    	
    	if (firstChar == displayLetter)
    	{
    		makeToast(true, "Yes! You are right", 5);

    		poseRandomQuestion();
    	}
    	else
    	{
    		makeToast(false, "Ohh No! Try again", 3);
    	}
    }
    
    private void makeToast(boolean success, CharSequence text, int duration)
    {    	
    	Toast toast = Toast.makeText(getApplicationContext(), text, duration);
    	View textView = toast.getView();
    	LinearLayout lay = new LinearLayout(getApplicationContext());
    	lay.setOrientation(LinearLayout.VERTICAL);
    	ImageView view = new ImageView(getApplicationContext());

    	if (success)
    	{
    		view.setImageResource(R.drawable.gol_winner);
    	}
    	else
    	{
    		view.setImageResource(R.drawable.gol_fails);
    	}
    	
    	lay.addView(view);
    	lay.addView(textView);
    	toast.setView(lay);
    	toast.show();    	
    }
    
    private void fillLetterResource(int alphabetIndex)
    {
    	char currentAlphabet = alphabet[alphabetIndex];
    	
    	switch (currentAlphabet)
    	{
    			case 'a':   letterIcon.setImageResource(R.drawable.letter_a);
			    			break;
    			case 'b': 
							 letterIcon.setImageResource(R.drawable.letter_b);
							 break;
    			case 'c': 
							 letterIcon.setImageResource(R.drawable.letter_c);
							 break;
    			case 'd':
							 letterIcon.setImageResource(R.drawable.letter_d);
							 break;    			
    			case 'e': 
							 letterIcon.setImageResource(R.drawable.letter_e);
							 break;    			
    			case 'f': 
							 letterIcon.setImageResource(R.drawable.letter_f);
							 break;    			
    			case 'g': 
							 letterIcon.setImageResource(R.drawable.letter_g);
							 break;    			
    			case 'h':
							 letterIcon.setImageResource(R.drawable.letter_h);
							 break;     			
    			case 'i':
							 letterIcon.setImageResource(R.drawable.letter_i);
							 break;     			
    			case 'j':
							 letterIcon.setImageResource(R.drawable.letter_j);
							 break;     			
    			case 'k':
							 letterIcon.setImageResource(R.drawable.letter_k);
							 break;     			
    			case 'l':
							 letterIcon.setImageResource(R.drawable.letter_l);
							 break;     			
    			case 'm':
							 letterIcon.setImageResource(R.drawable.letter_m);
							 break; 
    			case 'n':
							 letterIcon.setImageResource(R.drawable.letter_n);
							 break; 
    			case 'o':
							 letterIcon.setImageResource(R.drawable.letter_o);
							 break;     			
    			case 'p': 
							 letterIcon.setImageResource(R.drawable.letter_p);
							 break;     			
    			case 'q':
							 letterIcon.setImageResource(R.drawable.letter_q);
							 break;     			
    			case 'r':
							 letterIcon.setImageResource(R.drawable.letter_r);
							 break;     			
    			case 's':
							 letterIcon.setImageResource(R.drawable.letter_s);
							 break;     			
    			case 't':
							 letterIcon.setImageResource(R.drawable.letter_t);
							 break;     		
    			case 'u':
							 letterIcon.setImageResource(R.drawable.letter_u);
							 break;     			
    			case 'v':
							 letterIcon.setImageResource(R.drawable.letter_v);
							 break;     			
    			case 'w':
							 letterIcon.setImageResource(R.drawable.letter_w);
							 break;     			
    			case 'x':
							 letterIcon.setImageResource(R.drawable.letter_x);
							 break;     			
    			case 'y':
							 letterIcon.setImageResource(R.drawable.letter_y);
							 break;     			
    			case 'z':
							 letterIcon.setImageResource(R.drawable.letter_z);
							 break;     			
    	}
    }
    
    
    private String retrieveWordFromLetter(int alphabetIndex)
    {
    	// This is the current alphabet
    	char currentAlphabet = alphabet[alphabetIndex];
    	String word = "";

    	switch (currentAlphabet)
    	{
    			case 'a': word = String.valueOf(getResources().getString(R.string.a));
			    		  break;
			    		  
    			case 'b': word = String.valueOf(getResources().getString(R.string.b));  
							 
							 break;
    			case 'c': word = String.valueOf(getResources().getString(R.string.c));

							 break;
    			case 'd': word = String.valueOf(getResources().getString(R.string.d));

							 break;    			
    			case 'e': word = String.valueOf(getResources().getString(R.string.e));

							 break;    			
    			case 'f': word = String.valueOf(getResources().getString(R.string.f));

							 break;    			
    			case 'g': word = String.valueOf(getResources().getString(R.string.g));

							 break;    			
    			case 'h': word = String.valueOf(getResources().getString(R.string.h));

							 break;     			
    			case 'i': word = String.valueOf(getResources().getString(R.string.i));

							 break;     			
    			case 'j': word = String.valueOf(getResources().getString(R.string.j));

							 break;     			
    			case 'k': word = String.valueOf(getResources().getString(R.string.k));

							 break;     			
    			case 'l': word = String.valueOf(getResources().getString(R.string.l));

							 break;     			
    			case 'm': word = String.valueOf(getResources().getString(R.string.m));

							 break; 
    			case 'n': word = String.valueOf(getResources().getString(R.string.n));

							 break; 
    			case 'o': word = String.valueOf(getResources().getString(R.string.o));

							 break;     			
    			case 'p': word = String.valueOf(getResources().getString(R.string.p));

							 break;     			
    			case 'q': word = String.valueOf(getResources().getString(R.string.q));

							 break;     			
    			case 'r': word = String.valueOf(getResources().getString(R.string.r));

							 break;     			
    			case 's': word = String.valueOf(getResources().getString(R.string.s));

							 break;     			
    			case 't': word = String.valueOf(getResources().getString(R.string.t));
	
							 break;     		
    			case 'u': word = String.valueOf(getResources().getString(R.string.u));
	
							 break;     			
    			case 'v': word = String.valueOf(getResources().getString(R.string.v));
	
							 break;     			
    			case 'w': word = String.valueOf(getResources().getString(R.string.w));

							 break;     			
    			case 'x': word = String.valueOf(getResources().getString(R.string.x));

							 break;     			
    			case 'y': word = String.valueOf(getResources().getString(R.string.y));

							 break;     			
    			case 'z': word = String.valueOf(getResources().getString(R.string.z));

							 break;     			
    	} 
    	return word;
    }
    
}
