package com.neet.Game.Entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.neet.Game.Entity.Player;
import com.neet.Game.Manager.Sprite;
import com.neet.Game.TileMap.TileMap;

public class Item extends Entity{

	private BufferedImage sprite;
	private int type;
	private int value;
	public static final int GOLD = 0;
	public static final int POTION = 1;
	public static final int KEY = 2;
	
	public Item(TileMap tm) {
		super(tm);
		type = -1;
		width = height = 16;
		cwidth = cheight = 14;
	}
  
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public void setType(int i) {
		type = i;
		if(type == GOLD) {
			sprite = Sprite.item[0][1];
		}
		else if(type == POTION) {
			sprite = Sprite.item[0][0];
		}
		else if(type == KEY) {
			sprite = Sprite.item[0][2];
		}
	}
	public void collected(Player p) {
		if(type == GOLD) {
			p.gotGold(this);
		}
		if(type == POTION) {
			p.gotPotion(this);
		}
		if(type == KEY) {
			p.gotKey();
		}
	}
	public void populateGold(Enemy e) {		
		setType(Item.GOLD);
		setValue(e.getGold());
		setTilePosition(e.getRow(), e.getCol());
	}
	public void populatePotion(Enemy e) {		
		setType(Item.POTION);
		setValue(1);
		setTilePosition(e.getRow(), e.getCol());
	}
	@Override
	public void render(Graphics2D g) {
		setMapPosition();
		g.drawImage(sprite, x + xmap - width / 2, y + ymap - height / 2, null);
	}

}
