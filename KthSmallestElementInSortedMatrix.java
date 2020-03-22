import java.util.PriorityQueue;

public class KthSmallestElementInSortedMatrix {

    /**
     * Binary Search approach - faster
     * Time - O(log (m * n))
     * Space - O(1)
     * @param matrix
     * @param k
     * @return
     */
    public int kthSmallest1(int[][] matrix, int k) {
        int low = matrix[0][0];
        int high = matrix[matrix.length - 1][matrix[0].length - 1];

        while (low < high) {
            int mid = low + (high - low) / 2;
            int count = 0;
            int j = matrix[0].length - 1;

            for (int i = 0; i < matrix.length; i ++) {
                while (j >= 0 && matrix[i][j] > mid) {
                    j --;
                }
                count += (j + 1);
            }
            if (count < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }




    /**
     * Priority Queue approach - slower
     * Time - O(m * n)
     * Space - O(m * n)
     * @param matrix
     * @param k
     * @return
     */
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a, b) -> b - a);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                maxHeap.offer(matrix[i][j]);
                if (maxHeap.size() > k) {
                    maxHeap.poll();
                }
            }
        }
        return maxHeap.peek();
    }
}