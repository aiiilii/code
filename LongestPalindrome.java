public class LongestPalindrome {

    public int longestPalindrome(String s) {
        int[] count = new int[128];
        for (char c : s.toCharArray()) {
            count[c]++;
        }
        int ans = 0;
        for (int v : count) {
            // making a number into a even number; /2 will give floor number.
            // 6 / 2 * 2 == 6, 7 / 2 * 2 == 6
            ans += v / 2 * 2;
            if (ans % 2 == 0 && v % 2 == 1) {
                ans++;
                // this if statement will only run at most once, because when ans++, it will be an odd
                // number and will never satisfy ans % 2 == 0.
            }
        }
        return ans;
    }
}