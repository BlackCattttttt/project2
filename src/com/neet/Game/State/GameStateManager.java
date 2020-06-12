package com.neet.Game.State;

import java.awt.Graphics2D;
import java.util.ArrayList;

import com.neet.Game.Manager.Game;
import com.neet.Game.Manager.Sound;
import com.neet.Game.State.PauseState;


public class GameStateManager {
	 private boolean paused;
	 private boolean pause;
	 public static PauseState pauseState;
     private ArrayList<GameState> states;
     
     public static final int INTRO = 0;
     public static final int CONTROLS = 1;
     public static final int PLAY = 2;
     public static final int MENU = 3;
     public static final int PAUSE = 4;
     public static final int GAMEOVER = 5;
     public static final int GAMEWIN = 6;
     public static final int HIGHTSCORE = 7;
     public static final int LOADGAME = 8;
     public static final int PLAYSAVE = 9;
     
     
     public GameStateManager () {
    	 
    	 Sound.init();
    	 
    	 states = new ArrayList<GameState>();
    	 paused = false;
    	 pause = false;
 		 pauseState = new PauseState(this);
    	 add(INTRO);
     }
     public void add (int state) {
    	 if (state == INTRO) {
    		 states.add(new IntroState(this));
    	 }
    	 if (state == CONTROLS) {
    		 states.add(new ControlsState(this));
    	 }
    	 if (state == PLAY) {
    		 states.add(new PlayState(this));
    	 } 
    	 else if (state == MENU) {
    		 states.add(new MenuState(this));
    	 }
    	 else if (state == PAUSE) {
    		 states.add(new PauseState(this));
    	 }
    	 else if (state == GAMEOVER) {
    		 states.add(new GameoverState(this));
    	 }
    	 else if (state == GAMEWIN) {
    		 states.add(new GamewinState(this));
    	 }
    	 else if (state == HIGHTSCORE) {
    		 states.add(new HightscoreState(this));
    	 }
    	 else if (state == LOADGAME) {
    		 states.add(new LoadgameState(this));
    	 }
     }
     public void addSavegame (Game game) {
    	 states.remove(0);
    	 states.add(new PlaysaveState(this, game));
     }
     public void addAndpop (int state) {
    	 states.remove(0);
    	 add(state);
     }
     public void setPaused(boolean b) {
 		paused = b;
 	 }
     public void setPause(boolean b) {
  		pause = b;
  	 }
     public void update () {
    	 if (!pause) {
    		 if(paused) {
    	 		pauseState.update();
    	 		 } else {
    	 			for (int i=0;i<states.size();i++) {
    	 	    		 states.get(i).update();
    	 	    	 }
    	 		 }    
    	 }	 	 
     }
     public void render (Graphics2D g) {
    	 if (!pause) {
    		 if(paused) {
    			pauseState.render(g);
    			} else {
    			     for (int i=0;i<states.size();i++) {
    		    		 states.get(i).render(g);
    		    	 }
    			 }  	 
    	 }  
     }
     public void input () {
    	 if(paused) {
	 		pauseState.input();
	 		 } else {
	 			for (int i=0;i<states.size();i++) {
	 	    		 states.get(i).input();
	 	    	 }
	 		 }	 	 
     }
}
