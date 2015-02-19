package com.isec.mytowerdefense.View;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;
import com.isec.mytowerdefense.Bounds.Mapa;
import com.isec.mytowerdefense.Torres.Torre_1;
import com.isec.mytowerdefense.Torres.Torre_2;
import com.isec.mytowerdefense.Torres.Torre_3;

public class InputHandler implements InputProcessor{
        
		private Jogo jogo;
        Vector2 posicao_escolhida;
        
        public InputHandler(Jogo jogo) {
                this.jogo = jogo;
                posicao_escolhida = new Vector2();         
    
        }

        @Override
        public boolean keyDown(int keycode) {
        	
        	return false;
        }

        @Override
        public boolean keyUp(int keycode) {
        	
        	return false;
        }

        @Override
        public boolean keyTyped(char character) {
           
              return false;
        }

       
        @Override
        public boolean mouseMoved(int screenX, int screenY) {
              
              return false;
        }

        
        
        @Override
    	public boolean touchDown(int x, int y, int pointer, int button) { 
        	        	   	        		        	
           //ajustes necessarios para uma nova posicao para uma torre com o clique
            //tendo em conta diferentes resolucoes..
            float x_real = (800/(float) Gdx.graphics.getWidth()) * x; 
            float y_real = (480/(float) Gdx.graphics.getHeight()) * y;         
            posicao_escolhida.x=(float) (x_real) ;
            posicao_escolhida.y=(float) (y_real) ;
            
            Jogo.msgSemDinheiro=false;
          
                   
            if(Jogo.getDinheiro()<=0)         
            	return false;
          
            
            if(Jogo.torre_selected==1)  
            	return torre1();
            else
            	if(Jogo.torre_selected==2){
            		
            		if(Jogo.getDinheiro()<=1)            		
            			return false;  
                		
            	return torre2();
            	}
            	else
            		if(Jogo.torre_selected==3)
            		{                		
                		if(Jogo.getDinheiro()<=2)              	
                			return false;   
                		
            		return torre3();
            		}
            		else 
            			return false;            
       
    	}

    	@Override
    	public boolean touchUp(int x, int y, int pointer, int button) {
    	
    		return false;
    	}

    	@Override
    	public boolean touchDragged(int x, int y, int pointer) {

    		return false;
    	}

    	public boolean touchMoved(int x, int y) {

    		return false;
    	}

    	@Override
    	public boolean scrolled(int amount) {

    		return false;
    	}
    	
    	public boolean torre1(){
    		
    		 int conta=0;
    		
    	     // Rectangle bounds = new Rectangle(posicao_escolhida.x, posicao_escolhida.y, 28, 28);
            Torre_1 novaTorreTemp = new Torre_1 (new Vector2(posicao_escolhida), 28, 28);
            
            for(int i=0; i < Mapa.getTowerPosBounds().size(); i++)  
            {             	
            	if(novaTorreTemp.getBoundsNormal().overlaps(Mapa.getTowerPosBounds().get(i)))
            	{  	       
            		if(Jogo.getTorres_1().size() == 0) {                      	
                    	jogo.addTorres_1(new Torre_1(new Vector2(posicao_escolhida), (float) 28, (float) 28));
                    	Jogo.setDinheiro( Jogo.getDinheiro()-1);
                    	return false;
                    	}
            		
            			for(int j=0; j < Jogo.getTorres_1().size(); j++) 
            			{             	
            				if(!novaTorreTemp.getBoundsNormal().overlaps(Jogo.getTorres_1().get(j).getBoundsNormal())){
            					conta++;
            					if(conta == Jogo.getTorres_1().size())
            					{            					
        					    jogo.addTorres_1(new Torre_1(new Vector2(posicao_escolhida), (float) 28, (float) 28));
        					    Jogo.setDinheiro( Jogo.getDinheiro()-1);
                    	        return false;
            					}   
            				}
            			}
            	}
            }
            return false;
    	}
    	
    	
    	
    	public boolean torre2(){
    		
   		 int conta=0;
   		
   	      Torre_2 novaTorreTemp = new Torre_2 (new Vector2(posicao_escolhida), 28, 28);
           
           for(int i=0; i < Mapa.getTowerPosBounds().size(); i++)  
           {             	
           	if(novaTorreTemp.getBoundsNormal().overlaps(Mapa.getTowerPosBounds().get(i)))
           	{  	       
           		if(Jogo.getTorres_2().size() == 0) {                      	
                   	jogo.addTorres_2(new Torre_2(new Vector2(posicao_escolhida), (float) 28, (float) 28));
                   	Jogo.setDinheiro( Jogo.getDinheiro()-2);
                   	return false;
                   	}
           		
           			for(int j=0; j < Jogo.getTorres_2().size(); j++) 
           			{             	
           				if(!novaTorreTemp.getBoundsNormal().overlaps(Jogo.getTorres_2().get(j).getBoundsNormal())){
           					conta++;
           					if(conta == Jogo.getTorres_2().size())
           					{            					
       					    jogo.addTorres_2(new Torre_2(new Vector2(posicao_escolhida), (float) 28, (float) 28));
       					    Jogo.setDinheiro( Jogo.getDinheiro()-2);
                   	        return false;
           					}   
           				}
           			}
           	}
           }
           return false;
   	}
    	
    	
    	
    	public boolean torre3(){
    		
   		 int conta=0;
   		
           Torre_3 novaTorreTemp = new Torre_3 (new Vector2(posicao_escolhida), 28, 28);
           
           for(int i=0; i < Mapa.getTowerPosBounds().size(); i++)  
           {             	
           	if(novaTorreTemp.getBoundsNormal().overlaps(Mapa.getTowerPosBounds().get(i)))
           	{  	       
           		if(Jogo.getTorres_3().size() == 0) {                      	
                   	jogo.addTorres_3(new Torre_3(new Vector2(posicao_escolhida), (float) 28, (float) 28));
                   	Jogo.setDinheiro( Jogo.getDinheiro()-3);
                   	return false;
                   	}
           		
           			for(int j=0; j < Jogo.getTorres_3().size(); j++) 
           			{             	
           				if(!novaTorreTemp.getBoundsNormal().overlaps(Jogo.getTorres_3().get(j).getBoundsNormal())){
           					conta++;
           					if(conta == Jogo.getTorres_3().size())
           					{            					
       					    jogo.addTorres_3(new Torre_3(new Vector2(posicao_escolhida), (float) 28, (float) 28));
       					    Jogo.setDinheiro( Jogo.getDinheiro()-3);
                   	        return false;
           					}   
           				}
           			}
           	}
           }
           return false;
   	}

    	
}