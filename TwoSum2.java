import java.util.HashMap;

public class TwoSum2 {

    /**
     * Two pointer approach - fastest
     * Because input array is sorted, this is the fastest way.
     * @param numbers
     * @param target
     * @return the indices of the numbers that add up to the targer in ascending order, not zero-based so have to add 1 to the pointers
     */
    public int[] twoSum(int[] numbers, int target) {
        int pointerA = 0;
        int pointerB = numbers.length - 1;
        int[] result = new int[2];
        while (pointerA <= pointerB) {
            int sum = numbers[pointerA] + numbers[pointerB];
            if (sum > target) {
                pointerB--;
            } else if (sum < target) {
                pointerA++;
            } else { // (sum == target)
                result[0] = pointerA + 1;
                result[1] = pointerB + 1;
                return result;
            }
        }
        return result;
    }

    /**
     * Hashmap approach - medium fast
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum2(int[] numbers, int target) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int[] result = null;
        for (int i = 0; i < numbers.length; i++) {
            if (hm.containsKey(target - numbers[i])) {
                int j = hm.get(target - numbers[i]);
                if (i != j) {
                    result = new int[] {j + 1, i + 1};
                    return result;
                }
            }
            hm.put(numbers[i], i);
        }
        return result;
    }

    /**
     * Brute force approach - super slow
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum3(int[] numbers, int target) {
        int[] result = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target && i != j) {
                    result[0] = i + 1;
                    result[1] = j + 1;
                    return result;
                }
            }
        }
        return result;
    }
}