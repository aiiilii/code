public class PalindromicSubstrings {

    /**
     * Time - O(n ^ 2), n is the length of s, each expansion might do O(n) work;
     * Space - O(1)
     * @param s
     * @return
     */
    public int countSubstrings(String s) {
        int count = 0;

        if (s == null || s.length() == 0) {
            return count;
        }

        for (int i = 0; i < s.length(); i++) {
            count += extractPalindrome(s, i, i); // odd length;
            count += extractPalindrome(s, i, i + 1); // even length;
        }
        return count;
    }

    private int extractPalindrome(String s, int left, int right) {
        int count = 0;

        while (left >= 0 && right < s.length() && (s.charAt(left) == s.charAt(right))) {
            left --;
            right ++;
            count ++;
        }
        return count;
    }
}