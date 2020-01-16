import java.util.Queue;
import java.util.PriorityQueue;

public class KthLargestElementInAnArray {

    /**
     * Priority Queue Approach
     * Time - O(n log k), n times in heap size of k
     * Space - O(k), heap size of k
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> minHeap = new PriorityQueue<Integer>((n1, n2) -> n1 - n2);
        
        for (int n : nums) {
            minHeap.offer(n); // put each n into the priorityQueue;
            if (minHeap.size() > k) { // while putting them in one by one, chech the size;
                // if the size is greater than k, remove them from the heap,
                // after putting all of them into the heap and removing all the n when the queue size greater than k,
                // what is left in the queue is only k numbers
                minHeap.poll(); 
            }
        }
        return minHeap.poll(); // thus return the k largest number as it is in the top of the heap;
    }
}