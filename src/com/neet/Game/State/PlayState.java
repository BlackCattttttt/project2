package com.neet.Game.State;

import java.awt.Graphics2D;
import java.util.ArrayList;

import com.neet.Game.Main.GamePanel;
import com.neet.Game.Entity.Item;
import com.neet.Game.Entity.Chest;
import com.neet.Game.Entity.Enemies;
import com.neet.Game.Entity.Equip;
import com.neet.Game.Entity.Icon;
import com.neet.Game.Entity.Player;
import com.neet.Game.HUD.Hud;
import com.neet.Game.HUD.InformationState;
import com.neet.Game.HUD.Misson;
import com.neet.Game.HUD.Shop;
import com.neet.Game.Manager.Data;
import com.neet.Game.Manager.KeyHandle;
import com.neet.Game.Manager.Sound;
import com.neet.Game.TileMap.TileMap;

public class PlayState extends GameState{
	private Player player;
	
	private Enemies enemies;
	private ArrayList<Item> items;
	private ArrayList<Equip> equips;
	private ArrayList<Chest> chests;
	private ArrayList<Icon> icons;
	
	private Hud hud;
	private InformationState info;
	private Shop shop;
	private Misson misson;
	
	private TileMap tm;
	
	private int xsector;
	private int ysector;
	private int sectorSize;
	private int map;
	
	private boolean blockInput;
	public static boolean music;

	public PlayState(GameStateManager gsm) {
		super(gsm);
		init();
	}

