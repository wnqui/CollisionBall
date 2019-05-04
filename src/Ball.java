import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class Ball {

	private int x;
	private int y;

	protected int size;
	protected double r;

	protected double dx;
	protected double dy;
	public static int power = 10;

	protected Color color;

	public Ball(int x, int y, int size) {
		
		this.setX(x);
		this.setY(y);
		this.size = size;
		this.r = size / 2;

		int r1 = (int) (Math.random() * power + 1);

		dx = r1;
		dy = power - r1;

		int r2 = (int) (Math.random() * 3 + 1);

		switch (r2) {
		case 1:
			dx *= -1;
			break;
		case 2:
			dy *= -1;
			break;
		case 3:
			dx *= -1;
			dy *= -1;
			break;
		}

		int r3 = (int) (Math.random() * 5 + 1);
		switch (r3) {
		case 1:
			color = Color.RED;
			break;
		case 2:
			color = Color.BLUE;
			break;
		case 3:
			color = Color.YELLOW;
			break;
		case 4:
			color = Color.GREEN;
			break;
		case 5:
			color = Color.MAGENTA;
			break;
		}

	}

	public void run(ArrayList<Ball> balls) {

		// 邊界反彈
		outsideCheck();
		// 碰撞反彈
		isCollision(balls);
		// 移動
		this.x += dx;
		this.y += dy;
		// 移動速度補正

	}
	//邊境檢查
	public void outsideCheck() {

		if (this.y <= CollisionBall.UP_Y) {
			this.dy *= -1;
			this.y = CollisionBall.UP_Y + 1;

		} else if (this.y + size >= CollisionBall.DN_Y) {
			this.dy *= -1;
			this.y = CollisionBall.DN_Y - size - 1;
		}
		if (this.x <= CollisionBall.L_X) {
			this.dx *= -1;
			this.x = CollisionBall.L_X + 1;
		} else if (this.x + size >= CollisionBall.R_X) {
			this.dx *= -1;
			this.x = CollisionBall.R_X - size - 1;
		}

	}

	// collision check
	public void isCollision(ArrayList<Ball> balls) {
		double dr = 0;
		double angle1 = 0;
		double angle2 = 0;
		Ball b1;
		Ball b2;
		for (int i = balls.size(); i > 0; i--) {

			for (int j = 1; j < i; j++) {
				b1 = balls.get(i - 1);
				b2 = balls.get(j - 1);
				dr = Math.sqrt(Math.pow(b1.x - b2.x, 2) + Math.pow(b1.y - b2.y, 2));
				if (dr <= (b1.r + b2.r)) {
					angle1 = Math.atan2(b1.x - b2.x, b1.y - b2.y) / Math.PI * 180;
					angle2 = Math.atan2(b2.x - b1.x, b2.y - b1.y) / Math.PI * 180;

					balls.get(i - 1).dx = (int) (power * Math.cos(Math.toRadians(angle1)));
					balls.get(i - 1).dy = (int) (power * Math.sin(Math.toRadians(angle1)));

					balls.get(j - 1).dx = (int) (power * Math.cos(Math.toRadians(angle2)));
					balls.get(j - 1).dy = (int) (power * Math.sin(Math.toRadians(angle2)));

				}
			}
		}

	}
	//重設動量
	public void reset() {
		int r1 = (int) (Math.random() * power + 1);

		dx = r1;
		dy = power - r1;

		int r2 = (int) (Math.random() * 3 + 1);

		switch (r2) {
		case 1:
			dx *= -1;
			x += dx * 10;
			break;
		case 2:
			dy *= -1;
			y += dy * 10;
			break;
		case 3:
			dx *= -1;
			dy *= -1;
			x += dx * 10;
			y += dy * 10;
			break;

		}
	}

	// drawball
	public void drawBall(Graphics2D g2) {
		g2.setColor(color);
		g2.fillOval(x, y, size, size);
		g2.setColor(Color.black);
		g2.drawOval(x, y, size, size);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

}
