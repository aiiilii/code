public class FindMinimumInRotatedSortedArray {

    /**
     * Binary Search approach
     * Time - O(log n)
     * Space - O(1)
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Integer.MAX_VALUE;
        }

        int low = 0;
        int high = nums.length - 1;

        if (nums[low] <= nums[high]) {
            return nums[0];
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }
            if (nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }

            if (nums[mid] > nums[low]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return Integer.MAX_VALUE;
    }
}