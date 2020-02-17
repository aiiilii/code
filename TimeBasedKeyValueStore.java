import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TimeBasedKeyValueStore {

    Map<String, TreeMap<Integer, String>> map;

    /**
     * Space - O(n)
     */
    public TimeBasedKeyValueStore() {
        map = new HashMap<String, TreeMap<Integer, String>>();
    }

    /**
     * Time - O(1)
     * @param key
     * @param value
     * @param timestamp
     */
    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new TreeMap<Integer, String>()); // can also use map.put(key, map.getOrDefault(key, new TreeMap<Integer, String>()));
        }
        map.get(key).put(timestamp, value);
    }

    /**
     * Time - O(log n), n is the number of entries in the TimeMap
     * @param key
     * @param timestamp
     * @return
     */
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }
        TreeMap<Integer, String> tree = map.get(key);
        Integer t = tree.floorKey(timestamp); // tree.floorKey returns the greatest key less than or equal to the given key, or null if there is no such key;
        if (t != null) {
            return tree.get(t); // look for the result back in the tree;
        } else {
            return "";
        }
    }
}