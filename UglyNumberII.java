import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class UglyNumberII {

    public static class Ugly {
        public int[] nums = new int[1690];

        public Ugly() {
            Set<Long> seen = new HashSet<Long>();
            PriorityQueue<Long> heap = new PriorityQueue<Long>();
            seen.add(1L);
            heap.offer(1L);

            long currUgly;
            long newUgly;
            int[] primes = new int[] {2, 3, 5};

            for (int i = 0; i < 1690; i++) {
                currUgly = heap.poll();
                nums[i] = (int) currUgly;
                for (int j : primes) {
                    newUgly = currUgly * j;
                    if (!seen.contains(newUgly)) {
                        seen.add(newUgly);
                        heap.offer(newUgly);
                    }
                }
            }
        }
    }

    public static Ugly u = new Ugly();

    public int nthUglyNumber(int n) {
        return u.nums[n - 1];
    }
}