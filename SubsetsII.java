import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class SubsetsII {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        List<Integer> templist = new ArrayList<Integer>();
        backtracking(res, templist, nums, 0);
        return res;
    }

    private void backtracking(List<List<Integer>> res, List<Integer> templist, int[] nums, int start) {
        res.add(new ArrayList<Integer>(templist));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) { // Skip duplicates
                continue;
            }
            templist.add(nums[i]);
            backtracking(res, templist, nums, i + 1);
            templist.remove(templist.size() - 1);
        }
    }
}