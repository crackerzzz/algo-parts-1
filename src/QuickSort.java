import java.util.Arrays;

import edu.princeton.cs.algs4.StdRandom;

public class QuickSort {

	public static void sort(Comparable[] a) {
		StdRandom.shuffle(a);
		System.out.println("After shuffling: " + Arrays.asList(a));
		sort(a, 0, a.length - 1);
	}

	public static void sort(Comparable[] a, int lo, int hi) {
		if (hi <= lo) {
			return;
		}
		int j = partition(a, lo, hi);
		sort(a, lo, j - 1);
		sort(a, j + 1, hi);
	}

	public static int partition(Comparable[] a, int lo, int hi) {
		int i = lo;
		int j = hi + 1;

		while (true) {
			// move to right until you find an element greater than pivot element
			while (less(a[++i], a[lo])) {
				if (i == hi) {
					break;
				}
			}

			// move to left until you find an element less than pivot element
			while (less(a[lo], a[--j])) {
				if (j == lo) {
					break;
				}
			}

			// pointers cross
			if (i >= j) {
				break;
			}

			exch(a, i, j);
		}
		exch(a, lo, j);
		return j;
	}

	public static boolean less(Comparable a, Comparable b) {
		return a.compareTo(b) < 0;
	}

	public static void exch(Comparable[] a, int i, int j) {
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void main(String[] args) {
		Character[] arr = "QUICKSORTEXAMPLE".chars()
			.mapToObj(c -> (char) c)
			.toArray(Character[]::new);
		System.out.println("Before: " + Arrays.asList(arr));
		sort(arr);
		System.out.println("After: " + Arrays.asList(arr));
	}
}
