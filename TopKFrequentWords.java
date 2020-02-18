import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.PriorityQueue;

public class TopKFrequentWords {

    /**
     * Heap and HashMap
     * Keep a count of each word in a HashMap and then insert in a Priority Queue.
     * While inserting in pq, if the count of two words is same then insert based on string compare of the keys.
     * Time - O(n log k), n is the length of words, log k is each time a word added to the heap;
     * Space - O(n), to store hashmap;
     * @param words
     * @param k
     * @return
     */
    public List<String> topKFrequent(String[] words, int k) {
        List<String> res = new ArrayList<String>();
        if (words == null || words.length == 0) {
            return res;
        }
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        Queue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<Map.Entry<String, Integer>>(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> s1, Map.Entry<String, Integer> s2) {
                if (s1.getValue() == s2.getValue()) {
                    return s2.getKey().compareTo(s1.getKey());
                }
                return s1.getValue() - s2.getValue(); // sort the larget count first, if count equal, lower alphabetical order first into the priorityQueue;
            }
        });

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            minHeap.offer(entry);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        
        while (!minHeap.isEmpty()) {
            res.add(0, minHeap.poll().getKey()); // add the smaller one to the front;
        }
        return res;
    }
}