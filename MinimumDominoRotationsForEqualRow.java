public class MinimumDominoRotationsForEqualRow {

    /**
     * Time - O(n)
     * Space - O(1)
     * @param A
     * @param B
     * @return
     */
    public int minDominoRotations1(int[] A, int[] B) {
        int n = A.length;
        int rotations = check(A[0], A, B, n);
        // If one could make all elements in A or B equal to A[0];
        if (rotations != -1 || A[0] == B[0]) {
            return rotations;
        } else { // If one could make all elements in A or B equal to B[0];
            return check(B[0], A, B, n);
        }
    }
    private int check(int x, int[] A, int[] B, int n) {
        int rotations_a = 0;
        int rotations_b = 0;

        for (int i = 0; i < n; i++) {
            // how many rotations should be done
            // to have all elements in A equal to x
            // and to have all elements in B equal to x
            if (A[i] != x && B[i] != x) {
                return -1;
            } else if (A[i] != x) {
                rotations_a ++;
            } else if (B[i] != x) {
                rotations_b ++;
            }
        }
        return Math.min(rotations_a, rotations_b);
    }



    public int minDominoRotations(int[] A, int[] B) {
        int n = A.length;
        
        for (int i = 0, a = 0, b = 0; i < n && (A[i] == A[0] || B[i] == A[0]); i++) {
            if (A[i] != A[0]) {
                a ++;
            }
            if (B[i] != A[0]) {
                b ++;
            }
            if (i == n - 1) {
                return Math.min(a, b);
            }
        }

        for (int i = 0, a = 0, b = 0; i < n && (A[i] == B[0] || B[i] == B[0]); i++) {
            if (A[i] != B[0]) {
                a ++;
            }
            if (B[i] != B[0]) {
                b ++;
            }
            if (i == n - 1) {
                return Math.min(a, b);
            }
        }
        return -1;
    }
}