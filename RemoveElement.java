public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        if (nums.length == 0 || nums == null) {
            return 0;
        }
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        // i++ in the if statement causes i to be pointing at next index; 
        // thus returning i would be the length
        return i;
    }
}