import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ShortestWordDistanceII {
    
    Map<String, ArrayList<Integer>> locations;

    public ShortestWordDistanceII(String[] words) {
        locations = new HashMap<String, ArrayList<Integer>>();

        for (int i = 0; i < words.length; i++) {
            ArrayList<Integer> temp = locations.getOrDefault(words[i], new ArrayList<Integer>());
            temp.add(i);
            locations.put(words[i], temp);
        }
    }

    /**
     * Time - O(n)
     * Space - O(n)
     * @param word1
     * @param word2
     * @return
     */
    public int shortest(String word1, String word2) {
        ArrayList<Integer> loc1 = locations.get(word1);
        ArrayList<Integer> loc2 = locations.get(word2);

        int l1 = 0;
        int l2 = 0;
        int minDiff = Integer.MAX_VALUE;

        while (l1 < loc1.size() && l2 < loc2.size()) {
            minDiff = Math.min(minDiff, Math.abs(loc1.get(l1) - loc2.get(l2)));
            if (loc1.get(l1) < loc2.get(l2)) {
                l1 ++;
            } else {
                l2 ++;
            }
        }
        
        return minDiff;
    }
}