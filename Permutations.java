import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        if (nums == null || nums.length == 0) {
            return res;
        }
        List<Integer> templist = new ArrayList<Integer>();
        backtrack(res, templist, nums);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> templist, int[] nums) {
        if (templist.size() == nums.length) {
            res.add(new ArrayList<Integer>(templist));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (templist.contains(nums[i])) {
                continue;
            }
            templist.add(nums[i]);
            backtrack(res, templist, nums);
            templist.remove(templist.size() - 1);
        }
    }
}