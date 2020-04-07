public class FlipAnImage {

    /**
     * One pass
     * For each row, use two pointers. One going forward and another going backwards.
     * 1. If the two elements are the same, then make a light change: 0 -> 1 or 1 -> 0
     * 2. If the two elements are different, DON'T do anything. Continue.
     * Time - O(n)
     * Space - O(1)
     * @param A
     * @return
     */
    public int[][] flipAndInvertImage(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            int low = 0;
            int high = A[0].length - 1;

            while (low <= high) {
                if (A[i][low] == A[i][high]) {
                    A[i][low] = 1 - A[i][low];
                    A[i][high] = A[i][low];
                }
                low ++;
                high --;
            }
        }
        return A;
    }
}