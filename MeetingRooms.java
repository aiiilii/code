import java.util.Arrays;
import java.util.Comparator;

public class MeetingRooms {

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