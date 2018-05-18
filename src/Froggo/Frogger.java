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

	public final int WIDTH = 1200, HEIGHT = 720;

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

		g.setColor(Color.green);
		g.fillRect(0, 0, 1200, 700);
		g.setColor(Color.black);
		g.fillRect(0, 50, WIDTH, 270);
		g.setColor(Color.black);
		g.fillRect(0, 370, WIDTH, 270);
		g.setColor(Color.YELLOW);
		g.fillRect(0, 165, WIDTH, HEIGHT / 60);
		g.setColor(Color.YELLOW);
		g.fillRect(0, 185, WIDTH, HEIGHT / 60);
		g.setColor(Color.YELLOW);
		g.fillRect(0, 480, WIDTH, HEIGHT / 60);
		g.setColor(Color.YELLOW);
		g.fillRect(0, 500, WIDTH, HEIGHT / 60);
	}

	public static void main(String[] args) {

		frogger = new Frogger();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}