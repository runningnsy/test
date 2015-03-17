package niusy.test.algorithms;

import java.util.*;

public class LabyringhStack {

	private Point start;
	private Point finish;
	private char[][] mazemap;
	private Stack<Point> path;

	public LabyringhStack(char[][] ma) { // 初始化 存入数组
		this.mazemap = new char[ma.length][ma[0].length];
		for (int i = 0; i < ma.length; i++) {
			for (int j = 0; j < ma[0].length; j++) { // mazemap[0]必须有元素 不可为空
				this.mazemap[i][j] = ma[i][j];
			}
		}
		start = returnPlace('S');
		finish = returnPlace('F');
	}

	public Point returnPlace(char s) { // 返回数组中字符的位置
		Point point = new Point();
		for (int i = 0; i < this.mazemap.length; i++) {
			for (int j = 0; j < this.mazemap[0].length; j++) { // mazemap[0]必须有元素
																// 不可为空
				if (this.mazemap[i][j] == s) {
					point.setX(i);
					point.setY(j);
					point.setDirection(1);
				}
			}
		}
		return point;
	}

	public char returnChar(Point point) {
		if (point.getX() >= 0 && point.getY() >= 0)
			return this.mazemap[point.getX()][point.getY()];
		else
			return '#';
	}

	public void replacePlace(Point point, char s) { // 更改特定位置处的字符
		mazemap[point.getX()][point.getY()] = s;
	}

	public void printPath() {
		Stack<Point> tempPath = new Stack<Point>();
		while (!path.empty()) { // 对栈进行反序
			tempPath.push(path.pop());
		}
		while (!tempPath.empty()) {
			System.out.print("(" + tempPath.peek().getX() + ","
					+ tempPath.pop().getY() + ")");
		}
	}

	public boolean getPath() { // 取得路径的算法 如果有路径就返回真
		path = new Stack<Point>();
		path.push(start);
		while (!path.empty()) {
			Point curPoint = path.peek(); // 取得当前位置
			if (curPoint.getX() == finish.getX() && curPoint.getY() == finish.getY()) {
				// printPath();
				replacePlace(finish, 'F');
				return true;
			}
			Point nextPoint = new Point(); // 存放下一个可走的位置
			int find = 0; // 标志是否可继续走
			while (curPoint.getDirection() < 5 && find == 0) {
				switch (curPoint.getDirection()) {
				case 1:
					nextPoint = new Point(curPoint.getX(), curPoint.getY() - 1, 1);
					break;// 取得当前位置左边的位置
				case 2:
					nextPoint = new Point(curPoint.getX() + 1, curPoint.getY(), 1);
					break;// 取得当前位置下边的位置
				case 3:
					nextPoint = new Point(curPoint.getX(), curPoint.getY() + 1, 1);
					break;// 取得当前位置右边的位置
				case 4:
					nextPoint = new Point(curPoint.getX() - 1, curPoint.getY(), 1);
					break;// 取得当前位置上边的位置
				}

				if (returnChar(nextPoint) == 'O' || returnChar(nextPoint) == 'F') {
					find = 1; // 如果能向下走则置为1
					break;
				} else {
					curPoint.addDirection(); // 指向下一个需要验证的点
				}
			}
			if (find == 1) { // 如果可走就进栈
				replacePlace(nextPoint, '*'); // 设置成*防止回走
				// printArr();
				path.push(nextPoint);
			} else { // 如果不可走就退栈
				replacePlace(curPoint, 'X');
				path.pop();
			}
		}
		return false;
	}

	public void printArr() {
		for (int i = 0; i < mazemap.length; i++) {
			for (int j = 0; j < mazemap[0].length; j++) { // mazemap[0]必须有元素
															// 不可为空
				System.out.print(mazemap[i][j] + ",");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void main(String[] args) {
		char[][] mazemap = { 
				{ 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M' },
				{ 'M', 'S', 'O', 'O', 'M', 'M', 'M', 'M' },
				{ 'M', 'M', 'M', 'O', 'M', 'O', 'O', 'F' },
				{ 'M', 'M', 'O', 'O', 'O', 'O', 'M', 'M' },
				{ 'M', 'M', 'M', 'M', 'M', 'O', 'M', 'M' },
				{ 'M', 'M', 'M', 'M', 'O', 'M', 'O', 'M' },
				{ 'M', 'M', 'M', 'M', 'M', 'O', 'M', 'M' } };
		LabyringhStack solution = new LabyringhStack(mazemap);
		if (solution.getPath()) {
			System.out.print("迷宫路径如下：");
			solution.printPath();
			System.out.println();
			solution.printArr();
		} else {
			System.out.println("没有可走的路");
		}
	}
}