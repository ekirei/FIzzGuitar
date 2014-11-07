package com.gionji.fizzguitar;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.aidilab.ble.interfaces.FizzlyActivity;
import com.aidilab.ble.sensor.FizzlySensor;
import com.gionji.fizzguitar.fragment.FretboardFragment;
import com.gionji.fizzguitar.gesture.FizzGuitarGestures;

public class FizzGuitarMainActivity extends FizzlyActivity {

	private FretboardFragment mFragmentView = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fizz_guitar_main);
		
		FizzGuitarGestures mFizzGuitarGestures = new FizzGuitarGestures(this);
		mFizzGuitarGestures.setCyclesTimeout(5);		
		setGestureDetector(mFizzGuitarGestures);	
		setSensorPeriod(50);
		
//		// Gui custom settings    
//	    getActionBar().setBackgroundDrawable(new ColorDrawable(Color.YELLOW));
//	    getActionBar().setIcon(android.R.color.transparent);
		
	    mFragmentView = new FretboardFragment();
	    
		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, mFragmentView).commit();
		}
		
		enableSensors(FizzlySensor.ACC_MAG_BUTT_BATT);		
	}



	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.fizz_guitar_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}


	@Override
	public void onGestureDetected(int gestureId) {
		Log.w("FizzGuitarMainActivity","gesture detected: " + gestureId);
		mFragmentView.onGestureDetected(gestureId);
	}
}
