package com.neet.Game.Entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.neet.Game.Manager.Sprite;
import com.neet.Game.TileMap.TileMap;

public class Chest extends Entity{
	
	private BufferedImage sprite;
	private int type;
	
	public static final int OPEN = 0;
	public static final int CLOSE = 1;
	public Chest(TileMap tm) {
		super(tm);
		width = height = 32;
		cwidth = cheight = 30;
		setType(CLOSE);
		
	}
	public void setType(int i) {
		type = i;
		if(type == OPEN) {
			sprite = Sprite.chest[0][1];
		}
		else if(type == CLOSE) {
			sprite = Sprite.chest[0][0];
		}
	}
	
	public int getType() {
		return type;
	}
	public void collected(Player p) {
		setType(OPEN);
		p.gotChest();
	}
	@Override
	public void render(Graphics2D g) {
		setMapPosition();
		g.drawImage(sprite, x + xmap - width / 2, y + ymap - height / 2, null);
	}

}
