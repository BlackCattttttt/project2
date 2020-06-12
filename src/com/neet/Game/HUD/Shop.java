package com.neet.Game.HUD;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import com.neet.Game.Entity.Player;
import com.neet.Game.Manager.KeyHandle;
import com.neet.Game.Manager.Sprite;

public class Shop {
     
	private BufferedImage bg;
	private BufferedImage select;
	private Player player;
	private BufferedImage[] equip;
	
	private int r;
	private int row;
	private int col;
	
	private boolean live;
	private boolean buy;
	private boolean success;
	
	public Shop (Player p) {
		player = p;
		equip = new BufferedImage[16];
		live = true;
		buy = false;
		r = 0;
		row = col = 0;
		init();
	}
	public void init () {
		try {
			bg = ImageIO.read(getClass().getResourceAsStream("/Hud/shop.png"));
			select = ImageIO.read(getClass().getResourceAsStream("/Sprites/select.png"));
			for (int i=0;i<16;i++) {
				equip[i] = Sprite.shop[i][0];
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public boolean isLive() {
		return live;
	}
	public void setLive(boolean live) {
		this.live = live;
	}
	public void input () {
		if (KeyHandle.isPressed(KeyHandle.ESCAPE)) {
			setLive(false);
		}
		if (KeyHandle.isPressed(KeyHandle.RIGHT)) {
			buy = false;
			if (col<3) col++;
			else {
				col=0;
				if (row==0) row=1;
				else {
					row=0;
					r=8;
				}
			}
		}
		if (KeyHandle.isPressed(KeyHandle.LEFT)) {
			buy = false;
			if (col>0) col--;			
		}
		if (KeyHandle.isPressed(KeyHandle.DOWN)) {
			buy = false;
			if (row==0) row=1;
			else if (row==1 && r == 0){
				row = 0;
				r = 8;
			}
		}
		if (KeyHandle.isPressed(KeyHandle.UP)) {
			buy = false;
			if (row==0 && r==8) {
				row=1;
				r=0;
			} else {
				row=0;
			}
		}
		if (KeyHandle.isPressed(KeyHandle.ENTER)) {
			buy = true;
			if (player.getGold()>=price(row, col)) {
				success = true;
				player.setGold(player.getGold()-price(row,col));
				buy(row, col);
			} else {
				success = false;
			}
		}
	}
	public void buy (int i,int j) {
		if (r==0) {
			if (i==0 && j==0) {
				player.hat[1]++;
			}
			if (i==0 && j==1) {
				player.hat[2]++;
			}
			if (i==0 && j==2) {
				player.hat[3]++;
			}
			if (i==0 && j==3) {
				player.armor[1]++;
			}
			if (i==1 && j==0) {
				player.armor[2]++;
			}
			if (i==1 && j==1) {
				player.armor[3]++;
			}
			if (i==1 && j==2) {
				player.scepter[1]++;
			}
			if (i==1 && j==3) {
				player.scepter[2]++;
			}
		} else {
			if (i==0 && j==0) {
				player.scepter[3]++;
			}
			if (i==0 && j==1) {
				player.shoe[1]++;
			}
			if (i==0 && j==2) {
				player.shoe[1]++;
			}
			if (i==0 && j==3) {
				player.shoe[1]++;
			}
			if (i==1 && j==0) {
				player.setBinhmau(player.getBinhmau()+1);
			}
			if (i==1 && j==1) {
			}
		}
	}
	public int price (int i,int j) {
		if (r==0) {
			if (i==0 && j==0) {
				return 200;
			}
			if (i==0 && j==1) {
				return 400;
			}
			if (i==0 && j==2) {
				return 800;
			}
			if (i==0 && j==3) {
				return 200;
			}
			if (i==1 && j==0) {
				return 500;
			}
			if (i==1 && j==1) {
				return 800;
			}
			if (i==1 && j==2) {
				return 300;
			}
			if (i==1 && j==3) {
				return 600;
			}
		} else {
			if (i==0 && j==0) {
				return 1200;
			}
			if (i==0 && j==1) {
				return 400;
			}
			if (i==0 && j==2) {
				return 800;
			}
			if (i==0 && j==3) {
				return 1400;
			}
			if (i==1 && j==0) {
				return 100;
			}
			if (i==1 && j==1) {
				return 10000;
			}
		}
		return 0;
	}
	public void drawInfor (Graphics2D g,int i,int j) {
		g.setColor(Color.WHITE);
     	g.setFont(new Font("Serif",Font.PLAIN,15));
		if (r==0) {
			if (i==0 && j==0) {
				g.drawString("Mũ bóng đêm", 75, 170);
				g.drawString("+ 5% tỉ lệ chí mạng", 65, 200);
				g.drawString("Giá bán : 200", 65, 220);
			}
			if (i==0 && j==1) {
				g.drawString("Mũ hoàng kim", 75, 170);
				g.drawString("+ 10% tỉ lệ chí mạng", 65, 200);
				g.drawString("Giá bán : 400", 65, 220);
			}
			if (i==0 && j==2) {
				g.drawString("Mũ hoàng hôn", 75, 170);
				g.drawString("+ 25% tỉ lệ chí mạng", 65, 200);
				g.drawString("Giá bán : 800", 65, 220);
			}
			if (i==0 && j==3) {
				g.drawString("Áo bóng đêm", 75, 170);
				g.drawString("+ 2 giáp", 65, 200);
				g.drawString("Giá bán : 200", 65, 220);
			}
			if (i==1 && j==0) {
				g.drawString("Áo hoàng kim", 75, 170);
				g.drawString("+ 10 giáp", 65, 200);
				g.drawString("Giá bán : 500", 65, 220);
			}
			if (i==1 && j==1) {
				g.drawString("Áo hoàng hôn", 75, 170);
				g.drawString("+ 20 giáp", 65, 200);
				g.drawString("Giá bán : 800", 65, 220);
			}
			if (i==1 && j==2) {
				g.drawString("Trượng bóng đêm", 75, 170);
				g.drawString("+ 2 tấn công", 65, 200);
				g.drawString("Giá bán : 300", 65, 220);
			}
			if (i==1 && j==3) {
				g.drawString("Trượng hoàng kim", 75, 170);
				g.drawString("+ 10 tấn công", 65, 200);
				g.drawString("Giá bán : 600", 65, 220);
			}
		} else {
			if (i==0 && j==0) {
				g.drawString("Trượng hoàng hôn", 75, 170);
				g.drawString("+ 20 tấn công", 65, 200);
				g.drawString("Giá bán : 1200", 65, 220);
			}
			if (i==0 && j==1) {
				g.drawString("Giày bóng đêm", 75, 170);
				g.drawString("+ 1 tỉ lệ xuyên giáp", 65, 200);
				g.drawString("Giá bán : 400", 65, 220);
			}
			if (i==0 && j==2) {
				g.drawString("Giày hoàng kim", 75, 170);
				g.drawString("+ 3 tỉ lệ xuyên giáp", 65, 200);
				g.drawString("Giá bán : 800", 65, 220);
			}
			if (i==0 && j==3) {
				g.drawString("Giày hoàng hôn", 75, 170);
				g.drawString("+ 5 tỉ lệ xuyên giáp", 65, 200);
				g.drawString("Giá bán : 1400", 65, 220);
			}
			if (i==1 && j==0) {
				g.drawString("Bình máu", 75, 170);
				g.drawString("+ 1 bình máu", 65, 200);
				g.drawString("Giá bán : 100", 65, 220);
			}
			if (i==1 && j==1) {
				g.drawString("Bình mana", 75, 170);
				g.drawString("+ 1 bình mana", 65, 200);
				g.drawString("Giá bán : vô giá", 65, 220);
			}
		}
	}
	public void render (Graphics2D g) {
		g.drawImage(bg, 0, 0, null);
		g.setColor(Color.WHITE);
     	g.setFont(new Font("Serif",Font.PLAIN,10));
     	g.drawString(" "+player.getGold(), 165 ,70 );
     	int k = r;
     	for (int i=0;i<2;i++) {
     		for (int j=0;j<4;j++) {
     			g.drawImage(equip[k++], 66 + 33*j, 74 + 36*i, null);
     		}
     	}
     	g.drawImage(select,66 + 33*col, 74 + 36*row, null);
     	drawInfor(g, row, col);
     	g.setFont(new Font("Serif",Font.PLAIN,18));
     	if (buy) {
     		if (success) {
         		g.drawString("Mua thành công", 70, 250);
         	} else {
         		g.drawString("Bạn không đủ vàng", 70, 250);
         	}
     	}
	}
}
