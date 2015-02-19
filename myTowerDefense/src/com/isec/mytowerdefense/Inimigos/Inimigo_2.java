package com.isec.mytowerdefense.Inimigos;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.isec.mytowerdefense.Ecras.GameScreen;

public class Inimigo_2 extends Inimigo {
	
	   private int resistencia = 10; 
	   private float velocidade = 65f;
	   	
        public Inimigo_2(Vector2 position, float width, float height, float rotation) {
        	       	        	
                super(rotation, width, height, position);                             
              
                this.vidas=resistencia;
                
                loadTexture();
                
        }

        public  void update() {
        	
        	    position.add(velocity.tmp().mul(Gdx.graphics.getDeltaTime() * velocidade));                
            
                      
                if (velocity.x != 0 || velocity.y != 0)
                        rotation = velocity.angle() - 90;
                
                bounds.x = position.x; //quadrado da colisao
                bounds.y = position.y;   
                
             
                updatePath();  
                
            
        }
        
        public void loadTexture(){
        	
        	TextureInimigo = GameScreen.manager.get("data/inimigos/inimigo_2.png",Texture.class); 
            TextRegInimigo = new TextureRegion(TextureInimigo);
            TextRegInimigo.flip(false, true);            
        
        	
        }

		public int getResistencia() {
			return resistencia;
		}

		public void setResistencia(int resistencia) {
			this.resistencia = resistencia;
		}

		public float getVelocidade() {
			return velocidade;
		}

		public void setVelocidade(float velocidade) {
			this.velocidade = velocidade;
		}
        
        
        
        
}
        
        