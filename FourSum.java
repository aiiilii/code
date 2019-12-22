import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        if (nums.length < 4 || nums == null) {
            return res;
        }
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int sum3 = target - nums[i];
                for (int j = i + 1; j < nums.length - 2; j ++) {
                    if (j == i + 1 || (j > i + 1 && nums[j] != nums[j - 1])) {
                        int sum2 = sum3 - nums[j];
                        int low = j + 1;
                        int high = nums.length - 1;

                        while (low < high) {
                            if (nums[low] + nums[high] == sum2) {
                                res.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high]));
                                while (low < high && nums[low] == nums[low + 1]) {
                                    low ++;
                                }
                                while (low < high && nums[high] == nums[high - 1]) {
                                    high --;
                                }
                                low ++;
                                high --;
                            } else if (nums[low] + nums[high] > sum2) {
                                high --;
                            } else {
                                low ++;
                            }
                        }
                    }
                }
            }
        }
        return res;
    }
}