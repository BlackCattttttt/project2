package com.neet.Game.Entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.neet.Game.Manager.Sprite;
import com.neet.Game.TileMap.TileMap;

public class Equip extends Entity{
	
	private BufferedImage sprite;
	private int type;
	private int quanlity;
	public static final int HAT = 0;
	public static final int ARMOR = 1;
	public static final int SCEPTER = 2;
	public static final int SHOE = 3;

	public Equip (TileMap tm) {
		super(tm);
		type = -1;
		quanlity = -1;
		width = height = 16;
		cwidth = cheight = 14;
	}
	public int getType () {
		return type;
	}
	public void setType(int i,int j) {
		type = i;
		quanlity = j;
		if(type == HAT) {
			sprite = Sprite.equip[0][j];
		}
		else if(type == ARMOR) {
			sprite = Sprite.equip[1][j];
		}
		else if(type == SCEPTER) {
			sprite = Sprite.equip[2][j];
		}
		else if(type == SHOE) {
			sprite = Sprite.equip[3][j];
		}
	}
	public int getQuanlity () {
		return quanlity;
	}
	public void collected(Player p) {
		p.gotEquip(this);
	}
	@Override
	public void render(Graphics2D g) {
		setMapPosition();
		g.drawImage(sprite, x + xmap - width / 2, y + ymap - height / 2, null);
	}

}
