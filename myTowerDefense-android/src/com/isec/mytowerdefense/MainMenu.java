package com.isec.mytowerdefense;

import com.swarmconnect.SwarmActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class MainMenu extends SwarmActivity  {

	public MediaPlayer mp1 = new MediaPlayer();
	public boolean somLigado = false;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		 requestWindowFeature(Window.FEATURE_NO_TITLE);	
	        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
	                                WindowManager.LayoutParams.FLAG_FULLSCREEN);
	      
		
		setContentView(R.layout.activity_main_menu);		
						
	
	}
	
	public void onPause() {
	
		super.onPause();		
	    	 mp1.stop();
	    	 somLigado=false;	
	}
	
	public void onSom(View v) {
		
		 if(somLigado==false){
		    	mp1 = MediaPlayer.create(getBaseContext(), R.raw.music);  
		        mp1.start();
		        somLigado=true;}
		    	 else{
		        	mp1.stop();
		        	somLigado=false;		      
		    	 }
	}

		
	
	public void onPlay(View v)
	{
		launchActivity(StartGame.class);
		
	}
	
	public void onSair(View v)
	{
	   finish();
	}
	
	public void onCredits(View v)
	{
		MainMenu.this.startActivity(new Intent(MainMenu.this, CreditosActivity.class));		
		
	}
	
	public void onSobre(View v)
	{		
		MainMenu.this.startActivity(new Intent(MainMenu.this, SobreActivity.class));		
	}
	
    public void onScore(View v)
    {
    	 if (MainActivity.leaderboard != null) {
    	MainActivity.leaderboard.showLeaderboard();
    	 }
    
    }
	
	
	protected void launchActivity(Class<?> cls)
	{
		Intent myIntent = new Intent(this, cls);	
		myIntent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
		startActivity(myIntent);
	}
}
