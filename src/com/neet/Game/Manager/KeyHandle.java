package com.neet.Game.Manager;

import java.awt.event.KeyEvent;

public class KeyHandle{
public static final int NUM_KEYS = 14;
	
	public static boolean keyState[] = new boolean[NUM_KEYS];
	public static boolean prevKeyState[] = new boolean[NUM_KEYS];
	
	public static int UP = 0;
	public static int LEFT = 1;
	public static int DOWN = 2;
	public static int RIGHT = 3;
	public static int ATTACK = 4;
	public static int SKILL = 5;
	public static int INFOR = 6;
	public static int SHOP = 7;
	public static int MISSON = 8;
	public static int HEAL = 9;
	public static int ENTER = 10;
	public static int PAUSE = 11;
	public static int ESCAPE = 12;
	public static int F1 = 13;
	
	public static void keySet(int i, boolean b) {
		if(i == KeyEvent.VK_UP) keyState[UP] = b;
		else if(i == KeyEvent.VK_LEFT) keyState[LEFT] = b;
		else if(i == KeyEvent.VK_DOWN) keyState[DOWN] = b;
		else if(i == KeyEvent.VK_RIGHT) keyState[RIGHT] = b;
		else if(i == KeyEvent.VK_J) keyState[ATTACK] = b;
		else if(i == KeyEvent.VK_K) keyState[SKILL] = b;
		else if(i == KeyEvent.VK_I) keyState[INFOR] = b;
		else if(i == KeyEvent.VK_L) keyState[HEAL] = b;
		else if(i == KeyEvent.VK_O) keyState[SHOP] = b;
		else if(i == KeyEvent.VK_U) keyState[MISSON] = b;
		else if(i == KeyEvent.VK_ENTER) keyState[ENTER] = b;
		else if(i == KeyEvent.VK_P) keyState[PAUSE] = b;
		else if(i == KeyEvent.VK_ESCAPE) keyState[ESCAPE] = b;
		else if(i == KeyEvent.VK_F1) keyState[F1] = b;
	}
	
	public static void update() {
		for(int i = 0; i < NUM_KEYS; i++) {
			prevKeyState[i] = keyState[i];
		}
	}
	
	public static boolean isPressed(int i) {
		return keyState[i] && !prevKeyState[i];
	}
	
	public static boolean isDown(int i) {
		return keyState[i];
	}
	
	public static boolean anyKeyDown() {
		for(int i = 0; i < NUM_KEYS; i++) {
			if(keyState[i]) return true;
		}
		return false;
	}
	
	public static boolean anyKeyPress() {
		for(int i = 0; i < NUM_KEYS; i++) {
			if(keyState[i] && !prevKeyState[i]) return true;
		}
		return false;
	}

}
