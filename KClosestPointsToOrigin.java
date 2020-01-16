import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class KClosestPointsToOrigin {

    /**
     * Sortin Approach
     * Time - O(n log n)
     * Space - O(n)
     * @param points
     * @param K
     * @return
     */
    public int[][] kClosest(int[][] points, int K) {
        int n = points.length;
        int[] dists = new int[n];

        for (int i = 0; i < n; i++) {
            dists[i] = dist(points[i]);
        }
        Arrays.sort(dists);
        int distK = dists[K - 1];

        int[][] ans = new int[K][2];
        int t = 0;
        
        for (int i = 0; i < n; i++) {
            if (dist(points[i]) <= distK) {
                ans[t] = points[i];
                t++;
            }
        }
        return ans;
    }

    private int dist(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }



    /**
     * Slow
     * @param points
     * @param K
     * @return
     */
    public int[][] kClosest2(int[][] points, int K) {
        Queue<int[]> maxHeap = new PriorityQueue<int[]>((a, b) -> (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1]));

        for (int[] point : points) {
            maxHeap.offer(point);
            if (maxHeap.size() > K) {
                maxHeap.poll();
            }
        }

        int[][] res = new int[K][2];
        while (K > 0) {
            K--;
            res[K] = maxHeap.poll();
        }
        return res;
    }
}