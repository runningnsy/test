package niusy.test.designpatterns;

/**
 * ����ʽ������
 * @author Administrator
 *
 */
public class SinglePattern2 {

	private static SinglePattern2 instance = new SinglePattern2();

	private SinglePattern2() {

	}

	public static SinglePattern2 getInstance() {
		return instance;
	}
}
