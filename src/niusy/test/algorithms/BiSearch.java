package niusy.test.algorithms;

public class BiSearch {
	public int bsearch(int[] a, int v) {
		int start = 0;
		int last = a.length - 1;
		while (start <= last) {
			int m = (start + last) / 2;
			if (a[m] == v)
				return m;
			else if (v < a[m])
				last = m - 1;
			else if (v > a[m])
				start = m + 1;
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] a = { 1, 3, 5, 7, 9 , 11};
		for (int i = 0; i < 12; ++i)
			System.out.println("find " + i + " at pos: " + new BiSearch().bsearch(a, i));
	}
}