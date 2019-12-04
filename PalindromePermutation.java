// import java.util.ArrayList;
import java.util.HashMap;
// import java.util.List;
import java.util.Map;

public class PalindromePermutation {

    public boolean canPermutePalindrome(String s) {
        char[] chars = s.toCharArray();
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        // List<Integer> res = new ArrayList<Integer>();
        int resLength = 0;
        for (char c : chars) {
            if (hm.containsKey(c)) {
                hm.put(c, hm.get(c) + 1);
            } else {
                hm.put(c, 1);
            }
        }
        for (Map.Entry<Character,Integer> c :  hm.entrySet()) {
            if (c.getValue() % 2 != 0) {
                resLength ++;
                if (resLength > 1) {
                    return false;
                }
            }
        }
        return true;
    }
}