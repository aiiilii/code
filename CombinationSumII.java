import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class CombinationSumII {

    public static List<List<Integer>> combinationSumII(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        List<Integer> templist = new ArrayList<Integer>();
        Arrays.sort(candidates);
        
        backtracking(res, templist, candidates, target, 0);
        return res;
    }

    private static void backtracking(List<List<Integer>> res, List<Integer> templist, int[] candidates, int remain, int start) {
        if (remain < 0) {
            return;
        } else if (remain == 0) {
            res.add(new ArrayList<Integer>(templist));
            return;
        } else {
            for (int i = start; i < candidates.length; i++) {
                if (i > start && candidates[i] == candidates[i - 1]) { // when 3 or more same numbers are present, ex 1,1,1, no need to check individual 1s
                    continue;
                }
                templist.add(candidates[i]);

                if (remain - candidates[i] < 0) {
                    templist.remove(templist.size() - 1);
                    return;
                }

                backtracking(res, templist, candidates, remain - candidates[i], i + 1); // cannot re-use itself
                templist.remove(templist.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] {10,1,1,7,6,1,5};
        System.out.println(combinationSumII(nums, 8));
    }
}