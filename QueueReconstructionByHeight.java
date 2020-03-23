import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class QueueReconstructionByHeight {

    /**
     * Sorting approach
     * Time - O(n ^ 2), sorting takes n log n, each insert operation takes up to O(k) time, where k is a current number of elements in the list, thus up to O(n ^ 2) time total
     * Space - O(n), for the res
     * @param people
     * @return
     */
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) { // same height,
                    return o1[1] - o2[1]; // ascending number of people in front;
                } else { // different height,
                    return o2[0] - o1[0]; // descending height;
                }
            }
        });

        List<int[]> res = new ArrayList<int[]>();
        for (int[] p : people) {
            res.add(p[1], p);
        }

        return res.toArray(new int[res.size()][2]);
    }
}