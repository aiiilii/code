import java.util.ArrayList;
import java.util.List;


public class Permutations {

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        if (nums == null || nums.length == 0) {
            return res;
        }
        List<Integer> templist = new ArrayList<Integer>();
        boolean[] used = new boolean[nums.length];
        
        backtrack(res, templist, nums, used);
        return res;
    }

    private static void backtrack(List<List<Integer>> res, List<Integer> templist, int[] nums, boolean[] used) {
        if (templist.size() == nums.length) {
            res.add(new ArrayList<Integer>(templist));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            
            templist.add(nums[i]);
            used[i] = true;
            backtrack(res, templist, nums, used);
            used[i] = false;
            templist.remove(templist.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3};
        permute(nums);
    }
}