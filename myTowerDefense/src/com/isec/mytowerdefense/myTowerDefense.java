package com.isec.mytowerdefense;

import com.badlogic.gdx.Game;
import com.isec.mytowerdefense.Ecras.SplashScreen;
import com.isec.mytowerdefense.View.AndroidBridgeSubmitScore;


public class myTowerDefense extends Game {
		
	public static final String LOG = "My Tower Defense";
	public static String countryCode;
	public static AndroidBridgeSubmitScore actionResolver;
	
	public myTowerDefense(AndroidBridgeSubmitScore actionResolver, String countryCode)
	{
		myTowerDefense.countryCode = countryCode;
		myTowerDefense.actionResolver = actionResolver;
	}

	@Override
	public void create() {		
		
		setScreen(new SplashScreen(this));	
			
	}

	@Override
    public void dispose() {
            super.dispose();         
    }

	
    @Override
    public void render() {          
            super.render();
        
    }

    
    @Override
    public void resize(int width, int height) {
            super.resize(width, height);
    }
    

    @Override
    public void pause() {
            super.pause();
    }
    

    @Override
    public void resume() {
            super.resume();
    }

	public static String getCountryCode() {
		return countryCode;
	}

	public static void setCountryCode(String countryCode) {
		myTowerDefense.countryCode = countryCode;
	}
    
    
}