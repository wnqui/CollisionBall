import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/*
 * Random collision practice of the ball
 */

public class CollisionBall implements ActionListener, KeyListener {
	// variable
	public static final int WIDTH = 800;
	public static final int HEIGHT = 800;
	public static final int UP_Y = 70;
	public static final int DN_Y = HEIGHT - 170 + 70;
	public static final int L_X = 50;
	public static final int R_X = WIDTH - 2 * L_X + 50;
	// object
	public static JFrame JF;
	public static myJpanel MP;
	public static CollisionBall CB;
	public static ArrayList<Ball> balls = new ArrayList<Ball>();

	// control

	public CollisionBall() {
		JF = new JFrame("Collision Ball");
		MP = new myJpanel();
		JF.setBounds(100, 100, WIDTH, HEIGHT);
		JF.setVisible(true);
		JF.setResizable(false);
		JF.setAlwaysOnTop(true);
		JF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JF.add(MP);
		JF.addKeyListener(this);

		Timer T = new Timer(20, this);
		T.start();

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		for (int i = 0; i < balls.size(); i++) {

			balls.get(i).run(balls);

		}

		MP.repaint();

	}

	// draw
	public void repaint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(3));
		// 白底
		g2.setColor(Color.white);
		g2.fillRect(0, 0, WIDTH, HEIGHT);
		// 邊線
		g2.setColor(Color.black);
		g2.drawRect(L_X, UP_Y, R_X - 50, DN_Y - 70);
		// 提示文字
		g2.setColor(Color.GRAY);
		g2.setFont(new Font("", 1, 20));
		g2.drawString("type A add one           type D delete one           type R random all", 50, 65);

		for (int i = 0; i < balls.size(); i++) {
			balls.get(i).drawBall(g2);
		}

	}

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			int x = (int) (Math.random() * 500 + 100);
			int y = (int) (Math.random() * 500 + 100);
			int s = (int) (Math.random() * 30 + 30);
			balls.add(new Ball(x, y, s));
		}
		CB = new CollisionBall();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_A) {
			int x = (int) (Math.random() * 500 + 100);
			int y = (int) (Math.random() * 500 + 100);
			int s = (int) (Math.random() * 30 + 30);
			balls.add(new Ball(x, y, s));
		}
		if (e.getKeyCode() == KeyEvent.VK_D) {
			if (balls.size() >= 1) {
				balls.remove(0);
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_R) {
			for (int i = 0; i < balls.size(); i++) {
				balls.get(i).reset();
			}
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

//end
}

class myJpanel extends JPanel {
	private static final long serialVersionUID = 1L;

	public void paintComponent(Graphics g) {
		CollisionBall.CB.repaint(g);
	}

}