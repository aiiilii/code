import java.util.Queue;
import java.util.Random;
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
        Queue<Integer> minHeap = new PriorityQueue<Integer>((n1, n2) -> n1 - n2); // lambda notation; can also use comparator class;
        
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



    /**
     * Quick Select
     * Time - O(n), worst case O(n^2)
     * Space - O(1)
     * @param nums
     * @param K
     * @return
     */
    public int findKthLargest1(int[] nums, int K) {
        if (nums == null || nums.length == 0 || K <= 0) {
            return 0;
        }

        randomize(nums); // to increase speed;

        int left = 0;
        int right = nums.length - 1;
        int targetK = nums.length - K + 1; // making Kth largest into targetKth smallest; ex: 9 nums, 6th largest is 4th smallest

        while (left <= right) {
            int pivotIndex = partition(nums, left, right);
            if (targetK == pivotIndex + 1) {
                return nums[pivotIndex];
            } else if (targetK < pivotIndex + 1) {
                right = pivotIndex - 1;
            } else {
                left = pivotIndex + 1;
            }
        }
        return 0;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void randomize(int[] nums) {
        Random rand = new Random();
        for (int i = nums.length - 1; i > 0; i--) {
            int r = rand.nextInt(i + 1);
            swap(nums, i, r);
        }
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int fast = left;
        int slow = left - 1;
        
        for (fast = left; fast < right; fast ++) {
            if (nums[fast] < pivot) {
                slow ++;
                swap(nums, slow, fast);
            }
        }
        swap(nums, slow + 1, right);
        return slow + 1;
    }

}