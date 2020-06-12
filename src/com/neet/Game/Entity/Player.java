package com.neet.Game.Entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import com.neet.Game.Manager.Game;
import com.neet.Game.Manager.KeyHandle;
import com.neet.Game.Manager.Sound;
import com.neet.Game.Manager.Sprite;
import com.neet.Game.State.PlayState;
import com.neet.Game.State.PlaysaveState;
import com.neet.Game.TileMap.TileMap;


public class Player extends Entity {
	
	private int maxhp,hp;
	private int maxmn,mn;
	private int exp,Lv,maxexp;
	private int atk,def;
	private int critical;
	private int arp; //diem xuyen giap
	
	private BufferedImage[] downSprites;
	private BufferedImage[] leftSprites;
	private BufferedImage[] rightSprites;
	private BufferedImage[] upSprites;
	
	private final int DOWN = 0;
	private final int LEFT = 1;
	private final int RIGHT = 2;
	private final int UP = 3;
	
	protected ArrayList<Bullet> bullets;
	
	public int[] hat = new int[4];
	public int[] armor = new int[4];
	public int[] scepter = new int[4];
	public int[] shoe = new int[4];
	
	public int currentHat;
	public int currentArmor;
	public int currentScepter;
	public int currentShoe;
	
	private int map;
	private int binhmau;
	private int gold;
	private int mission;
	private int kill;
	private int key;
	private int icon;
	private long ticks;
	
