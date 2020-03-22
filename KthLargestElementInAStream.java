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




    


    public KthLargestElementInAStream(int k, int[] nums, int nothing) { // same construction as previous solution;
        minHeap = new PriorityQueue<Integer>();
        this.k = k;
        
        int minSize = Math.min(k, nums.length);
        
        for (int i = 0; i < minSize; i++) {
            minHeap.offer(nums[i]);
        }
        
        for (int i = k; i < nums.length; i++) {
            if (minHeap.peek() < nums[i]) {
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        }
    }

    public int add1(int val) {
        if (minHeap.size() < k) {
            minHeap.offer(val);
        } else {
            if (minHeap.peek() < val) {
                minHeap.poll();
                minHeap.offer(val);
            }
        }
        return minHeap.peek();
    }
}