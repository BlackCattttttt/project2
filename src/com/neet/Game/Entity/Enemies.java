package com.neet.Game.Entity;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.neet.Game.TileMap.TileMap;

public class Enemies {
	public ArrayList<Enemy> enemies;
	
	private int n;
	public Enemies (TileMap tm,String file) {
		enemies = new ArrayList<Enemy>();
		loadEnemy(tm,file);
	}
	public void loadEnemy (TileMap tm,String file) {
		try {
			InputStream in = getClass().getResourceAsStream(file);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			n = Integer.parseInt(br.readLine());
			String delims = "\\s+";
			for (int i=0;i<n;i++) {
				String line = br.readLine();
				String[] tokens = line.split(delims);
				Enemy e = new Enemy(tm, Integer.parseInt(tokens[5]), Integer.parseInt(tokens[4]));
				e.setTilePosition(Integer.parseInt(tokens[0]), 
						Integer.parseInt(tokens[1]),
						Integer.parseInt(tokens[2]), 
						Integer.parseInt(tokens[3]));
				enemies.add(e);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Cannot load map");
		}
	}
}
