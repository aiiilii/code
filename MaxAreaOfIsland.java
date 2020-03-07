public class MaxAreaOfIsland {

    /**
     * Time - O(m * n), m is the number of rows, n is the number of columns;
     * Space - O(m * n), m is the number of rows, n is the number of columns;
     * @param grid
     * @return
     */
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int maxCount = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                maxCount = Math.max(maxCount, dfs(grid, i, j));
            }
        }
        return maxCount;
    }

    private int dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == 0 || grid[i][j] == 2) {
            return 0;
        }
        grid[i][j] = 2;

        return 1 + dfs(grid, i + 1, j) + dfs(grid, i - 1, j) + dfs(grid, i, j + 1) + dfs(grid, i, j - 1);
    }
}