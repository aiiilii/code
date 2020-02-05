import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

public class LongestStringChain {

    /**
     * Time - O(n log n) for sorting, O(NSS) for the for-loop
     * Space - O(NS)
     * @param words
     * @return
     */
    public int longestStrChain(String[] words) {
        Map<String, Integer> dp = new HashMap<String, Integer>();
        // sort the words by length
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        
        int res = 0;

        for (String word : words) {
            int best = 0;
            // for each word, loop on all possible previous word with 1 letter missing,
            // if we have seen this previous word, update the longest chain for the current word;
            for (int i = 0; i < word.length(); i++) {
                String prev = word.substring(0, i) + word.substring(i + 1);
                best = Math.max(best, dp.getOrDefault(prev, 0) + 1);
            }
            dp.put(word, best);
            res = Math.max(res, best);
        }
        return res;
    }
}