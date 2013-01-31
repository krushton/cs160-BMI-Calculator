package com.krushton.bmicalculator;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;

public class ResultActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);
		Bundle extras = this.getIntent().getExtras();
		int height = extras.getInt("height");
		int weight = extras.getInt("weight");
		calculateBmi(height, weight);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_result, menu);
		return true;
	}
	
	public void calculateBmi(int height, int weight) {
		double bMI = weight * 703 / (height * height);
		String category = getCategory(bMI);
		Log.d("result", ""+height);
		Log.d("result",""+weight);
		TextView tv = (TextView)findViewById(R.id.message);
		String message = String.format("Your BMI is: %.1f (%s)", bMI, category);
		tv.setText(message);
	}
	
	private String getCategory(Double score) {
		if (score <= 15)
			return "Very severely underweight";
		if (score <= 16)
			return "Severely underweight";
		if (score <= 18.5)
			return "Underweight";
		if (score <= 25)
			return "Normal (healthy weight)";
		if (score <= 30)
			return "Overweight";
		if (score <= 35)
			return "Moderately obese";
		if (score <= 40)
			return "Severely obese";
	return "";
	}
}
