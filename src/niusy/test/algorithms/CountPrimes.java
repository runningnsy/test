package niusy.test.algorithms;

public class CountPrimes {

	public static int count() {
		int c = 0;
		for (int i = 101; i < 200; i += 2) {
			boolean b = true;
			for (int j = 2; j <= Math.sqrt(i); j++) {
				if (i % j == 0) {
					b = false;
					break;
				}
			}
			if (b) {
				c++;
			}
		}
		return c;
	}

	public static void main(String[] args) {
		int count = 0;
		for (int i = 101; i < 200; i += 2) {
			boolean b = false;
			for (int j = 2; j <= Math.sqrt(i); j++) {
				if (i % j == 0) {
					b = false;
					break;
				} else {
					b = true;
				}
			}
			if (b == true) {
				count++;
				System.out.println(i);
			}
		}
		System.out.println("����������: " + count);
		System.out.println(CountPrimes.count());
	}
}