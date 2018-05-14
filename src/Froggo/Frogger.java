package Froggo;

import javax.swing.JFrame;

public class Frogger {

	public static Frogger frogger;

	public final int WIDTH = 800, HEIGHT = 800;

	public Frogger() {
		
		JFrame jframe = new JFrame();

		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setSize(WIDTH, HEIGHT);
		jframe.setResizable(false);
		jframe.setVisible(true);

	}

	public static void main(String[] args) {
		frogger = new Frogger();
	}

}
