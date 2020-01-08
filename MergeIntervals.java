import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;;

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }

        Arrays.sort(intervals, new SortInArray());

        List<int[]> list = new ArrayList<int[]>();
        
        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int[] interval : intervals) {
            if (interval[0] <= end) {
                end = Math.max(end, interval[1]);
            } else {
                list.add(new int[] {start, end});
                start = interval[0];
                end = interval[1];
            }
        }
        list.add(new int[] {start, end});

        return list.toArray(new int[list.size()][2]);
    }

    private class SortInArray implements Comparator<int[]> {
        public int compare (int[] a, int[] b) {
            return a[0] - b[0];
        }
    }
}