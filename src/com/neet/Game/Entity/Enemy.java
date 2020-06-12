package com.neet.Game.Entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

import com.neet.Game.Manager.Sprite;
import com.neet.Game.TileMap.TileMap;
import com.neet.Game.Entity.Icon;

public class Enemy extends Entity{
	
	private int x1,y1;
	private int x2,y2;
	private int maxhp,hp;
    private int atk,def;
    private int exp;
    private int gold;
    private boolean live;
    private boolean fight;
    
	private BufferedImage[] downSprites;
	private BufferedImage[] rightSprites;
	private BufferedImage[] leftSprites;
	private BufferedImage[] upSprites;
	private BufferedImage[] downFightSprites;
	private BufferedImage[] leftFightSprites;
	private BufferedImage[] rightFightSprites;
	private BufferedImage[] upFightSprites;
	
	private final int DOWN = 0;
	private final int RIGHT = 1;
	private final int LEFT = 2;
	private final int UP = 3;
	private final int DOWNFight = 4;
	private final int RIGHTFight = 5;
	private final int LEFTFight = 6;
	private final int UPFight = 7;
	
	protected ArrayList<BulletE> bullets;
	
	private int type;
	private int ticks;

	public Enemy(TileMap tm,int type, int status) {
		super(tm);
		width = height = 32;
		cwidth = cheight = 30;
		
		moveSpeed = 1;
		moving = true;
		live = true;
		fight = false;
		
		this.type = type;
		ticks=0;
		
		bullets = new ArrayList<BulletE>();
		
		if (type == 1) {
			downSprites = Sprite.enemy1[0];
			rightSprites = Sprite.enemy1[1];
			leftSprites = Sprite.enemy1[2];
			upSprites = Sprite.enemy1[3];
			downFightSprites = Sprite.enemy1[4];
			rightFightSprites = Sprite.enemy1[5];
			leftFightSprites = Sprite.enemy1[6];
			upFightSprites = Sprite.enemy1[7];
			
			hp = maxhp = 20;
			atk = 1;
			def = 1;
			exp = 5;
			gold = 10;
		} else if (type == 2) {
			downSprites = Sprite.enemy2[0];
			rightSprites = Sprite.enemy2[1];
			leftSprites = Sprite.enemy2[2];
			upSprites = Sprite.enemy2[3];
			downFightSprites = Sprite.enemy2[4];
			rightFightSprites = Sprite.enemy2[5];
			leftFightSprites = Sprite.enemy2[6];
			upFightSprites = Sprite.enemy2[7];
			
			hp = maxhp = 20;
			atk = 1;
			def = 2;
			exp = 5;
			gold = 10;
		} else if (type == 3) {
			downSprites = Sprite.enemy3[0];
			rightSprites = Sprite.enemy3[1];
			leftSprites = Sprite.enemy3[2];
			upSprites = Sprite.enemy3[3];
			downFightSprites = Sprite.enemy3[4];
			rightFightSprites = Sprite.enemy3[5];
			leftFightSprites = Sprite.enemy3[6];
			upFightSprites = Sprite.enemy3[7];
			
			hp = maxhp = 30;
			atk = 2;
			def = 0;
			exp = 7;
			gold = 15;
		} else if (type == 4) {
			downSprites = Sprite.enemy4[0];
			rightSprites = Sprite.enemy4[1];
			leftSprites = Sprite.enemy4[2];
			upSprites = Sprite.enemy4[3];
			downFightSprites = Sprite.enemy4[4];
			rightFightSprites = Sprite.enemy4[5];
			leftFightSprites = Sprite.enemy4[6];
			upFightSprites = Sprite.enemy4[7];
			
			hp = maxhp = 50;
			atk = 3;
			def = 1;
			exp = 10;
			gold = 20;
		} else if (type == 5) {
			downSprites = Sprite.enemy5[0];
			rightSprites = Sprite.enemy5[1];
			leftSprites = Sprite.enemy5[2];
			upSprites = Sprite.enemy5[3];
			downFightSprites = Sprite.enemy5[4];
			rightFightSprites = Sprite.enemy5[5];
			leftFightSprites = Sprite.enemy5[6];
			upFightSprites = Sprite.enemy5[7];
			
			hp = maxhp = 100;
			atk = 7;
			def = 3;
			exp = 25;
			gold = 35;
		} else if (type == 6) {
			downSprites = Sprite.enemy6[0];
			rightSprites = Sprite.enemy6[1];
			leftSprites = Sprite.enemy6[2];
			upSprites = Sprite.enemy6[3];
			downFightSprites = Sprite.enemy6[4];
			rightFightSprites = Sprite.enemy6[5];
			leftFightSprites = Sprite.enemy6[6];
			upFightSprites = Sprite.enemy6[7];
			
			hp = maxhp = 20;
			atk = 3;
			def = 0;
			exp = 5;
			gold = 10;
		} else if (type == 7) {
			downSprites = Sprite.enemy7[0];
			rightSprites = Sprite.enemy7[1];
			leftSprites = Sprite.enemy7[2];
			upSprites = Sprite.enemy7[3];
			downFightSprites = Sprite.enemy7[4];
			rightFightSprites = Sprite.enemy7[5];
			leftFightSprites = Sprite.enemy7[6];
			upFightSprites = Sprite.enemy7[7];
			
			hp = maxhp = 150;
			atk = 5;
			def = 3;
			exp = 30;
			gold = 40;
		} else if (type == 8) {
			downSprites = Sprite.enemy8[0];
			rightSprites = Sprite.enemy8[1];
			leftSprites = Sprite.enemy8[2];
			upSprites = Sprite.enemy7[3];
			downFightSprites = Sprite.enemy8[4];
			rightFightSprites = Sprite.enemy8[5];
			leftFightSprites = Sprite.enemy8[6];
			upFightSprites = Sprite.enemy8[7];
			
			hp = maxhp = 20;
			atk = 3;
			def = 0;
			exp = 5;
			gold = 10;
		} else if (type == 9) {
			downSprites = Sprite.enemy9[0];
			rightSprites = Sprite.enemy9[1];
			leftSprites = Sprite.enemy9[2];
			upSprites = Sprite.enemy9[3];
			downFightSprites = Sprite.enemy9[4];
			rightFightSprites = Sprite.enemy9[5];
			leftFightSprites = Sprite.enemy9[6];
			upFightSprites = Sprite.enemy9[7];
			
			hp = maxhp = 70;
			atk = 4;
			def = 2;
			exp = 20;
			gold = 20;
		} else if (type == 10) {
			downSprites = Sprite.enemy10[0];
			rightSprites = Sprite.enemy10[1];
			leftSprites = Sprite.enemy10[2];
			upSprites = Sprite.enemy10[3];
			downFightSprites = Sprite.enemy10[4];
			rightFightSprites = Sprite.enemy10[5];
			leftFightSprites = Sprite.enemy10[6];
			upFightSprites = Sprite.enemy10[7];
			
			hp = maxhp = 80;
			atk = 5;
			def = 1;
			exp = 20;
			gold = 20;
		} else if (type == 11) {
			downSprites = Sprite.enemy11[0];
			rightSprites = Sprite.enemy11[1];
			leftSprites = Sprite.enemy11[2];
			upSprites = Sprite.enemy11[3];
			downFightSprites = Sprite.enemy11[4];
			rightFightSprites = Sprite.enemy11[5];
			leftFightSprites = Sprite.enemy11[6];
			upFightSprites = Sprite.enemy11[7];
			
			hp = maxhp = 50;
			atk = 3;
			def = 2;
			exp = 20;
			gold = 15;
		} else if (type == 12) {
			downSprites = Sprite.enemy12[0];
			rightSprites = Sprite.enemy12[1];
			leftSprites = Sprite.enemy12[2];
			upSprites = Sprite.enemy12[3];
			downFightSprites = Sprite.enemy12[4];
			rightFightSprites = Sprite.enemy12[5];
			leftFightSprites = Sprite.enemy12[6];
			upFightSprites = Sprite.enemy12[7];
			
			hp = maxhp = 50;
			atk = 3;
			def = 1;
			exp = 15;
			gold = 25;
		} 	
		if (status == LEFT) {
			left = true;
			up = down = right = false;
			setAnimation(LEFT, leftSprites, 10);
		} else if (status == RIGHT) {
			right = true;
			up = down = left = false;
			setAnimation(RIGHT, rightSprites, 10);
		} else if (status == UP) {
			up = true;
			right = down = left = false;
			setAnimation(UP, upSprites, 10);
		} else if (status == DOWN) {
			down = true;
			up = right = left = false;
			setAnimation(DOWN, downSprites, 10);
		}
		
	}
	public int getDef() {
		return def;
	}
	public void setDef(int def) {
		this.def = def;
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
	public int getAtk() {
		return atk;
	}
	public void setAtk(int atk) {
		this.atk = atk;
	}
	public int getGold() {
		return gold;
	}
	public void setGold(int gold) {
		this.gold = gold;
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	public boolean isLive() {
		return live;
	}
	public void setLive(boolean live) {
		this.live = live;
	}
	public void setTilePosition (int a, int b, int c, int d) {
		y1 = a * tileSize + tileSize/2;
		x1 = b * tileSize + tileSize/2;
		y2 = c * tileSize + tileSize/2;
		x2 = d * tileSize + tileSize/2;
		y = y1;
		x = x1;
	}
	public void move () {
		if(down) {
			if(fight && currentAnimation != DOWNFight) {
				setAnimation(DOWNFight, downFightSprites, 10);
			}
			else if(!fight && currentAnimation != DOWN) {
				setAnimation(DOWN, downSprites, 10);
			}
		}
		if(left) {
			if(fight && currentAnimation != LEFTFight) {
				setAnimation(LEFTFight, leftFightSprites, 10);
			}
			else if(!fight && currentAnimation != LEFT) {
				setAnimation(LEFT, leftSprites, 10);
			}
		}
		if(right) {
			if(fight && currentAnimation != RIGHTFight) {
				setAnimation(RIGHTFight, rightFightSprites, 10);
			}
			else if(!fight && currentAnimation != RIGHT) {
				setAnimation(RIGHT, rightSprites, 10);
			}
		}
		if(up) {
			if(fight && currentAnimation != UPFight) {
				setAnimation(UPFight, upFightSprites, 10);
			}
			else if(!fight && currentAnimation != UP) {
				setAnimation(UP, upSprites, 10);
			}
		}
	}
	public void update (Player p,ArrayList<Item> items,ArrayList<Equip> equips,ArrayList<Icon> icons) {
		ticks++;
		
		if (live) {
			rowTile = y / tileSize;
			colTile = x / tileSize;
			move();
			if (x1 == x2) {
				if (up && ydest >= y1 - tileSize) {
					ydest = y - tileSize;
				} else {
					up = false;
					down = true;
				}
				if (down && ydest <=y2 + tileSize) {
					ydest = y + tileSize;
				} else {
					down = false;
					up = true;
				}
			}
			if (y1 == y2) {
				if (left && xdest >= x1 - tileSize) {
					xdest = x - tileSize;
				} else {
					left = false;
					right = true;
				}
				if (right && xdest <=x2 + tileSize) {
					xdest = x + tileSize;
				} else {
					right = false;
					left = true;
				}
			}
			if (moving) {
				if(left && x > xdest) x -= moveSpeed;		
				if(right && x < xdest) x += moveSpeed;		
				if(up && y > ydest) y -= moveSpeed;		
				if(down && y < ydest) y += moveSpeed;
			}
			if (ticks%100==0 && !fight) {
				if (type != 4 && type !=5) {
					BulletE e = new BulletE(this.tileMap, this);
					bullets.add(e);
				}			
			}
			for (int i=0;i<bullets.size();i++) {
				BulletE bullet = bullets.get(i);
				if (bullet.isLive()==false) bullets.remove(i);
				else bullet.update();
			}
			hitPlayer(p);
			hitBullet(p,items,equips,icons);
			animation.update();
		} else if (!live && ticks%1500==0) {
			live = true;
			hp = maxhp;
		}
	}
	public void hitBullet (Player p,ArrayList<Item> items,ArrayList<Equip> equips,ArrayList<Icon> icons) {
		for (int i=0;i<p.bullets.size();i++) {
			if (this.intersects(p.bullets.get(i))) {
				if (hp>0) {
					p.bullets.get(i).setLive(false);
					if (p.bullets.get(i).getType()==0) {
						Random r = new Random();
						if (r.nextInt(100)>60) {
							float crit = (p.getCritical()+p.HatCrit())/100;
							int dmg = (int) ((int) (p.getAtk()+p.scepterAtk())*(crit+1) - this.def + (p.getArp()+p.shoeArp()));
							if (dmg>0) this.hp = this.hp - dmg;
						}
					} else {
						Random r = new Random();
						if (r.nextInt(100)>40) {
							float crit = (p.getCritical()+p.HatCrit())/100;
							int dmg = (int) ((int) (p.getAtk()+p.scepterAtk())*(crit+1)*3 - this.def + (p.getArp()+p.shoeArp()));
							if (dmg>0) this.hp = this.hp - dmg;
						}
					}				
					if (hp<=0) {
						live = false;
						p.setExp(p.getExp() + this.exp);
						if (p.getMission()==5) {
							if (type==4) p.setKill(p.getKill()+1);
						} else if (p.getMission()==9) {
							if (type==7) p.setKill(p.getKill()+1);
						} else if (p.getMission()==1 || p.getMission()==2 || p.getMission()==3){
							p.setKill(p.getKill()+1);
						}
						Item item = new Item(this.tileMap);
						Equip equip = new Equip(this.tileMap);
						Icon icon = new Icon(this.tileMap);
						Random r = new Random();
						int rd = r.nextInt(100);
						if (rd > 85) {
							int type = r.nextInt(4);
							equip.setType(type, 0);
							equip.setTilePosition(this.rowTile, this.colTile);
							equips.add(equip);
						} else if (rd > 70) {
							item.populatePotion(this);
							items.add(item);
						} else {
							item.populateGold(this);
							items.add(item);
						}
						if (p.getMission()==6 && p.getMap()==3) {
							int rd1 = r.nextInt(100);
							if (rd1 > 40) {
								icon.setType(Icon.FEATHER);
								icon.setPosition(this.x+5, this.y);
								icons.add(icon);
							}
						}
						if (p.getMission()==7 && p.getMap()==4) {
							int rd1 = r.nextInt(100);
							if (rd1 > 40) {
								icon.setType(Icon.SNOWFLAKES);
								icon.setPosition(this.x+5, this.y);
								icons.add(icon);
							}
						}
						if (p.getMission()==10 && p.getMap()==5) {
							int rd1 = r.nextInt(100);
							if (rd1 > 40) {
								icon.setType(Icon.FIRE);
								icon.setPosition(this.x+5, this.y);
								icons.add(icon);
							}
						}
					}
				}
			}
		}
	}
	public void hitPlayer (Player p) {
		if (!fight) {
			moveSpeed = 1;
			if (left || right) {
				int r = y / tileSize;
				int c1 = x1 / tileSize;
				int c2 = x2 / tileSize;
				if (r==p.rowTile && p.colTile>=c1 && p.colTile<=c2 ) {
					fight = true;
					if (left) {
						setAnimation(LEFTFight, leftFightSprites, 10);
						move();
					} else {
						setAnimation(RIGHTFight, rightFightSprites, 10);
					}
				}
				if (this.intersects(p)) {
					int dmg = atk * 2 - (p.getDef() + p.armorDef());
					if (dmg>0) p.setHp(p.getHp() - dmg);
					moving = false;
				} else {
					moving = true;
				}
			}
			if (up || down) {
				int r1 = y1 / tileSize;
				int r2 = y2 / tileSize;
				int c = x / tileSize;
				if (c==p.colTile && p.rowTile>=r1 && p.rowTile<=r2 ) {
					fight = true;
					if (up) {
						setAnimation(UPFight, upFightSprites, 10);
						move();
					} else {
						setAnimation(DOWNFight, downFightSprites, 10);
					}
				}
				if (this.intersects(p)) {
					int dmg = atk * 2 - (p.getDef() + p.armorDef());
					if (dmg>0) p.setHp(p.getHp() - dmg);
					moving = false;
				} else {
					moving = true;
				}
			}
		} else {
			moveSpeed = 2;
			if (left || right) {
				int r = y / tileSize;
				int c1 = x1 / tileSize;
				int c2 = x2 / tileSize;
				if (r!=p.rowTile || p.colTile<c1 || p.colTile>c2 ) {
					fight = false;
				}
				if (this.intersects(p)) {
					Random rd = new Random();
					if (rd.nextInt(100)>50) {
						int dmg = atk * 2 - p.getDef();
						if (dmg>0) p.setHp(p.getHp() - dmg);
					}				
					moving = false;
				} else {
					moving = true;
				}
			}
			if (up || down) {
				int r1 = y1 / tileSize;
				int r2 = y2 / tileSize;
				int c = x / tileSize;
				if (c!=p.colTile || p.rowTile<r1 || p.rowTile>r2 ) {
					fight = false;
				}
				if (this.intersects(p)) {
					Random rd = new Random();
					if (rd.nextInt(100)>50) {
						int dmg = atk * 2 - p.getDef();
						if (dmg>0) p.setHp(p.getHp() - dmg);
					}	
					moving = false;
				} else {
					moving = true;
				}
		   }
		}
	}
	@Override
	public void render(Graphics2D g) {
		if (live) {
			setMapPosition();
			g.setColor(Color.green);
			if (type==1) {
				g.fillRect(x + xmap - width/2 + 4, y + ymap - height/2 + 7,20*hp/maxhp, 3);
			} else if (type==2) {
				g.fillRect(x + xmap - width/2 + 3, y + ymap - height/2 + 9,20*hp/maxhp, 3);
			} else if (type==3 || type==11) {
				g.fillRect(x + xmap - width/2 + 6, y + ymap - height/2 + 3,20*hp/maxhp, 3);
			} else if (type==4) {
				g.fillRect(x + xmap - width/2 + 18, y + ymap - height/2 + 20 ,25*hp/maxhp, 3);
			} else if (type==5) {
				g.fillRect(x + xmap - width/2 + 15, y + ymap - height/2 + 16 ,25*hp/maxhp, 3);
			} else if (type==7) {
				g.fillRect(x + xmap - width/2 + 12, y + ymap - height/2 + 12 ,25*hp/maxhp, 3);
			} else if (type==9) {
				g.fillRect(x + xmap - width/2 + 4, y + ymap - height/2 - 5 ,25*hp/maxhp, 3);
			} else if (type==10) {
				g.fillRect(x + xmap - width/2 + 2, y + ymap - height/2 - 5 ,25*hp/maxhp, 3);
			} else if (type==12) {
				g.fillRect(x + xmap - width/2 + 4, y + ymap - height/2 - 5,25*hp/maxhp, 3);
			} 
			g.drawImage(animation.getImage(), x + xmap - width/2, y + ymap - height/2, null);
			for (int i = 0;i<bullets.size();i++) {
				bullets.get(i).render(g);
			}
		}	
	}
}
