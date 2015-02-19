package com.isec.mytowerdefense;

import com.swarmconnect.SwarmActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class CreditosActivity extends SwarmActivity  {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);		

		 requestWindowFeature(Window.FEATURE_NO_TITLE);
	        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
	                                WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		setContentView(R.layout.activity_creditos);
		
	}

		
	public void onBack(View v)
	{
		finish();
	}

}
