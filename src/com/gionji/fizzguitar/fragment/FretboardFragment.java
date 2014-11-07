package com.gionji.fizzguitar.fragment;

import java.util.ArrayList;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.aidilab.ble.gesture.GestureDetector;
import com.aidilab.ble.interfaces.FizzlyActivity;
import com.aidilab.ble.interfaces.FizzlyFragment;
import com.aidilab.ble.utils.Effect;
import com.aidilab.ble.utils.SensorsValues;
import com.gionji.fizzguitar.R;
import com.gionji.fizzguitar.gesture.FizzGuitarGestures;

public class FretboardFragment extends FizzlyFragment{

	private FizzlyActivity mActivity;
		
	ArrayList<Button> frets  = null;
	ArrayList<Effect> sounds = null;
	
	int[] buttons = {R.id.button61, R.id.button62, R.id.button63, R.id.button64, R.id.button65, 
			         R.id.button51, R.id.button52, R.id.button53, R.id.button54, R.id.button55, 
			         R.id.button41, R.id.button42, R.id.button43, R.id.button44, R.id.button45, 
			         R.id.button31, R.id.button32, R.id.button33, R.id.button34, R.id.button35, 
			         R.id.button21, R.id.button22, R.id.button23, R.id.button24, R.id.button25, 
			         R.id.button11, R.id.button12, R.id.button13, R.id.button14, R.id.button15 };
	
	
	int[] gionji1Samples = {R.raw.intro_e2,   R.raw.my1_f1,      R.raw.my1_fd1, R.raw.intro_g2,   R.raw.intro_a2,
							R.raw.intro_a2,   R.raw.baba_bb3,    R.raw.my1_b2 , R.raw.baba_c3 ,   R.raw.my1_cd2,
							R.raw.my1_d2,     R.raw.my1_dd2,     R.raw.my1_e1,  R.raw.baba_f3,    R.raw.my1_fd1,
							R.raw.my1_g1,     R.raw.my1_gd1,     R.raw.my1_a2,  R.raw.my1_ad2,    R.raw.my1_b2,
							R.raw.my1_b2,     R.raw.my1_c2,     R.raw.my1_cd2,  R.raw.my1_d2,     R.raw.my1_dd2};
	
	
//	R.raw.pw_e1));
//    sounds.add(new Effect(mActivity, R.raw.pw_f1));
//    sounds.add(new Effect(mActivity, R.raw.pw_fd1));
//    sounds.add(new Effect(mActivity, R.raw.pw_g1));
//    sounds.add(new Effect(mActivity, R.raw.pw_gd1));
//
//    sounds.add(new Effect(mActivity, R.raw.pw_a1));
//    sounds.add(new Effect(mActivity, R.raw.pw_ad1));
//    sounds.add(new Effect(mActivity, R.raw.pw_b1));
//    sounds.add(new Effect(mActivity, R.raw.pw_c1));
//    sounds.add(new Effect(mActivity, R.raw.pw_cd1));

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
	    mInstance = this;
	    mActivity = (FizzlyActivity) getActivity();
    
	    // The last two arguments ensure LayoutParams are inflated properly.	    
	    View view = inflater.inflate(R.layout.fragment_fizz_guitar_main, container, false);
	    	
	    /** 
	     *  GUI initialization - getting gui references
	     */	    
	    frets  = new ArrayList<Button>();
	    sounds = new ArrayList<Effect>();
	    
	    for(int i=0; i<buttons.length; i++){
	    	((Button) view.findViewById(buttons[i])).setAlpha(0.3f);
	    }
	    
	    for(int i=0; i<gionji1Samples.length; i++){
	    	sounds.add(new Effect(mActivity, gionji1Samples[i]));
	    	frets.add((Button) view.findViewById(buttons[i]));
	    }
	    	    
	    for(int i=0; i<frets.size(); i++){
	    	frets.get(i).setOnClickListener(this);
	    }
	    	    
	    // Notify activity that UI has been inflated
	    mActivity.onViewInflated(view);
		return view;
	}
	
	@Override
	public void onClick(View arg0) {
		
	}

	@Override
	public void onCharacteristicChanged(String uuidStr, byte[] rawValue) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onCharacteristicChanged(String uuidStr, SensorsValues sv) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onGestureDetected(int gestureId) {
		if(gestureId == FizzGuitarGestures.HIT_GESTURE){
			for(int i=0; i<frets.size(); i++){
				if(frets.get(i).isPressed())
					sounds.get(i).play();
			}			
		}
		
	}
	
	

}
