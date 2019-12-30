public class SearchInsertPosition {

    /**
     * Binary Search - O(logn)
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        // When out of the while loop, high has to be < low. 
        // Low can be any value from 0 to nums.length - 1; high can be any value from -1 to nums.length - 2.
        // The number at low is greater than the target, while the number at high is less than the target.
        // What we want here is the number greater than or equal to the target, and take its index, thus return low.
        return low;
    }


    /**
     * Brute force - O(n)
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert1(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        if (target <= nums[0]) {
            return 0;
        }
        if (target > nums[nums.length - 1]) {
            return nums.length;
        }
        if (target == nums[nums.length - 1]) {
            return nums.length - 1;
        }
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            count ++;
            if (nums[i] < target && nums[i + 1] > target) {
                return count;
            } else if (nums[i] == target && nums[i + 1] > target) {
                return count - 1;
            }
        }
        return count + 1;
    }
}