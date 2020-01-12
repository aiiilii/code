import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<List<String>>();
        if (s == null || s.length() == 0) {
            return res;
        }
        List<String> templist = new ArrayList<String>();

        backtracking(res, templist, s, 0);
        return res;
    }

    private void backtracking(List<List<String>> res, List<String> templist, String s, int start) {
        if (start == s.length()) {
            res.add(new ArrayList<String>(templist));
        }
        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s, start, i)) {
                templist.add(s.substring(start, i + 1));
                backtracking(res, templist, s, i + 1);
                templist.remove(templist.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int low, int high) {
        while (low < high) {
            if (s.charAt(low) != s.charAt(high)) {
                return false;
            }
            low ++;
            high --;
        }
        return true;
    }
}