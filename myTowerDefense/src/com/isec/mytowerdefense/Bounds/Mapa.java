package com.isec.mytowerdefense.Bounds;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;
import com.isec.mytowerdefense.Torres.Torre_1;

//Limites do Mapa (e debug)

public class Mapa{
	
	public static ArrayList<Rectangle> towerPosBounds = new ArrayList<Rectangle>();
	   
    public static Rectangle mapBounds = new Rectangle(5,-90,505,565);    

           
        public Mapa()
        {
        	towerPosBounds.add(new Rectangle(30,267,160,25));   
        	towerPosBounds.add(new Rectangle(220,190,75,100));
            towerPosBounds.add(new Rectangle(110,373,240,25));   
            towerPosBounds.add(new Rectangle(388,90,35,300));   
            towerPosBounds.add(new Rectangle(160,80,200,35));
            towerPosBounds.add(new Rectangle(100,80,35,100));
            towerPosBounds.add(new Rectangle(208,8,45,48));   
        }
        
        public static void Debug(ShapeRenderer sr, OrthographicCamera cam){

        	sr.setProjectionMatrix(cam.combined);
            sr.begin(ShapeType.Rectangle);
            sr.setColor(Color.MAGENTA);
            sr.rect(30,267,160,25);             
            sr.rect(220,190,75,100);            
            sr.rect(110,373,240,25);            
            sr.rect(388,90,35,300);            
            sr.rect(160,80,200,35);            
            sr.rect(100,80,35,100);            
            sr.rect(208,8,45,45);            
            sr.setColor(Color.YELLOW);            
            sr.rect(5,-90,505,565);            
            sr.end();
        }
        
        public static void DebugTowers(ShapeRenderer sr, OrthographicCamera cam, ArrayList<Torre_1> torre){
        	
            sr.setProjectionMatrix(cam.combined);
            sr.begin(ShapeType.Rectangle);
            sr.setColor(Color.BLUE);
            
            for(int i=0; i < torre.size(); i++){
                sr.rect(torre.get(i).getBoundsNormal().x, torre.get(i).getBoundsNormal().y, torre.get(i).getBoundsNormal().width, torre.get(i).getBoundsNormal().height);
             }
            
            sr.setColor(Color.CYAN);
            
            for(int i=0; i < torre.size(); i++){                
                sr.rect(torre.get(i).getBounds().x, torre.get(i).getBounds().y, torre.get(i).getBounds().width, torre.get(i).getBounds().height);
               }
            sr.end();
        	
        }
        

		public static ArrayList<Rectangle> getTowerPosBounds() {
			return towerPosBounds;
		}

		public static void setTowerPosBounds(ArrayList<Rectangle> towerPosBounds) {
			Mapa.towerPosBounds = towerPosBounds;
		}

		public static Rectangle getMapBounds() {
			return mapBounds;
		}

		public static void setMapBounds(Rectangle mapBounds) {
			Mapa.mapBounds = mapBounds;
		}

	
        
        
}