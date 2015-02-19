package com.isec.mytowerdefense.TShot;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.isec.mytowerdefense.Ecras.GameScreen;
import com.isec.mytowerdefense.Inimigos.Inimigo;
import com.isec.mytowerdefense.View.Jogo;

public class Torres_3_shot extends Inimigo {
	

    protected Texture textureBullet;
    
    protected Vector2 position;
    protected Rectangle towerRange;
    
    protected int velocidade = 7;
    
    protected boolean textureLoaded;
    
    protected float time=0;
    protected boolean firstTimeShot=false;
    
    protected boolean inimigoEmRange;  //se nao tiver "limpa" a texture
  

    public Torres_3_shot(float SPEED, float width, float height, Vector2 position, Rectangle towerRange) {
    	
            super(0, width, height, position);
            
            this.position = new Vector2(position);
            this.towerRange = towerRange;              
              
            textureBullet =  GameScreen.manager.get("data/tiros/bullet_3.png",Texture.class);
            
            inimigoEmRange=false;
           
    }

    @Override
    public void update() {
    	
    	inimigoEmRange=false;
    	
    	if(firstTimeShot==true){    	
    	
    	for(int i=0; i < Jogo.getInimigos().size(); i++)    	
    	  if(Jogo.getInimigos().get(i).getBounds().overlaps(towerRange))
    	  {    	  
    		position.lerp(Jogo.getInimigos().get(i).getPosition(), Gdx.graphics.getDeltaTime()*velocidade); 
               	     
            super.updateShot(position);
            inimigoEmRange=true;
            break;
            
    	  }
    }
    	else
    	{    		
    	   time+=Gdx.graphics.getDeltaTime();
    	    	  if(time>=0.3){  
    	    		  firstTimeShot=true; //ja pode dar o tiro
    	    		  time=0;    	    		  
    	    	  }    	
    	
    	}
    }
    	
    

	public Texture getTextureBullet() {
		return textureBullet;
	}

	public void setTextureBullet(Texture weapon) {
		this.textureBullet = weapon;
	}

	public Vector2 getPosition() {
		return position;
	}

	public void setPosition(Vector2 position) {
		this.position = position;
	}

	public Rectangle getTowerRange() {
		return towerRange;
	}

	public void setTowerRange(Rectangle towerRange) {
		this.towerRange = towerRange;
	}

	public int getVelocidade() {
		return velocidade;
	}

	public void setVelocidade(int velocidade) {
		this.velocidade = velocidade;
	}

	public boolean isTextureLoaded() {
		return textureLoaded;
	}

	public void setTextureLoaded(boolean textureLoaded) {
		this.textureLoaded = textureLoaded;
	}

	public float getTime() {
		return time;
	}

	public void setTime(float time) {
		this.time = time;
	}

	public boolean isFirstTimeShot() {
		return firstTimeShot;
	}

	public void setFirstTimeShot(boolean firstTimeShot) {
		this.firstTimeShot = firstTimeShot;
	}

	public boolean isInimigoEmRange() {
		return inimigoEmRange;
	}

	public void setInimigoEmRange(boolean inimigoEmRange) {
		this.inimigoEmRange = inimigoEmRange;
	}

			
	
	
    
    
}
