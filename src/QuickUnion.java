import java.util.Arrays;

/***
 * <pre>
 * Initialize: N 
 * union: N because of having to find root
 * find (connected): N due to root
 * 
 * Problem: union and find is slow
 * </pre>
 * 
 * @author shreejwal.shrestha
 *
 */
public class QuickUnion {
	private final int[] ids;

	public QuickUnion(int N) {
		ids = new int[N];
		for (int i = 0; i < N; i++) {
			ids[i] = i;
		}
	}

	public void union(int p, int q) {
		int rootP = root(p);
		int rootQ = root(p);
		ids[rootP] = rootQ;
	}

	public boolean connected(int p, int q) {
		return root(p) == root(q);
	}

	public int root(int p) {
		if (ids[p] == p) {
			return p;
		} else {
			return root(ids[p]);
		}
	}

	public void print() {
		Arrays.stream(ids)
			.boxed()
			.forEach(id -> System.out.print(id + " "));
		System.out.println();
	}

	public static void main(String[] args) {
		final QuickFind uf = new QuickFind(8);
		uf.print();
		uf.union(3, 4);
		uf.print();
		uf.union(3, 5);
		uf.print();
		uf.union(5, 7);
		uf.print();
		uf.union(7, 1);
		uf.print();
		uf.union(4, 0);
		uf.print();
		uf.union(2, 6);
		uf.print();
		uf.union(6, 7);
		uf.print();

		System.out.println(uf.connected(2, 7));
	}
}
