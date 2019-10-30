import java.util.HashMap;

public class MajorityElement {

    /**
     * Hashmap approach
     * @param nums
     * @return which element occurs for majority of the time, which is more than half of the number of elements
     */
    public int majorityElement(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            if (map.containsKey(i) && map.get(i) + 1 > nums.length / 2) {
                return i;
            } else {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }
        }
        return -1;
    }

    /**
     * Brute force approach
     * @param nums
     * @return
     */
    public int majorityElement2(int[] nums) {
        int majorityCount = nums.length / 2;
        for (int num : nums) {
            int count = 0;
            for (int elem : nums) {
                if (elem == num) {
                    count++;
                }
            }
            if (count > majorityCount) {
                return num;
            }
        }
        return -1;
    }
}