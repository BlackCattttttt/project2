package com.neet.Game.TileMap;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import com.neet.Game.Main.GamePanel;
import com.neet.Game.TileMap.Tile;

public class TileMap {
	private int x;
	private int y;
	private int xdest;
	private int ydest;
	private int speed;
	
	private int xmin;
	private int ymin;
	private int xmax;
	private int ymax;
	
	private int[][] map;
	private int tileSize;
	private int numRows;
	private int numCols;
	private int width;
	private int height;
	
	private BufferedImage tileset;
	private int numTilesAcross;
	private Tile[][] tiles;
	
	private int rowOffset;
	private int colOffset;
	private int numRowsToDraw;
	private int numColsToDraw;
	
	public TileMap (int tileSize) {
		this.tileSize = tileSize;
		numRowsToDraw = GamePanel.HEIGHT/tileSize +2;
		numColsToDraw = GamePanel.WIDTH/tileSize + 2;
		speed = 8;
		
	}
	public void loadTiles (String s) {
		try {
			tileset = ImageIO.read(getClass().getResourceAsStream(s));
			numTilesAcross = tileset.getWidth()/tileSize;
			tiles = new Tile[2][numTilesAcross];
			BufferedImage subimage;
			for (int i=0;i<numTilesAcross;i++) {
				subimage = tileset.getSubimage(i * tileSize, 0, tileSize, tileSize);
				tiles[0][i] = new Tile(subimage,Tile.NORMAL);
				subimage = tileset.getSubimage(i * tileSize, tileSize, tileSize, tileSize);
				tiles[1][i] = new Tile(subimage,Tile.BLOCKED);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Cannot load map");
		}
	}
	public void loadMap (String s) {
		try {
			InputStream in = getClass().getResourceAsStream(s);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			numCols = Integer.parseInt(br.readLine());
			numRows = Integer.parseInt(br.readLine());
			map = new int[numRows][numCols];
			width = numCols * tileSize;
			height = numRows * tileSize;			
			xmin = -width;
			xmax = 0;
			ymin = -height;
			ymax = 0;
			String delims = "\\s+";
			for (int i=0;i<numRows;i++) {
				String line = br.readLine();
				String[] tokens = line.split(delims);
				for (int j=0;j<numCols;j++) {
					map[i][j]=Integer.parseInt(tokens[j]);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Cannot load map");
		}
	}
	public int getTileSize() { 
		return tileSize; 
	}
	public int getx() {
		return x; 
	}
	public int gety() {
		return y; 
	}
	public int getWidth() { 
		return width; 
	}
	public int getHeight() { 
		return height; 
	}
	public int getNumRows() {
		return numRows; 
	}
	public int getNumCols() {
		return numCols; 
	}
	public int getType(int row, int col) {
		int rc = map[row][col];
		int r = rc / numTilesAcross;
		int c = rc % numTilesAcross;
		return tiles[r][c].getType();
	}
	public int getIndex(int row, int col) {
		return map[row][col];
	}
	public void setPosition(int x, int y) {
		xdest = x;
		ydest = y;
	}
	public void setPositionImmediately(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public void fixBounds() {
		if(x < xmin) x = xmin;
		if(y < ymin) y = ymin;
		if(x > xmax) x = xmax;
		if(y > ymax) y = ymax;
	}
	public void setTile(int row, int col, int index) {
		map[row][col] = index;
	}
	public void replace(int i1, int i2) {
		for(int row = 0; row < numRows; row++) {
			for(int col = 0; col < numCols; col++) {
				if(map[row][col] == i1) map[row][col] = i2;
			}
		}
	}
	public void update() {
		if(x < xdest) {
			x += speed;
			if(x > xdest) {
				x = xdest;
			}
		}
		if(x > xdest) {
			x -= speed;
			if(x < xdest) {
				x = xdest;
			}
		}
		if(y < ydest) {
			y += speed;
			if(y > ydest) {
				y = ydest;
			}
		}
		if(y > ydest) {
			y -= speed;
			if(y < ydest) {
				y = ydest;
			}
		}		
		fixBounds();		
		colOffset = -this.x / tileSize;
		rowOffset = -this.y / tileSize;
	}
	public void render (Graphics2D g) {
		for (int i=rowOffset;i<rowOffset+numRowsToDraw;i++) {
			if (i>=numRows) break;
			for (int j=colOffset;j<colOffset+numColsToDraw;j++) {
				if (j>=numCols) break;
				if (map[i][j]==0) continue;
				int rc = map[i][j];
				int r = rc/numTilesAcross;
				int c = rc%numTilesAcross;
				g.drawImage(tiles[r][c].getImg(),x+j*tileSize,y+i*tileSize , null);
			}
		}
	}
}
