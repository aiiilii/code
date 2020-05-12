public class MinimumIncrementToMakeArrayUnique {
    
    /**
     * Time - O(n)
     * Space - O(n), for the bucket
     * @param A
     * @return
     */
    public int minIncrementForUnique(int[] A) {
        int[] count = new int[100000]; // create a bucket
        for (int x : A) {
            count[x] ++;
        }

        int res = 0;
        int taken = 0; 

        for (int x = 0; x < 100000; x++) {
            if (count[x] >= 2) { // if there is more than 1 count[x] in bucket, 
                taken += count[x] - 1; // taken is to save the extra duplicates to be used for later,
                res -= x * (count[x] - 1); // multiply the extras' count with that x, and deduct from res;
            } else if (taken > 0 && count[x] == 0) { 
                taken --;
                res += x;
            }
        }
        return res;
    }
}