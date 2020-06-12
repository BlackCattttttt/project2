package com.neet.Game.Main;

import javax.swing.JFrame;

public class Windows extends JFrame{
	private static final long serialVersionUID = 1L;

	public Windows() {
		setTitle("Project2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(new GamePanel());
		pack();
		setLocationRelativeTo(null);
//		setResizable(false);
		setVisible(true);
	}
}
