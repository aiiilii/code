import java.util.List;

public class MinimumTimeDifference {

    public int findMinDifference(List<String> timePoints) {
        boolean[] mark = new boolean[24 * 60];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (String time : timePoints) {
            String[] ts = time.split(":");
            int h = Integer.parseInt(ts[0]);
            int m = Integer.parseInt(ts[1]);

            if (mark[h * 60 + m]) {
                return 0; // duplicate;
            }

            min = Math.min(min, h * 60 + m);
            max = Math.max(max, h * 60 + m);
            mark[h * 60 + m] = true;
        }

        int minDiff = Integer.MAX_VALUE;
        int prevVal = 0;

        for (int i = min; i <= max; i++)  {
            if (mark[i]) {
                if (i == min) {
                    // the min and max is the special case, it looks like :
                    // 0 ---min---max-----1440, so we hve two directions to calculate the distance;
                    minDiff = Math.min(minDiff, Math.min(max - min, 1440 - max + min));
                } else {
                    // normal case : just one direction;
                    minDiff = Math.min(minDiff, i - prevVal);
                }
                prevVal = i;
            }
        }
        return minDiff;
    }
}