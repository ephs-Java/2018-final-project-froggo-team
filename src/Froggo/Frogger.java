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

	public final int WIDTH = 1200, HEIGHT = 800;

	public Renderer renderer;

	public Rectangle frog;

	public int ticks, xMotion, yMotion;

	public ArrayList<Rectangle> car;

	public boolean gameOver, started;

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

		addCar(true);
		addCar(true);
		addCar(true);
		addCar(true);

		timer.start();

	}

	public void addCar(boolean start) {

		int space = 300;
		int width = 100;
		int height = 50 + rand.nextInt(300);

		if (start) {
			car.add(new Rectangle(WIDTH + width + car.size() * 300, HEIGHT - height - 120, width, height));
			car.add(new Rectangle(WIDTH + width + (car.size() - 1) * 300, 0, width, HEIGHT - height - space));
		} else {
			car.add(new Rectangle(car.get(car.size() - 1).x + 600, HEIGHT - height - 120, width, height));
			car.add(new Rectangle(car.get(car.size() - 1).x, 0, width, HEIGHT - height - space));
		}

	}

	public void paintCar(Graphics g, Rectangle car) {

		g.setColor(Color.red);
		g.fillRect(car.x, car.y, car.width, car.height);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		int speed = 10;

		ticks++;

		if (started) {
			for (int i = 0; i < car.size(); i++) {
				Rectangle Car = car.get(i);
				Car.x -= speed;
			}

			if (ticks % 2 == 0 && yMotion < 15 && xMotion < 15) {
				yMotion += 2;
				xMotion += 2;
			}

			for (int i = 0; i < car.size(); i++) {
				Rectangle Car = car.get(i);

				if (Car.x + Car.width < 0) {
					car.remove(Car);

					if (Car.y == 0) {
						addCar(false);
					}
				}
			}

			frog.y += yMotion;
			frog.x += xMotion;

			for (Rectangle Car : car) {
				if (Car.intersects(frog)) {
					gameOver = true;
				}
			}

			if (frog.y > HEIGHT - 120) {
				gameOver = true;
			}
		}
		renderer.repaint();
	}

	public void repaint(Graphics g) {

		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);

		g.setColor(Color.orange);
		g.fillRect(0, HEIGHT - 120, WIDTH, 120);

		g.setColor(Color.green);
		g.fillRect(frog.x, frog.y, frog.width, frog.height);

		for (Rectangle Car : car) {
			paintCar(g, Car);
		}
	}

	public static void main(String[] args) {

		frogger = new Frogger();
	}

}
