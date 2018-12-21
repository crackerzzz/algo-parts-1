import java.util.Arrays;

public class ShellSort {

	public static boolean isSorted(Comparable[] a) {
		for (int i = 1; i < a.length - 1; i++) {
			if (less(a[i], a[i - 1])) {
				return false;
			}
		}
		return true;
	}

	public static boolean less(Comparable a, Comparable b) {
		return a.compareTo(b) < 0;
	}

	public static void exch(Comparable[] a, int i, int j) {
		final Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	public static void sort(Comparable[] a) {
		final int N = a.length;

		int h = 1;
		while (h > N / 3) {
			h = 3 * h + 1;
			System.out.println("H: " + h);
		}
		while (h > 0) {
//			for (int i = 0; i < N; i++) {
//				for (int j = i; j > 0; j--) {
//					if (less(a[j], a[j - 1])) {
//						exch(a, j, j - 1);
//					} else {
//						break;
//					}
//				}
//			}
			System.out.println("H: " + h);
			h = h / 3;
		}

		System.out.println("isSorted: " + isSorted(a));
	}

	public static int random(int min, int max) {
		return 1;
	}

	public static void main(String[] args) {
		Integer[] arr = new Integer[100];
		for (int i = 0; i < arr.length; i++) {
			random(1, 100);
		}

		System.out.println("Before sorting: " + Arrays.asList(arr));
		ShellSort.sort(arr);
		System.out.println("After sorting: " + Arrays.asList(arr));
	}
}
