import java.util.ArrayList;
import java.util.List;

public class Combinations {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (n <= 0 || k <= 0) {
            return res;
        }
        List<Integer> templist = new ArrayList<Integer>();
        backtracking(res, templist, n, k, 1);
        return res;
    }

    private void backtracking(List<List<Integer>> res, List<Integer> templist, int n, int k, int start) {
        if (k == 0) {
            res.add(new ArrayList<Integer>(templist));
            return;
        }
        for (int i = start; i <= n; i++) {
            templist.add(i);
            backtracking(res, templist, n, k - 1, i + 1);
            templist.remove(templist.size() - 1);
        }
    }
}