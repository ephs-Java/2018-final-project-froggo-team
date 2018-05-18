package Froggo;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

public class Frogger {

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

g.setColor(Color.green);
g.fillRect(0, 0, 1000, 1000);
g.setColor(Color.black);
g.fillRect(0, 100, WIDTH, 375);
g.setColor(Color.YELLOW);
g.fillRect(0, 290, WIDTH, HEIGHT / 45);
g.setColor(Color.YELLOW);
g.fillRect(0, 270, WIDTH, HEIGHT / 45);
}

public static void main(String[] args) {

frogger = new Frogger();
}


}