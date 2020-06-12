package com.neet.Game.Main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import com.neet.Game.Manager.KeyHandle;
import com.neet.Game.State.GameStateManager;

public class GamePanel extends JPanel implements Runnable,KeyListener{

	public static final int WIDTH = 256;
	public static final int HEIGHT = 256;
	public static final int HEIGHT2 = HEIGHT + 32;
	public static final int SCALE = 2;
	private static final long serialVersionUID = 1L;
	
	private Thread thread;
	private boolean running;
	private final int FPS = 60;
	private final int TARGET_TIME = 1000 / FPS;
	
	private BufferedImage img;
	private Graphics2D g;
	
	private GameStateManager gsm;
	
	public GamePanel() {
		setPreferredSize(new Dimension(WIDTH*SCALE,HEIGHT2*SCALE));
		setFocusable(true);
		requestFocus();
	}
    public void addNotify() {
		super.addNotify();
		if (thread==null) {
			addKeyListener(this);
			thread = new Thread(this);
			thread.start();
		}
	}
    public void init() {
    	running = true;
    	gsm = new GameStateManager();
    	img = new BufferedImage(WIDTH, HEIGHT2, BufferedImage.TYPE_INT_ARGB);
    	g = (Graphics2D) img.getGraphics();
    }
	@Override
	public void run() {
		init();
		long start;
		long elapsed;
		long wait;
		
		while (running) {
		    start = System.nanoTime();
			input();
			update();
			render();
			draw();
			elapsed = System.nanoTime() - start;
			wait = TARGET_TIME - elapsed/1000000;
			if (wait <0) wait = TARGET_TIME;
			
			try {
				Thread.sleep(wait);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void update () {
		gsm.update();
		KeyHandle.update();
	}
	public void input() {
		gsm.input();
	}
    public void render () {
		if (g!=null) {
			gsm.render(g);
		}
    	
	}
    public void draw () {
    	Graphics g2 = (Graphics) this.getGraphics();
    	g2.drawImage(img, 0, 0, WIDTH*SCALE, HEIGHT2*SCALE, null);
    	g2.dispose();
    }
    @Override
	public void keyPressed(KeyEvent e) {
		KeyHandle.keySet(e.getKeyCode(), true);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		KeyHandle.keySet(e.getKeyCode(), false);
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
