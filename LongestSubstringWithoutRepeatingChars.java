import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingChars {

    /**
     * HashMap approach - optimized - faster
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;

        if (s == null || s.length() == 0) {
            return maxLength;
        }
        Map<Character, Integer> mp = new HashMap<Character, Integer>();
        
        for (int j = 0, i = 0; j < s.length(); j++) {
            if (mp.containsKey(s.charAt(j))) {
                // if s[j] have a duplicate in the range [i, j) with index j' (j' is the last j in the map, current j not put in map yet), 
                // we don't need to increase i one by one. 
                // We can skip all the elements in the range [i, j'] and let i to be j' + 1 directly
                i = Math.max(i, mp.get(s.charAt(j)) + 1);
            }
            maxLength = Math.max(maxLength, j - i + 1);
            mp.put(s.charAt(j), j); 
        }
        return maxLength;
    }

    /**
     * HashSet approach - slower
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring1(String s) {
        int maxLength = 0;
        Set<Character> set = new HashSet<Character>();

        int i = 0;
        int j = 0;
        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                maxLength = Math.max(maxLength, j - i + 1);
                j++;
            } else {
                // increasing i and removing s.charAt(i) one by one
                set.remove(s.charAt(i));
                i++;
            }
        }
        return maxLength;
    }
}