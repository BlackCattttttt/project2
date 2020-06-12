package com.neet.Game.HUD;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import com.neet.Game.Entity.Player;
import com.neet.Game.Manager.KeyHandle;

public class Misson {
	private BufferedImage bg;
	private Player player;
	
	private boolean live;
	
	public Misson(Player p) {
		player = p;
		setLive(true);
		init();
	}
	public void init() {
		try {
			bg = ImageIO.read(getClass().getResourceAsStream("/Hud/bg.png"));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void render (Graphics2D g) {
		g.drawImage(bg, 0, 0, null);
		g.setColor(Color.WHITE);
     	g.setFont(new Font("Serif",Font.PLAIN,25));
		g.drawString("NHIỆM VỤ", 60, 70);
		g.setFont(new Font("Serif",Font.PLAIN,20));
		if (player.getMap()==1) {
			if (player.getMission()==1) {
				g.drawString("Tiêu diệt 1 quái thú bất kỳ", 20, 130);
				g.drawString(player.getKill() + "/1", 100, 155);
			} else if (player.getMission()==2) {
				g.drawString("Tiêu diệt 2 quái thú bất kỳ", 20, 130);
				g.drawString(player.getKill() + "/2", 100, 155);
			} else {
				g.drawString("Thoát khỏi khu rừng", 50, 130);
			}
		}
		if (player.getMap()==2) {
			if (player.getMission()==3) {
				g.drawString("Tiêu diệt 3 quái thú bất kỳ", 20, 130);
				g.drawString(player.getKill() + "/3", 100, 155);
			} else if (player.getMission()==4) {
				g.drawString("Đạt đến Lv 2", 55, 130);
				g.drawString(player.getLv() + "/2", 100, 155);
			} else {
				g.drawString("Thoát khỏi sa mạc", 50, 130);
			}
		}
		if (player.getMap()==3) {
			if (player.getMission()==5) {
				g.drawString("Tiêu diệt 2 quái rồng", 45, 130);
				g.drawString(player.getKill() + "/2", 100, 155);
			} else if (player.getMission()==6) {
				g.drawString("Thu thập 2 lông bạc", 45, 130);
				g.drawString(player.getIcon() + "/2", 100, 155);
			} else {
				g.drawString("Thoát khỏi đầm lầy", 50, 130);
			}
		}
		if (player.getMap()==4) {
			if (player.getMission()==7) {
				g.drawString("Thu thập 5 bông tuyết", 45, 130);
				g.drawString(player.getIcon() + "/5", 100, 155);
			} else if (player.getMission()==8) {
				g.drawString("Đạt đến Lv 3", 55, 130);
				g.drawString(player.getLv() + "/3", 100, 155);
			} else {
				g.drawString("Thoát khỏi núi tuyết", 50, 130);
			}
		}
		if (player.getMap()==5) {
			if (player.getMission()==9) {
				g.drawString("Tiêu diệt 25 rồng con", 45, 130);
				g.drawString(player.getKill() + "/25", 100, 155);
			} else if (player.getMission()==10) {
				g.drawString("Thu thập 5 ngọn lửa", 45, 130);
				g.drawString(player.getIcon() + "/5", 100, 155);
			} else {
				g.drawString("Thoát khỏi núi lửa", 50, 130);
			}
		}
	}
	public void input () {
		if (KeyHandle.isPressed(KeyHandle.ESCAPE)) {
			setLive(false);
		}
	}
	public boolean isLive() {
		return live;
	}

	public void setLive(boolean live) {
		this.live = live;
	}
}
