public class RangeSumQueryImmutable {

    // private int[] data;

    /**
     * Brute force
     * @param nums
     */
    // public RangeSumQueryImmutable(int[] nums) {
    //     data = nums;
    // }

    // public int sumRange(int i, int j) {
    //     int sum = 0;
    //     for (int k = i; k <= j; k++) {
    //         sum += data[k];
    //     }
    //     return sum;
    // }


    private int[] sum1;

    /**
     * Caching
     * @param nums
     */
    public RangeSumQueryImmutable(int[] nums) {
        sum1 = new int[nums.length + 1]; 
        for (int i = 0; i < nums.length; i++) {
            sum1[i + 1] = sum1[i] + nums[i];
        }
    }

    public int sumRange2(int i, int j) {
        return sum1[j + 1] - sum1[i];
    }
}