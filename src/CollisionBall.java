import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/*
 * Random collision practice of the ball
 */

public class CollisionBall implements ActionListener {
	//variable
	public static final int WIDTH =800;
	public static final int HEIGHT = 800;
	//object
	public static JFrame JF;
	public static myJpanel	MP;
	public static CollisionBall CB;
	public ArrayList<Ball>ball = new ArrayList<Ball>();
	//control

	public CollisionBall() {
		JF = new JFrame("Collision Ball");
		MP = new myJpanel();
		JF.setBounds(100, 100, WIDTH, HEIGHT);
		JF.setVisible(true);
		JF.setResizable(false);
		JF.setAlwaysOnTop(true);
		JF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JF.add(MP);
		
		
		Timer T = new Timer(20,this);
		T.start();
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		
		
		MP.repaint();
		
	}
	//draw 
	public void repaint(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		g2.setStroke(new BasicStroke(3));
		//¥Õ©³
		g2.setColor(Color.white);
		g2.fillRect(0, 0, WIDTH, HEIGHT);
	}
	

	public static void main(String[] args) {
		CB = new CollisionBall();
	}
	
//end
}


class myJpanel extends JPanel{
	private static final long serialVersionUID = 1L;
	public void paintComponent(Graphics g) {
		CollisionBall.CB.repaint(g);
	}
	
}