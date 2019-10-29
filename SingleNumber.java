import java.util.HashMap;
import java.util.Map;

public class SingleNumber {

    /**
     * Using XOR
     * @param nums
     * @return
     */
    public int singleNumber(int [] nums) {

        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }

    /**
     * Using HashMap
     * @param nums
     * @return
     */
    public int singleNumber2(int[] nums) {
        HashMap<Integer, Integer> numFrequencies = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (!numFrequencies.containsKey(nums[i])) {
                numFrequencies.put(nums[i], 1);
            } else {
                numFrequencies.put(nums[i], numFrequencies.get(nums[i]) + 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : numFrequencies.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();

            if (value == 1) {
                return key;
            }
        }
        return -1;
    }
}