	@Override
	public void init() {
		map = 1;
		tm = new TileMap(32);
		tm.loadTiles("/Tilesets/tileset" + map + ".png");
		tm.loadMap("/Maps/map" + map + ".txt");
		player = new Player(tm);
		player.setTilePosition(3, 3);
		player.setMap(map);
	    enemies = new Enemies(tm,"/Enemy/map" + map + ".txt");
	    items = new ArrayList<Item>();
	    equips = new ArrayList<Equip>();
	    chests = new ArrayList<Chest>();
	    icons = new ArrayList<Icon>();
		populateItems();
		populateChess();
		
		hud = new Hud(player);
		
		music = true;
		
		// load music
		Sound.load("/Music/bgmusic.mp3", "music1");
		Sound.setVolume("music1", -10);
		Sound.loop("music1", 1000, 1000, Sound.getFrames("music1") - 1000);
		Sound.load("/Music/finish.mp3", "finish");
		Sound.setVolume("finish", -10);
				
		// load sfx
		Sound.load("/SFX/collect.wav", "collect");
		Sound.load("/SFX/mapmove.wav", "mapmove");
		Sound.load("/SFX/tilechange.wav", "tilechange");
		Sound.load("/SFX/splash.wav", "splash");
		
		sectorSize = GamePanel.WIDTH;
		xsector = player.getx() / sectorSize;
		ysector = player.gety() / sectorSize;
		tm.setPositionImmediately(-xsector * sectorSize, -ysector * sectorSize);
	}
    private void populateItems() {
		
		Item item;
		if (map==1) {
			item = new Item(tm);
			item.setType(Item.KEY);
			item.setTilePosition(26, 29);
			items.add(item);
		} else if (map==2) {
			item = new Item(tm);
			item.setType(Item.KEY);
			item.setTilePosition(29, 25);
			items.add(item);
		} else if (map==3) {
			item = new Item(tm);
			item.setType(Item.KEY);
			item.setTilePosition(20, 7);
			items.add(item);
		} else if (map==4) {
			item = new Item(tm);
			item.setType(Item.KEY);
			item.setTilePosition(10, 13);
			items.add(item);
		} else if (map==5) {
			item = new Item(tm);
			item.setType(Item.KEY);
			item.setTilePosition(25, 29);
			items.add(item);
		}
		
	}
    private void populateChess() {
    	Chest chest;
    	if (map==1) {
    		chest = new Chest(tm);
    		chest.setTilePosition(26, 26);
    		chests.add(chest);
    		chest = new Chest(tm);
    		chest.setTilePosition(38, 1);
    		chests.add(chest);
    		chest = new Chest(tm);
    		chest.setTilePosition(3, 22);
    		chests.add(chest);
    		chest = new Chest(tm);
    		chest.setTilePosition(14, 26);
    		chests.add(chest);
    		chest = new Chest(tm);
    		chest.setTilePosition(14, 30);
    		chests.add(chest);
    		chest = new Chest(tm);
    		chest.setTilePosition(14, 21);
    		chests.add(chest);
    		chest = new Chest(tm);
    		chest.setTilePosition(18, 18);
    		chests.add(chest);
    		chest = new Chest(tm);
    		chest.setTilePosition(18, 21);
    		chests.add(chest);
    		chest = new Chest(tm);
    		chest.setTilePosition(21, 38);
    		chests.add(chest);
    		chest = new Chest(tm);
    		chest.setTilePosition(18, 26);
    		chests.add(chest);
    		chest = new Chest(tm);
    		chest.setTilePosition(14, 35);
    		chests.add(chest);
    	}
    	if (map==2) {
    		chest = new Chest(tm);
    		chest.setTilePosition(24, 23);
    		chests.add(chest);
    		chest = new Chest(tm);
    		chest.setTilePosition(21, 22);
    		chests.add(chest);
    		chest = new Chest(tm);
    		chest.setTilePosition(10, 28);
    		chests.add(chest);
    		chest = new Chest(tm);
    		chest.setTilePosition(6, 10);
    		chests.add(chest);
    		chest = new Chest(tm);
    		chest.setTilePosition(27, 38);
    		chests.add(chest);
    		chest = new Chest(tm);
    		chest.setTilePosition(37, 33);
    		chests.add(chest);
    	} else if (map==3) {
    		chest = new Chest(tm);
    		chest.setTilePosition(35, 20);
    		chests.add(chest);
    		chest = new Chest(tm);
    		chest.setTilePosition(20, 6);
    		chests.add(chest);
    		chest = new Chest(tm);
    		chest.setTilePosition(23, 13);
    		chests.add(chest);
    		chest = new Chest(tm);
    		chest.setTilePosition(5, 25);
    		chests.add(chest);
    		chest = new Chest(tm);
    		chest.setTilePosition(25, 33);
    		chests.add(chest);
    		chest = new Chest(tm);
    		chest.setTilePosition(33, 30);
    		chests.add(chest);
    		chest = new Chest(tm);
    		chest.setTilePosition(27, 23);
    		chests.add(chest);
    		chest = new Chest(tm);
    		chest.setTilePosition(36, 14);
    		chests.add(chest);
    	} else if (map==4) {
    		chest = new Chest(tm);
    		chest.setTilePosition(21, 18);
    		chests.add(chest);
    		chest = new Chest(tm);
    		chest.setTilePosition(26, 35);
    		chests.add(chest);
    		chest = new Chest(tm);
    		chest.setTilePosition(27, 36);
    		chests.add(chest);
    		chest = new Chest(tm);
    		chest.setTilePosition(36, 14);
    		chests.add(chest);
    		chest = new Chest(tm);
    		chest.setTilePosition(33, 22);
    		chests.add(chest);
    		chest = new Chest(tm);
    		chest.setTilePosition(10, 14);
    		chests.add(chest);
    		chest = new Chest(tm);
    		chest.setTilePosition(22, 28);
    		chests.add(chest);
    		chest = new Chest(tm);
    		chest.setTilePosition(6, 33);
    		chests.add(chest);
    		chest = new Chest(tm);
    		chest.setTilePosition(33, 26);
    		chests.add(chest);
    		chest = new Chest(tm);
    		chest.setTilePosition(22, 33);
    		chests.add(chest);
    	} else if (map==5) {
    		chest = new Chest(tm);
    		chest.setTilePosition(25, 27);
    		chests.add(chest);
    		chest = new Chest(tm);
    		chest.setTilePosition(19, 21);
    		chests.add(chest);
    		chest = new Chest(tm);
    		chest.setTilePosition(22, 29);
    		chests.add(chest);
    		chest = new Chest(tm);
    		chest.setTilePosition(27, 38);
    		chests.add(chest);
    		chest = new Chest(tm);
    		chest.setTilePosition(27, 34);
    		chests.add(chest);
    		chest = new Chest(tm);
    		chest.setTilePosition(14, 10);
    		chests.add(chest);
    		chest = new Chest(tm);
    		chest.setTilePosition(14, 14);
    		chests.add(chest);
    		chest = new Chest(tm);
    		chest.setTilePosition(20, 14);
    		chests.add(chest);
    		chest = new Chest(tm);
    		chest.setTilePosition(20, 11);
    		chests.add(chest);
    	}
	}

