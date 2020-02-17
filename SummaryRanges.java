import java.util.List;
import java.util.ArrayList;

public class SummaryRanges {

    /**
     * Time - O(n), each element is visited constant times, either in comparison with neighbor or put in the result list;
     * Space - O(1), two indices, if we don't count the return list;
     * @param nums
     * @return
     */
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<String>();
        if (nums == null || nums.length == 0) {
            return res;
        }

        for (int i = 0, j = 0; j < nums.length; j++) {
            if (j + 1 < nums.length && nums[j + 1] == nums[j] + 1) {
                continue;
            }
            if (i == j) {
                res.add(nums[i] + "");
            } else {
                res.add(nums[i] + "->" + nums[j]);
            }
            i = j + 1; // sliding window; move i to one after j and restart;
        }
        return res;
    }
}