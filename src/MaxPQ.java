
public class MaxPQ<K extends Comparable<K>> {
	private K[] pq;
	private int N;

	public MaxPQ(int capacity) {
		pq = (K[]) new Comparable[capacity + 1];
	}

	public boolean isEmpty() {
		return N == 0;
	}

	public void insert(K v) {
		pq[++N] = v;
		swim(N);
	}

	public K delMax() {
		// max is always at the root.
		K max = pq[1];

		// replace root with last element
		exch(1, N);

		// prevent loitering and decrement count
		pq[N--] = null;

		sink(1);
		return max;
	}

	/*
	 * Child's key becomes larger than parent's key
	 */
	private void swim(int k) {
		while (k > 1 && less(k / 2, k)) {
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

			// find bigger of children
			if (j < N && less(j, j + 1)) {
				j++;
			}

			if (!less(k, j)) {
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
}
