import java.util.PriorityQueue;

public class KthLargestElementInAStream {

    PriorityQueue<Integer> minHeap;
    int k;

    public KthLargestElementInAStream(int k, int[] nums) {
        minHeap = new PriorityQueue<Integer>();
        this.k = k;

        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
    }

    public int add(int val) {
        minHeap.offer(val);
        if (minHeap.size() > k) {
            minHeap.poll();
        }
        return minHeap.peek();
    }

}