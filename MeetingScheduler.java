import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MeetingScheduler {
    
    /**
     * Time - O(n log n), n is the sum of lengths of slots1 and slots2
     * Space - O(n)
     * @param slots1
     * @param slots2
     * @param duration
     * @return
     */
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        // PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(a -> a[0])); SHORTER way to write
        PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        for (int[] s : slots1) {
            if (s[1] - s[0] >= duration) {
                minHeap.offer(s);
            }
        }

        for (int[] s : slots2) {
            if (s[1] - s[0] >= duration) {
                minHeap.offer(s);
            }
        }

        while (minHeap.size() > 1) {
            if (minHeap.poll()[1] >= minHeap.peek()[0] + duration) {
                return Arrays.asList(minHeap.peek()[0], minHeap.peek()[0] + duration);
            }
        }
        return Arrays.asList();
    }
}