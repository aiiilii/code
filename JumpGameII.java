public class JumpGameII {

    /**
     * Time - O(n)
     * Space - O(1)
     * @param nums
     * @return
     */
    public int jump1(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }

        int maxPos = nums[0];
        int maxSteps = nums[0];
        int jumps = 1;

        for (int i = 1; i < nums.length; i++) {
            if (maxSteps < i) {
                jumps ++;
                maxSteps = maxPos;
            }
            maxPos = Math.max(maxPos, nums[i] + i);
        }
        return jumps;
    }





    public int jump(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }

        int currMax = 0;
        int nextMax = 0;
        int step = 0;
        int index = 0;

        while (index <= currMax) {
            while(index <= currMax) {
                nextMax = Math.max(nextMax, index + nums[index]);
                index ++;
            }
            currMax = nextMax;
            step ++;
            if (currMax >= nums.length - 1) {
                return step;
            }
        }
        return 0;
    }
}