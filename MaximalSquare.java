public class MaximalSquare {

    /**
     * Time - O(m * n)
     * Space - O(m * n)
     * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int res = 0;

        int[][] dp = new int[m + 1][n + 1]; // create a matrix that is 1 row and 1 column bigger than the given matrix; initiallize first row and first column to all zeroes

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    // dp[i][j] represent the edge length of the largest square ENDING at position(i, j)
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j - 1]), dp[i - 1][j]) + 1; //need to look a left, up, and diagonal left-up 3 positions and find the min, then + 1;
                    res = Math.max(dp[i][j], res); // keep updating the length of the largest square;
                }
            }
        }
        return res * res;
    }
}