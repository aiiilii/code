public class MinumumSizeSubarraySum {
    
    /**
     * Two pointer approach
     * Time - O(n)
     * Space - O(1)
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0 || s == 0) {
            return 0;
        }

        int res = Integer.MAX_VALUE;
        int sum = 0;
        int temp = 0;

        // i is the faster pointer, j is the slower pointer
        for (int i = 0, j = 0; i < nums.length; i++) {
            sum += nums[i];
            temp ++;

            while (sum >= s) {
                res = Math.min(res, temp); // update res;

                // move the slow pointer foward and decrease the related nums[j], decrease temp;
                temp --;
                sum -= nums[j];
                j ++; 
            }
        }
        return (res == Integer.MAX_VALUE) ? 0 : res;
    }
}