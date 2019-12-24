import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    public int romanToInt(String s) {
        int res = 0;
        if (s == null || s.length() == 0) {
            return res;
        }
        Map<Character, Integer> mp = new HashMap<Character, Integer>();

        mp.put('I', 1);
        mp.put('V', 5);
        mp.put('X', 10);
        mp.put('L', 50);
        mp.put('C', 100);
        mp.put('D', 500);
        mp.put('M', 1000);

        for (int i = 0; i < s.length() - 1; i++) {
            if (mp.get(s.charAt(i)) >= mp.get(s.charAt(i + 1))) {
                res += mp.get(s.charAt(i));
            } else {
                res -= mp.get(s.charAt(i));
            }
        }
        res += mp.get(s.charAt(s.length() - 1));

        return res;
    }
}