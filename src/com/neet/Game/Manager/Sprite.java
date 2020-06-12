package com.neet.Game.Manager;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Sprite {
	
	public static BufferedImage[][] menubg = load("/HUD/menuscreen1.gif", 256, 288);
	public static BufferedImage[][] controls = load("/HUD/controls.png", 256, 288);
	
	public static BufferedImage[][] player = load("/Sprites/playersprites.gif",32,32);
	
	public static BufferedImage[][] enemy1 = load("/Enemy/enemy1.png",32,32);
	public static BufferedImage[][] enemy2 = load("/Enemy/enemy2.png",32,32);
	public static BufferedImage[][] enemy3 = load("/Enemy/enemy3.png",32,32);
	public static BufferedImage[][] enemy4 = load("/Enemy/enemy4.png",64,64);
	public static BufferedImage[][] enemy5 = load("/Enemy/enemy5.png",64,64);
	public static BufferedImage[][] enemy6 = load("/Enemy/enemy6.png",48,48);
	public static BufferedImage[][] enemy7 = load("/Enemy/enemy7.png",48,48);
	public static BufferedImage[][] enemy8 = load("/Enemy/enemy8.png",32,32);
	public static BufferedImage[][] enemy9 = load("/Enemy/enemy9.png",32,32);
	public static BufferedImage[][] enemy10 = load("/Enemy/enemy10.png",32,32);
	public static BufferedImage[][] enemy11 = load("/Enemy/enemy11.png",32,32);
	public static BufferedImage[][] enemy12 = load("/Enemy/enemy12.png",32,32);
	
	public static BufferedImage[][] item = load("/Sprites/items.png",16,16);
	public static BufferedImage[][] chest = load("/Sprites/chest.png",32,32);
	public static BufferedImage[][] equip = load("/Sprites/equip.png",16,16);
	public static BufferedImage[][] icon = load("/Sprites/icon.png",16,16);
	public static BufferedImage[][] shop = load("/Sprites/shop.png",24,24);
	public static BufferedImage[][] diamond = load("/Sprites/diamond.gif", 16, 16);
	public static BufferedImage[][] bullet = load("/Sprites/bullet.png",16,16);
	public static BufferedImage[][] skill = load("/Sprites/skill.png",24,24);
	public static BufferedImage[][] bulletE = load("/Sprites/bulletE.png",16,16);
	
	public static BufferedImage[][] arrow = load("/Sprites/arrow.png",32,21);
	public static BufferedImage[][] font = load("/HUD/font.gif",16,16);
	public static BufferedImage[][] tinifont = load("/HUD/tinifont.gif",8,8);
	public static BufferedImage[][] bigfont = load("/HUD/bigfont.gif",32,32);
	
    public static BufferedImage[][] load (String file,int w,int h) {
		BufferedImage[][] ret = null;
		try {
			BufferedImage spritesheet = ImageIO.read(Sprite.class.getResourceAsStream(file));
			int width = spritesheet.getWidth()/w;
			int height = spritesheet.getHeight()/h;
			ret = new BufferedImage[height][width];
			for (int i=0;i<height;i++)
				for (int j=0;j<width;j++) {
					ret[i][j] = spritesheet.getSubimage(j*w, i*h, w, h);
				}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Cannot load file");
			System.exit(0);
		}
		return ret;
	}
    public static void drawString (Graphics2D g,String s,int x,int y) {
    	s=s.toUpperCase();
    	for (int i=0;i<s.length();i++) {
    		char c = s.charAt(i);
			if(c == 47) c = 36; // slash
			if(c == 58) c = 37; // colon
			if(c == 32) c = 38; // space
			if(c >= 65 && c <= 90) c -= 65; // letters
			if(c >= 48 && c <= 57) c -= 22; // numbers
			int row = c / font[0].length;
			int col = c % font[0].length;
			g.drawImage(font[row][col], x + 14 * i, y, null);
    	}
    }
    public static void tiniDrawString (Graphics2D g,String s,int x,int y) {
    	s=s.toUpperCase();
    	for (int i=0;i<s.length();i++) {
    		char c = s.charAt(i);
			if(c == 47) c = 36; // slash
			if(c == 58) c = 37; // colon
			if(c == 32) c = 38; // space
			if(c >= 65 && c <= 90) c -= 65; // letters
			if(c >= 48 && c <= 57) c -= 22; // numbers
			int row = c / tinifont[0].length;
			int col = c % tinifont[0].length;
			g.drawImage(tinifont[row][col], x + 8 * i, y, null);
    	}
    }
    public static void bigDrawString (Graphics2D g,String s,int x,int y) {
    	s=s.toUpperCase();
    	for (int i=0;i<s.length();i++) {
    		char c = s.charAt(i);
			if(c == 47) c = 36; // slash
			if(c == 58) c = 37; // colon
			if(c == 32) c = 38; // space
			if(c >= 65 && c <= 90) c -= 65; // letters
			if(c >= 48 && c <= 57) c -= 22; // numbers
			int row = c / bigfont[0].length;
			int col = c % bigfont[0].length;
			g.drawImage(bigfont[row][col], x + 28 * i, y, null);
    	}
    }
}
