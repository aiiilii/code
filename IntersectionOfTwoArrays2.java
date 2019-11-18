import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class IntersectionOfTwoArrays2 {

    public int[] intersectionOfTwoArrays2(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int num : nums2) {
            if (map.containsKey(num) && map.get(num) > 0) {
                queue.offer(num);
                map.put(num, map.get(num) - 1);
            }
        }
        int i = 0;
        int [] result = new int[queue.size()];
        while (!queue.isEmpty()) {
            result[i] = queue.poll();
            i++;
        }
        return result;
    }
}