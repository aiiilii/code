public class MinimumMovesToEqualArrayElements {

    public int minMoves(int[] nums) {
        int rep = 0;
        int target = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < target) {
                target = nums[i];
            }
        }
        for (int num : nums) {
            rep += num - target;
        }
        return rep;
    }
}