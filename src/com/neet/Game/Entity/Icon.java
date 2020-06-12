package com.neet.Game.Entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.neet.Game.Manager.Sprite;
import com.neet.Game.TileMap.TileMap;

public class Icon extends Entity{

	private BufferedImage sprite;
	private int type;
	public static final int FEATHER = 0;
	public static final int SNOWFLAKES = 1;
	public static final int FIRE = 2;
	
	public Icon(TileMap tm) {
		super(tm);
		type = -1;
		width = height = 16;
		cwidth = cheight = 14;
	}
	public void setType(int i) {
		type = i;
		if(type == FEATHER) {
			sprite = Sprite.icon[0][2];
		}
		else if(type == SNOWFLAKES) {
			sprite = Sprite.icon[0][0];
		}
		else if(type == FIRE) {
			sprite = Sprite.icon[0][4];
		}
	}
	public void collected(Player p) {
		p.gotIcon();
	}
	@Override
	public void render(Graphics2D g) {
		setMapPosition();
		g.drawImage(sprite, x + xmap - width / 2, y + ymap - height / 2, null);
	}

}
