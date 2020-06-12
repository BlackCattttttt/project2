package com.neet.Game.State;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.neet.Game.Manager.KeyHandle;
import com.neet.Game.Manager.Sprite;

public class ControlsState extends GameState{

	private BufferedImage bg;
	private BufferedImage controls;
	
	public ControlsState(GameStateManager gsm) {
		super(gsm);
		init();
	}

	@Override
	public void init() {
		bg = Sprite.menubg[0][0];
		controls = Sprite.controls[0][0];
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics2D g) {
		g.drawImage(bg, 0, 0, null);
		g.drawImage(controls, 0, 0,null);
	}

	@Override
	public void input() {
		if (KeyHandle.isPressed(KeyHandle.ESCAPE)) {
			gsm.addAndpop(GameStateManager.MENU);
		}
	}

}
