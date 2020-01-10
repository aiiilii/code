public class JumpGameII {

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