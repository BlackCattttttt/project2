package com.neet.Game.Entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.neet.Game.Manager.Sprite;
import com.neet.Game.TileMap.Tile;
import com.neet.Game.TileMap.TileMap;

public class Bullet extends Entity{
	
	private int xm;
	private int ym;
	
	private BufferedImage[] downSprites;
	private BufferedImage[] leftSprites;
	private BufferedImage[] rightSprites;
	private BufferedImage[] upSprites;
	private int range;
	private boolean live;
	private int type;
	public static final int NORMAL = 0;
	public static final int SKILL = 1;
	
	private final int DOWN = 0;
	private final int LEFT = 1;
	private final int RIGHT = 2;
	private final int UP = 3;

	public Bullet(TileMap tm,Player p,int i) {
		super(tm);
		moveSpeed = 2;
		live = true;
		setType(i);
		setTilePosition(p.rowTile, p.colTile);
		if (p.currentAnimation == UP) {
			up = true;
			down = left = right = false;
			ym = y - range*tileSize;
			setAnimation(UP, upSprites, 10);
		} else if (p.currentAnimation == DOWN) {
			down = true;
			up = left = right = false;
			ym = y + range*tileSize;
			setAnimation(DOWN, downSprites, 10);
		} else if (p.currentAnimation == LEFT) {
			left = true;
			up = down = right = false;
			xm = x - range*tileSize;
			setAnimation(LEFT, leftSprites, 10);
		} else if (p.currentAnimation == RIGHT) {
			right = true;
			up = left = down = false;
			xm = x + range*tileSize;
			setAnimation(RIGHT, rightSprites, 10);
		}
	}
	public boolean isLive() {
		return live;
	}
	public void setLive(boolean live) {
		this.live = live;
	}
	public int getType () {
		return type;
	}
	public void setType(int i) {
		type = i;
		if(type == NORMAL) {
			upSprites = Sprite.bullet[0];
			rightSprites = Sprite.bullet[2];
			leftSprites = Sprite.bullet[1];
			downSprites = Sprite.bullet[3];
			width = height = 16;
			cwidth = cheight = 14;
			range = 3;
		}
		else if(type == SKILL) {
			upSprites = Sprite.skill[0];
			rightSprites = Sprite.skill[0];
			leftSprites = Sprite.skill[0];
			downSprites = Sprite.skill[0];
			width = height = 24;
			cwidth = cheight = 22;
			range = 5;
		}
	}
	public boolean validateNextPosition() {
		rowTile = y / tileSize;
		colTile = x / tileSize;
		if(left) {
			if(colTile == 0 || tileMap.getType(rowTile, colTile) == Tile.BLOCKED || x < xm) {
				return false;
			}
			else {
				xdest = x - tileSize;
			}
		} 
		if(right) {
			if(colTile == tileMap.getNumCols() || tileMap.getType(rowTile, colTile) == Tile.BLOCKED || x > xm) {
				return false;
			}
			else {
				xdest = x + tileSize;
			}
		}
		if(up) {
			if(rowTile == 0 || tileMap.getType(rowTile, colTile) == Tile.BLOCKED || y < ym) {
				return false;
			}
			else {
				ydest = y - tileSize;
			}
		}
		if(down) {
			if(rowTile == tileMap.getNumRows() - 1 || tileMap.getType(rowTile, colTile) == Tile.BLOCKED || y > ym) {
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
