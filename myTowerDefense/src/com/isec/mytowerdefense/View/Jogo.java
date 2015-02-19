package com.isec.mytowerdefense.View;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.isec.mytowerdefense.myTowerDefense;
import com.isec.mytowerdefense.Bounds.Mapa;
import com.isec.mytowerdefense.Ecras.GameScreen;
import com.isec.mytowerdefense.Inimigos.Inimigo;
import com.isec.mytowerdefense.Torres.Torre_1;
import com.isec.mytowerdefense.Torres.Torre_2;
import com.isec.mytowerdefense.Torres.Torre_3;

public class Jogo {
    
	
	public SpriteBatch batch;
	public OrthographicCamera cam;
	public ShapeRenderer sr;	
		
	public Texture backgroundMapTexture;
	public TextureRegion backgroundMapTextureRegion;
	
	public static ArrayList<Inimigo> inimigos;	
	
	public static ArrayList<Torre_1> torres_1;	
	public static ArrayList<Torre_2> torres_2;	
	public static ArrayList<Torre_3> torres_3;	
	
	public static final int VIRTUAL_WIDTH = 800; 
	public static final int VIRTUAL_HEIGHT = 480;   
    	
   	
	public static BitmapFont font; // http://www.angelcode.com/products/bmfont/
	public static BitmapFont fontBig;
	public static BitmapFont fontCalibri;
	
	public static boolean flagLevelPassed;
	
	public static int nivel;
	public static int vidas;
	public static int inimigosDestruidos;
	public static int dinheiro;
	
	public static final int EN = 0;
	public static final int PT = 1;
	
	public static int language;
	
	public static Stage stage;
	
	public static TextButton buttonPlay , buttonTower1, buttonTower2, buttonTower3;
	public static TextButtonStyle buttonPlayStyle ,buttonTower1Style, buttonTower2Style, buttonTower3Style ;	
		
	public static InputMultiplexer InputMulti;
	
	public static boolean start;
	public static boolean buttonStart;
	
	public static JogoListeners listener;
	
	public static int torre_selected;
	
	public static boolean msgSemDinheiro;
	public static boolean msgJogoParado;
	
	public static boolean jogoAcabou;
	
	   
    
    public Jogo(){
    	        	   
    	   start = false;
    	   buttonStart = true;
    	   msgJogoParado = true;
    	   msgSemDinheiro = false;
    	   msgJogoParado = false;
    	   jogoAcabou = false;
    	   torre_selected = 0;
    	   flagLevelPassed = true;
    		
    	   if(myTowerDefense.getCountryCode().equalsIgnoreCase("PT")) //recebido na activity
    	   {
    		   language = PT;
    	   }else { language = EN; }
    	     	   
      	   
    	   font = new BitmapFont(Gdx.files.internal("data/fonts/britanicbold.fnt"), true);
    	   fontBig =  new BitmapFont(Gdx.files.internal("data/fonts/brit_black_big.fnt"), true);
    	   fontCalibri =  new BitmapFont(Gdx.files.internal("data/fonts/calibri_medio.fnt"), true);
    	       	   
    	   sr = new ShapeRenderer();    	   
    	   cam = new OrthographicCamera(VIRTUAL_WIDTH , VIRTUAL_HEIGHT );           
           cam.setToOrtho(true, VIRTUAL_WIDTH, VIRTUAL_HEIGHT);
           cam.update();
           batch = new SpriteBatch();
           batch.setProjectionMatrix(cam.combined);  
           
           stage = new Stage(800, 480, true);
           stage.clear();    
           stage.setCamera(cam);
                	   
    	   new Mapa();   
   	       	   
    	   inimigos = new ArrayList<Inimigo>();     	   
    	   
    	   torres_1 = new ArrayList<Torre_1>();  
    	   torres_2 = new ArrayList<Torre_2>();
    	   torres_3 = new ArrayList<Torre_3>();
    	   
    	   listener = new JogoListeners();
       	        
    	   nivel=0;	 
    	   vidas=1;
    	   inimigosDestruidos=0;
    	   dinheiro=2;    	   
           
           loadBackground();  
           
           loadActors(); //botoes
  
       InputMulti = new InputMultiplexer();
       InputMulti.addProcessor(new InputHandler(this));
       InputMulti.addProcessor(stage);
       
       Gdx.input.setInputProcessor(InputMulti);
       //2 inputs.. um "generico" outro para o stage
           
    }
    