	@Override
	public void update() {
		if ((info!=null && info.isLive()) || (shop!=null && shop.isLive()) || (misson!=null && misson.isLive())) {
			return;
		}
		if (!music) {
			Sound.stop("music1");
		} else {
			Sound.resume("music1");
		}
		int oldxs = xsector;
		int oldys = ysector;
		xsector = player.getx() / sectorSize;
		ysector = player.gety() / sectorSize;
		tm.setPosition(-xsector * sectorSize, -ysector * sectorSize);
		tm.update();
		
		if(oldxs != xsector || oldys != ysector) {
			if (music) {
				Sound.play("mapmove");
			}
		}

		player.update();
		player.hitBullet(enemies);
		
		if (player.getHp()<0) {
			gsm.addAndpop(GameStateManager.GAMEOVER);
		}
		evenFinish();
		for (int i=0;i<enemies.enemies.size();i++) {
			enemies.enemies.get(i).update(player,items,equips,icons);	
		}
		for(int i = 0; i < items.size(); i++) {
			Item item = items.get(i);
			if(player.intersects(item)) {
				items.remove(i);
				i--;
				item.collected(player);
				if (music) {
					Sound.play("collect");
				}
			}
		}
		for(int i = 0; i < equips.size(); i++) {
			Equip equip = equips.get(i);
			if(player.intersects(equip)) {
				equips.remove(i);
				i--;
				equip.collected(player);
				if (music) {
					Sound.play("collect");
				}
			}
		}
		for(int i = 0; i < icons.size(); i++) {
			Icon icon = icons.get(i);
			if(player.intersects(icon)) {
				icons.remove(i);
				i--;
				icon.collected(player);
				if (music) {
					Sound.play("collect");
				}
			}
		}
		for(int i = 0; i < chests.size(); i++) {
			Chest chest = chests.get(i);
			if(chest.getType()==Chest.CLOSE && player.intersects(chest)) {
				i--;
				chest.collected(player);
				tm.setTile(chest.gety()/tm.getTileSize(), chest.getx()/tm.getTileSize(), 31);
				if (music) {
					Sound.play("collect");
				}
			}
		}
	}

	@Override
	public void render (Graphics2D g) {
		tm.render(g);
		player.render(g);
		for (int i=0;i<enemies.enemies.size();i++) {
			enemies.enemies.get(i).render(g);
		}
		for(Item i : items) {
			i.render(g);
		}
		for(Equip i : equips) {
			i.render(g);
		}
		for(Icon i : icons) {
			i.render(g);
		}
		for(Chest i : chests) {
			i.render(g);
		}
		hud.render(g);
		if (info!=null && info.isLive()) {
			info.render(g);
		}
		if (shop!=null && shop.isLive()) {
			shop.render(g);
		}
		if (misson!=null && misson.isLive()) {
			misson.render(g);
		}
	}

	@Override
	public void input() {
		if (KeyHandle.isPressed(KeyHandle.PAUSE)) {
			Sound.stop("music1");
			gsm.setPaused(true);
			GameStateManager.pauseState.init(player);
		}	
		if (KeyHandle.isPressed(KeyHandle.F1)) {
			if (music) music = false;
		    else music = true;
		}
		if (KeyHandle.isPressed(KeyHandle.INFOR)) {
			info = new InformationState(player);
		} else if (KeyHandle.isPressed(KeyHandle.SHOP)) {
//			gsm.setPause(true);
			shop = new Shop(player);
		} else if (KeyHandle.isPressed(KeyHandle.MISSON)) {
			misson = new Misson(player);
		} 
		if (info!=null && info.isLive()) {
			blockInput = true;
			info.input();
		} else if (shop!=null && shop.isLive()) {
			blockInput = true;
			shop.input();
		} else if (misson!=null && misson.isLive()) {
			blockInput = true;
			misson.input();
		} else {
			blockInput = false;
		}
		if(blockInput) return;
		player.input();
	}

	public void evenFinish () {
		if (player.getKey()==1) {
			if (map==1) {
				player.setTilePosition(3, 3);
			} else if (map==2) {
				player.setTilePosition(3, 3);
			} else if (map==3) {
				player.setTilePosition(3, 3);
			} else if (map==4) {
				player.setTilePosition(35, 34);
			} else {
				Sound.stop("music1");
				Sound.play("finish");
				Data.setTime(player.getTicks());
				gsm.addAndpop(GameStateManager.GAMEWIN);
			}
			if (map<5) {
				player.setKill(0);
				player.setIcon(0);
				player.setKey(0);
				map++;
				player.setMap(map);
				items.clear();
				equips.clear();
				icons.clear();
				chests.clear();
				tm.loadTiles("/Tilesets/tileset" + map + ".png");
				tm.loadMap("/Maps/map" + map + ".txt");
				populateChess();
				populateItems();
				enemies = new Enemies(tm,"/Enemy/map" + map + ".txt");
			}		
		}		
	}
}
