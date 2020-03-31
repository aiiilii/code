import java.util.ArrayList;
import java.util.List;

public class MajorityElementII {

    /**
     * Moore's Voting Algorithm
     * We need two candidates with top 2 frequency. 
     * If meeting different number from the candidate, then decrease 1 from its count, or increase 1 on the opposite condition.
     * Once count equals 0, then swaitch the candidate to the current number.
     * The trick is that we need to count again for the two candidates after the first loop.
     * Time - O(n)
     * Space - O(1)
     * @param nums
     * @return
     */
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) {
            return res;
        }

        int n1 = 0;
        int n2 = 0;
        int c1 = 0;
        int c2 = 0;

        for (int num : nums) {
            if (num == n1) {
                c1 ++;
            } else if (num == n2) {
                c2 ++;
            } else if (c1 == 0) {
                c1 = 1;
                n1 = num;
            } else if (c2 == 0) {
                c2 = 1;
                n2 = num;
            } else {
                c1 --;
                c2 --;
            }
        }

        c1 = 0;
        c2 = 0;

        for (int num : nums) {
            if (num == n1) {
                c1 ++;
            } else if (num == n2) {
                c2 ++;
            }
        }

        if (c1 > nums.length / 3) {
            res.add(n1);
        }
        if (c2 > nums.length / 3) {
            res.add(n2);
        }

        return res;
    }
}