    public void render(){
    	    	    	
       //     Gdx.gl.glClearColor(0, 0, 0, 1);
              Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);                                                      
                     
                     
            if(AddInimigos.getNumInimigosLvl() == AddInimigos.getNumInimigosKilledLvl()) //dead enemys
  			{
            	flagLevelPassed=true;  	
  				buttonStart=true;
  				msgJogoParado=true;  				
  			}  
            
            if(flagLevelPassed && nivel<=7 && start==true) //se passou de nivel
            {
               nivel++;
               vidas++;  
               dinheiro+=3;
               loadInimigos(nivel);         	    
         	   flagLevelPassed=false;
         	   start=false;
         	   buttonStart=false;
         	   msgJogoParado=false;
         	   
         	   
            }else
            	{if(nivel>7)
           		  vidas=-1;} //forca fim de jogo
            
                
            batch.begin();              
            
            detetaFinal();            
           
                                  
            if(jogoAcabou!=true){  //se o jogo acabou nao e' necessario atualizar          	
           
            desenhaBg();
            
            desenhaInimigos();
            
            desenhaTorreseShots();
          
            desenhaTexto();  
            
            }
            
                          
            batch.end();   
            
            //mDebug();              
               
            desenhaBotoes(); //fora do batch..
               
    }
    
    public void detetaFinal()
    {
    	 if(vidas<=0)
         {
         	           	
         	font.setColor(Color.CYAN);
 			font.draw(batch, "Game Over!", 150, 150);
             	
 			font.setColor(Color.YELLOW);
 			if(language==PT){
 				font.draw(batch, "Pontuação Final: "+inimigosDestruidos, 115, 260);
 				font.setColor(Color.WHITE);
 				font.draw(batch, "Clique no start para enviar a pontuação...", 0, 350);}
 			else{
 				font.draw(batch, "Final Score: "+inimigosDestruidos, 130, 260);
 				font.setColor(Color.WHITE);
 				font.draw(batch, "Click on start to submit the score...", 0, 350);
 			}
 		
 			font.setColor(Color.WHITE);
 			
 			vidas=0;
 			jogoAcabou=true;
         }
    }
    
    
    public void desenhaBotoes()
    {
    	
    	buttonPlay.setText("Start");
    	
    	if(buttonStart==true)
    	buttonPlay.setColor(Color.ORANGE);
    	else
    	buttonPlay.setColor(Color.GRAY);
     
       stage.act(Gdx.graphics.getDeltaTime());    
       stage.draw();        
   
    	
    }
    
    public void loadActors()
    {
    	
       buttonPlayStyle = new TextButtonStyle();
  	   buttonTower1Style = new TextButtonStyle();
  	   buttonTower2Style = new TextButtonStyle();
  	   buttonTower3Style = new TextButtonStyle();
  	   
    	//PLAY
    	buttonPlayStyle.up = GameScreen.getSkin().getDrawable("playNormal");
    	buttonPlayStyle.down = GameScreen.getSkin().getDrawable("playNormalPressed");
    	buttonPlayStyle.font = fontBig;
    	    	
    	buttonPlay = new TextButton("Start", buttonPlayStyle);
    	buttonPlay.setWidth(265); buttonPlay.setHeight(100);
    	buttonPlay.setX(525);
        buttonPlay.setY(380);
        buttonPlay.setColor(Color.ORANGE);

    	buttonPlay.addListener(listener);
    	       
    	stage.addActor(buttonPlay);
    	
    	//TORRE 1
        buttonTower1Style.up = GameScreen.getSkin().getDrawable("torre1");
    	buttonTower1Style.font = font;
    	  
    	buttonTower1 = new TextButton("", buttonTower1Style);
 
    	buttonTower1.setHeight(64); buttonTower1.setWidth(64);
    	buttonTower1.setX(525);    	buttonTower1.setY(150);
        	    
    	buttonTower1.addListener(listener);
    	       
    	stage.addActor(buttonTower1);
    		 
    	//TORRE 2
        buttonTower2Style.up = GameScreen.getSkin().getDrawable("torre2");
    	buttonTower2Style.font = font;
    	  
    	buttonTower2 = new TextButton("", buttonTower2Style);
 
    	buttonTower2.setHeight(64); buttonTower2.setWidth(64);
    	buttonTower2.setX(625); 	buttonTower2.setY(150);
        	    
    	buttonTower2.addListener(listener);
    	       
    	stage.addActor(buttonTower2);
    	
    	//TORRE 3
        buttonTower3Style.up = GameScreen.getSkin().getDrawable("torre3");
    	buttonTower3Style.font = font;
    	  
    	buttonTower3 = new TextButton("", buttonTower3Style);
 
    	buttonTower3.setHeight(64); buttonTower3.setWidth(64);
    	buttonTower3.setX(725); buttonTower3.setY(150);
        	    
    	buttonTower3.addListener(listener);
    	       
    	stage.addActor(buttonTower3);
    	 
    	 
    	 
    }
    
    public void loadInimigos(int lvl)
    {    	
 	   new AddInimigos(this,lvl).cria(); 	
    }
    
    public void mDebug()
    {
    	 Mapa.Debug(sr, cam);
         
         Mapa.DebugTowers(sr, cam, torres_1 );
    }
    
    public void desenhaBg()
    {
        batch.draw(backgroundMapTextureRegion, 0, 0, backgroundMapTextureRegion.getRegionWidth(),
        					backgroundMapTextureRegion.getRegionHeight()-30);
    }
    
    public void desenhaInimigos()
    {
                
              for(int i=0; i < inimigos.size(); i++)
              batch.draw(inimigos.get(i).getTextRegInimigo(), inimigos.get(i).getPosition().x, inimigos.get(i).getPosition().y, 
            		  inimigos.get(i).getWidth() / 2, inimigos.get(i).getHeight() / 2, 
            		  inimigos.get(i).getWidth(), inimigos.get(i).getHeight(),
            		  1, 1, inimigos.get(i).getRotation());                    	 
    }
    
    
    public void desenhaTorreseShots()
    {    	
    	
   	//Monster libgdx draw function...
    	
    	for(int i=0; i < torres_1.size(); i++)
            batch.draw(torres_1.get(i).getTextRegTorre(), torres_1.get(i).getPosition().x, torres_1.get(i).getPosition().y, 
            		torres_1.get(i).getWidth() / 2, torres_1.get(i).getHeight() / 2, torres_1.get(i).getWidth(),
            		torres_1.get(i).getHeight(), 1, 1, 0);

            for(int i=0; i < torres_1.size(); i++){
            	if(torres_1.get(i).getShot().isInimigoEmRange())     
            batch.draw(torres_1.get(i).getShot().getTextureBullet(), torres_1.get(i).getShot().getPosition().x, torres_1.get(i).getShot().getPosition().y, 
            		torres_1.get(i).getShot().getWidth() / 2, torres_1.get(i).getShot().getHeight() / 2,
            		torres_1.get(i).getShot().getWidth(), torres_1.get(i).getShot().getHeight(), 
            		1, 1, torres_1.get(i).getShot().getRotation(), 0, 0, 
            		torres_1.get(i).getShot().getTextureBullet().getWidth(), torres_1.get(i).getShot().getTextureBullet().getHeight(), false, false);
            }
            
            for(int i=0; i < torres_2.size(); i++)
                batch.draw(torres_2.get(i).getTextRegTorre(), torres_2.get(i).getPosition().x, torres_2.get(i).getPosition().y, 
                		torres_2.get(i).getWidth() / 2, torres_2.get(i).getHeight() / 2, torres_2.get(i).getWidth(),
                		torres_2.get(i).getHeight(), 1, 1, 0);

                for(int i=0; i < torres_2.size(); i++){
                	if(torres_2.get(i).getShot().isInimigoEmRange())               
                batch.draw(torres_2.get(i).getShot().getTextureBullet(), torres_2.get(i).getShot().getPosition().x, torres_2.get(i).getShot().getPosition().y, 
                		torres_2.get(i).getShot().getWidth() / 2, torres_2.get(i).getShot().getHeight() / 2,
                		torres_2.get(i).getShot().getWidth(), torres_2.get(i).getShot().getHeight(), 
                		1, 1, torres_2.get(i).getShot().getRotation(), 0, 0, 
                		torres_2.get(i).getShot().getTextureBullet().getWidth(), torres_2.get(i).getShot().getTextureBullet().getHeight(), false, false);
                }
                
                
                for(int i=0; i < torres_3.size(); i++)
                    batch.draw(torres_3.get(i).getTextRegTorre(), torres_3.get(i).getPosition().x, torres_3.get(i).getPosition().y, 
                    		torres_3.get(i).getWidth() / 2, torres_3.get(i).getHeight() / 2, torres_3.get(i).getWidth(),
                    		torres_3.get(i).getHeight(), 1, 1, 0);

                    for(int i=0; i < torres_3.size(); i++){
                    	if(torres_3.get(i).getShot().isInimigoEmRange())
                    batch.draw(torres_3.get(i).getShot().getTextureBullet(), torres_3.get(i).getShot().getPosition().x, torres_3.get(i).getShot().getPosition().y, 
                    		torres_3.get(i).getShot().getWidth() / 2, torres_3.get(i).getShot().getHeight() / 2,
                    		torres_3.get(i).getShot().getWidth(), torres_3.get(i).getShot().getHeight(), 
                    		1, 1, torres_3.get(i).getShot().getRotation(), 0, 0, 
                    		torres_3.get(i).getShot().getTextureBullet().getWidth(), torres_3.get(i).getShot().getTextureBullet().getHeight(), false, false);
                    }
                        
    }
    
    public void desenhaTexto()
    {    	
    	
    	if(language==PT)
    	{
    		font.draw(batch, "Pontos: "+inimigosDestruidos,  525, 5);   
    		font.draw(batch, "Nível: "+nivel, 525, 40);
    		font.draw(batch, "Vidas: "+vidas, 670, 40);    	
    		
    		font.draw(batch, "Torres:",  525, 110); 
    		
    		if(buttonTower1.getColor().equals(Color.YELLOW)){    		
    			fontCalibri.draw(batch, "Esta torre custa 1$", 525, 250);
    			fontCalibri.draw(batch, "Baixo dano mas com uma taxa de tiro elevada", 525, 265);
    		}else
    			if(buttonTower2.getColor().equals(Color.YELLOW)){        	
    				fontCalibri.draw(batch, "Esta torre custa 2$", 525, 250);
        			fontCalibri.draw(batch, "Taxa de tiro lenta mas com um alcance elevado", 525, 265);
        		}else
        			if(buttonTower3.getColor().equals(Color.YELLOW)){            	
        				fontCalibri.draw(batch, "Esta torre custa 3$", 525, 250);
            			fontCalibri.draw(batch, "Bom dano e bom alcance", 525, 265);
            		}
    		
    		if(msgSemDinheiro==true){
    			fontCalibri.setColor(Color.RED);
    			fontCalibri.draw(batch, "Não há dinheiro para comprar a torre!", 525, 320);
    			fontCalibri.setColor(Color.WHITE);
    		}
    		
    		if(msgJogoParado==true){
    			fontCalibri.draw(batch, "Quando estiveres preparado carrega no start!", 525, 340);
    		}
    			
    	}
    	else
    	{
    		font.draw(batch, "Score: "+inimigosDestruidos, 525, 5);           
    		font.draw(batch, "Level: "+nivel, 533, 40);
    		font.draw(batch, "Lifes: "+vidas, 670, 40);  
    		
    		font.draw(batch, "Towers:", 525, 110); 
    		
    	    		
    		if(buttonTower1.getColor().equals(Color.YELLOW)){    		
    			fontCalibri.draw(batch, "This tower costs 1$", 525, 250);
    			fontCalibri.draw(batch, "Low damage but very fast fire rate", 525, 265);
    		
    		}else
    			if(buttonTower2.getColor().equals(Color.YELLOW)){        	
    				fontCalibri.draw(batch, "This tower costs 2$", 525, 250);
        			fontCalibri.draw(batch, "Slow fire rate but with high range", 525, 265);
        		}else
        			if(buttonTower3.getColor().equals(Color.YELLOW)){            	
        				fontCalibri.draw(batch, "This tower costs 3$", 525, 250);
            			fontCalibri.draw(batch, "Good Damage, rate and range ", 525, 265);
            		}
    		if(msgSemDinheiro==true){
    			fontCalibri.setColor(Color.RED);
    			fontCalibri.draw(batch, "There is no money to afford that tower!", 525, 320);
    			fontCalibri.setColor(Color.WHITE);
    		}
    		
    		if(msgJogoParado==true){
    			fontCalibri.draw(batch, "When you're ready, click on start to play!", 525, 340);
    		}
    	
    	}
    	
    	if(dinheiro<=0)
    		font.setColor(Color.RED);
    	else
    	font.setColor(Color.GREEN);
    	
    	font.draw(batch, dinheiro +"$", 710, 5);
    	font.setColor(Color.WHITE);
    	
    }
    
    public void dispose(){
            batch.dispose();
            sr.dispose();
            
            for(int i=0; i < inimigos.size(); i++)
            	inimigos.get(i).getTextureInimigo().dispose();            
                      
            for(int i=0; i < torres_1.size(); i++)
            	torres_1.get(i).getShot().getTextureBullet().dispose();           
            
            for(int i=0; i < torres_1.size(); i++)
                torres_1.get(i).getTextureTorre().dispose();
            
            for(int i=0; i < torres_2.size(); i++)
            	torres_2.get(i).getShot().getTextureBullet().dispose();           
            
            for(int i=0; i < torres_2.size(); i++)
                torres_2.get(i).getTextureTorre().dispose();
            
            for(int i=0; i < torres_3.size(); i++)
            	torres_3.get(i).getShot().getTextureBullet().dispose();           
            
            for(int i=0; i < torres_3.size(); i++)
                torres_3.get(i).getTextureTorre().dispose();
                        
            
    }
    
    public Inimigo getInimigo(int i){
        return inimigos.get(i);
    }
    
    public void addInimigo(Inimigo novo){
        inimigos.add(novo);
    }
    
    
    public Torre_1 getTorres_1(int i){
        return torres_1.get(i);
    }
    
    public void addTorres_1(Torre_1 novo){
    	torres_1.add(novo);
    }
    
    public Torre_2 getTorres_2(int i){
        return torres_2.get(i);
    }
    
    public void addTorres_2(Torre_2 novo){
    	torres_2.add(novo);
    }
        
    public Torre_3 getTorres_3(int i){
        return torres_3.get(i);
    }
    
    public void addTorres_3(Torre_3 novo){
    	torres_3.add(novo);
    }
    
    
  

    public void update(){
    	
           
    	 for(int i=0; i < torres_1.size(); i++)     
    			 torres_1.get(i).getShot().update();
    	 
    	 for(int i=0; i < torres_2.size(); i++)     
			 torres_2.get(i).getShot().update();
    	 
    	 for(int i=0; i < torres_3.size(); i++)     
			 torres_3.get(i).getShot().update();
    	 
    	    
    	 for(int i=0; i < torres_1.size(); i++)  {
    		 for(int j=0; j < inimigos.size(); j++){
    			 if(inimigos.get(j).getBounds().overlaps(torres_1.get(i).getShot().getBounds()))    		
    			 {     		
    				 if(inimigos.get(j).getVidas() <= 0)
    				 {
    					 inimigos.remove(j);  
    					 AddInimigos.setNumInimigosKilledLvl( AddInimigos.getNumInimigosKilledLvl() +1 ); 
    					 inimigosDestruidos++;
    				 }else
    				 {
    				 inimigos.get(j).setVidas( inimigos.get(j).getVidas() -1); //retira so 1
    				 }    				   			
    				 
    				 torres_1.get(i).newShot(); 
    			 }
        	}
    	 }
    		 
    		 
    		 for(int i=0; i < torres_2.size(); i++)  {
        		 for(int j=0; j < inimigos.size(); j++){
        			 if(inimigos.get(j).getBounds().overlaps(torres_2.get(i).getShot().getBounds()))    		
        			 {         			
        				 if(inimigos.get(j).getVidas() <= 0)
        				 {
        					 inimigos.remove(j);  
        					 AddInimigos.setNumInimigosKilledLvl( AddInimigos.getNumInimigosKilledLvl() +1 ); 
        					 inimigosDestruidos++;
        				 }else
        				 {
        				 inimigos.get(j).setVidas( inimigos.get(j).getVidas() -3); //retira 2
        				 }    				   			
        				 
        				 torres_2.get(i).newShot(); 
        			 }   	 
    		 
        		 }
    		 }
    		 
    		 
    		 for(int i=0; i < torres_3.size(); i++)  {
        		 for(int j=0; j < inimigos.size(); j++){
        			 if(inimigos.get(j).getBounds().overlaps(torres_3.get(i).getShot().getBounds()))    		
        			 {         		
        				 if(inimigos.get(j).getVidas() <= 0)
        				 {
        					 inimigos.remove(j);  
        					 AddInimigos.setNumInimigosKilledLvl( AddInimigos.getNumInimigosKilledLvl() +1 ); 
        					 inimigosDestruidos++;
        				 }else
        				 {
        				 inimigos.get(j).setVidas( inimigos.get(j).getVidas() -5); //retira 3 a resistencia..
        				 }    				   			
        				 
        				 torres_3.get(i).newShot(); 
        			 }   	 
    		 
        		 }
    		 }
    				
	    for(int i=0; i < inimigos.size(); i++)
	    inimigos.get(i).update();
       
        	 
    }
    

	public SpriteBatch getBatch() {
		return batch;
	}

	public void setBatch(SpriteBatch batch) {
		this.batch = batch;
	}

	public OrthographicCamera getCam() {
		return cam;
	}

	public void setCam(OrthographicCamera cam) {
		this.cam = cam;
	}

	public ShapeRenderer getSr() {
		return sr;
	}

	public void setSr(ShapeRenderer sr) {
		this.sr = sr;
	}

	
	public Texture getBackgroundMapTexture() {
		return backgroundMapTexture;
	}

	public void setBackgroundMapTexture(Texture backgroundMapTexture) {
		this.backgroundMapTexture = backgroundMapTexture;
	}

	public TextureRegion getBackgroundMapTextureRegion() {
		return backgroundMapTextureRegion;
	}

	public void setBackgroundMapTextureRegion(
			TextureRegion backgroundMapTextureRegion) {
		this.backgroundMapTextureRegion = backgroundMapTextureRegion;
	}

	public static ArrayList<Inimigo> getInimigos() {
		return inimigos;
	}

	public static void setInimigosLvl1(ArrayList<Inimigo> inimigos) {
		Jogo.inimigos = inimigos;
	}
	

	public BitmapFont getFont() {
		return font;
	}

	public void setFont(BitmapFont font) {
		Jogo.font = font;
	}

	public static int getVirtualWidth() {
		return VIRTUAL_WIDTH;
	}

	public static int getVirtualHeight() {
		return VIRTUAL_HEIGHT;
	}
    
	public void loadBackground()
	{
		
		backgroundMapTexture = GameScreen.manager.get("data/backgroundpath.png",Texture.class);
		backgroundMapTextureRegion = new TextureRegion(backgroundMapTexture);
		backgroundMapTextureRegion.flip(false, true);		
	      
	}

	public static boolean isFlagLevelPassed() {
		return flagLevelPassed;
	}

	public static void setFlagLevelPassed(boolean flagLevelPassed) {
		Jogo.flagLevelPassed = flagLevelPassed;
	}

	

	public static int getNivel() {
		return nivel;
	}

	public static void setNivel(int nivel) {
		Jogo.nivel = nivel;
	}


	public static int getVidas() {
		return vidas;
	}

	public static void setVidas(int vidas) {
		Jogo.vidas = vidas;
	}

	public static int getLanguage() {
		return language;
	}

	public static void setLanguage(int language) {
		Jogo.language = language;
	}

	public static int getEn() {
		return EN;
	}

	public static int getPt() {
		return PT;
	}

	public static int getInimigosDestruidos() {
		return inimigosDestruidos;
	}

	public static void setInimigosDestruidos(int inimigosDestruidos) {
		Jogo.inimigosDestruidos = inimigosDestruidos;
	}

	public static int getDinheiro() {
		return dinheiro;
	}

	public static void setDinheiro(int dinheiro) {
		Jogo.dinheiro = dinheiro;
	}

	public static ArrayList<Torre_1> getTorres_1() {
		return torres_1;
	}

	public static void setTorres_1(ArrayList<Torre_1> torres_1) {
		Jogo.torres_1 = torres_1;
	}

	public static ArrayList<Torre_2> getTorres_2() {
		return torres_2;
	}

	public static void setTorres_2(ArrayList<Torre_2> torres_2) {
		Jogo.torres_2 = torres_2;
	}

	public static ArrayList<Torre_3> getTorres_3() {
		return torres_3;
	}

	public static void setTorres_3(ArrayList<Torre_3> torres_3) {
		Jogo.torres_3 = torres_3;
	}

	public static BitmapFont getFontBig() {
		return fontBig;
	}

	public static void setFontBig(BitmapFont fontBig) {
		Jogo.fontBig = fontBig;
	}

	public static BitmapFont getFontCalibri() {
		return fontCalibri;
	}

	public static void setFontCalibri(BitmapFont fontCalibri) {
		Jogo.fontCalibri = fontCalibri;
	}

	public static Stage getStage() {
		return stage;
	}

	public static void setStage(Stage stage) {
		Jogo.stage = stage;
	}

	public static TextButton getButtonPlay() {
		return buttonPlay;
	}

	public static void setButtonPlay(TextButton buttonPlay) {
		Jogo.buttonPlay = buttonPlay;
	}

	public static TextButton getButtonTower1() {
		return buttonTower1;
	}

	public static void setButtonTower1(TextButton buttonTower1) {
		Jogo.buttonTower1 = buttonTower1;
	}

	public static TextButton getButtonTower2() {
		return buttonTower2;
	}

	public static void setButtonTower2(TextButton buttonTower2) {
		Jogo.buttonTower2 = buttonTower2;
	}

	public static TextButton getButtonTower3() {
		return buttonTower3;
	}

	public static void setButtonTower3(TextButton buttonTower3) {
		Jogo.buttonTower3 = buttonTower3;
	}

	public static TextButtonStyle getButtonPlayStyle() {
		return buttonPlayStyle;
	}

	public static void setButtonPlayStyle(TextButtonStyle buttonPlayStyle) {
		Jogo.buttonPlayStyle = buttonPlayStyle;
	}

	public static TextButtonStyle getButtonTower1Style() {
		return buttonTower1Style;
	}

	public static void setButtonTower1Style(TextButtonStyle buttonTower1Style) {
		Jogo.buttonTower1Style = buttonTower1Style;
	}

	public static TextButtonStyle getButtonTower2Style() {
		return buttonTower2Style;
	}

	public static void setButtonTower2Style(TextButtonStyle buttonTower2Style) {
		Jogo.buttonTower2Style = buttonTower2Style;
	}

	public static TextButtonStyle getButtonTower3Style() {
		return buttonTower3Style;
	}

	public static void setButtonTower3Style(TextButtonStyle buttonTower3Style) {
		Jogo.buttonTower3Style = buttonTower3Style;
	}

	public static InputMultiplexer getInputMulti() {
		return InputMulti;
	}

	public static void setInputMulti(InputMultiplexer inputMulti) {
		InputMulti = inputMulti;
	}

	public static boolean isStart() {
		return start;
	}

	public static void setStart(boolean start) {
		Jogo.start = start;
	}

	public static boolean isButtonStart() {
		return buttonStart;
	}

	public static void setButtonStart(boolean buttonStart) {
		Jogo.buttonStart = buttonStart;
	}

	public static JogoListeners getListener() {
		return listener;
	}

	public static void setListener(JogoListeners listener) {
		Jogo.listener = listener;
	}

	public static int getTorre_selected() {
		return torre_selected;
	}

	public static void setTorre_selected(int torre_selected) {
		Jogo.torre_selected = torre_selected;
	}

	public static boolean isMsgSemDinheiro() {
		return msgSemDinheiro;
	}

	public static void setMsgSemDinheiro(boolean msgSemDinheiro) {
		Jogo.msgSemDinheiro = msgSemDinheiro;
	}

	public static boolean isMsgJogoParado() {
		return msgJogoParado;
	}

	public static void setMsgJogoParado(boolean msgJogoParado) {
		Jogo.msgJogoParado = msgJogoParado;
	}

	public static boolean isJogoAcabou() {
		return jogoAcabou;
	}

	public static void setJogoAcabou(boolean jogoAcabou) {
		Jogo.jogoAcabou = jogoAcabou;
	}

	public static void setInimigos(ArrayList<Inimigo> inimigos) {
		Jogo.inimigos = inimigos;
	}

	
	
	

}