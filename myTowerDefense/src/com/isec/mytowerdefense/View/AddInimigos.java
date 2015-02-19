package com.isec.mytowerdefense.View;

import com.badlogic.gdx.math.Vector2;
import com.isec.mytowerdefense.Inimigos.Inimigo_1;
import com.isec.mytowerdefense.Inimigos.Inimigo_2;
import com.isec.mytowerdefense.Inimigos.Inimigo_3;
import com.isec.mytowerdefense.Inimigos.Inimigo_4;
import com.isec.mytowerdefense.Inimigos.Inimigo_5;
import com.isec.mytowerdefense.Inimigos.Inimigo_6;
import com.isec.mytowerdefense.Inimigos.Inimigo_7;

public class AddInimigos{
	
	protected Jogo jogo;
	public static int numInimigosLvl;
	public static int nivel;
	public static int numInimigosKilledLvl;
	public static int up;
	
	
	AddInimigos(Jogo jogo, int nivel)
	{
		this.jogo = jogo;
		AddInimigos.nivel = nivel;
		up=-50; //posicao inicial (implementacao possivel...)
		numInimigosKilledLvl=0;
		numInimigosLvl=0;
		
	}
	
	public void cria()           
	{        
		
			          
				
		switch(nivel)
		{
		case 1:
			
			Jogo.getInimigos().clear();			
			numInimigosLvl=10;		

			for(int i=0 ; i < numInimigosLvl ; i++){  	
				Jogo.getInimigos().add(new Inimigo_1(new Vector2(140,-50-up), 32, 32, 0));	
				up-=-50;  }				
		
		break;
		
		case 2:
			
			Jogo.getInimigos().clear();			
			numInimigosLvl=20;		

			for(int i=0 ; i < numInimigosLvl ; i++){  	
				Jogo.getInimigos().add(new Inimigo_2(new Vector2(140,-50-up), 32, 32, 0));	
				up-=-50;  }	
			
		break;	
		
		case 3:
			
			Jogo.getInimigos().clear();			
			numInimigosLvl=25;		

			for(int i=0 ; i < numInimigosLvl ; i++){  	
				Jogo.getInimigos().add(new Inimigo_3(new Vector2(140,-50-up), 32, 32, 0));	
				up-=-50;  }	
			
		break;	
		
		case 4:
			
			Jogo.getInimigos().clear();			
			numInimigosLvl=20;		

			for(int i=0 ; i < numInimigosLvl ; i++){  	
				Jogo.getInimigos().add(new Inimigo_4(new Vector2(140,-50-up), 32, 32, 0));	
				up-=-50;  }	
			
		break;	
		
		case 5:
		
		Jogo.getInimigos().clear();			
		numInimigosLvl=25;		

		for(int i=0 ; i < numInimigosLvl ; i++){  	
			Jogo.getInimigos().add(new Inimigo_5(new Vector2(140,-50-up), 32, 32, 0));	
			up-=-50;  }	
		
		break;	
	
	
		case 6:
		
		Jogo.getInimigos().clear();			
		numInimigosLvl=30;		

		for(int i=0 ; i < numInimigosLvl ; i++){  	
			Jogo.getInimigos().add(new Inimigo_6(new Vector2(140,-50-up), 32, 32, 0));	
			up-=-50;  }	
		
		break;	
	
	
		case 7:
		
		Jogo.getInimigos().clear();			
		numInimigosLvl=35;		

		for(int i=0 ; i < numInimigosLvl ; i++){  	
			Jogo.getInimigos().add(new Inimigo_7(new Vector2(140,-50-up), 32, 32, 0));	
			up-=-50;  }	
		
	break;	
		
		
		}
	}

	public Jogo getJogo() {
		return jogo;
	}

	public void setJogo(Jogo jogo) {
		this.jogo = jogo;
	}

	public static int getNumInimigosLvl() {
		return numInimigosLvl;
	}

	public static void setNumInimigosLvl(int numInimigosLvl) {
		AddInimigos.numInimigosLvl = numInimigosLvl;
	}

	public static int getNivel() {
		return nivel;
	}

	public static void setNivel(int nivel) {
		AddInimigos.nivel = nivel;
	}

	public static int getNumInimigosKilledLvl() {
		return numInimigosKilledLvl;
	}

	public static void setNumInimigosKilledLvl(int numInimigosKilledLvl) {
		AddInimigos.numInimigosKilledLvl = numInimigosKilledLvl;
	}

	public static int getUp() {
		return up;
	}

	public static void setUp(int up) {
		AddInimigos.up = up;
	}

	

	

}
