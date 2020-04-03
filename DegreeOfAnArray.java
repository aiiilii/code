import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class DegreeOfAnArray {

    /**
     * Time - O(n), n is the length of nums
     * Space - O(n), for left right and count
     * @param nums
     * @return
     */
    public int findShorestSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Map<Integer, Integer> left = new HashMap<Integer, Integer>();
        Map<Integer, Integer> right = new HashMap<Integer, Integer>();
        Map<Integer, Integer> count = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if (left.get(x) == null) {
                left.put(x, i);
            }
            right.put(x, i);
            count.put(x, count.getOrDefault(x, 0) + 1);
        }

        int res = nums.length;
        int degree = Collections.max(count.values());

        for (int x : count.keySet()) {
            if (count.get(x) == degree) {
                res = Math.min(res, right.get(x) - left.get(x) + 1);
            }
        }

        return res;
    }
}