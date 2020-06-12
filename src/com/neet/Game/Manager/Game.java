package com.neet.Game.Manager;

import com.neet.Game.Entity.Player;

public class Game {
	private String name;
	private String hp;
	private String mn;
	private String exp;
	private int level;
	private String atkdef;
	private String critarp;
	private String hat;
	private String armor;
	private String scepter;
	private String shoe;
	private String item;
	private int mission;
	private int time;
	private int map;
	private String rowcol;
	public Game(String name, String hp, String mn, String exp, int level, String atkdef, String critarp, String hat,
			String armor, String scepter, String shoe, String item, int mission, int time, int map, String rowcol) {
		super();
		this.name = name;
		this.hp = hp;
		this.mn = mn;
		this.exp = exp;
		this.level = level;
		this.atkdef = atkdef;
		this.critarp = critarp;
		this.hat = hat;
		this.armor = armor;
		this.scepter = scepter;
		this.shoe = shoe;
		this.item = item;
		this.mission = mission;
		this.time = time;
		this.map = map;
		this.rowcol = rowcol;
	}
	public Game (String s,Player p) {
		this.name = s;
		this.hp = p.getHp() + "/" + p.getMaxhp();
		this.mn = p.getMn() + "/" + p.getMaxmn();
		this.exp = p.getExp() + "/" + p.getMaxexp();
		this.level = p.getLv();
		this.atkdef = p.getAtk() + "/" + p.getDef();
		this.critarp = p.getCritical() + "/" + p.getArp();
		this.hat = p.currentHat + "/" + p.hat[1] + "/" + p.hat[2] + "/" + p.hat[3];
		this.armor = p.currentArmor + "/" + p.armor[1] + "/" + p.armor[2] + "/" + p.armor[3];
		this.scepter = p.currentScepter + "/" + p.scepter[1] + "/" + p.scepter[2] + "/" + p.scepter[3];
		this.shoe = p.currentShoe + "/" + p.shoe[1] + "/" + p.shoe[2] + "/" + p.shoe[3];
		this.item = p.getBinhmau() + "/" + p.getGold() + "/" + p.getKey();
		this.mission = p.getMission();
		this.time = (int) p.getTicks();
		this.map = p.getMap();
		this.rowcol = p.getRow() + "/" + p.getCol();
	}
	public int[] detachedTwo (String s) {
		int[] a = new int[2];
		String delims = "/";
		String token[] = s.split(delims);
		a[0] = Integer.parseInt(token[0]);
		a[1] = Integer.parseInt(token[1]);
		return a;
	}
	public int[] detachedThree (String s) {
		int[] a = new int[3];
		String delims = "/";
		String token[] = s.split(delims);
		a[0] = Integer.parseInt(token[0]);
		a[1] = Integer.parseInt(token[1]);
		a[2] = Integer.parseInt(token[2]);
		return a;
	}
	public int[] detachedFour (String s) {
		int[] a = new int[4];
		String delims = "/";
		String token[] = s.split(delims);
		a[0] = Integer.parseInt(token[0]);
		a[1] = Integer.parseInt(token[1]);
		a[2] = Integer.parseInt(token[2]);
		a[3] = Integer.parseInt(token[3]);
		return a;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHp() {
		return hp;
	}
	public void setHp(String hp) {
		this.hp = hp;
	}
	public String getMn() {
		return mn;
	}
	public void setMn(String mn) {
		this.mn = mn;
	}
	public String getExp() {
		return exp;
	}
	public void setExp(String exp) {
		this.exp = exp;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getAtkdef() {
		return atkdef;
	}
	public void setAtkdef(String atkdef) {
		this.atkdef = atkdef;
	}
	public String getCritarp() {
		return critarp;
	}
	public void setCritarp(String critarp) {
		this.critarp = critarp;
	}
	public String getHat() {
		return hat;
	}
	public void setHat(String hat) {
		this.hat = hat;
	}
	public String getArmor() {
		return armor;
	}
	public void setArmor(String armor) {
		this.armor = armor;
	}
	public String getScepter() {
		return scepter;
	}
	public void setScepter(String scepter) {
		this.scepter = scepter;
	}
	public String getShoe() {
		return shoe;
	}
	public void setShoe(String shoe) {
		this.shoe = shoe;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public int getMission() {
		return mission;
	}
	public void setMission(int mission) {
		this.mission = mission;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public int getMap() {
		return map;
	}
	public void setMap(int map) {
		this.map = map;
	}
	public String getRowcol() {
		return rowcol;
	}
	public void setRowcol(String rowcol) {
		this.rowcol = rowcol;
	}
	
	
}
