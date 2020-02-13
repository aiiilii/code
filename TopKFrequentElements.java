import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.PriorityQueue;

public class TopKFrequentElements {

    /**
     * Time - O(n log k), to build the heap and out out the list
     * Space - O(n), to store into hashmap
     * @param nums
     * @param k
     * @return
     */
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Queue<Integer> minHeap = new PriorityQueue<Integer>((n1, n2) -> map.get(n1) - map.get(n2));
        for (int n : map.keySet()) {
            minHeap.offer(n);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        List<Integer> res = new ArrayList<Integer>();
        while (!minHeap.isEmpty()) {
            res.add(minHeap.poll());
        }
        return res;
    }
}