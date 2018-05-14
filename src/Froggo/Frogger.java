package Froggo;

import java.awt.Color;
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

	public final int WIDTH = 800, HEIGHT = 800;

	public Renderer renderer;

	public Rectangle frog;

	public ArrayList<Rectangle> car;

	public Random rand;

	public Frogger() {

		JFrame jframe = new JFrame();
		Timer timer = new Timer(20, this);

		renderer = new Renderer();
		rand = new Random();

		jframe.add(renderer);
		jframe.setTitle("Frogger");
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setSize(WIDTH, HEIGHT);
		jframe.setResizable(false);
		jframe.setVisible(true);

		frog = new Rectangle(WIDTH / 2 - 10, HEIGHT / 2 - 10, 20, 20);
		car = new ArrayList<Rectangle>();

		timer.start();

	}

	public void addCar() {

		int space = 300;
		int width = 100;
		int height = 50 + rand.nextInt(300);

		car.add(new Rectangle(WIDTH + width + car.size() * 300, HEIGHT - height));

	}

	public void paintCar(Graphics g, Rectangle car) {

		g.setColor(Color.red);
		g.fillRect(car.x, car.y, car.width, car.height);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		renderer.repaint();
	}

	public void repaint(Graphics g) {

		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);

		g.setColor(Color.orange);
		g.fillRect(0, HEIGHT - 120, WIDTH, 120);

		g.setColor(Color.green);
		g.fillRect(frog.x, frog.y, frog.width, frog.height);
	}

	public static void main(String[] args) {

		frogger = new Frogger();
	}

}
