public class ValidPalindromeII {

    /**
     * Time - O(n)
     * Space - O(1)
     * @param s
     * @return
     */
    public boolean validPalindrome(String s) {
        char[] arr = s.toCharArray();
        int l = 0;
        int r = arr.length - 1;

        while (l < r) {
            if (arr[l] == arr[r]) {
                l ++;
                r --;
            } else {
                // the char may be at the l or the r; thus ignore it and run isPalindrome again for both sides;
                return isPalindrome(arr, l, r - 1) || isPalindrome(arr, l + 1, r);
            }
        }
        return true;
    }

    private boolean isPalindrome(char[] arr, int left, int right) {
        while (left < right) {
            if (arr[left] == arr[right]) {
                left ++;
                right --;
            } else {
                return false;
            }
        }
        return true;
    }
}