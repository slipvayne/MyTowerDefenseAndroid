package com.isec.mytowerdefense.Inimigos;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.isec.mytowerdefense.Bounds.Mapa;
import com.isec.mytowerdefense.View.Jogo;

public abstract class Inimigo {
	
    protected Vector2 position; //posicao actual
    protected float width;
    protected float height;
    protected Rectangle bounds; //limites do objecto

    protected Vector2 velocity; //vector velocidade (para que posicao andar)
    protected float rotation; //rotaçao da imagem ao virar
    
    protected Texture TextureInimigo;
    protected TextureRegion TextRegInimigo;
    
    protected int flag=0;
    protected boolean repor=false;    
    public int vidas;
        
       
	public Inimigo(float rotation, float width, float height, Vector2 position){

        	  this.position = position;
              this.width = width;
              this.height = height;
              
              bounds = new Rectangle(position.x, position.y, width, height);
              
              this.rotation = rotation;
              velocity = new Vector2(0, 0); 
      		  
      		  baixo();
      		  flag=0;      		  
        }
        
        
        
        public Vector2 getVelocity(){
                return velocity;
        }
        
        public void setVelocity(Vector2 velocity){
                this.velocity = velocity;
        }
        
        public float getRotation(){
                return rotation;
        }
        
        public void setRotation(float rotation){
                this.rotation = rotation;
        }
        
        public void update(){
                bounds.x = position.x;
                bounds.y = position.y;
        }
        
