public class SpiralMatrixII {

    /**
     * Time - O(n)
     * Space - O(n)
     * @param n
     * @return
     */
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        if (n <= 0) {
            return matrix;
        }
        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = n - 1;

        int k = 1;

        while (top < bottom && left < right) {
            for (int i = left; i < right; i++) {
                matrix[top][i] = k++;
            }
            for (int i = top; i < bottom; i++) {
                matrix[i][right] = k++;
            }
            for (int i = right; i > left; i--) {
                matrix[bottom][i] = k++;
            }
            for (int i = bottom; i > top; i--) {
                matrix[i][left] = k++;
            }
            left ++;
            right --;
            top ++;
            bottom --;
        }
        if (n % 2 != 0) {
            matrix[n / 2][n / 2] = k;
        }
        return matrix;
    }
}