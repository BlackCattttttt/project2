package com.neet.Game.State;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.neet.Game.State.GameStateManager;
import com.neet.Game.Manager.KeyHandle;
import com.neet.Game.Manager.Sound;
import com.neet.Game.Manager.Sprite;

public class MenuState extends GameState {
	
	private BufferedImage bg;
	private BufferedImage diamond;
	
	private int currentOption = 0;
	private String[] options = {
		"PLAY",
		"CONTINUE",
		"CONTROLS",
		"HIGHTSCORE",
		"EXIT"
	};

	public MenuState(GameStateManager gsm) {
		super(gsm);
		init();
	}

	@Override
	public void init() {
		bg = Sprite.menubg[0][0];
		diamond = Sprite.diamond[0][0];
	}

	@Override
	public void update() {
		
	}

	@Override
	public void render(Graphics2D g) {
        g.drawImage(bg, 0, 0, null);
		Sprite.bigDrawString(g, "MONSTER", 25, 20);
		Sprite.bigDrawString(g, "HUNTERS", 25, 50);
		Sprite.drawString(g, options[0], 100, 150);
		Sprite.drawString(g, options[1], 72, 170);
		Sprite.drawString(g, options[2], 72, 190);
		Sprite.drawString(g, options[3], 60, 210);
		Sprite.drawString(g, options[4], 100, 230);
		
		if(currentOption == 0) g.drawImage(diamond, 55, 150, null);
		else if(currentOption == 1) g.drawImage(diamond, 55, 170, null);
		else if(currentOption == 2) g.drawImage(diamond, 55, 190, null);
		else if(currentOption == 3) g.drawImage(diamond, 40, 210, null);
		else if(currentOption == 4) g.drawImage(diamond, 55, 230, null);
	}

	@Override
	public void input() {
		if(KeyHandle.isPressed(KeyHandle.DOWN) && currentOption < options.length - 1) {
			Sound.play("menuoption");
			currentOption++;
		}
		if(KeyHandle.isPressed(KeyHandle.UP) && currentOption > 0) {
			Sound.play("menuoption");
			currentOption--;
		}
		if(KeyHandle.isPressed(KeyHandle.ENTER)) {
			selectOption();
		}
	}
	private void selectOption() {
		if(currentOption == 0) {
			gsm.addAndpop(GameStateManager.PLAY);
		}
		if(currentOption == 1) {
			gsm.addAndpop(GameStateManager.LOADGAME);
		}
		if(currentOption == 2) {
			gsm.addAndpop(GameStateManager.CONTROLS);
		}
		if(currentOption == 3) {
			gsm.addAndpop(GameStateManager.HIGHTSCORE);
		}
		if(currentOption == 4) {
			System.exit(0);
		}
	}
}
