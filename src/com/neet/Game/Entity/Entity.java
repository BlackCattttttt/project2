package com.neet.Game.Entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.neet.Game.TileMap.Tile;
import com.neet.Game.TileMap.TileMap;

public abstract class Entity {
	
	protected int width;
	protected int height;
	protected int cwidth;
	protected int cheight;
	
	protected int x;
	protected int y;
	protected int xdest;
	protected int ydest;
	protected int rowTile;
	protected int colTile;
	
	protected boolean moving;
	protected boolean left;
	protected boolean right;
	protected boolean up;
	protected boolean down;
	
	protected int moveSpeed;
	
	protected TileMap tileMap;
	protected int tileSize;
	protected int xmap;
	protected int ymap;
	
	protected Animation animation;
	protected int currentAnimation;
	
	public Entity( TileMap tm) {
		tileMap = tm;
		tileSize = tileMap.getTileSize();
		animation = new Animation();
	}
	public int getx() {
		return x; 
	}
	public int gety() {
		return y; 
	}
	public int getRow() {
		return rowTile; 
	}
	public int getCol() {
		return colTile; 
	}
	public void setAnimation(int i,BufferedImage[] frames,int delay) {
		currentAnimation = i;
		animation.setFrames(frames);
		animation.setDelay(delay);
	}
	public void setPosition(int i1, int i2) {
		x = i1;
		y = i2;
		xdest = x;
		ydest = y;
	}
	public void setMapPosition() {
		xmap = tileMap.getx();
		ymap = tileMap.gety();
	}
	public void setTilePosition(int i1, int i2) {
		y = i1 * tileSize + tileSize / 2;
		x = i2 * tileSize + tileSize / 2;
		xdest = x;
		ydest = y;
	}
	public boolean intersects (Entity o) {
		return getRectangle().intersects(o.getRectangle());
	}
	public Rectangle getRectangle() {
		return new Rectangle(x,y,cwidth,cheight);
	}
    public boolean validateNextPosition() {		
		if(moving) return true;		
		rowTile = y / tileSize;
		colTile = x / tileSize;		
		if(left) {
			if(colTile == 0 || tileMap.getType(rowTile, colTile - 1) == Tile.BLOCKED) {
				return false;
			}
			else {
				xdest = x - tileSize;
			}
		} else
		if(right) {
			if(colTile == tileMap.getNumCols() || tileMap.getType(rowTile, colTile + 1) == Tile.BLOCKED) {
				return false;
			}
			else {
				xdest = x + tileSize;
			}
		} else
		if(up) {
			if(rowTile == 0 || tileMap.getType(rowTile - 1, colTile) == Tile.BLOCKED) {
				return false;
			}
			else {
				ydest = y - tileSize;
			}
		} else
		if(down) {
			if(rowTile == tileMap.getNumRows() - 1 || tileMap.getType(rowTile + 1, colTile) == Tile.BLOCKED) {
				return false;
			}
			else {
				ydest = y + tileSize;
			}
		}		
		return true;		
	}
	public void getNextPosition() {		
		if(left && x > xdest) x -= moveSpeed;
		else left = false;
		if(left && x < xdest) x = xdest;		
		if(right && x < xdest) x += moveSpeed;
		else right = false;
		if(right && x > xdest) x = xdest;		
		if(up && y > ydest) y -= moveSpeed;
		else up = false;
		if(up && y < ydest) y = ydest;		
		if(down && y < ydest) y += moveSpeed;
		else down = false;
		if(down && y > ydest) y = ydest;		
	}
	public void update () {
		if (moving) getNextPosition();
		if(x == xdest && y == ydest) {
			left = right = up = down = moving = false;
			rowTile = y / tileSize;
			colTile = x / tileSize;
		}
		animation.update();
	}
	public abstract void render (Graphics2D g);
}
