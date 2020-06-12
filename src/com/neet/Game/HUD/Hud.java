package com.neet.Game.HUD;

import java.awt.Color;
import java.awt.Graphics2D;

import com.neet.Game.Manager.Sprite;
import com.neet.Game.Entity.Player;

public class Hud {
	
	private Player player;
	private Color textColor;
	
	public Hud (Player p) {
		player = p;
		
		textColor = new Color(100, 39, 16);
	}
	public void render (Graphics2D g) {
		
		g.setColor(textColor);
		g.fillRect(0, 256, 256, 32);
		g.setColor(Color.WHITE);
		Sprite.tiniDrawString(g, "HP",5,260);
		g.setColor(Color.RED);
		g.fillRect(25, 263, 150*player.getHp()/player.getMaxhp(), 3);
		Sprite.tiniDrawString(g, "MP",5,270);
		g.setColor(Color.BLUE);
		g.fillRect(25, 273, 150*player.getMn()/player.getMaxmn(), 3);
		Sprite.tiniDrawString(g, "LV"+player.getLv(),1,280);
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(25, 283, 150*player.getExp()/player.getMaxexp(), 3);
		g.drawImage(Sprite.item[0][0], 180, 265, null);
		Sprite.tiniDrawString(g, " "+player.getBinhmau(), 188, 270);
		g.drawImage(Sprite.item[0][1], 210, 265, null);
		Sprite.tiniDrawString(g, " "+player.getGold(), 218, 270);
		
		int minutes = (int) (player.getTicks() / 1800);
		int seconds = (int) ((player.getTicks() / 30) % 60);
		if(minutes < 10) {
			if(seconds < 10) Sprite.drawString(g, "0" + minutes + ":0" + seconds, 170, 6);
			else Sprite.drawString(g, "0" + minutes + ":" + seconds, 170, 6);
		}
		else {
			if(seconds < 10) Sprite.drawString(g, minutes + ":0" + seconds, 170, 6);
			else Sprite.drawString(g, minutes + ":" + seconds, 170, 6);
		}
	}
}
