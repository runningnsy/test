package niusy.test.variableParameter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author niusy
 */
public class VarableParameter {

	List<Integer> list = new ArrayList<Integer>();
	public VarableParameter() {
		// TODO Auto-generated constructor stub
	}
	public static int add(int x, int... list) {
		int sum = x;
//		for (int arg : args) {
//			sum += arg;
//		}
//		for (int i = 0; i < args.length; i++) {
//			sum += args[i];
//		}

		return sum;

	}

	public static void main(String[] args) {
		System.out.println(add(2, 3));
		System.out.println(add(2, 3, 5));
	}
}
