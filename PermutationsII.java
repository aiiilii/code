import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        List<Integer> templist = new ArrayList<Integer>();
        boolean[] used = new boolean[nums.length];
        
        Arrays.sort(nums);

        backtracking(res, templist, used, nums);
        return res;
    }

    private void backtracking(List<List<Integer>> res, List<Integer> templist, boolean[] used, int[] nums) {
        if (templist.size() == nums.length) {
            res.add(new ArrayList<Integer>(templist));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            used[i] = true;
            templist.add(nums[i]);
            backtracking(res, templist, used, nums);
            used[i] = false;
            templist.remove(templist.size() - 1);
        }
    }
}