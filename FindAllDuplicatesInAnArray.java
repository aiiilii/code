import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInAnArray {

    /**
     * The question specifies that 1 <= a[i] <= n, in an n-sized array, thus the below solution could work.
     * When find a number i, flip the number at position i-1 to negative. This is because position is zero-based.
     * If the number at position i-1 is already negative, i is the number that occurs twice.
     * Time - O(n)
     * Space - O(1)
     * @param nums
     * @return
     */
    public List<Integer> findDuplicate(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        if (nums == null || nums.length < 2) {
            return res;
        }

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1; // use Math.abs to get the true value of the index, because nums[i] might have been changed to negative;
            if (nums[index] < 0) {
                res.add(index + 1); // index could never be negative, and index + 1 is convert the index back to nums[i];
            }
            nums[index] = -nums[index];
        }
        return res;
    }
}