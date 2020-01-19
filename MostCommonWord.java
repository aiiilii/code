import java.util.HashSet;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;

public class MostCommonWord {
    
    /**
     * Time - O(p + b), p and b is size of paragraph and banned respectively
     * Space - O(p + b), to store the count and the banned set
     * @param paragraph
     * @param banned
     * @return
     */
    public String mostCommonWord(String paragraph, String[] banned) {
        // split paragraph
        String[] words = paragraph.toLowerCase().split("\\W+");

        // add banned word to the set
        Set<String> set = new HashSet<String>();
        for (String word : banned) {
            set.add(word);
        }

        // add paragraph words to hashmap
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (String word : words) {
            if (!set.contains(word)) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        // get the most frequent word
        int max = 0; // max frequency
        String res = "";
        for (String str : map.keySet()) {
            if (map.get(str) > max) {
                max = map.get(str);
                res = str;
            }
        }
        return res;
    }
}