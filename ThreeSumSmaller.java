import java.util.Arrays;

public class ThreeSumSmaller {

    public int threeSumSmaller(int[] nums, int target) {
        int res = 0;
        if (nums == null || nums.length < 3) {
            return res;
        }
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 2; i ++) {
            int low = i + 1;
            int high = nums.length - 1;
            int sum2 = target - nums[i];
            
            while (low < high) {
                int curr = nums[low] + nums[high];
                if (curr < sum2) {
                    res += high - low;
                    low ++;
                } else {
                    high --;
                }
            }
        }
        return res;
    }
}