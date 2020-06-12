package com.neet.Game.State;

import java.awt.Graphics2D;

import com.neet.Game.Entity.Player;
import com.neet.Game.Manager.Game;
import com.neet.Game.Manager.KeyHandle;
import com.neet.Game.Manager.Sound;
import com.neet.Game.Manager.Sprite;

import Database.SaveGame;

public class PauseState extends GameState {
	
	private Player player;
	private Game game;

	public PauseState(GameStateManager gsm) {
		super(gsm);
	}

	@Override
	public void init() {
	}

	public void init(Player p) {
		this.player = p;
	}
	public void init(Game g) {
		this.game = g;
	}
	@Override
	public void update() {
	}

	@Override
	public void render(Graphics2D g) {
        Sprite.drawString(g, "paused", 80, 60);
		
        Sprite.drawString(g, "arrow", 24, 142);
        Sprite.drawString(g, "keys", 32, 158);
        Sprite.drawString(g, ": move", 104, 150);
		
        Sprite.drawString(g, "enter", 24, 182);
        Sprite.drawString(g, ": save game", 104, 182);
		
		Sprite.drawString(g, "F1:", 75, 214);
		Sprite.drawString(g, "return", 136, 206);
		Sprite.drawString(g, "to menu", 136, 222);
	}

	@Override
	public void input() {
		if(KeyHandle.isPressed(KeyHandle.ESCAPE)) {
			gsm.setPaused(false);
			Sound.resumeLoop("music1");
		}
		if(KeyHandle.isPressed(KeyHandle.F1)) {
			gsm.setPaused(false);
			gsm.addAndpop(GameStateManager.MENU);
		}
		if (KeyHandle.isPressed(KeyHandle.ENTER)) {
			if (game==null) {
				SaveGame sg = new SaveGame();
				sg.save(player, SaveGame.NEW,game);
			} else {
				SaveGame sg = new SaveGame();
				sg.save(player, SaveGame.LOAD,game);
			}		
		}
	}

}
