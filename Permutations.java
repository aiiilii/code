import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Permutations {

    /**
     * Don't really need the hashmap. It is for if the interviewer challanges the "arraylist.contains()" function since the time complexity of contains() is O(n).
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        if (nums == null || nums.length == 0) {
            return res;
        }
        List<Integer> templist = new ArrayList<Integer>();
        Set<Integer> st = new HashSet<Integer>();
        
        backtrack(res, templist, nums, st);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> templist, int[] nums, Set<Integer> st) {
        if (templist.size() == nums.length) {
            res.add(new ArrayList<Integer>(templist));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (st.contains(nums[i])) {
                continue;
            }
            
            templist.add(nums[i]);
            st.add(nums[i]);
            backtrack(res, templist, nums, st);
            st.remove(templist.get(templist.size() - 1));
            templist.remove(templist.size() - 1);
        }
    }
}