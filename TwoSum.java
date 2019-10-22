import java.util.HashMap;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
       HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
       //int n = nums.length;
       int[] result = null;
       for (int i = 0; i < nums.length; i++) {
           // try to find the (target - nums[i]) in the previous hashmap, not the current hashmap
           if (hm.containsKey(target - nums[i])) {
               int j = hm.get(target - nums[i]);
               result = new int[] {j, i};
               return result;
            }
            // whether found (targer - nums[i]) or not, add (nums[i], i) anyway into the current hashmap
            hm.put(nums[i], i);
        }
        return result;
    }

    public static void main(String[] args) {
        
    }

}