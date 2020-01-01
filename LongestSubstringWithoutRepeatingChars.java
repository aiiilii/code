import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingChars {

    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int ans = 0;

        if (s == null || s.length() == 0) {
            return ans;
        }
        Map<Character, Integer> mp = new HashMap<Character, Integer>();
        
        for (int j = 0, i = 0; j < n; j++) {
            if (mp.containsKey(s.charAt(j))) {
                i = Math.max(i, mp.get(s.charAt(j)));
            }
            ans = Math.max(ans, j - i + 1);
            mp.put(s.charAt(j), j + 1);
        }
        return ans;
    }
}