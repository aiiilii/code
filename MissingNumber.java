import java.util.Arrays;

public class MissingNumber {

    /**
     * Math approach - fastest
     * @param nums
     * @return
     */
    public int missingNumber3(int[] nums) {
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
        }
        int n = nums.length + 1;
        return (n * (n - 1)) / 2 - sum;
    }

    /**
     * Sorting approach - slower O(nlogn)
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);

        if (nums[nums.length - 1] != nums.length) {
            return nums.length;
        } else if (nums[0] != 0) {
            return 0;
        }
        for (int i = 1; i < nums.length; i++) {
            int expectedNum = nums[i - 1] + 1;
            if (nums[i] != expectedNum) {
                return expectedNum;
            }
        }
        return -1; // if not missing any number
    }

    /**
     * Bitwise - faster O(n)
     * @param nums
     * @return
     */
    public int missingNumber2(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }
}