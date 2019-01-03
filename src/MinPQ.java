
public class MinPQ<K extends Comparable<K>> {
	private K[] pq;
	private int N;

	@SuppressWarnings("unchecked")
	public MinPQ(int capacity) {
		pq = (K[]) new Comparable[capacity + 1];
	}

	public boolean isEmpty() {
		return N == 0;
	}

	public void insert(K v) {
		pq[++N] = v;
		swim(N);
	}

	public K delMin() {
		// max is always at the root.
		K min = pq[1];

		// replace root with last element
		exch(1, N);

		// prevent loitering and decrement count
		pq[N--] = null;

		sink(1);
		return min;
	}

	/*
	 * Child's key becomes larger than parent's key
	 */
	private void swim(int k) {
		while (k > 1 && less(k, k / 2)) {
			exch(k / 2, k);
			k = k / 2;
		}
	}

	/**
	 * Parent's key becomes smaller than child's key
	 * 
	 * @param k
	 */
	private void sink(int k) {
		while (2 * k <= N) {
			int j = 2 * k;

			// find smaller of children
			if (j < N && less(j + 1, j)) {
				j++;
			}

			if (less(k, j)) {
				break;
			}
			exch(k, j);
			k = j;
		}
	}

	private boolean less(int i, int j) {
		return pq[i].compareTo(pq[j]) < 0;
	}

	private void exch(int i, int j) {
		K temp = pq[i];
		pq[i] = pq[j];
		pq[j] = temp;
	}

	public static void main(String[] args) {
		Integer[] input = new Integer[] { 15, 8, 7, 3, 6, 4, 5, 98, 6, 12 };
		final MinPQ<Integer> pq = new MinPQ<>(input.length);
		for (Integer i : input) {
			pq.insert(i);
		}

		while (!pq.isEmpty()) {
			System.out.println(pq.delMin());
		}
	}
}
