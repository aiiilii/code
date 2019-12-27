import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        if (n == 0) {
            return res;
        }
        String templist = "";
        backtracking(res, templist, 0, 0, n);
        return res;
    }

    private void backtracking(List<String> res, String templist, int open , int close, int max) {
        if (templist.length() == max * 2) {
            res.add(templist);
            return;
        }
        if (open < max) {
            backtracking(res, templist + "(", open + 1, close, max);
        }
        if (close < open) {
            backtracking(res, templist + ")", open,  close + 1, max);
        }
    }
}