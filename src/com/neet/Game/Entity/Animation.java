package com.neet.Game.Entity;

import java.awt.image.BufferedImage;

public class Animation {
	private BufferedImage[] frames;
	private int numFrames;
	private int currentFrame;
	
	private int count;
	private int delay;
	
	private int timePlayed;
	
	public Animation () {
		timePlayed = 0;
	}
	public void setFrames (BufferedImage[] frames) {
		this.frames = frames;
		count = 0;
		currentFrame = 0;
		timePlayed = 0;
		delay = 2;
		numFrames = frames.length;
	}
	public void setDelay(int delay) {
		this.delay = delay;
	}
	public void setFrame (int i) {
		this.currentFrame = i;
	}
	public void setNumFrame (int i) {
		this.numFrames = i;
	}
	public void update () {
		if (delay == -1) return ;
		count++;
		if (count == delay) {
			currentFrame ++;
			count = 0;
		}
		if (currentFrame == numFrames) {
			currentFrame = 0;
			timePlayed++;
		}
	}
	public BufferedImage getImage() {
		return frames[currentFrame];
	}
	public int getCount() {
		return count;
	}
	public int getDelay() {
		return delay;
	}
	public int getTimePlayed() {
		return timePlayed;
	}
	public boolean hasPlayedOnce () {
		return timePlayed>0;
	}
	public  boolean hasPlayed(int i) {
		return timePlayed == i;
	}
}
