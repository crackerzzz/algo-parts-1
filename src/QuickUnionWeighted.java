import java.util.Arrays;
import java.util.stream.IntStream;

/***
 * <pre>
 * Initialize: N 
 * union: lg N
 * find (connected): lg N
 * 
 * </pre>
 * 
 * @author shreejwal.shrestha
 *
 */
public class QuickUnionWeighted {
	private final int[] ids;
	private final int[] weight;

	public QuickUnionWeighted(int N) {
		ids = new int[N];
		weight = new int[N];
		for (int i = 0; i < N; i++) {
			ids[i] = i;
			weight[i] = 1;
		}
	}

	public void union(int p, int q) {
		int rootP = root(p);
		int rootQ = root(q);

		if (rootP == rootQ) {
			return;
		}

		if (weight[rootP] >= weight[rootQ]) {
			ids[rootQ] = rootP;
			weight[rootP] += weight[rootQ];
		} else {
			ids[rootP] = rootQ;
			weight[rootQ] += weight[rootP];
		}
		System.out.println("Union(" + p + "," + q + ")");
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
		System.out.println("----------------------------");
		IntStream.rangeClosed(0, ids.length - 1)
			.boxed()
			.forEach(id -> System.out.print(id + " "));
		System.out.println();
		Arrays.stream(ids)
			.boxed()
			.forEach(id -> System.out.print(id + " "));
		System.out.println();
		Arrays.stream(weight)
			.boxed()
			.forEach(h -> System.out.print(h + " "));
		System.out.println();
		System.out.println("----------------------------");
	}

	public static void main(String[] args) {
		final QuickUnionWeighted uf = new QuickUnionWeighted(10);
		uf.print();
		uf.union(4, 3);
		uf.print();
		uf.union(3, 8);
		uf.print();
		uf.union(6, 5);
		uf.print();
		uf.union(9, 4);
		uf.print();
		uf.union(2, 1);
		uf.print();
		uf.union(5, 0);
		uf.print();
		uf.union(7, 2);
		uf.print();
		uf.union(6, 2);
		uf.print();

		System.out.println(uf.connected(6, 4));
	}
}