	public Player(TileMap tm) {
		super(tm);
		width = 32;
		height = 32;
		cwidth = 30;
		cheight = 30;
		
		maxhp=hp=100;
		maxmn=mn=20;
		atk = 3;
		def = 1;
		critical = 0;
		arp = 0;
		maxexp = 50;
		exp = 0;
		Lv = 1;
		binhmau = 0;
		gold = 0;
		map = 1;
		
		mission = 1;
		kill = 0;
		icon = 0;
		key = 0;
		
		moveSpeed = 2;
		
		bullets = new ArrayList<Bullet>();
		
		for (int i=0;i<4;i++) {
			hat[i] = 0;
			armor[i] = 0;
			scepter[i] = 0;
			shoe[i] = 0;
		}
		currentHat = currentArmor = currentScepter = currentShoe = 0;
		downSprites = Sprite.player[0];
		leftSprites = Sprite.player[1];
		rightSprites = Sprite.player[2];
		upSprites = Sprite.player[3];
		setAnimation(DOWN, downSprites, 10);
	}
	public Player (TileMap tm,Game game) {
		super(tm);
		width = 32;
		height = 32;
		cwidth = 30;
		cheight = 30;
		
		hp = game.detachedTwo(game.getHp())[0];
		maxhp = game.detachedTwo(game.getHp())[1];
		mn = game.detachedTwo(game.getMn())[0];
		maxmn = game.detachedTwo(game.getMn())[1];
		exp = game.detachedTwo(game.getExp())[0];
		maxexp = game.detachedTwo(game.getExp())[1];
		Lv = game.getLevel();
		atk = game.detachedTwo(game.getAtkdef())[0];
		def = game.detachedTwo(game.getAtkdef())[1];
		critical = game.detachedTwo(game.getCritarp())[0];
		arp = game.detachedTwo(game.getCritarp())[1];
		
		currentHat = game.detachedFour(game.getHat())[0];
		hat[0] = 0;
		hat[1] = game.detachedFour(game.getHat())[1];
		hat[2] = game.detachedFour(game.getHat())[2];
		hat[3] = game.detachedFour(game.getHat())[3];
		currentArmor = game.detachedFour(game.getArmor())[0];
		armor[0] = 0;
		armor[1] = game.detachedFour(game.getArmor())[1];
		armor[2] = game.detachedFour(game.getArmor())[2];
		armor[3] = game.detachedFour(game.getArmor())[3];
		currentScepter = game.detachedFour(game.getScepter())[0];
		scepter[0] = 0;
		scepter[1] = game.detachedFour(game.getScepter())[1];
		scepter[2] = game.detachedFour(game.getScepter())[2];
		scepter[3] = game.detachedFour(game.getScepter())[3];
		currentShoe = game.detachedFour(game.getShoe())[0];
		shoe[0] = 0;
		shoe[1] = game.detachedFour(game.getShoe())[1];
		shoe[2] = game.detachedFour(game.getShoe())[2];
		shoe[3] = game.detachedFour(game.getShoe())[3];
		
		binhmau = game.detachedThree(game.getItem())[0];
		gold = game.detachedThree(game.getItem())[1];
		key = game.detachedThree(game.getItem())[2];
		
		mission = game.getMission();
		map = game.getMap();
		ticks = game.getTime();
		kill = 0;
		icon = 0;
        moveSpeed = 2;
		
		bullets = new ArrayList<Bullet>();
		
		downSprites = Sprite.player[0];
		leftSprites = Sprite.player[1];
		rightSprites = Sprite.player[2];
		upSprites = Sprite.player[3];
		setAnimation(DOWN, downSprites, 10);
	}
	public int getMaxhp() {
		return maxhp;
	}
	public void setMaxhp(int maxhp) {
		this.maxhp = maxhp;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getMaxmn() {
		return maxmn;
	}
	public void setMaxmn(int maxmn) {
		this.maxmn = maxmn;
	}
	public int getMn() {
		return mn;
	}
	public void setMn(int mn) {
		this.mn = mn;
	}
	public int getAtk() {
		return atk;
	}
	public void setAtk(int atk) {
		this.atk = atk;
	}
	public int getDef() {
		return def;
	}
	public void setDef(int def) {
		this.def = def;
	}
	public int getCritical() {
		return critical;
	}
	public void setCritical(int critical) {
		this.critical = critical;
	}
	public int getArp() {
		return arp;
	}
	public void setArp(int arp) {
		this.arp = arp;
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	public int getLv() {
		return Lv;
	}
	public void setLv(int lv) {
		Lv = lv;
	}
	public int getMaxexp() {
		return maxexp;
	}
	public void setMaxexp(int maxexp) {
		this.maxexp = maxexp;
	}
	public int getMap() {
		return map;
	}
	public void setMap(int map) {
		this.map = map;
	}
	public int getMission() {
		return mission;
	}
	public void setMission(int mission) {
		this.mission = mission;
	}
	public int getBinhmau() {
		return binhmau;
	}
	public void setBinhmau(int binhmau) {
		this.binhmau = binhmau;
	}
	public int getGold() {
		return gold;
	}
	public void setGold(int gold) {
		this.gold = gold;
	}
	public int getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
	}
	public int getIcon() {
		return icon;
	}
	public void setIcon(int icon) {
		this.icon = icon;
	}
	public long getTicks() { 
		return ticks; 
	}
	public void gotGold (Item item) {
		gold = gold + item.getValue();
	}
	public void gotPotion (Item item) {
		binhmau = binhmau + item.getValue();
	}
	public void gotKey () {
		key = key + 1;
	}
	public void gotChest () {
		gold = gold + 50;
	}
	public void gotIcon () {
		icon = icon + 1;
	}
	public void gotEquip (Equip e) {
		if (e.getType() ==  Equip.HAT) {
			hat[e.getQuanlity()+1]++;
		}
		if (e.getType() ==  Equip.ARMOR) {
			armor[e.getQuanlity()+1]++;
		}
		if (e.getType() ==  Equip.SCEPTER) {
			scepter[e.getQuanlity()+1]++;
		}
		if (e.getType() ==  Equip.SHOE) {
			shoe[e.getQuanlity()+1]++;
		}
	}
	public int getKill() {
		return kill;
	}
	public void setKill(int kill) {
		this.kill = kill;
	}
	public int exptoLvup (int k)
    {
    	if (k==1) return 50;
    	else if (k==2) return 75;
    	else if (k==3) return 100;
    	else if (k==4) return 150;
    	else if (k==5) return 200;
    	else if (k==6) return 300;
    	else if (k==7) return 500;
    	else if (k==8) return 750;
    	return 1000;
    	
    }
	public void upLv (int k)
	{
		if (k==1 && this.exp>=100)
		{
			this.Lv=2;
			this.exp=0;
			this.atk++;
			this.maxhp=this.hp=150;
		} else
		if (k==2 && this.exp>=250)
		{
			this.Lv=3;
			this.exp=0;
			this.atk++;
			this.arp=1;
			this.maxhp=this.hp=200;
			
		} else
		if (k==3 && this.exp>=400)
		{
			this.Lv=4;
			this.exp=0;
			this.atk++;
			this.critical=5;
			this.maxhp=this.hp=350;
		} else
		if (k==4 && this.exp>=550)
		{
			this.Lv=5;
			this.exp=0;
			this.atk++;
			this.arp=2;
			this.maxhp=this.hp=450;
		} else
		if (k==5 && this.exp>=750)
		{
			this.Lv=6;
			this.exp=0;
			this.atk++;
			this.maxhp=this.hp=500;
		} else
		if (k==6 && this.exp>=900)
		{
     		this.Lv=7;
			this.exp=0;
 			this.atk++;
 			this.critical=8;
			this.maxhp=this.hp=550;
		} else
		if (k==7 && this.exp>=1050)
		{
			this.Lv=8;
			this.exp=0;
 			this.atk++;
 			this.arp=3;
			this.maxhp=this.hp=650;
		} else
		if (k==8 && this.exp>=1200)
		{
			this.Lv=9;
			this.exp=0;
 			this.atk++;
 			this.arp=4;
			this.maxhp=this.hp=750;
		} else
		if (k==9 && this.exp>=1500)
		{
			this.Lv=10;
			this.exp=0;
 			this.atk++;
 			this.critical=10;
			this.maxhp=this.hp=1000;
		} else
		if (k==10 && this.exp>=1000)
		{
			this.exp=1000;
		}
	}
	public void mission (int mission) {
		if (mission == 1) {
			if (kill >= 1 ) {
				this.kill = 0;
				this.mission++;
			}
		} else if (mission == 2) {
			if (kill >= 2) {
				this.kill = 0;
				this.mission++;
				tileMap.setTile(29, 27, 1);
			}
		} else if (mission == 3) {
			if (map==1) tileMap.setTile(29, 27, 1);
			if (kill >= 3) {
				this.kill = 0;
				this.mission++;
				tileMap.setTile(4, 11, 1);
				tileMap.setTile(5, 11, 1);
		   }
		} else if (mission == 4) {
			if (map==2) {
				tileMap.setTile(4, 11, 1);
				tileMap.setTile(5, 11, 1);
			}
			if (Lv >= 2) {
				this.mission++;
				tileMap.setTile(27, 28, 1);
		   }
		} else if (mission == 5) {
			if (map==2) {
				tileMap.setTile(27, 28, 1);
			}
			if (kill >= 2) {
				this.mission++;
				kill = 0;
		   }
		} else if (mission == 6) {
			if (icon >= 2) {
				this.mission++;
				icon = 0;
				tileMap.setTile(18, 6, 1);
		   }
		} else if (mission == 7) {
			if (map==3) {
				tileMap.setTile(18, 6, 1);
			}
			if (icon >= 5) {
				this.mission++;
				icon = 0;
		   }
		} else if (mission == 8) {
			if (Lv >= 3) {
				this.mission++;
				tileMap.setTile(11, 13, 1);
				tileMap.setTile(12, 13, 1);
		   }
		} else if (mission == 9) {
			if (map==4) {
				tileMap.setTile(11, 13, 1);
				tileMap.setTile(12, 13, 1);
			}
			if (kill >= 25) {
				this.mission++;
				kill = 0;
		   }
		} else if (mission == 10) {
			if (icon >= 5) {
				this.mission++;
				icon = 0;
				tileMap.setTile(28, 28, 1);
		   }
		}
	}
	public void move () {
		if(down && currentAnimation != DOWN) {
			setAnimation(DOWN, downSprites, 10);
		}
		if(left && currentAnimation != LEFT) {
			setAnimation(LEFT, leftSprites, 10);
		}
		if(right && currentAnimation != RIGHT) {
			setAnimation(RIGHT, rightSprites, 10);
		}
		if(up && currentAnimation != UP) {
			setAnimation(UP, upSprites, 10);
		}
	}
	public void update () {
		ticks++;

		maxexp = exptoLvup(Lv);
		upLv(Lv);
		
		move();
		mission(this.mission);
		
		for (int i=0;i<bullets.size();i++) {
			Bullet bullet = bullets.get(i);
			if (bullet.isLive()==false) bullets.remove(i);
			else bullet.update();
		}
		if (ticks%250==0 && maxmn>mn) {
			mn = mn + 1;
		}
		super.update();
		System.out.println(rowTile+" "+colTile);
	}
	public void hitBullet (Enemies enemies) {
		for (int i=0;i<enemies.enemies.size();i++) {
			Enemy e = enemies.enemies.get(i);
			for (int j=0;j<e.bullets.size();j++) {
				if (this.intersects(e.bullets.get(j))) {
					e.bullets.get(j).setLive(false);
					int dmg = e.getAtk() - (def + armorDef());
					if (dmg>0) hp = hp - dmg;
				}
			}
		}
	}
	public int scepterAtk () {
		if (scepter[currentScepter]==0) {
			return 0;
		} else {
			if (currentScepter==1) return 2;
			if (currentScepter==2) return 10;
			if (currentScepter==3) return 20;
		}
		return 0;
	}
	public int armorDef () {
		if (armor[currentArmor]==0) {
			return 0;
		} else {
			if (currentArmor==1) return 2;
			if (currentArmor==2) return 10;
			if (currentArmor==3) return 20;
		}
		return 0;
	}
	public int HatCrit () {
		if (hat[currentHat]==0) {
			return 0;
		} else {
			if (currentHat==1) return 5;
			if (currentHat==2) return 10;
			if (currentHat==3) return 25;
		}
		return 0;
	}
	public int shoeArp () {
		if (shoe[currentShoe]==0) {
			return 0;
		} else {
			if (currentShoe==1) return 1;
			if (currentShoe==2) return 3;
			if (currentShoe==3) return 5;
		}
		return 0;
	}
	public void input () {
		if (KeyHandle.isDown(KeyHandle.UP))  {
			if(moving) return;
			up = true;
			moving = validateNextPosition();
		} 
		if (KeyHandle.isDown(KeyHandle.DOWN))  {
			if(moving) return;
			down = true;
			moving = validateNextPosition();
		} 
		if (KeyHandle.isDown(KeyHandle.LEFT))  {
			if(moving) return;
			left = true;
			moving = validateNextPosition();
		} 
		if (KeyHandle.isDown(KeyHandle.RIGHT))  {
			if(moving) return;
			right = true;
			moving = validateNextPosition();
		}
		if (KeyHandle.isPressed(KeyHandle.ATTACK)) {
			Bullet e = new Bullet(this.tileMap, this, 0);
			bullets.add(e);
			if (PlayState.music || PlaysaveState.music) {
				Sound.play("tilechange");
			}
		}
		if (KeyHandle.isPressed(KeyHandle.SKILL)) {
			if (mn>=3) {
				Bullet e = new Bullet(this.tileMap, this, 1);
				bullets.add(e);
				mn = mn - 3;
				if (PlayState.music) {
					Sound.play("tilechange");
				}
			}			
		}
		if (KeyHandle.isPressed(KeyHandle.HEAL)) {
			if (binhmau>0)
			{
				if (hp <=  maxhp - 50)
				{
					hp = hp + 50;
				} else
				{
					hp = maxhp;
				}
				binhmau = binhmau - 1;
			}
		}
	}
	@Override
	public void render(Graphics2D g) {
		setMapPosition();
		g.drawImage(animation.getImage(), x + xmap - width/2, y + ymap - height/2, null);
		for (int i = 0;i<bullets.size();i++) {
			bullets.get(i).render(g);
		}
	}

}
