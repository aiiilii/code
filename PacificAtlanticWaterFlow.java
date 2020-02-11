import java.util.List;
import java.util.ArrayList;

public class PacificAtlanticWaterFlow {

    public int[] dx = new int[] {-1, 0, 0, 1};
    public int[] dy = new int[] {0, 1, -1, 0};

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        boolean[][] pacific = new boolean[rows][cols]; // stores that pacific can reach;
        boolean[][] atlantic = new boolean[rows][cols]; // stores that atlantic can reach;

        for (int i =0; i < rows; i++) {
            explore(pacific, matrix, i, 0); // pacific left side;
            explore(atlantic, matrix, i, cols - 1); // atlantic right side;
        }

        for (int j = 0; j < cols; j++) {
            explore(pacific, matrix, 0, j); // pacific top side;
            explore(atlantic, matrix, rows - 1, j); // atlantic bottom side;
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (pacific[i][j] == true && atlantic[i][j] == true) { // if both pacific and atlantic can reach i, j, then add into list
                    List<Integer> temp = new ArrayList<Integer>();
                    temp.add(i);
                    temp.add(j);
                    res.add(temp);
                }
            }
        }
        return res;
    }

    private void explore(boolean[][] grid, int[][] matrix, int i, int j) {
        grid[i][j] = true; // change to true if reachable;
        for (int k = 0; k < 4; k++) {
            if ((i + dy[k] < grid.length && i + dy[k] >= 0) && (j + dx[k] < grid[0].length && j + dx[k] >= 0) && 
            grid[i + dy[k]][j + dx[k]] == false && matrix[i + dy[k]][j + dx[k]] >= matrix[i][j]) { // if in bounds, AND the next == false, which means have not visited, AND the next is larger than curr value on the given matrix;
                explore(grid, matrix, i + dy[k], j + dx[k]); // then keep exploring with the next indices;
            }
        }
    }
}