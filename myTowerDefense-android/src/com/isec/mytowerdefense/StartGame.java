package com.isec.mytowerdefense;

import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;

public class StartGame extends AndroidApplication {
	
	public AndroidBridgeScore actionResolver;	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        actionResolver = new AndroidBridgeScore(this);
        
        AndroidApplicationConfiguration cfg = new AndroidApplicationConfiguration();
        cfg.useGL20 = false; // cfg.useGL20 = false; -> usar imagens com "power of two size"
                 
        //inicializa aplicacao com a framework
        initialize(new myTowerDefense(actionResolver,this.getResources().getConfiguration().locale.getCountry()), cfg);
    }
}