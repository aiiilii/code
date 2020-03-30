import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInAnArray {

    /**
     * When find a number i, flip the number at position i-1 to negative. 
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
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                res.add(index + 1); // index could never be negative;
            }
            nums[index] = -nums[index];
        }
        return res;
    }
}