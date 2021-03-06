package com.isec.mytowerdefense.Torres;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.isec.mytowerdefense.Ecras.GameScreen;
import com.isec.mytowerdefense.TShot.Torres_1_shot;

public class Torre_1 extends Torre {
	
	protected Torres_1_shot shot;
	protected Vector2 shot_posinicial;

       
	public Torre_1(Vector2 position, float width, float height) {
        
       super(width, height, position);
       
       tRange=150;
       
       bounds = new Rectangle(position.x - tRange/2, position.y - tRange/2, width+tRange, height+tRange);     
       boundsNormal = new Rectangle(position.x, position.y , width, height); 
        
                
       shot_posinicial = new Vector2( position );                       
                            
       shot=new Torres_1_shot(10f,(float)12,(float)12,shot_posinicial,bounds);         
        
       TextureTorre = GameScreen.manager.get("data/torres/torre_1.png",Texture.class);
       TextRegTorre = new TextureRegion(TextureTorre);
       TextRegTorre.flip(false, true);         
       
       
       }

              
        public void newShot()
        {     	
        	shot=new Torres_1_shot(10f,(float)12,(float)12,shot_posinicial,bounds); //bounds range tower              	
            //falta limpar shot
        }

		public Torres_1_shot getShot() {
			return shot;
		}

		public void setShot(Torres_1_shot shot) {
			this.shot = shot;
		}

		public Vector2 getShot_posinicial() {
			return shot_posinicial;
		}

		public void setShot_posinicial(Vector2 shot_posinicial) {
			this.shot_posinicial = shot_posinicial;
		}
        
		
        
        
}