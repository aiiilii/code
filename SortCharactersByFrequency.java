import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortCharactersByFrequency {

    /**
     * HashMap + PriorityQueue approach
     * Time - O(n log n)
     * Space - O(n)
     * @param s
     * @return
     */
    public String frequencySort(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (char ch : s.toCharArray()) {
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<Map.Entry<Character, Integer>>(new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> entry1, Map.Entry<Character, Integer> entry2) {
                return entry2.getValue() - entry1.getValue();
            }
        });

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            maxHeap.offer(entry);
        }

        char[] res = new char[s.length()];
        int index = 0;

        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> entry = maxHeap.poll();
            int val = entry.getValue();
            char c = entry.getKey();
            while (val > 0) {
                res[index] = c;
                index ++;
                val --;
            }
        }
        return new String(res);
    }
}