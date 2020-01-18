import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Random;


public class InsertDeleteGetRandomO1 {
    
    List<Integer> nums;
    Map<Integer, Integer> map;
    Random rand;

    public InsertDeleteGetRandomO1() {
        nums = new ArrayList<Integer>();
        map = new HashMap<Integer, Integer>();
        rand = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        } else {
            nums.add(val);
            map.put(val, nums.size() - 1); // nums.size() - 1 is the index of the val being put into the arrayList
            return true;
        }
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int index = map.get(val);
        if (index < nums.size() - 1) {
            int lastVal = nums.get(nums.size() - 1);
            nums.set(index, lastVal); // override the val at index with lastVal
            map.put(lastVal, index); // put the overrode lastVal/index pair into the map
        }
        map.remove(val);
        nums.remove(nums.size() - 1); // removing the last one of an arrayList only costs O(1) time
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }
}