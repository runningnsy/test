package niusy.test.algorithms;

public class TestStringAddValue {

	int[] arr = { 1, 3, 3, 2, 8 };
	String str = "";
	int i = 0;

	public void doIt() {
		for (; i < arr.length;) {
			if (arr[i] > arr[i + 1]) {
				str = arr[i] + arr[i + 1] + str;
				break;
			} else if (arr[i] < arr[i + 1]) {
				str = arr[i] + str + arr[i + 1];
				i++;
				continue;
			} else {
				str += arr[i];
				i++;
			}
		}
		System.out.println(i);
		System.out.println(str);
	}

	public static void main(String[] args) {
		// new TestStringAddValue().doIt();
		System.out.println(5 + "" + 6);
		System.out.println("56" + 7);
		System.out.println(8 + 9 + "567");
	}
}
