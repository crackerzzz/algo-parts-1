import java.util.Arrays;

public class MergeSortGeneric {

	@SuppressWarnings("unchecked")
	public static <T extends Comparable<? super T>> void sort(T[] a) {
		final T[] aux = (T[]) new Object[a.length];
		sort(a, aux, 0, a.length - 1);
	}

	public static <T extends Comparable<? super T>> void sort(T[] a, T[] aux, int lo, int hi) {
		if (hi <= lo) {
			return;
		}
		final int mid = lo + (hi - lo) / 2;
		sort(a, aux, lo, mid);
		sort(a, aux, mid + 1, hi);
		merge(a, aux, lo, mid, hi);
	}

	public static <T extends Comparable<? super T>> void merge(T[] a, T[] aux, int lo, int mid, int hi) {
		assert isSorted(a, lo, mid) == true;
		assert isSorted(a, mid + 1, hi) == true;

		for (int k = lo; k <= hi; k++) {
			aux[k] = a[k];
		}

		int i = lo;
		int j = mid + 1;
		for (int k = lo; k <= hi; k++) {
			if (i > mid) {
				// first half exhausted, copy from other half
				a[k] = aux[j++];
			} else if (j > hi) {
				// second half exhausted, copy from first half
				a[k] = aux[i++];
			} else if (less(aux[i], aux[j])) {
				a[k] = aux[i++];
			} else {
				a[k] = aux[j++];
			}
		}
	}

	public static <T extends Comparable<? super T>> boolean isSorted(T[] a, int lo, int hi) {
		for (int i = lo; i <= hi - 1; i++) {
			if (less(a[i + 1], a[i])) {
				return false;
			}
		}
		return true;
	}

	public static <T extends Comparable<? super T>> boolean less(T a, T b) {
		return a.compareTo(b) < 0;
	}

	public static void main(String[] args) {
		System.out.println(less("a", "b"));

		Integer[] arr = new Integer[] { 0, 2, 4, 6, 8, 1, 3, 5, 7, 9 };
		Integer[] aux = new Integer[arr.length];
		merge(arr, aux, 0, 4, 9);
		System.out.println(Arrays.asList(arr));
	}

}
