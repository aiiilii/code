import java.util.HashSet;

public class IntersectionOfTwoArrays {

    public int[] intersection (int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums1) {
            set.add(i);
        }

        HashSet<Integer> intersection = new HashSet<>();
        for (int i : nums2) {
            if (set.contains(i)) {
                intersection.add(i);
            }
        }

        int[] result = new int[intersection.size()];
        int i = 0;
        for (int j : intersection) {
            result[i] = j;
            i++;
        }
        return result;
    }
}