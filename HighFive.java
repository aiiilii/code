import java.util.PriorityQueue;
import java.util.TreeMap;

public class HighFive {
    
    /**
     * Time - O(n log n)
     * Space - O(n)
     * @param items
     * @return
     */
    public int[][] highFive(int[][] items) {
        TreeMap<Integer, PriorityQueue<Integer>> map = new TreeMap<Integer, PriorityQueue<Integer>>();

        for (int[] item : items) {
            int id = item[0];
            int score = item[1];

            if (!map.containsKey(id)) {
                PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
                pq.offer(score);
                map.put(id, pq);
            } else {
                PriorityQueue<Integer> pq = map.get(id);
                pq.offer(score);
                if (pq.size() > 5) {
                    pq.poll();
                }
                map.put(id, pq);
            }
        }

        int index = 0;

        int[][] res = new int[map.size()][2];

        for (int id : map.keySet()) {
            res[index][0] = id;

            PriorityQueue<Integer> pq = map.get(id);
            int sum = 0;
            int size = pq.size();

            while (!pq.isEmpty()) {
                sum += pq.poll();
            }

            res[index][1] = sum / size;

            index ++;
        }

        return res;
    }
}