import java.util.Arrays;

public class KeyIndexedCounting {

	public static void count(char a[], int R) {
		final int N = a.length;
		final int[] count = new int[R + 1];

		// count number of element of array
		for (int i = 0; i < N; i++) {
			int j = a[i] + 1 - 97;
			System.out.println("j=" + j);
			count[j]++;
		}
		System.out.println("count: " + Arrays.toString(count));

		// cumulative counting
		for (int r = 1; r <= R; r++) {
			count[r] += count[r - 1];
		}
		System.out.println("count: " + Arrays.toString(count));

		final char[] aux = new char[N];
		for (int i = 0; i < N; i++) {
			int j = a[i] - 97;
			aux[count[j]++] = a[i];
		}
		System.out.println("count: " + Arrays.toString(aux));

		for (int i = 0; i < N; i++) {
			a[i] = aux[i];
		}
		System.out.println("count: " + Arrays.toString(a));
	}

	public static void main(String[] args) {
		final char[] a = "bdadebdedabcedca".toCharArray();
		count(a, 5);
		System.out.println("Sorted array: " + Arrays.toString(a));
	}
}
