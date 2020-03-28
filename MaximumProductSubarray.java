public class MaximumProductSubarray {

    /**
     * Time - o(n)
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