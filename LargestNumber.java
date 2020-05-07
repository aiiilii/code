import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
    
    /**
     * Time - O(n log n), sort comparator
     * Space - O(n), copy nums[] into strs[]
     * @param nums
     * @return
     */
    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                String order1 = a + b;
                String order2 = b + a;
                return order2.compareTo(order1);
            }
        });

        // If, after being sorted, the largest number is 0,
        // then the entire number if 0;
        if (strs[0].equals("0")) {
            return "0";
        }

        String res = new String();
        for (String str : strs) {
            res += str;
        }

        return res;
    }
}