import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

    /**
     * HashMap Approach
     * Time - O(n)
     * Space - O(n)
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;

        if (nums == null || nums.length == 0) {
            return count;
        }

        Map<Integer, Integer> mp = new HashMap<Integer, Integer>();
        mp.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (mp.containsKey(sum - k)) {
                count += mp.get(sum - k);
            }
            mp.put(sum, mp.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    
    /**
     * Cummulative sum approach
     * Time - O(n^2)
     * Space - O(n)
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum1(int[] nums, int k) {
        int count = 0;
        int[] sum = new int[nums.length + 1];
        sum[0] = 0;

        // sum is not zero based, sum is one-based thus start at 1 end at nums.length
        // but nums is still zero-based thus adding the current number is nums[i - 1] not nums[i]
        for (int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        for (int start = 0; start < nums.length; start ++) {
            for (int end = start + 1; end <= nums.length; end ++) {
                if (sum[end] - sum[start] == k) {
                    count ++;
                }
            }
        }
        return count;
    }
}