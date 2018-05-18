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

	public boolean gameOver, started;

	public Rectangle frog;

	public Frogger() {

		JFrame jframe = new JFrame();
		Timer timer = new Timer(20, this);

		renderer = new Renderer();

		jframe.add(renderer);
		jframe.setTitle("Frogger");
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setSize(WIDTH, HEIGHT);
		jframe.addMouseListener(this);
		jframe.addKeyListener(this);
		jframe.setResizable(false);
		jframe.setVisible(true);

		frog = new Rectangle(WIDTH / 2 - 10, HEIGHT - 50, 20, 20);

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

		g.setColor(Color.RED);
		g.fillRect(frog.x, frog.y, frog.width, frog.height);
		
	

	}

	public static void main(String[] args) {

		frogger = new Frogger();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (frog.y > HEIGHT - 30) {
			gameOver = true;
		} else if (frog.y < 0) {
			gameOver = true;
		}
		renderer.repaint();

	}

	public void moveUp() {

		if (gameOver) {

			frog = new Rectangle(WIDTH / 2 - 10, HEIGHT - 50, 20, 20);

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

			frog = new Rectangle(WIDTH / 2 - 10, HEIGHT - 50, 20, 20);
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

			frog = new Rectangle(WIDTH / 2 - 10, HEIGHT - 50, 20, 20);
			
			gameOver = false;
			
		}

			gameOver = false;
		
			if (!started) {
				started = true;
			} else if (!gameOver) {
				frog.x += 15;
			}

		}
	


	public void moveLeft() {

		if (gameOver) {

			frog = new Rectangle(WIDTH / 2 - 10, HEIGHT - 50, 20, 20);

			gameOver = false;
		}
		if (!started) {
			started = true;
		} else if (!gameOver) {
			frog.x += -15;
		}
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