import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.IntSupplier;

import edu.princeton.cs.algs4.Stopwatch;

public class TripleSumToZero {
    private final int[] values;
    private final int length;

    public TripleSumToZero(int[] values) {
        this.values = values;
        this.length = this.values.length;
    }

    /***
     * <p>
     * finds number of times sum of three elements equal 0. Uses three loop to
     * iterate amonng all elements and keeps count if sum equals 0.
     * </p>
     * <p>
     * O(n) = N^3
     * </p>
     * 
     * @return number of times three elements equals 0.
     */
    public int findUsingNaiveApproach() {
        int count = 0;
        for (int i = 0; i < this.length; i++) {
            for (int j = i + 1; j < this.length; j++) {
                for (int k = j + 1; k < this.length; k++) {
                    if (this.values[i] + this.values[j] + this.values[k] == 0) {
                        System.out.println("found " + i + " + " + j + " = " + k);
                        System.out.println("found " + values[i] + " + " + values[j] + " = " + values[k]);
                        count++;
                    }
                }
            }
        }
        return count;
    }

    /***
     * <p>
     * finds number of times sum of three elements equal 0 using binary search.
     * </p>
     * <p>
     * O(n) = N^2
     * </p>
     * 
     * @return number of times three elements equals 0.
     */
    public int findUsingBinarySearch() {
        Arrays.sort(values);
        int count = 0;
        for (int i = 0; i < this.length; i++) {
            System.out.println("i=" + i);
            for (int j = i + 1; j < this.length; j++) {
                final int key = values[i] + values[j];
                final int k = Arrays.binarySearch(values, -key);
                if (k >= 0) {
                    if (i <= j && j <= k) {
//                        System.out.println("found " + i + " + " + j + " = " + k);
                        System.out.println("found " + values[i] + " + " + values[j] + " = " + values[k]);
                        count++;
                    } else {
//                        System.out.println("overlapping found " + i + " + " + j + " = " + k);
//                        System.out.println("overlapping found " + values[i] + " + " + values[j] + " = " + values[k]);
                    }
                }
            }
        }
        return count;
    }

    public int findUsingHashMap() {
        int count = 0;
        final Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < this.length - 1; i++) {
            map.clear();
            for (int j = i + 1; j < this.length; j++) {
                int sum = -(this.values[i] + this.values[j]);
                if (map.containsKey(sum)) {
                    count++;
                } else {
                    map.put(sum, sum);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        final TripleSumToZero o = new TripleSumToZero(new int[] { 30, -40, -20, -10, 40, 0, 10, 5 });
//        invoke(() -> o.findUsingNaiveApproach());
        invoke(() -> o.findUsingHashMap());
//        invoke(() -> o.findUsingHashMap());
    }

    private static void invoke(IntSupplier supplier) {
        final Stopwatch timer1 = new Stopwatch();
        System.out.println("findUsingNaiveApproach: ");
        System.out.println("Count: " + supplier.getAsInt());
        System.out.println("Elapsed Time:" + timer1.elapsedTime());

    }

}
