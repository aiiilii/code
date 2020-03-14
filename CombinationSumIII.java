import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {

    public List<List<Integer>> combinationSumIII(int k, int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (k <= 0 || n <= 0) {
            return res;
        }
        List<Integer> templist = new ArrayList<Integer>();
        backtracking(res, templist, k, n, 1);

        return res;
    }

    private void backtracking(List<List<Integer>> res, List<Integer> templist, int k, int remain, int start) {
        if (remain < 0) {
            return;
        }
        if (k == 0 && remain == 0) {
            res.add(new ArrayList<Integer>(templist));
            return;
        }
        for (int i = start; i <= 9; i ++) {
            templist.add(i);
            if (remain - i < 0) {
                templist.remove(templist.size() - 1);
                return;
            }
            backtracking(res, templist, k - 1, remain - i, i + 1);
            templist.remove(templist.size() - 1);
        }
    }
}