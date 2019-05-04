
public class Ball {

	private int x;
	private int y;
	protected int size;
	
	protected int dx;
	protected int dy;
	
	public Ball(int x ,int y, int size) {
		this.setX(x);
		this.setY(y);
		this.size = size;
	}

	public void run() {
		
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
