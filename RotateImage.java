public class RotateImage {

    /**
     * To rotate, we can transpose the matrix firstly, then reverse columns:
        for a matrix:
        [1,2,3],
        [4,5,6],
        [7,8,9]

        1/ transpose: swap( matrix[i][j], matrix[j][i] )
        [1,4,7],
        [2,5,8],
        [3,6,9]

        2/ reverse columns: swap( matrix[][i], matrix[][j] )
        [7,4,1],
        [8,5,2],
        [9,6,3]
     */

    
    /**
     * Time - O(n^2)
     * Space - O(1)
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // transpose matrix
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) { // j start at i because if j start at 0, then the swap would repeat itself and swap back.
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = temp;
            }
        }
    }


    /**
     * Time - O(n^2)
     * Space - O(1)
     * @param matrix
     */
    public void rotate1(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < (n + 1) / 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - j - 1];
                matrix[n - 1 - i][n - j - 1] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }
}