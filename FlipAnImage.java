public class FlipAnImage {

    /**
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