import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        List<Integer> templist = new ArrayList<Integer>();
        Arrays.sort(candidates);
        
        backtracking(res, templist, candidates, target, 0);
        return res;
    }

    private void backtracking(List<List<Integer>> res, List<Integer> templist, int[] candidates, int remain, int start) {
        if (remain < 0) {
            return;
        } else if (remain == 0) {
            res.add(new ArrayList<Integer>(templist));
            return;
        } else {
            for (int i = start; i < candidates.length; i++) {
                templist.add(candidates[i]);
                if (remain - candidates[i] < 0) {
                    templist.remove(templist.size() - 1);
                    return;
                }
                backtracking(res, templist, candidates, remain - candidates[i], i); // start at i again because can reuse itself
                templist.remove(templist.size() - 1);
            }
        }
    }
}