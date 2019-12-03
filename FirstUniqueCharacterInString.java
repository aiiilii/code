import java.util.HashMap;

public class FirstUniqueCharacterInString {

    /**
     * Hashmap approach - slower
     * @param s
     * @return
     */
    public int firstUniqueChar(String s) {
        char[] c = s.toCharArray();
        HashMap<Character, Integer> hash = new HashMap<>();
        for (char i : c) {
            hash.put(i, hash.getOrDefault(i, 0) + 1);
        }

        for (int i = 0; i < c.length; i++) {
            if (hash.get(c[i]) == 1) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Using self-store map - faster
     * can self-store alphabets since only lowercases, so 26 char
     * @param s
     * @return
     */
    public int firstUniqueChar2(String s) {
        int [] a = new int[26];

        for (int i = 0; i < s.length(); i++) {
            a[s.charAt(i) - 'a'] += 1; // ascii 'a' - 'a' == 0; use this to store char into int
        }
        
        for (int i = 0; i < s.length(); i++) {
            if (a[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}