import java.util.Arrays;

public class ThreeSumClosest{

    public int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3 || nums == null) {
            return Integer.MAX_VALUE;
        }
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[nums.length - 1];

        for (int i = 0; i < nums.length - 2; i ++) {
            int low = i + 1;
            int high = nums.length - 1;

            while (low < high) {
                int currSum = nums[i] + nums[low] + nums[high];
                if (currSum > target) {
                    high --;
                } else {
                    low ++;
                }
                if (Math.abs(target - currSum) < Math.abs(target - res)) {
                    res = currSum;
                }
            }
        }
        return res;
    }
}