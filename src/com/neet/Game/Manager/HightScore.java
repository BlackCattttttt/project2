package com.neet.Game.Manager;

public class HightScore {
	private int time;
	private String name;
	
	
	public HightScore() {
		super();
	}

	public HightScore (int time,String name) {
		this.time = time;
		this.name = name;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
