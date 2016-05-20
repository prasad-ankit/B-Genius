/**Project Under : Golakar Kids Apps
 * You can not modify & redistribute without permission from the author
 * Project published on Golakar Technology platform April, 2014
 * Release Template for the buyer august 2015
 */
package com.golakar.kids.edu.utilities;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;

import ksz.test.b_genius.R;


public class ImageGameStart extends Activity implements OnCheckedChangeListener {

	private Random golRandom = new Random();
	private int count = 1;
	private int questionsAsked, questionsCorrect = 0;
	
	private ImageView golImages;
	private RadioGroup radioGroup;
	private RadioButton[] radioChoices = new RadioButton[4];
	private TextView correctVal;
	private TextView askedVal;

	private Set<GolImagesUtils> usedGolImage = new HashSet<GolImagesUtils>();
	GolImagesUtils correctGolImage;
	
	private Button submitButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.image_game_view);
				
		// grab resources
		golImages = (ImageView) findViewById(R.id.gol_imageView);
		
		radioGroup = (RadioGroup) findViewById(R.id.radioChoices);
		radioGroup.setOnCheckedChangeListener(this);

		radioChoices[0] = (RadioButton) findViewById(R.id.radioChoice1);
		radioChoices[1] = (RadioButton) findViewById(R.id.radioChoice2);
		radioChoices[2] = (RadioButton) findViewById(R.id.radioChoice3);
		radioChoices[3] = (RadioButton) findViewById(R.id.radioChoice4);
		
		correctVal = (TextView) findViewById(R.id.correctValView);
		askedVal = (TextView) findViewById(R.id.askedValView);
		
		submitButton = (Button) findViewById(R.id.submit_button);
		
		TypedArray golImages = getResources().obtainTypedArray(R.array.golimages);
		count = golImages.length();
		golImages.recycle();
			
		setupNextQuestion();
		
	}

	/**
	 * Processes the action when the submit button is pressed
	 * @param theButton
	 */
	public void submit(View theButton){
		
		// check answer
		RadioButton r = (RadioButton) findViewById(radioGroup.getCheckedRadioButtonId());
		
		String toastText;
		if(r.getText().equals(correctGolImage.getGolName())){
			Log.d("Golakar", "Correct:" + r.getText() + ":" + correctGolImage.getGolName());
			toastText = "Correct!";
			questionsCorrect++; 
			
		} else {
			Log.d("Golakar", "Incorrect:" + r.getText() + ":" + correctGolImage.getGolName());
			toastText = "Sorry! Wrong!";
		}
		
		questionsAsked++; 
		
		// update score
		correctVal.setText(String.valueOf(questionsCorrect));
		askedVal.setText(String.valueOf(questionsAsked));
		
		
		Toast.makeText(
		getApplicationContext(),
		toastText, 
		Toast.LENGTH_SHORT).show();
		
		// exit game after so many questions		
		if(questionsAsked < 10){
				
			// uncheck radio buttons and set button to disabled
			radioGroup.clearCheck();
			submitButton.setEnabled(false);
			
			
			// set up next question
			setupNextQuestion();
		
		} else { // exit game
			
			// FIXME drop current Activity from stack so user doesn't go
			// 'back' into the finished game
			
			Intent intent = new Intent(this, ImageGameEnd.class);
			intent.putExtra("questionsAsked", questionsAsked);
			intent.putExtra("questionsCorrect", questionsCorrect);
			startActivity(intent);
		
		}
		
	}
	
	private void setupNextQuestion(){
		
		List<GolImagesUtils> golNames = new LinkedList<GolImagesUtils>();
		
		GolImagesUtils golName;		
		do {
			// get a golName for question
			correctGolImage = getRandomGolName();
			
		// if the golName as already been used before, grab another one
		} while(usedGolImage.contains(correctGolImage));
		
		golNames.add(correctGolImage);		
		
		while(golNames.size() < 4 ) {			
			do {			
			golName = getRandomGolName();			
			} while(golNames.contains(golName));			
			golNames.add(golName);		
		}
		
		// set the Golakar image
		golImages.setImageDrawable(golNames.get(0).getGolImages());
		
		// randomize where the correct answer goes
		Collections.shuffle(golNames);
		
		for(int i = 0; i < golNames.size(); i++){
			radioChoices[i].setText(golNames.get(i).getGolName());
		}		
	    usedGolImage.add(correctGolImage);
	}

	private GolImagesUtils getRandomGolName(){
		
		int index = golRandom.nextInt(count);		
		Resources resources = getResources();
	    TypedArray golName = resources.obtainTypedArray(R.array.golname);
	    TypedArray golImages = resources.obtainTypedArray(R.array.golimages);

	    GolImagesUtils golNameObj = 
	    new GolImagesUtils(golName.getString(index), golImages.getDrawable(index));

	 // recycling resources
	    golName.recycle();
	    golImages.recycle();

	    return golNameObj;
	}
	
	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		submitButton.setEnabled(true);
	}
}