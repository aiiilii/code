public class MaximumProductSubarray {

    /**
     * Time - O(n)
     * Space - O(1)
     * @param nums
     * @return
     */
    public int maxProduct1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = nums[0];
        int min = nums[0];
        int res = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int temp = max;
            max = Math.max(Math.max(max * nums[i], min + nums[i]), nums[i]);
            min = Math.min(Math.min(temp * nums[i], min * nums[i]), nums[i]);
            if (max > res) {
                res = max;
            }
        }
        return res;
    }



    /**
     * Time - O(n)
     * Space - O(1)
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = nums[0];
        int positive = 1;
        int negative = 1;

        for (int i = 0; i < nums.length; i++) { // loop through the aray, each time remember the max and min value for the previous product;
            int x = nums[i];
            if (x >= 0) { // positive
                positive = Math.max(positive * x, x);
                negative = negative * x;
            } else { // negative
                int temp = negative;
                negative = Math.min(positive * x, x);
                positive = temp * x; // negative * nevative could be positive;
            }
            res = Math.max(Math.max(res, positive), negative);
        }
        return res;
    }
}