        public void updateShot(Vector2 pos){
            bounds.x = pos.x;
            bounds.y = pos.y;
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

		
		public Texture getTextureInimigo() {
			return TextureInimigo;
		}

		public void setTextureInimigo(Texture textureInimigo) {
			TextureInimigo = textureInimigo;
		}



		public TextureRegion getTextRegInimigo() {
			return TextRegInimigo;
		}



		public void setTextRegInimigo(TextureRegion textRegInimigo) {
			TextRegInimigo = textRegInimigo;
		}
		
		
		
		public void updatePath(){
        	
      		 
   		 for(int i=0; i < Mapa.getTowerPosBounds().size(); i++)  
            {         
   			 if(!this.getBounds().overlaps(Mapa.getMapBounds())){
   				 	repor=true;
   				 	break;}
   			 if(this.getBounds().overlaps(Mapa.getTowerPosBounds().get(i))){
   	         		repor=true;
   			        break;}
            }
                        	   		 
   		 
 //PATH Provisorio.. ou entao fica assim.. (implementação não muito correcta)
   	      
   	      if (this.getPosition().x ==140 && this.getPosition().y>=24
   	    		  && this.getPosition().y<=28 || flag==1 && repor==true)
   	      {	    
   	    	 esquerda();
   	    	 flag=1;
   	    	 if(repor==true){
   	    		 this.setPosition(new Vector2(140,28));
   	    	     repor=false;
   	    	 }
   	      }
   	      
   	      else if ( (this.getPosition().x >=36 && this.getPosition().x <=40) 
   	    		  && (this.getPosition().y>=24 && this.getPosition().y<=28) || flag==2 && repor==true )
   	      {    		      
   		     baixo();	
   		     flag=2;
   		     if(repor==true){
   	    		 this.setPosition(new Vector2(38,26));
   	    	     repor=false;
   	    	 }
   	      }
   	      
   	     else if  ( (this.getPosition().x >=36 && this.getPosition().x <=40) 
   	    		  && (this.getPosition().y>=208 && this.getPosition().y<=212) || flag==3 && repor==true )
   	      {    	      
   		  direita();	
   		     flag=3;
   		     if(repor==true){
   	    		 this.setPosition(new Vector2(38,210));
   	    	     repor=false;
   	    	 }
   	      }
   	      
   	  else if  ( (this.getPosition().x >=148 && this.getPosition().x <=152) 
   	    		  && (this.getPosition().y>=208 && this.getPosition().y<=216) || flag==4 && repor==true  )
   	      {    		      
   		  cima();	 
   		  flag=4;
   		  if(repor==true){
   	    		 this.setPosition(new Vector2(150,212));
   	    	     repor=false;
   	    	 }
   	      }
   	      
   	else if  ( (this.getPosition().x >=148 && this.getPosition().x <=152) 
   	    		  && (this.getPosition().y>=128 && this.getPosition().y<=132) || flag==5 && repor==true )
   	      {    	      
   	     direita();	 
   	     flag=5;
   	     if(repor==true){
       		 this.setPosition(new Vector2(150,130));
       	     repor=false;
       	 }
   	      }
   	      
   	else if  ( (this.getPosition().x >=148 && this.getPosition().x <=152) 
   	    		  && (this.getPosition().y>=128 && this.getPosition().y<=132) || flag==6 && repor==true )
   	      {    		      
   	     direita();	
   	     flag=6;
   	     if(repor==true){
       		 this.setPosition(new Vector2(150,130));
       	     repor=false;
       	 }
   	      }
   	      
   	else if  ( (this.getPosition().x >=316 && this.getPosition().x <=320) 
   	    		  && (this.getPosition().y>=128 && this.getPosition().y<=132) || flag==7 && repor==true )
   	      {    		      
   	     baixo();
   	     flag=7;
   	     if(repor==true){
       		 this.setPosition(new Vector2(318,130));
       	     repor=false;
       	 }
   	      }
   	      
   	else if  ( (this.getPosition().x >=316 && this.getPosition().x <=320) 
   	    		  && (this.getPosition().y>=312 && this.getPosition().y<=316) || flag==8 && repor==true )
   	      {    	
   	      esquerda();	
   	      flag=8;
   	      if(repor==true){
   	    		 this.setPosition(new Vector2(318,314));
   	    	     repor=false;
   	    	 }
   	      }
   	      
   	else if  ( (this.getPosition().x >=40 && this.getPosition().x <=44) 
   	    		  && (this.getPosition().y>=312 && this.getPosition().y<=316) || flag==9 && repor==true)
   	      {    		      
   	     baixo();
   	     flag=9;
   	     if(repor==true){
       		 this.setPosition(new Vector2(42,314));
       	     repor=false;
       	 }
   	      }
   	      
   	else if  ( (this.getPosition().x >=40 && this.getPosition().x <=44) 
   	    		  && (this.getPosition().y>=416 && this.getPosition().y<=420) || flag==10 && repor==true )
   	      {    		      
   	     direita();	     
   	     flag=10;
   	     if(repor==true){
       		 this.setPosition(new Vector2(42,418));
       	     repor=false;
       	 }
   	      }
   	      
   	else if  ( (this.getPosition().x >=436 && this.getPosition().x <=440) 
   	    		  && (this.getPosition().y>=416 && this.getPosition().y<=420) || flag==11 && repor==true )
   	      {    	      
   	     cima();	
   	     flag=11;
   	     if(repor==true){
       		 this.setPosition(new Vector2(438,418));
       	     repor=false;
       	 }
   	      }
   	      
   	      
   	else if  ( (this.getPosition().x >=436 && this.getPosition().x <=440) 
   	    		  && (this.getPosition().y>=24 && this.getPosition().y<=28) || flag==12 && repor==true )
   	      {    	      
   	     esquerda();
   	     flag=12;
   	     if(repor==true){
       		 this.setPosition(new Vector2(438,26));
       	     repor=false;
       	 }
   	      }
   	      
   	      
   	else if  ( (this.getPosition().x >=264 && this.getPosition().x <=270) 
   	    		  && (this.getPosition().y>=24 && this.getPosition().y<=28) || flag==13 && repor==true)
   	      {    	
   	      	cima();
   	      flag=13;
   	      if(repor==true){
   	    		 this.setPosition(new Vector2(268,26));
   	    	     repor=false;
   	    	 }
   	     
   	      }
   	      
   	      //VOLTA (se nao for morto)
   	      
   	else if  ( (this.getPosition().x >=264 && this.getPosition().x <=270) 
   	    		  && (this.getPosition().y>=-80 && this.getPosition().y<=-40) || flag==14 && repor==true )
   	      {    	
   	    	  Vector2 position = new Vector2((float)140,-30);
       	      
   			  this.setPosition(position);	
   			  
   			  baixo();
   			  flag=0;
   			  if(repor==true){
   		    		 this.setPosition(new Vector2(140,-30));
   		    	     repor=false;
   		    	 }
   	     
   			  Jogo.setVidas(Jogo.getVidas()-1);
   	      }
   	      
   	else  if (flag==0 && repor==true && this.getPosition().y>= 0 )
   	      {
   	    	  this.setPosition(new Vector2(140,0));
  		      repor=false;
  		    
   	      }
   	      
   	      
   	  
   	  }
   	 
   	 public void baixo()
        {
        this.getVelocity().x = (float) 0;
        this.getVelocity().y = (float) +1;
        }
   	 
   	 public void esquerda()
        {
        this.getVelocity().x = (float) -1;
        this.getVelocity().y = (float) 0;
        }
   	 
   	 public void direita()
        {
        this.getVelocity().x = (float) +1;
        this.getVelocity().y = (float) 0;
        }
   	 
   	 public void cima()
        {
        this.getVelocity().x = (float) 0;
        this.getVelocity().y = (float) -1;
        }



	public int getFlag() {
		return flag;
	}



	public void setFlag(int flag) {
		this.flag = flag;
	}



	public boolean isRepor() {
		return repor;
	}



	public void setRepor(boolean repor) {
		this.repor = repor;
	}
	

	public int getVidas() {
		return vidas;
	}



	public void setVidas(int vidas) {
		this.vidas = vidas;
	}
	
	
	

}
   	
	 


		
        
