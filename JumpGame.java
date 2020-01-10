public class JumpGame {

    public boolean canJump(int[] nums) {
        if (nums.length < 2) {
            return true;
        }
        int reach = 0;
        
        for (int i = 0; i < nums.length && i <= reach; i++) { // i <= reach because we can going go through the numbers we can reach to
            // nums[i] is steps at current index, i is the index we are on; nums[i] + i is the index we can reach at the current index we are on
            reach = Math.max(reach, nums[i] + i); 
            if (reach >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
}