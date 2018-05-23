package Froggo;

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

	public final int WIDTH = 1200, HEIGHT = 720;

	public Renderer renderer;

	public Random rand;

	public ArrayList<Rectangle> car;

	public boolean gameOver, started, youWin;

	public Rectangle frog;

	public static void main(String[] args) {

		frogger = new Frogger();
	}

	public Frogger() {

		JFrame jframe = new JFrame();
		Timer timer = new Timer(20, this);

		renderer = new Renderer();
		rand = new Random();

		jframe.add(renderer);
		jframe.setTitle("Frogger");
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setSize(WIDTH, HEIGHT);
		jframe.addMouseListener(this);
		jframe.addKeyListener(this);
		jframe.setResizable(false);
		jframe.setVisible(true);

		frog = new Rectangle(WIDTH / 2 - 10, HEIGHT - 75, 20, 20);
		car = new ArrayList<Rectangle>();

		addCarRight(true);
	    addCarRight(true);
		addCarRight(true);
		addCarRight(true);
		addCarRight(true);

		addCarLeft(true);
		addCarLeft(true);
		addCarLeft(true);
		addCarLeft(true);

		timer.start();
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

		for (Rectangle Car : car) {
			paintCar(g, Car);
		}

		g.setColor(Color.RED);
		g.fillRect(frog.x, frog.y, frog.width, frog.height);

		if (gameOver) {
			g.setColor(Color.RED);
			g.setFont(new Font("Arial", 4, WIDTH - HEIGHT - 300));
			g.drawString("Game Over!", WIDTH / 4 - 200, HEIGHT / 2 - 50);
		} else if (youWin) {
			g.setColor(Color.CYAN);
			g.setFont(new Font("Arial", 4, WIDTH - HEIGHT - 300));
			g.drawString("You Win!", WIDTH / 4 - 200, HEIGHT / 2 - 50);
		}
	}

	public void moveUp() {

		if (gameOver) {

			frog = new Rectangle(WIDTH / 2 - 10, HEIGHT - 75, 20, 20);

			gameOver = false;
		}
		if (!started) {
			started = true;
		} else if (!gameOver) {
			frog.y += -20;
		}
	}

	public void moveDown() {

		if (gameOver) {

			frog = new Rectangle(WIDTH / 2 - 10, HEIGHT - 75, 20, 20);

			gameOver = false;
		}
		if (!started) {
			started = true;
		} else if (!gameOver) {
			frog.y += 20;
		}
	}

	public void moveRight() {

		if (gameOver) {

			frog = new Rectangle(WIDTH / 2 - 10, HEIGHT - 75, 20, 20);

			gameOver = false;
		}
		if (!started) {
			started = true;
		} else if (!gameOver) {
			frog.x += 20;
		}
	}

	public void moveLeft() {

		if (gameOver) {

			frog = new Rectangle(WIDTH / 2 - 10, HEIGHT - 75, 20, 20);

			gameOver = false;
		}
		if (!started) {
			started = true;
		} else if (!gameOver) {
			frog.x += -20;
		}
	}

	public void click() {

		if (gameOver) {

			frog = new Rectangle(WIDTH / 2 - 10, HEIGHT - 75, 20, 20);

			gameOver = false;
		}
		if (!started) {
			started = true;
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		int speed = 15;
		if (started) {
			for (int i = 0; i < car.size(); i++) {
				Rectangle Car = car.get(i);
				if(Car.x)
			}
		}
		for (int i = 0; i < car.size(); i++) {
			Rectangle Car = car.get(i);
			if (Car.x + Car.width < 0) {
				car.remove(Car);

				if (Car.y == 0) {
					addCarRight(false);
				}

			}
		}

		for (Rectangle Car : car) {
			if (Car.intersects(frog)) {
				gameOver = true;
				frog.x = Car.x - frog.width;
			}
		}

		if (frog.y > HEIGHT - 60) {
			gameOver = true;
		} else if (frog.y < 0) {
			youWin = true;
		} else if (frog.x < 0) {
			gameOver = true;
		} else if (frog.x > WIDTH - 35) {
			gameOver = true;
		}
		renderer.repaint();

	}

	public void addCarRight(boolean start) {

		int width = 100;
		int height = 50;
		int r = 50 + rand.nextInt(300);

		car.add(new Rectangle(WIDTH + width + car.size() * 300 + r - 300, HEIGHT - height - 270, width, height));
		car.add(new Rectangle(WIDTH + width + car.size() * 300 + r - 900, HEIGHT - height - 590, width, height));
		car.add(new Rectangle(WIDTH + width + (car.size() - 1) * 300, 0, 0, height));

		car.add(new Rectangle(car.get(car.size() - 1).x + r, HEIGHT - height - 270, width, height));
		car.add(new Rectangle(car.get(car.size() - 1).x - r, HEIGHT - height - 590, width, height));
		car.add(new Rectangle(car.get(car.size() - 1).x, 0, 0, height));

	}

	public void addCarLeft(boolean start) {

		int width = 100;
		int height = 50;
		int r = 50 + rand.nextInt(300);
		
		
			car.add(new Rectangle(WIDTH + width + car.size() * 300 - r, HEIGHT - height - 120, width, height));
			car.add(new Rectangle(WIDTH + width + car.size() * 300 + r, HEIGHT - height - 270, width, height));
			car.add(new Rectangle(WIDTH + width + car.size() * 300 - r, HEIGHT - height - 435, width, height));
			car.add(new Rectangle(WIDTH + width + car.size() * 300 + r, HEIGHT - height - 590, width, height));
			car.add(new Rectangle(WIDTH + width + (car.size() - 1) * 300, 0, 0, height));

		car.add(new Rectangle(0 - width - r, HEIGHT - height - 120, width, height));
		car.add(new Rectangle(0 - width - r - 600, HEIGHT - height - 435, width, height));
		car.add(new Rectangle(WIDTH + width + (car.size() - 1) * 300, 0, 0, height));

		car.add(new Rectangle(car.get(car.size() - 1).x + 600, HEIGHT - height - 120, width, height));
		car.add(new Rectangle(car.get(car.size() - 1).x - r, HEIGHT - height - 435, width, height));
		car.add(new Rectangle(car.get(car.size() - 1).x, 0, 0, height));


	}
		
	

	public void paintCar(Graphics g, Rectangle car) {

		g.setColor(Color.white);
		g.fillRect(car.x, car.y, car.width, car.height);

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		click();
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
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			moveLeft();
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			moveRight();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

}