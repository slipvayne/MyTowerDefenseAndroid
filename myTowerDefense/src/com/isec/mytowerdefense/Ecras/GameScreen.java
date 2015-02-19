package com.isec.mytowerdefense.Ecras;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.TextureLoader.TextureParameter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.isec.mytowerdefense.myTowerDefense;
import com.isec.mytowerdefense.View.Jogo;


public class GameScreen implements Screen {
	
    public static myTowerDefense game;
    private Jogo jogo;
    public static AssetManager manager;
    public static Skin skin;
	public static TextureAtlas atlas;
    
    public GameScreen(myTowerDefense game){
    	
            GameScreen.game = game;
            
            manager = new AssetManager();
            
            loadTextures();
            
            jogo = new Jogo();     
    }
    
    @Override
    public void render(float delta) {
    	
    	if(!Jogo.isJogoAcabou())
            jogo.update();
                    
            jogo.render();
    							
    }

    @Override
    public void resize(int width, int height) {
            
    }

    @Override
    public void show() {
    	
            
    }

    @Override
    public void hide() {
            dispose();
    }

    @Override
    public void pause() {
    	
   
                     
    }

    @Override
    public void resume() {
                       
     	  	
    }

    @Override
    public void dispose() {
    	
    	jogo.dispose();
    	
    }

	public static myTowerDefense getGame() {
		return game;
	}

	public static void setGame(myTowerDefense game) {
		GameScreen.game = game;
	}

	public Jogo getJogo() {
		return jogo;
	}

	public void setJogo(Jogo jogo) {
		this.jogo = jogo;
	}
    
    public void loadTextures()
    {
    	TextureParameter param = new TextureParameter();
    	param.minFilter = TextureFilter.Linear;
 
    	manager.load("data/backgroundpath.png",Texture.class,param);
    	manager.load("data/inimigos/inimigo_1.png",Texture.class,param);
    	manager.load("data/inimigos/inimigo_2.png",Texture.class,param);
    	manager.load("data/inimigos/inimigo_3.png",Texture.class,param);
    	manager.load("data/inimigos/inimigo_4.png",Texture.class,param);
    	manager.load("data/inimigos/inimigo_5.png",Texture.class,param);
    	manager.load("data/inimigos/inimigo_6.png",Texture.class,param);
    	manager.load("data/inimigos/inimigo_7.png",Texture.class,param);
    	
    	manager.load("data/tiros/bullet_1.png",Texture.class,param);
    	manager.load("data/tiros/bullet_2.png",Texture.class,param);
    	manager.load("data/tiros/bullet_3.png",Texture.class,param);

    	manager.load("data/torres/torre_1.png",Texture.class,param); 
    	manager.load("data/torres/torre_2.png",Texture.class,param); 
    	manager.load("data/torres/torre_3.png",Texture.class,param); 
    	
    	manager.update();
		manager.finishLoading();
      
        atlas = new TextureAtlas(Gdx.files.internal("data/packs/buttons.pack"),true);
        skin = new Skin();        
        skin.addRegions(atlas);       
    			
		
    }

	public static AssetManager getManager() {
		return manager;
	}

	public static void setManager(AssetManager manager) {
		GameScreen.manager = manager;
	}

	public static Skin getSkin() {
		return skin;
	}

	public static void setSkin(Skin skin) {
		GameScreen.skin = skin;
	}

	public static TextureAtlas getAtlas() {
		return atlas;
	}

	public static void setAtlas(TextureAtlas atlas) {
		GameScreen.atlas = atlas;
	}
    
    

    
}