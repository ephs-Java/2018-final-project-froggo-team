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

	public final int WIDTH = 1000, HEIGHT = 600;

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

		frog = new Rectangle(WIDTH / 2 - 10, HEIGHT / 2 - 10, 20, 20);
		
		timer.start();
	}

	public void repaint(Graphics g) {
		g.setColor(Color.green);
		g.fillRect(0, 0, 1000, 1000);
		
		g.setColor(Color.black);
		g.fillRect(0, 100, WIDTH, 375);
		
		g.setColor(Color.YELLOW);
		g.fillRect(0, 290, WIDTH, HEIGHT / 45);
		g.setColor(Color.YELLOW);
		g.fillRect(0, 270, WIDTH, HEIGHT / 45);
		
		g.setColor(Color.RED);
		g.fillRect(frog.x, frog.y, frog.width, frog.height);
		
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
	public void actionPerformed(ActionEvent e) {
		if (frog.y > HEIGHT - 120) {
			gameOver = true;
		} else if (frog.y < 0) {
			gameOver = true;
		}
		renderer.repaint();

	}

	public void moveUp() {

		if (gameOver) {

			frog = new Rectangle(WIDTH / 2 - 10, HEIGHT / 2 - 10, 20, 20);

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

			if (!started) {
				started = true;
			} else if (!gameOver) {
				frog.x += 15;
			}
		}
	}

	public void moveLeft() {

		if (gameOver) {

			frog = new Rectangle(WIDTH / 2 - 10, HEIGHT / 2 - 10, 20, 20);

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