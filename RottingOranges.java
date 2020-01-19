import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {

    /**
     * Faster
     * Time - O(h * w * (h + w)), where h and w are the dimension of the grid. We are scanning h + w times (maximum distance between two cells) through all grid cells.
     * Space - O(1)
     * @param grid
     * @return
     */
    public int orangesRotting2(int[][] grid) {
        int fresh = 0;
        int days = 0;
        // count fresh oranges;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    fresh ++;
                }
            }
        }
        
        // until fresh oranges is non-zero, perform bfs to rot oranges, decresing fresh. 
        for (int old_fresh = fresh; fresh > 0; days ++, old_fresh = fresh) {
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == days + 2) { // process oranges that rotted yesterday;
                        fresh -= rot(grid, i + 1, j, days) + rot(grid, i - 1, j, days) + rot(grid, i, j + 1, days) + rot(grid, i, j - 1, days);
                    }
                }
            }
            // if after another day, fresh does not change, return -1, meaning cannot rot all oranges.
            if (fresh == old_fresh) {
                return -1;
            }
        }
        return days;
    }

    private int rot(int[][] grid, int i, int j, int days) {
        if (i < 0 || j < 0 || i >= grid.length || j > grid[i].length || grid[i][j] != 1) {
            return 0;
        }
        grid[i][j] = days + 3;
        return 1;
    }


    /**
     * Slower
     * @param grid
     * @return
     */
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        Queue<int[]> queue = new LinkedList<int[]>();
        int count_fresh = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j}); // position all the rotten oranges in to queue;
                } else if (grid[i][j] == 1) {
                    count_fresh ++; // count the number of fresh oranges;
                }
            }
        }

        if (count_fresh == 0) {
            return 0;
        }

        int count = 0;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!queue.isEmpty()) {
            count ++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] point = queue.poll();
                for (int[] dir : directions) {
                    int x = point[0] + dir[0];
                    int y = point[1] + dir[1];

                    if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == 0 || grid[x][y] == 2) {
                        continue;
                    }
                    grid[x][y] = 2;
                    // put the new rotten orange at (x, y) into the queue
                    queue.offer(new int[] {x, y});
                    count_fresh --;
                }
            }
        }
        if (count_fresh == 0) {
            return count - 1;
        } else {
            return -1;
        }
    }
}