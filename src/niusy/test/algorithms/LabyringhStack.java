package niusy.test.algorithms;

import java.util.*;

public class LabyringhStack {

	private Point start;
	private Point finish;
	private char[][] mazemap;
	private Stack<Point> path;

	public LabyringhStack(char[][] ma) { // ��ʼ�� ��������
		this.mazemap = new char[ma.length][ma[0].length];
		for (int i = 0; i < ma.length; i++) {
			for (int j = 0; j < ma[0].length; j++) { // mazemap[0]������Ԫ�� ����Ϊ��
				this.mazemap[i][j] = ma[i][j];
			}
		}
		start = returnPlace('S');
		finish = returnPlace('F');
	}

	public Point returnPlace(char s) { // �����������ַ���λ��
		Point point = new Point();
		for (int i = 0; i < this.mazemap.length; i++) {
			for (int j = 0; j < this.mazemap[0].length; j++) { // mazemap[0]������Ԫ��
																// ����Ϊ��
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

	public void replacePlace(Point point, char s) { // �����ض�λ�ô����ַ�
		mazemap[point.getX()][point.getY()] = s;
	}

	public void printPath() {
		Stack<Point> tempPath = new Stack<Point>();
		while (!path.empty()) { // ��ջ���з���
			tempPath.push(path.pop());
		}
		while (!tempPath.empty()) {
			System.out.print("(" + tempPath.peek().getX() + ","
					+ tempPath.pop().getY() + ")");
		}
	}

	public boolean getPath() { // ȡ��·�����㷨 �����·���ͷ�����
		path = new Stack<Point>();
		path.push(start);
		while (!path.empty()) {
			Point curPoint = path.peek(); // ȡ�õ�ǰλ��
			if (curPoint.getX() == finish.getX() && curPoint.getY() == finish.getY()) {
				// printPath();
				replacePlace(finish, 'F');
				return true;
			}
			Point nextPoint = new Point(); // �����һ�����ߵ�λ��
			int find = 0; // ��־�Ƿ�ɼ�����
			while (curPoint.getDirection() < 5 && find == 0) {
				switch (curPoint.getDirection()) {
				case 1:
					nextPoint = new Point(curPoint.getX(), curPoint.getY() - 1, 1);
					break;// ȡ�õ�ǰλ����ߵ�λ��
				case 2:
					nextPoint = new Point(curPoint.getX() + 1, curPoint.getY(), 1);
					break;// ȡ�õ�ǰλ���±ߵ�λ��
				case 3:
					nextPoint = new Point(curPoint.getX(), curPoint.getY() + 1, 1);
					break;// ȡ�õ�ǰλ���ұߵ�λ��
				case 4:
					nextPoint = new Point(curPoint.getX() - 1, curPoint.getY(), 1);
					break;// ȡ�õ�ǰλ���ϱߵ�λ��
				}

				if (returnChar(nextPoint) == 'O' || returnChar(nextPoint) == 'F') {
					find = 1; // ���������������Ϊ1
					break;
				} else {
					curPoint.addDirection(); // ָ����һ����Ҫ��֤�ĵ�
				}
			}
			if (find == 1) { // ������߾ͽ�ջ
				replacePlace(nextPoint, '*'); // ���ó�*��ֹ����
				// printArr();
				path.push(nextPoint);
			} else { // ��������߾���ջ
				replacePlace(curPoint, 'X');
				path.pop();
			}
		}
		return false;
	}

	public void printArr() {
		for (int i = 0; i < mazemap.length; i++) {
			for (int j = 0; j < mazemap[0].length; j++) { // mazemap[0]������Ԫ��
															// ����Ϊ��
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
			System.out.print("�Թ�·�����£�");
			solution.printPath();
			System.out.println();
			solution.printArr();
		} else {
			System.out.println("û�п��ߵ�·");
		}
	}
}