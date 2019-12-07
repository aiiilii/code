import java.util.HashMap;
import java.util.Map;

public class TwoSum3 {

    Map<Integer, Integer> mp;

    public TwoSum3() {
        mp = new HashMap<Integer, Integer>();
    }

    public void add(int number) {
        if (!mp.containsKey(number)) {
            mp.put(number, 1);
        } else {
            mp.replace(number, mp.get(number) + 1);
        }
    }

    public boolean find(int value) {
        for (Map.Entry<Integer, Integer> p : mp.entrySet()) {
            int otherNumber = value - p.getKey();
            if (mp.containsKey(otherNumber)) {
                if (otherNumber == p.getKey() && p.getValue() > 1) {
                    return true;
                } else if (otherNumber != p.getKey() && p.getValue() > 0) {
                    return true;
                }
            }
        }
        return false;
    }
}