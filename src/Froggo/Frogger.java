package Froggo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.Timer;

public class Frogger implements ActionListener {

	public static Frogger frogger;

	public final int WIDTH = 1000, HEIGHT = 600;

	public Renderer renderer;

	public Frogger() {

		JFrame jframe = new JFrame();

		renderer = new Renderer();

		jframe.add(renderer);
		jframe.setTitle("Frogger");
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setSize(WIDTH, HEIGHT);
		jframe.setResizable(false);
		jframe.setVisible(true);


	}

	public void repaint(Graphics g) {

		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		g.setColor(Color.black);
		g.fillRect(0, 133, WIDTH, HEIGHT / 2);
		
		g.setColor(Color.green);
		g.fillRect(0,  0, WIDTH, HEIGHT / 5);
		
		g.setColor(Color.green);
		g.fillRect(0, 470, WIDTH, HEIGHT / 5);
		
		g.setColor(Color.YELLOW);
		g.fillRect(0, 295, WIDTH, HEIGHT / 45);
		
		g.setColor(Color.YELLOW);
		g.fillRect(0, 275, WIDTH, HEIGHT / 45);
		
	}

	public static void main(String[] args) {

		frogger = new Frogger();
	}

}
