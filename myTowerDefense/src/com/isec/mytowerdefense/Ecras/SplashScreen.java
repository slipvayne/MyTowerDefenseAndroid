package com.isec.mytowerdefense.Ecras;


import aurelienribon.tweenengine.BaseTween;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenCallback;
import aurelienribon.tweenengine.TweenEquations;
import aurelienribon.tweenengine.TweenManager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.isec.mytowerdefense.myTowerDefense;
import com.isec.mytowerdefense.TweenAccessors.SpriteTween;

public class SplashScreen implements Screen { 
	//Tweenengine Tutorial em:  http://code.google.com/p/java-universal-tween-engine/
        
        private Texture splashTexture;
        private Sprite splashSprite;
        private SpriteBatch batch;
        private myTowerDefense game;
        private TweenManager manager;
        public static final int VIRTUAL_WIDTH = 800; 
    	public static final int VIRTUAL_HEIGHT = 480;
    	private OrthographicCamera cam;
 
        public SplashScreen(myTowerDefense game) {
                this.game = game;
                
                cam = new OrthographicCamera(VIRTUAL_WIDTH , VIRTUAL_HEIGHT );           
                cam.setToOrtho(false, VIRTUAL_WIDTH, VIRTUAL_HEIGHT);
                cam.update();
                
                batch = new SpriteBatch();
                batch.setProjectionMatrix(cam.combined);
         
        }

        @Override
        public void render(float delta) {
                Gdx.gl.glClearColor(0, 0, 0, 1);
                Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
                manager.update(delta);
                
                batch.begin();
                splashSprite.draw(batch);
                batch.end();
        }

        @Override
        public void resize(int width, int height) {
                
        }

        @Override
        public void show() {
                splashTexture = new Texture("data/splashscreen.jpg");
                splashTexture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
                
                splashSprite = new Sprite(splashTexture);
                splashSprite.setColor(1, 1, 1, 0);
                splashSprite.setX(VIRTUAL_WIDTH / 2 - (splashSprite.getWidth() / 2));
                splashSprite.setY(VIRTUAL_HEIGHT / 2 - (splashSprite.getHeight() / 2));
                
                              
                Tween.registerAccessor(Sprite.class, new SpriteTween());
                
                manager = new TweenManager();
                
                TweenCallback cb = new TweenCallback() {                        
                        @Override
                        public void onEvent(int type, BaseTween<?> source) {
                                tweenCompleted();
                        }
                };
                
                Tween.to(splashSprite, SpriteTween.ALPHA, 0.5f).target(1).ease(TweenEquations.easeInQuad).repeatYoyo(1, 0.5f).setCallback(cb).setCallbackTriggers(TweenCallback.COMPLETE).start(manager);
        }

        private void tweenCompleted(){
                Gdx.app.log(myTowerDefense.LOG, "Tween Complete");
                game.setScreen(new GameScreen(game));     
                
                return;
        }
        
        @Override
        public void hide() {
                
        }

        @Override
        public void pause() {
                
        }

        @Override
        public void resume() {
                
        }

        @Override
        public void dispose() {
                
        }

		public Texture getSplashTexture() {
			return splashTexture;
		}

		public void setSplashTexture(Texture splashTexture) {
			this.splashTexture = splashTexture;
		}

		public Sprite getSplashSprite() {
			return splashSprite;
		}

		public void setSplashSprite(Sprite splashSprite) {
			this.splashSprite = splashSprite;
		}

		public SpriteBatch getBatch() {
			return batch;
		}

		public void setBatch(SpriteBatch batch) {
			this.batch = batch;
		}

		public myTowerDefense getGame() {
			return game;
		}

		public void setGame(myTowerDefense game) {
			this.game = game;
		}

		public TweenManager getManager() {
			return manager;
		}

		public void setManager(TweenManager manager) {
			this.manager = manager;
		}

        
}