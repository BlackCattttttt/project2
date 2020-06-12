package com.neet.Game.Entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.neet.Game.Manager.Sprite;
import com.neet.Game.TileMap.Tile;
import com.neet.Game.TileMap.TileMap;

public class BulletE extends Entity{
	
	private BufferedImage[] downSprites;
	private BufferedImage[] leftSprites;
	private BufferedImage[] rightSprites;
	private BufferedImage[] upSprites;
	private boolean live;
	
	private final int DOWN = 0;
	private final int RIGHT = 1;
	private final int LEFT = 2;
	private final int UP = 3;

	public BulletE(TileMap tm,Enemy e) {
		super(tm);
		moveSpeed = 2;
		live = true;
		width = height = 16;
		cwidth = cheight = 14;
		
		upSprites = Sprite.bulletE[3];
		rightSprites = Sprite.bulletE[2];
		leftSprites = Sprite.bulletE[1];
		downSprites = Sprite.bulletE[0];
		setTilePosition(e.rowTile, e.colTile);
		if (e.currentAnimation == UP) {
			up = true;
			down = left = right = false;
			setAnimation(UP, upSprites, 10);
		} else if (e.currentAnimation == DOWN) {
			down = true;
			up = left = right = false;
			setAnimation(DOWN, downSprites, 10);
		} else if (e.currentAnimation == LEFT) {
			left = true;
			up = down = right = false;
			setAnimation(LEFT, leftSprites, 10);
		} else if (e.currentAnimation == RIGHT) {
			right = true;
			up = left = down = false;
			setAnimation(RIGHT, rightSprites, 10);
		}		
	}
	public boolean isLive() {
		return live;
	}
	public void setLive(boolean live) {
		this.live = live;
	}
 	public boolean validateNextPosition() {
		rowTile = y / tileSize;
		colTile = x / tileSize;
		if(left) {
			if(colTile == 0 || tileMap.getType(rowTile, colTile) == Tile.BLOCKED) {
				return false;
			}
			else {
				xdest = x - tileSize;
			}
		} 
		if(right) {
			if(colTile == tileMap.getNumCols() || tileMap.getType(rowTile, colTile) == Tile.BLOCKED) {
				return false;
			}
			else {
				xdest = x + tileSize;
			}
		}
		if(up) {
			if(rowTile == 0 || tileMap.getType(rowTile, colTile) == Tile.BLOCKED) {
				return false;
			}
			else {
				ydest = y - tileSize;
			}
		}
		if(down) {
			if(rowTile == tileMap.getNumRows() - 1 || tileMap.getType(rowTile, colTile) == Tile.BLOCKED) {
				return false;
			}
			else {
				ydest = y + tileSize;
			}
		}	
		return true;
	}
	public void move () {
		if (up && currentAnimation!=UP) {
			setAnimation(UP, upSprites, 10);
		}
		if (down && currentAnimation!=DOWN) {
			setAnimation(DOWN, downSprites, 10);
		}
		if (left && currentAnimation!=LEFT) {
			setAnimation(LEFT, leftSprites, 10);
		}
		if (right && currentAnimation!=RIGHT) {
			setAnimation(RIGHT, rightSprites, 10);
		}
	}
	public void update () {
		move();
		if(left && x > xdest) x -= moveSpeed;
		if(left && x < xdest) x = xdest;		
		if(right && x < xdest) x += moveSpeed;
		if(right && x > xdest) x = xdest;		
		if(up && y > ydest) y -= moveSpeed;
		if(up && y < ydest) y = ydest;		
		if(down && y < ydest) y += moveSpeed;
		if(down && y > ydest) y = ydest;
		if (!validateNextPosition()) live = false;
		animation.update();
	}
	@Override
	public void render(Graphics2D g) {
		setMapPosition();
		g.drawImage(animation.getImage(), x + xmap - width / 2, y + ymap - height / 2, null);
	}

}
