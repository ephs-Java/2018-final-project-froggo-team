package notes;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.Timer;

public class Frogger implements ActionListener, MouseListener, KeyListener {

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
		jframe.setTitle("Game");
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setSize(WIDTH, HEIGHT);
		jframe.addMouseListener(this);
		jframe.addKeyListener(this);
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

		g.setColor(Color.white);
		g.fillRect(car.x, car.y, car.width, car.height);

	}

	public void moveUp() {

		if (gameOver) {

			frog = new Rectangle(WIDTH / 2 - 10, HEIGHT / 2 - 10, 20, 20);
			car.clear();

			addCar(true);
			addCar(true);
			addCar(true);
			addCar(true);

			gameOver = false;
		}
		if (!started) {
			started = true;
		} else if (!gameOver) {
			frog.y += -15;
		}
	}

	public void moveDown() {

		if (gameOver) {

			frog = new Rectangle(WIDTH / 2 - 10, HEIGHT / 2 - 10, 20, 20);
			car.clear();

			addCar(true);
			addCar(true);
			addCar(true);
			addCar(true);

			gameOver = false;
		}
		if (!started) {
			started = true;
		} else if (!gameOver) {
			frog.y += 15;
		}
	}

	public void moveRight() {

		if (gameOver) {

			frog = new Rectangle(WIDTH / 2 - 10, HEIGHT / 2 - 10, 20, 20);
			car.clear();

			addCar(true);
			addCar(true);
			addCar(true);
			addCar(true);

			gameOver = false;
		}
		if (!started) {
			started = true;
		} else if (!gameOver) {
			frog.x = 15;
		}
	}

	public void moveLeft() {

		if (gameOver) {

			frog = new Rectangle(WIDTH / 2 - 10, HEIGHT / 2 - 10, 20, 20);
			car.clear();

			addCar(true);
			addCar(true);
			addCar(true);
			addCar(true);

			gameOver = false;
		}
		if (!started) {
			started = true;
		} else if (!gameOver) {
			frog.x += -15;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int speed = 15;
		if (started) {
			for (int i = 0; i < car.size(); i++) {
				Rectangle Car = car.get(i);
				Car.x -= speed;
			}
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

		for (Rectangle Car : car) {
			if (Car.intersects(frog)) {
				gameOver = true;
				frog.x = Car.x - frog.width;
			}
		}

		if (frog.y > HEIGHT - 120) {
			gameOver = true;
		} else if (frog.y < 0) {
			gameOver = true;
		}
		if (gameOver) {
			frog.y = HEIGHT - 120 - frog.height;
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

		g.setColor(Color.white);
		g.setFont(new Font("Arial", 4, WIDTH - HEIGHT - 350));

		if (!started) {
			g.drawString("Click a difficulty to Start!", WIDTH / 2 - 300, HEIGHT / 2 - 200);
			g.drawString("Easy", WIDTH / 2 - 100, HEIGHT / 2 - 100);
			g.drawString("Medium", WIDTH / 2 - 100, HEIGHT / 2);
			g.drawString("Hard", WIDTH / 2 - 100, HEIGHT / 2 + 100);
		}

		if (gameOver) {
			g.setFont(new Font("Arial", 4, WIDTH - HEIGHT - 250));
			g.drawString("Game Over!", WIDTH / 4 - 150, HEIGHT / 2 - 50);
		}
	}

	public static void main(String[] args) {
		frogger = new Frogger();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		started = true;
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			moveUp();
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			moveDown();
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			moveRight();
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			moveLeft();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

}
