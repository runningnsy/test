package niusy.test.designpatterns;

/**
 * ����ʽ������
 * @author Administrator
 *
 */
public class SinglePattern1 {

	private static SinglePattern1 instance = null;

	private SinglePattern1() {
	}

	public static SinglePattern1 getInstance() {
		if (instance == null) {
			instance = new SinglePattern1();
		}
		return instance;
	}
	
}