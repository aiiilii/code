public class MinimumMovesToEqualArrayElements {

    /**
     * Incrementing (n - 1) elements by 1 is equal to decrementing the nth element(which is likely the
     * largest element) by 1 
     * @param nums
     * @return
     */
    public int minMoves(int[] nums) {
        int rep = 0;
        int target = nums[0];
        // target is the minimum, this function finds the minimum and set it as target
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < target) {
                target = nums[i];
            }
        }
        for (int num : nums) {
            // num - targer is the distance between num and target
            rep += num - target;
        }
        return rep;
    }
}