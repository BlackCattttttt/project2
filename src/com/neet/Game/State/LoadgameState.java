package com.neet.Game.State;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.neet.Game.Main.GamePanel;
import com.neet.Game.Manager.Game;
import com.neet.Game.Manager.KeyHandle;
import com.neet.Game.Manager.Sound;
import com.neet.Game.Manager.Sprite;

import Database.DataQuery;
import Database.ExportGame;

public class LoadgameState extends GameState{
	
	private BufferedImage diamond;
	
	private Color color;
	private DataQuery data;
	
	private int currentOption = 0;
	
	private ArrayList<Game> games;

	public LoadgameState(GameStateManager gsm) {
		super(gsm);
		init();
	}

	@Override
	public void init() {
		diamond = Sprite.diamond[0][0];
		
		color = new Color(164, 198, 222);
		games = new ArrayList<Game>();
		data = new DataQuery();
    	String [] cols = {"name", "hp","mn","exp","level","atk/def","crit/arp","hat"
    			,"armor","scepter","shoe","item","mission","time","map","row/col"};
    	ResultSet resultSet = data.view("savegame", cols);
    	try {
    		int index=0;
    	    while(resultSet.next() && index<8){
    	    	Game game = new Game(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),
    	    			resultSet.getString(4),resultSet.getInt(5),resultSet.getString(6),resultSet.getString(7),
    	    			resultSet.getString(8),resultSet.getString(9),resultSet.getString(10),resultSet.getString(11),
    	    			resultSet.getString(12),resultSet.getInt(13),resultSet.getInt(14),resultSet.getInt(15),resultSet.getString(16));
    	    	games.add(game);
    	        index++;
    	    }     
    	} catch (SQLException e) {
    	    e.printStackTrace();
    	}
	}

	@Override
	public void update() {
	}

	@Override
	public void render(Graphics2D g) {
		g.setColor(color);
		g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT2);
		
		Sprite.bigDrawString(g, "Loadgame", 10, 32);
		
		for (int i=0;i<games.size();i++) {
			Game game = games.get(i);
			Sprite.drawString(g, (i+1) + ". ", 30, 80 + i*25);
			Sprite.drawString(g, game.getName(), 60, 80 + i*25);
			Sprite.drawString(g,"LV" + game.getLevel(), 150, 80 + i*25);
		}
		if(currentOption == 0) g.drawImage(diamond, 15, 80 + currentOption*25, null);
		else if(currentOption == 1) g.drawImage(diamond, 15, 80 + currentOption*25, null);
		else if(currentOption == 2) g.drawImage(diamond, 15, 80 + currentOption*25, null);
		else if(currentOption == 3) g.drawImage(diamond, 15, 80 + currentOption*25, null);
		else if(currentOption == 4) g.drawImage(diamond, 15, 80 + currentOption*25, null);
		else if(currentOption == 5) g.drawImage(diamond, 15, 80 + currentOption*25, null);
		else if(currentOption == 6) g.drawImage(diamond, 15, 80 + currentOption*25, null);
		else if(currentOption == 7) g.drawImage(diamond, 15, 80 + currentOption*25, null);
		
		Sprite.tiniDrawString(g, "Press J to export to pdf file", 5, 280);
	}

	@Override
	public void input() {
		if (KeyHandle.isPressed(KeyHandle.ESCAPE)) {
			gsm.addAndpop(GameStateManager.MENU);
			Sound.play("collect");
		}
		if(KeyHandle.isPressed(KeyHandle.DOWN) && currentOption < games.size()-1) {
			Sound.play("menuoption");
			currentOption++;
		}
		if(KeyHandle.isPressed(KeyHandle.UP) && currentOption > 0) {
			Sound.play("menuoption");
			currentOption--;
		}
		if(KeyHandle.isPressed(KeyHandle.ENTER)) {
			selectOption();
		}
		if(KeyHandle.isPressed(KeyHandle.ATTACK)) {
			ExportGame app = new ExportGame();
			app.export();
		}
	}
	private void selectOption() {
		gsm.addSavegame(games.get(currentOption));
	}
}
