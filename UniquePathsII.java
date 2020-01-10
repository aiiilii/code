public class UniquePathsII {
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }

        int height = obstacleGrid.length;
        int width = obstacleGrid[0].length;

        int[][] paths = new int[height][width];

        // first column
        for (int i = 0; i < height; i++) {

            // if not an obstacle, then there is 1 path
            if (obstacleGrid[i][0] != 1) {
                paths[i][0] = 1;
            } else {
                break; // encountered a obstacle; 0 default value
            }
        }

        // first row
        for (int j = 0; j < width; j++) {
            if (obstacleGrid[0][j] != 1) {
                paths[0][j] = 1;
            } else {
                break;
            }
        }

        // other spaces
        for (int i = 1; i < height; i++) {
            for (int j = 1; j < width; j++) {
                if (obstacleGrid[i][j] != 1) {
                    paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
                }
                //otherwise, by default, it is 0
            }
        }
        return paths[height - 1][width - 1];
    }
}