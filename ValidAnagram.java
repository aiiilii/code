import java.util.Arrays;
import java.util.HashMap;

public class ValidAnagram {

    /**
     * Sorting approach - faster
     * Anagram is made up of the same letters
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        Arrays.sort(sc);
        Arrays.sort(tc);
        return Arrays.equals(sc, tc);
    }

    /**
     * Hashtable approach - slower
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram2(String s, String t) {
        HashMap<Character, Integer> smap = new HashMap<>();
        if (s.length() != t.length()) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            smap.put(s.charAt(i), smap.getOrDefault(s.charAt(i), 0) + 1);
            smap.put(t.charAt(i), smap.getOrDefault(t.charAt(i), 0) - 1); //** KEY PART! */
        }
        for (char c : smap.keySet()) {
            if (smap.get(c) != 0) {
                return false;
            }
        }
        return true;
    }
}