package niusy.test.algorithms;

public class Point {
	int x;
	int y;
	int direction; // direction指向此点附近的一个点应该有四个编号为1 2 3 4

	public Point() {
	}

	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
		this.direction = 1;
	}

	public Point(int x, int y, int direction) {
		super();
		this.x = x;
		this.y = y;
		this.direction = direction;
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

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public void addDirection() {
		this.direction++;

	}

}