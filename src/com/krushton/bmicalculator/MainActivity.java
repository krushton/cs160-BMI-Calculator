package com.krushton.bmicalculator;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	public void getData(View v) {
		EditText heightBox = (EditText)findViewById(R.id.heightTextbox);
		int height = Integer.valueOf(heightBox.getText().toString());
		EditText weightBox = (EditText)findViewById(R.id.weightTextbox);
		int weight = Integer.valueOf(weightBox.getText().toString());
		Intent i = new Intent(this, ResultActivity.class);
		i.putExtra("height", height);
		i.putExtra("weight", weight);
		startActivity(i);
	}

}
