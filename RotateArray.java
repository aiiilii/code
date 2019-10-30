public class RotateArray {

    /**
     * Reverse approach
     * First, reverse the whole array.
     * Second, reverse the first k numbers of the array.
     * Last, reverse the last n-k numbers of the array.
     * @param nums
     * @param k rotate k times to the right
     */
    public void rotate(int[] nums, int k) {
        if (k == 0) {
            return;
        }
        k = k % nums.length; // for nums.length to be less than or equal to k
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}