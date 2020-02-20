import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllAnagramsInAString {

    /**
     * Sliding Window with Array - faster
     * Time - O(Ns + Np), one pass along both strings;
     * Space - O(1), pCount and sCount contain not more than 26 elements;
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams(String s, String p) {
        int sl = s.length();
        int pl = p.length();

        if (sl < pl) {
            return new ArrayList<Integer>();
        }

        int[] pCount = new int[26];
        int[] sCount = new int[26];

        for (char ch : p.toCharArray()) {
            pCount[ch - 'a'] ++;
        }

        List<Integer> res = new ArrayList<Integer>();

        for (int i = 0; i < sl; i++) {

            sCount[s.charAt(i) - 'a'] ++;

            if (i >= pl) {
                sCount[s.charAt(i - pl) - 'a'] --;
            }

            if (Arrays.equals(pCount, sCount)) {
                res.add(i - pl + 1);
            }
        }
        return res;
    }




    /**
     * Sliding Window with HashMap
     * Time - O(Ns + Np), one pass along both strings
     * Space - O(1), pCount and sCount contain not more than 26 elements;
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams1(String s, String p) {
        int sl = s.length();
        int pl = p.length();
        
        if (sl < pl) {
            return new ArrayList<Integer>();
        }
        
        Map<Character, Integer> pCount = new HashMap<Character, Integer>();
        Map<Character, Integer> sCount = new HashMap<Character, Integer>();
        
        for (char ch : p.toCharArray()) {
            pCount.put(ch, pCount.getOrDefault(ch, 0) + 1);
        }
        
        List<Integer> res = new ArrayList<Integer>();
        
        for (int i = 0; i < sl; i++) {
            char ch = s.charAt(i);
            sCount.put(ch, sCount.getOrDefault(ch, 0) + 1);
            
            if (i >= pl) {
                ch = s.charAt(i - pl);
                if (sCount.get(ch) == 1) {
                    sCount.remove(ch);
                } else {
                    sCount.put(ch, sCount.get(ch) - 1);
                }
            }
            
            if (pCount.equals(sCount)) {
                res.add(i - pl + 1);
            }
        }
        return res;
    }
}