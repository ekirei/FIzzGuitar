package com.gionji.fizzguitar;

import android.content.Intent;
import android.os.Bundle;

import com.aidilab.ble.TestFizzlyActivity;
import com.aidilab.ble.interfaces.FizzlyDeviceScanActivity;



public class FizzScanActivity extends FizzlyDeviceScanActivity{

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.onScanViewReady();
	}
	
	@Override
	protected void startDeviceActivity() {
		this.mDeviceIntent = new Intent(this, FizzGuitarMainActivity.class); 
		mDeviceIntent.putExtra(FizzGuitarMainActivity.EXTRA_DEVICE, this.mBluetoothDevice); 
		startActivityForResult(mDeviceIntent, FizzScanActivity.REQ_DEVICE_ACT);
	}



}
