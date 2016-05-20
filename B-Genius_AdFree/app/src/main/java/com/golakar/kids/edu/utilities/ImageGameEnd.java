/**Project Under : Golakar Kids Apps
 * You can not modify & redistribute without permission from the author
 * Project published on Golakar Technology platform April, 2014
 * Release Template for the buyer august 2015
 */
package com.golakar.kids.edu.utilities;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import ksz.test.b_genius.R;

public class ImageGameEnd extends Activity {

	private TextView scoreView;
	private TextView scoreResponseView;	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.image_game_end);
		
		scoreView = (TextView) findViewById(R.id.score_view);
		scoreResponseView = (TextView) findViewById(R.id.score_response_view);
		
		int score = getIntent().getIntExtra("questionsCorrect", 0);
		int questions = getIntent().getIntExtra("questionsAsked", 0);
		float grade = score / questions;
		
		scoreView.setText(String.valueOf(score) + "/" + String.valueOf(questions));
				
		if(grade < 0.33){
			scoreView.setTextColor(Color.RED);
			scoreResponseView.setText("You need more practice!");
		} else if(grade < 0.66){
			scoreView.setTextColor(Color.YELLOW);
			scoreResponseView.setText("Ok...not bad!");
		} else if(grade < 1.0){
			scoreView.setTextColor(Color.GREEN);
			scoreResponseView.setText("Good job!");
		} else {
			scoreView.setTextColor(Color.GREEN);
			scoreResponseView.setText("Wow!! Perfect Score!");
		}
		
	}
	
	
	public void mainMenu(View theButton){		
		Intent intent = new Intent(this, ImageGameStart.class);
		startActivity(intent);
	}

}
