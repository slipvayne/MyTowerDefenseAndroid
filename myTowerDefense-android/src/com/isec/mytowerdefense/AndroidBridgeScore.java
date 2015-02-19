package com.isec.mytowerdefense;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;

import com.isec.mytowerdefense.View.AndroidBridgeSubmitScore;
import com.swarmconnect.SwarmActivity;

//http://code.google.com/p/libgdx-users/wiki/IntegratingAndroidNativeUiElements3TierProjectSetup

public class AndroidBridgeScore extends SwarmActivity implements AndroidBridgeSubmitScore {
	Handler uiThread;
    Context appContext;
    
    public AndroidBridgeScore(Context appContext) {
        uiThread = new Handler();
        this.appContext = appContext;
}
    
	@Override
	public void submitScore(final int score) {
		uiThread.post(new Runnable() {
            public void run() {
            	
            	 if (MainActivity.leaderboard != null) {
            			MainActivity.leaderboard.submitScore(score);
            			if(appContext.getResources().getConfiguration().locale.getCountry().equalsIgnoreCase("PT"))
            			Toast.makeText(appContext, "A pontuação ( "+score+" ) foi enviada!", Toast.LENGTH_LONG)
                        .show();
            			else
            				Toast.makeText(appContext, "The score ( "+score+" ) was submited!", Toast.LENGTH_LONG)
                            .show();  	
            			 }else{
            				 if(appContext.getResources().getConfiguration().locale.getCountry().equalsIgnoreCase("PT"))
            				 Toast.makeText(appContext, "Ocoreu um erro a enviar a pontuação!", Toast.LENGTH_LONG)
                             .show();
            				 else
            					 Toast.makeText(appContext, "Error submiting the score!", Toast.LENGTH_LONG)
                                 .show();
                 			 }
            	 
            }
    });
}
		
	

}
