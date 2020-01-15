import java.util.Arrays;
import java.util.Comparator;

public class MeetingRooms {

    /**
     * Faster
     * @param intervals
     * @return
     */
    public boolean canAttendMeetings1(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return true;
        }

        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);

        for (int i = 0; i < start.length - 1; i++) {
            if (end[i] > start[i + 1]) { // next start before last end;
                return false;
            }
        }
        return true;
    }




    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, new SortIntArray());

        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i][1] > intervals[i + 1][0]) {
                return false;
            }
        }
        return true;
    }

    private class SortIntArray implements Comparator<int[]> {

        public int compare(int[] a, int[] b) {
            return a[0] - b[0];
        }
    }

}