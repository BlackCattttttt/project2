package com.neet.Game.State;

import java.awt.Color;
import java.awt.Graphics2D;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.neet.Game.Main.GamePanel;
import com.neet.Game.Manager.HightScore;
import com.neet.Game.Manager.KeyHandle;
import com.neet.Game.Manager.Sound;
import com.neet.Game.Manager.Sprite;

import Database.DataQuery;
import Database.ExportHightScore;

public class HightscoreState extends GameState{

	private Color color;
	private DataQuery data;
	
	public ArrayList<HightScore> hs;
	
	public HightscoreState(GameStateManager gsm) {
		super(gsm);
		init();
	}

	@Override
	public void init() {
		color = new Color(164, 198, 222);
		hs = new ArrayList<HightScore>();
		data = new DataQuery();
    	String [] cols = {"name", "time"};
    	ResultSet resultSet = data.view("highscore", cols);
    	try {
    		int index=0;
    	    while(resultSet.next() && index<5){
    	    	HightScore temp = new HightScore(resultSet.getInt(2), resultSet.getString(1));
    	    	hs.add(temp);
    	        index++;
    	    }     
    	} catch (SQLException e) {
    	    e.printStackTrace();
    	}
	}

	@Override
	public void update() {}

	@Override
	public void render(Graphics2D g) {
		g.setColor(color);
		g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT2);
		
		Sprite.drawString(g, "HIGHT SCORE", 40, 72);
		
		for (int i=0;i<hs.size();i++) {
			HightScore hightscore = hs.get(i);
			Sprite.drawString(g, (i+1) + ". ", 30, 120 + i*25);
			Sprite.drawString(g, hightscore.getName(), 60, 120 + i*25);
			drawTime(g, hightscore.getTime(), 150, 120 + i*25);
		}
		Sprite.tiniDrawString(g, "Press J to export tofile pdf", 5, 250);
	}

	@Override
	public void input() {
		if (KeyHandle.isPressed(KeyHandle.ESCAPE)) {
			gsm.addAndpop(GameStateManager.MENU);
			Sound.play("collect");
		}
		if (KeyHandle.isPressed(KeyHandle.ATTACK)) {
			ExportHightScore app = new ExportHightScore();
			app.export();
		}
	}

	public void drawTime (Graphics2D g,int ticks,int i,int j) {
		int minutes = (int) (ticks / 1800);
		int seconds = (int) ((ticks / 30) % 60);
		if(minutes < 10) {
			if(seconds < 10) Sprite.drawString(g, "0" + minutes + ":0" + seconds, i, j);
			else Sprite.drawString(g, "0" + minutes + ":" + seconds, i, j);
		}
		else {
			if(seconds < 10) Sprite.drawString(g, minutes + ":0" + seconds, i, j);
			else Sprite.drawString(g, minutes + ":" + seconds, i, j);
		}
	}
}
