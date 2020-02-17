public class DesignHitCounter {

    private int[] times;
    private int[] hits;

    /**
     * Using buckets, 1 bucket for every second because we only need to keep the recent hits info for 300 seconds.
     * hit[] array is wrapped around by mod operation. Each hit bucket is associated with times[] bucket which record current time. 
     * If it is not current time, it means it is 300s or 600s... ago and need to reset to 1.
     */
    public DesignHitCounter() {
        times = new int[300]; // 300 second == 5 mins;
        hits = new int[300];
    }

    /**
     * Time - O(1)
     * @param timestamp
     */
    public void hit(int timestamp) {
        int index = timestamp % 300;
        if (times[index] != timestamp) {
            times[index] = timestamp;
            hits[index] = 1;
        } else {
            hits[index] ++;
        }
    }

    /**
     * Time - O(s), s is the total seconds in given time interval, in this case, 300;
     * @param timestamp
     * @return
     */
    public int getHits(int timestamp) {
        int total = 0;
        for (int i = 0; i < 300; i++) {
            if (timestamp - times[i] < 300) { // within the last 5 mins, do not need to count the ones outside of 5 min range;
                total += hits[i];
            }
        }
        return total;
    }
}