package com.isec.mytowerdefense.Torres;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public abstract class Torre {
	
    protected Vector2 position;
    protected float width;
    protected float height;
    protected Rectangle bounds; //limites com range
    protected Rectangle boundsNormal; //limites da imagem
    
    protected int tRange; //range da torre para chegar aos inimigos
    
    protected Texture TextureTorre;
    protected TextureRegion TextRegTorre;    
         
        
    public Torre(float width, float height, Vector2 position){

        	  this.position = position;
              this.width = width;
              this.height = height;                           
                                 
        }        
                
             
     	public Vector2 getPosition() {
			return position;
		}

		public void setPosition(Vector2 position) {
			this.position = position;
		}

		public float getWidth() {
			return width;
		}

		public void setWidth(float width) {
			this.width = width;
		}

		public float getHeight() {
			return height;
		}

		public void setHeight(float height) {
			this.height = height;
		}

		public Rectangle getBounds() {
			return bounds;
		}

		public void setBounds(Rectangle bounds) {
			this.bounds = bounds;
		}


		public Texture getTextureTorre() {
			return TextureTorre;
		}



		public void setTextureTorre(Texture textureTorre) {
			TextureTorre = textureTorre;
		}



		public TextureRegion getTextRegTorre() {
			return TextRegTorre;
		}



		public void setTextRegTorre(TextureRegion textRegTorre) {
			TextRegTorre = textRegTorre;
		}



		public Rectangle getBoundsNormal() {
			return boundsNormal;
		}



		public void setBoundsNormal(Rectangle boundsNormal) {
			this.boundsNormal = boundsNormal;
		}



		public int gettRange() {
			return tRange;
		}



		public void settRange(int tRange) {
			this.tRange = tRange;
		}


				

		
}