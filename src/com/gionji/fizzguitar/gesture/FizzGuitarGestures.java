package com.gionji.fizzguitar.gesture;

import com.aidilab.ble.interfaces.FizzlyActivity;
import com.aidilab.ble.interfaces.GestureDetector;
import com.aidilab.ble.utils.SensorsValues;

public class FizzGuitarGestures extends GestureDetector{
	
	// Gesture List
	public static final int HIT_GESTURE = 1;
	
	public FizzGuitarGestures(FizzlyActivity mDeviceActivity) {
		super(mDeviceActivity);
	}	

	@Override
	public void detectGesture(SensorsValues sv) {
		
		if(checkTimeout()){
			if(sv.getAccelerometer().getModule() > 17 ){
				notifyGesture(HIT_GESTURE);
				lockGestureUntilTimeout();
			}
		}
		
	}

}
