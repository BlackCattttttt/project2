package com.neet.Game.State;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.neet.Game.Manager.KeyHandle;
import com.neet.Game.Manager.Sprite;

public class GameoverState extends GameState {

	private BufferedImage bg;
	
	public GameoverState(GameStateManager gsm) {
		super(gsm);
		init();
	}

	@Override
	public void init() {
		bg = Sprite.menubg[0][0];
	}

	@Override
	public void update() {
	}

	@Override
	public void render(Graphics2D g) {
		g.drawImage(bg,0,0,null);
		Sprite.bigDrawString(g, "GAMEOVER", 10, 20);
		Sprite.drawString(g, "Press F1", 70,120);
		Sprite.drawString(g, "to return menu", 30, 140);
	}

	@Override
	public void input() {
		if (KeyHandle.isPressed(KeyHandle.F1)) {
			gsm.addAndpop(GameStateManager.MENU);
		}
	}

}
