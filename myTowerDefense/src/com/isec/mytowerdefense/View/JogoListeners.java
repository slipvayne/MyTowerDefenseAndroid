package com.isec.mytowerdefense.View;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.isec.mytowerdefense.myTowerDefense;
import com.isec.mytowerdefense.Ecras.GameScreen;


public class JogoListeners extends InputListener {
	
	//ou...StageListeners
	
		
	public boolean touchDown(InputEvent event, float x, float y,
            int pointer, int button) {
    return true;
     }
	

	public void touchUp(InputEvent event, float x, float y,
            int pointer, int button) {

		  if(event.getListenerActor().toString().equals(Jogo.buttonPlay.toString())){
        		   
        	   Jogo.start = true;
        	   Jogo.buttonStart = false;
        	   
        	   if(Jogo.jogoAcabou==true){    
        		   myTowerDefense.actionResolver.submitScore(Jogo.getInimigosDestruidos());
           		Jogo.jogoAcabou=false;   
           		new GameScreen(GameScreen.getGame());         
           	}
        	   
        
		  }
		  
		  else if(event.getListenerActor().toString().equals(Jogo.buttonTower1.toString())){
			 
			  Jogo.buttonTower1.setColor(Color.YELLOW);
			  Jogo.buttonTower2.setColor(Color.WHITE);
			  Jogo.buttonTower3.setColor(Color.WHITE);
			  
			  Jogo.torre_selected=1;
			  
			  if(Jogo.getDinheiro()<=0)
	                  	Jogo.msgSemDinheiro=true; 
			  else
				  Jogo.msgSemDinheiro=false;
						  
		  }
		  
		  else if(event.getListenerActor().toString().equals(Jogo.buttonTower2.toString())){
				 
			  Jogo.buttonTower1.setColor(Color.WHITE);
			  Jogo.buttonTower2.setColor(Color.YELLOW);
			  Jogo.buttonTower3.setColor(Color.WHITE);
			  
			  Jogo.torre_selected=2;
			  
			  if(Jogo.getDinheiro()<=1)
                	Jogo.msgSemDinheiro=true; 
			  else
				  Jogo.msgSemDinheiro=false;
		  }
		  
		  else if(event.getListenerActor().toString().equals(Jogo.buttonTower3.toString())){
				 
			  Jogo.buttonTower1.setColor(Color.WHITE);
			  Jogo.buttonTower2.setColor(Color.WHITE);
			  Jogo.buttonTower3.setColor(Color.YELLOW);
			  
			  Jogo.torre_selected=3;
			  
			  if(Jogo.getDinheiro()<=2)
              	Jogo.msgSemDinheiro=true;
			  else
				  Jogo.msgSemDinheiro=false;
		  }
		  
		  
		  
		  
			

	}
}
