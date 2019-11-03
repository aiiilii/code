public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        int index = 0; //start placing things at the 0th index
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}