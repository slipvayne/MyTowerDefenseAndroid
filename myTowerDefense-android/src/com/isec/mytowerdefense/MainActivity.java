package com.isec.mytowerdefense;

import com.swarmconnect.Swarm;
import com.swarmconnect.SwarmActivity;
import com.swarmconnect.SwarmLeaderboard;
import com.swarmconnect.SwarmLeaderboard.GotLeaderboardCB;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

//API LIBGDX: http://libgdx.badlogicgames.com/
//API PONTUACOES: http://swarmconnect.com/admin/docs/setup

public class MainActivity extends SwarmActivity  {
	
	public static SwarmLeaderboard leaderboard;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
                                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        
        
        //Pontuacoes..
        Swarm.init(this, 2865, "d0ed34079dce811586c6f6acd72a47d5");
        GotLeaderboardCB callback = new GotLeaderboardCB() {
          
			public void gotLeaderboard(SwarmLeaderboard leaderboard) {

        	if (leaderboard != null) {
                    // Save the leaderboard for later use
                    MainActivity.leaderboard = leaderboard;
                }
            }
        };
                     
        SwarmLeaderboard.getLeaderboardById(4807, callback);       
     
		MainActivity.this.startActivity(new Intent(MainActivity.this, MainMenu.class));	
		
		finish();
    }
}