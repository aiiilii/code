import java.util.Arrays;

public class PartitionToKEqualSumSubset {

    /**
     * Space - O(n)
     * @param nums
     * @param k
     * @return
     */
    public boolean canPartitionKSebsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if (sum % k > 0) {
            return false;
        }
        int target = sum / k;

        Arrays.sort(nums);

        int row = nums.length - 1;
        if (nums[row] > target) {
            return false;
        }
        while (row >= 0 && nums[row] == target) {
            row --;
            k --;
        }
        return search(new int[k], row, nums, target);
    }

    private boolean search(int[] groups, int row, int[] nums, int target) {
        if (row < 0) {
            return true;
        }
        int v = nums[row];
        row --;

        for (int i = 0; i < groups.length; i++) {
            if (groups[i] + v <= target) {
                groups[i] += v;
                if (search(groups, row, nums, target)) {
                    return true;
                }
                groups[i] -= v;
            }
            if (groups[i] == 0) {
                break;
            }
        }
        return false;
    }
}