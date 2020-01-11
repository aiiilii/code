public class MinimumPathSum {

    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int height = grid.length;
        int width = grid[0].length;

        int[][] sums = new int[height][width];
        sums[0][0] = grid[0][0];

        for (int i = 1; i < height; i++) {
            sums[i][0] = sums[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < width; j++) {
            sums[0][j] = sums[0][j - 1] + grid[0][j];
        }

        for (int i = 1; i < height; i++) {
            for (int j = 1; j < width; j++) {
                sums[i][j] = Math.min(sums[i - 1][j], sums[i][j - 1]) + grid[i][j];
            }
        }
        return sums[height - 1][width - 1];
    }
}