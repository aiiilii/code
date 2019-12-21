import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum{

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        if (nums.length < 3 || nums == null) {
            return res;
        }
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 2; i ++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) { // taking care of duplicates
                int low = i + 1;
                int high = nums.length - 1;
                int sum = 0 - nums[i];
                
                while(low < high) {
                    if (nums[low] + nums[high] == sum) {
                        res.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        while (low < high && nums[low] == nums[low + 1]) {
                            low ++; // keep increasing until not meeting the same number
                        }
                        while (low < high && nums[high] == nums[high - 1]) {
                            high --; // keep decreasing until not meeting the same number
                        }
                        low ++;
                        high --;
                    } else if (nums[low] + nums[high] > sum) {
                        high --;
                    } else {
                        low ++;
                    }
                }
            }
        }
        return res;
    }
}