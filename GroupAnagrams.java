import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class GroupAnagrams {

    /**
     * Time - O(nk log k); n is the length of strs, k is the max lenght of a string in strs; the outer loop has O(n) and sorting each (quicksort) is O(k log k) time.
     * Space - O(n k)
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<List<String>>();
        if (strs == null || strs.length == 0) {
            return res;
        }

        Map<String, List<String>> mp = new HashMap<String, List<String>>();

        for (int i = 0; i < strs.length; i++) {
            char[] ca = strs[i].toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);

            if (!mp.containsKey(key)) {
                mp.put(key, new ArrayList<String>());
            }
            mp.get(key).add(strs[i]);
        }

        return new ArrayList<List<String>>(mp.values());
    }
}