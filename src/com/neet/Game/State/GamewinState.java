package com.neet.Game.State;

import java.awt.Color;
import java.awt.Graphics2D;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.neet.Game.Main.GamePanel;
import com.neet.Game.Manager.Data;
import com.neet.Game.Manager.HightScore;
import com.neet.Game.Manager.KeyHandle;
import com.neet.Game.Manager.Sound;
import com.neet.Game.Manager.Sprite;

import Database.DataQuery;
import Database.Save;

public class GamewinState extends GameState{

    private Color color;
	
	private long ticks;
	
	public ArrayList<HightScore> hs;
	
	public GamewinState(GameStateManager gsm) {
		super(gsm);
		init();
	}

	@Override
	public void init() {
		color = new Color(164, 198, 222);
		ticks = Data.getTime();
		
		hs = new ArrayList<HightScore>();
		DataQuery data = new DataQuery();
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
		
		Sprite.drawString(g, "finish time", 40, 50);
		
		int minutes = (int) (ticks / 1800);
		int seconds = (int) ((ticks / 30) % 60);
		if(minutes < 10) {
			if(seconds < 10) Sprite.drawString(g, "0" + minutes + ":0" + seconds, 88, 74);
			else Sprite.drawString(g, "0" + minutes + ":" + seconds, 88, 74);
		}
		else {
			if(seconds < 10) Sprite.drawString(g, minutes + ":0" + seconds, 88, 74);
			else Sprite.drawString(g, minutes + ":" + seconds, 88, 74);
		}
		if (hs.size()<=4) {
			Sprite.drawString(g, "new record", 45, 100);
			gsm.setPause(true);
	    	Save save = new Save();
	    	save.init(ticks);
		} else {
			if (ticks<hs.get(3).getTime()) {
				Sprite.drawString(g, "new record", 45, 100);
				gsm.setPause(true);
		    	Save save = new Save();
		    	save.init(ticks);
		    }		
		}
		
		Sprite.drawString(g, "Press F1", 70,210);
		Sprite.drawString(g, "to return menu", 30, 230);
	}

	@Override
	public void input() {
		if (KeyHandle.isPressed(KeyHandle.F1)) {
			gsm.setPause(false);
			gsm.addAndpop(GameStateManager.MENU);
			Sound.play("collect");
		}
	}

}
