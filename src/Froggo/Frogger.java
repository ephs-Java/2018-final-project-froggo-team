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

	public final int WIDTH = 1200, HEIGHT = 800;

	public Renderer renderer;

	public boolean gameOver, started = true;

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

		g.setColor(Color.blue);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
	}

	public static void main(String[] args) {

		frogger = new Frogger();
	}

}
