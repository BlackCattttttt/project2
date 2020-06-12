package com.neet.Game.HUD;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import com.neet.Game.Entity.Player;
import com.neet.Game.Manager.KeyHandle;
import com.neet.Game.Manager.Sprite;

public class InformationState{

	private BufferedImage bg;
	private BufferedImage[] arrow;
	private Player player;
	
	private int type;
	private int currentOption = -1;

	public static final int INFORMATION = 0;
	public static final int HAT_INFORMATION = 1;
	public static final int ARMOR_INFORMATION = 2;
	public static final int SCEPTER_INFORMATION = 3;
	public static final int SHOE_INFORMATION = 4;
	
	private boolean live;
	private boolean option;
	
	public InformationState(Player p) {
		player = p;
		arrow = new BufferedImage[3];
		type = INFORMATION;
		setLive(true);
		option = false;
		init();
	}

	public void init() {
		try {
			bg = ImageIO.read(getClass().getResourceAsStream("/Hud/bg.png"));
			arrow[0] = Sprite.arrow[0][0];
			arrow[1] = Sprite.arrow[1][0];
			arrow[2] = Sprite.arrow[2][0];
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void render(Graphics2D g) {
		g.drawImage(bg, 0, 0, null);
		g.drawImage(arrow[0],220, 40, null);
		g.drawImage(arrow[1],10, 40, null);
		g.setColor(Color.WHITE);
     	g.setFont(new Font("Serif",Font.PLAIN,15));
		if (type == INFORMATION) {			
	    	g.drawString("THÔNG TIN NHÂN VẬT", 50, 55);
	    	g.setFont(new Font("Serif",Font.PLAIN,18));
	    	g.drawString("HP: "+player.getHp()+"/"+player.getMaxhp(), 5, 100);
	    	g.drawString("MP: "+player.getMn()+"/"+player.getMaxmn(), 5, 125);
	    	g.drawString("Lv "+player.getLv(), 120, 100);
	    	g.drawString("Lên cấp: "+player.getExp()+"/"+player.getMaxexp(), 120, 125);
	    	g.drawString("Tấn công: "+player.getAtk()+" + "+player.scepterAtk(), 5, 150);
	    	g.drawString("Phòng thủ: "+player.getDef()+" + "+player.armorDef(), 5, 175);
	    	g.drawString("Tỉ lệ bạo kích: "+player.getCritical()+"%"+"+"+player.HatCrit()+"%", 5, 200);
	    	g.drawString("Tỉ lệ xuyên giáp: "+player.getArp()+" + "+player.shoeArp(), 5, 225);
	    	g.drawString("Tốc độ: "+2, 5, 250);
		} else if (type == HAT_INFORMATION) {
			g.setFont(new Font("Serif",Font.PLAIN,22));
			g.drawString("MŨ", 105, 55);
			g.setFont(new Font("Serif",Font.PLAIN,18));
			if (option) drawArrow(g);
			g.drawString("Mũ nông dân: "+player.hat[0],70,130);
			g.drawString("Mũ bóng đêm: "+player.hat[1],70,160);
			g.drawString("Mũ hoàng kim: "+player.hat[2],70,190);
			g.drawString("Mũ hoàng hôn: "+player.hat[3],70,220);
		} else if (type == ARMOR_INFORMATION) {
			g.setFont(new Font("Serif",Font.PLAIN,22));
			g.drawString("ÁO GIÁP", 95, 55);
			g.setFont(new Font("Serif",Font.PLAIN,18));
			if (option) drawArrow(g);
			g.drawString("Áo nông dân: "+player.armor[0],70,130);
			g.drawString("Áo giáp bóng đêm: "+player.armor[1],70,160);
			g.drawString("Áo giáp hoàng kim: "+player.armor[2],70,190);
			g.drawString("Áo giáp hoàng hôn: "+player.armor[3],70,220);
		} else if (type == SCEPTER_INFORMATION) {
			g.setFont(new Font("Serif",Font.PLAIN,22));
			g.drawString("QUYỀN TRƯỢNG", 50, 55);
			g.setFont(new Font("Serif",Font.PLAIN,18));
			if (option) drawArrow(g);
			g.drawString("Gậy nông dân: "+player.scepter[0],70,130);
			g.drawString("Trượng bóng đêm: "+player.scepter[1],70,160);
			g.drawString("Trượng hoàng kim: "+player.scepter[2],70,190);
			g.drawString("Trượng hoàng hôn: "+player.scepter[3],70,220);
		} else if (type == SHOE_INFORMATION) {
			g.setFont(new Font("Serif",Font.PLAIN,22));
			g.drawString("GIÀY", 98, 55);
			g.setFont(new Font("Serif",Font.PLAIN,18));
			if (option) drawArrow(g);
			g.drawString("Giày nông dân: "+player.shoe[0],70,130);
			g.drawString("Giày bóng đêm: "+player.shoe[1],70,160);
			g.drawString("Giày hoàng kim: "+player.shoe[2],70,190);
			g.drawString("Giày hoàng hôn: "+player.shoe[3],70,220);
		}
		
	}
	public void drawArrow (Graphics2D g) {
		if (currentOption == 0) g.drawImage(arrow[2], 35, 113, null);
		else if (currentOption == 1) g.drawImage(arrow[2], 35, 143, null);
		else if (currentOption == 2) g.drawImage(arrow[2], 35, 173, null);
		else if (currentOption == 3) g.drawImage(arrow[2], 35, 203, null);
	}
	public void input() {
		if (KeyHandle.isPressed(KeyHandle.ESCAPE)) {
			setLive(false);
		}
		if (KeyHandle.isPressed(KeyHandle.RIGHT)) {
			option = false;
			if (type < SHOE_INFORMATION) type++;
			else type = INFORMATION;
		}
		if (KeyHandle.isPressed(KeyHandle.LEFT)) {
			option = false;
			if (type > INFORMATION) type--;
			else type = SHOE_INFORMATION;
		}
		if (KeyHandle.isPressed(KeyHandle.ENTER) && type!=INFORMATION) {
			option = true;
			if (type == HAT_INFORMATION) currentOption = player.currentHat;
			if (type == ARMOR_INFORMATION) currentOption = player.currentArmor;
			if (type == SCEPTER_INFORMATION) currentOption = player.currentScepter;
			if (type == SHOE_INFORMATION) currentOption = player.currentShoe;
		}
		if (KeyHandle.isPressed(KeyHandle.ATTACK) && type!=INFORMATION) {
			if (type == HAT_INFORMATION && player.hat[currentOption]>0) player.currentHat = currentOption;
			if (type == ARMOR_INFORMATION && player.armor[currentOption]>0) player.currentArmor = currentOption;
			if (type == SCEPTER_INFORMATION && player.scepter[currentOption]>0) player.currentScepter = currentOption;
			if (type == SHOE_INFORMATION && player.shoe[currentOption]>0) player.currentShoe = currentOption;
		}
		if (KeyHandle.isPressed(KeyHandle.SKILL) && type!=INFORMATION) {
			if (type == HAT_INFORMATION && player.hat[currentOption]>0) {
				if (currentOption!=0) player.hat[currentOption]--;
				if (currentOption == 1) player.setGold(player.getGold() + 50);
				else if (currentOption == 2) player.setGold(player.getGold() + 100);
				else if (currentOption == 3) player.setGold(player.getGold() + 200);
			}
			if (type == ARMOR_INFORMATION && player.armor[currentOption]>0) {
				if (currentOption!=0) player.armor[currentOption]--;
				if (currentOption == 1) player.setGold(player.getGold() + 50);
				else if (currentOption == 2) player.setGold(player.getGold() + 125);
				else if (currentOption == 3) player.setGold(player.getGold() + 200);
			}
			if (type == SCEPTER_INFORMATION && player.scepter[currentOption]>0) {
				if (currentOption!=0) player.scepter[currentOption]--;
				if (currentOption == 1) player.setGold(player.getGold() + 75);
				else if (currentOption == 2) player.setGold(player.getGold() + 150);
				else if (currentOption == 3) player.setGold(player.getGold() + 300);
			}
			if (type == SHOE_INFORMATION && player.shoe[currentOption]>0) {
				if (currentOption!=0) player.shoe[currentOption]--;
				if (currentOption == 1) player.setGold(player.getGold() + 100);
				else if (currentOption == 2) player.setGold(player.getGold() + 200);
				else if (currentOption == 3) player.setGold(player.getGold() + 350);
			}
		}
		if (KeyHandle.isPressed(KeyHandle.DOWN) && currentOption < 3  && option) {
			currentOption++;
		}
		if(KeyHandle.isPressed(KeyHandle.UP) && currentOption > 0  && option) {
//			JukeBox.play("menuoption");
			currentOption--;
		}
	}

	public boolean isLive() {
		return live;
	}

	public void setLive(boolean live) {
		this.live = live;
	}

}
