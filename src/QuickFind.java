import java.util.Arrays;

/***
 * <pre>
 * Initialize: N 
 * union: N
 * find (connected): 1
 * 
 * Problem: requires N^2 (quadratic time) to carry out N union operations on N 
 * </pre>
 * 
 * @author shreejwal.shrestha
 *
 */
public class QuickFind {
	private final int[] ids;

	public QuickFind(int N) {
		ids = new int[N];
		for (int i = 0; i < N; i++) {
			ids[i] = i;
		}
	}

	public void union(int p, int q) {
		if (connected(p, q)) {
			return;
		}
		final int pid = ids[p];
		final int qid = ids[q];
		for (int i = 0; i < ids.length; i++) {
			if (ids[i] == pid) {
				ids[i] = qid;
			}
		}
	}

	public boolean connected(int p, int q) {
		return ids[p] == ids[q];
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
		uf.union(5, 7);
		uf.print();
		uf.union(1, 7);
		uf.print();
		uf.union(0, 4);
		uf.print();
		uf.union(2, 6);
		uf.print();
		uf.union(7, 2);
		uf.print();
	}
}
