import java.util.LinkedList;
import java.util.Queue;
import java.util.Map;
import java.util.HashMap;

public class RottingOranges {

    // directions mapping;
    int[] dr = new int[] {-1, 0, 1, 0}; 
    int[] dc = new int[] {0, -1, 0, 1};
    /**
     * BFS
     * Time - O(n)
     * Space - O(n)
     * @param grid
     * @return
     */
    public int orangesRotting1(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;

        Queue<Integer> queue = new LinkedList<Integer>();
        Map<Integer, Integer> depth = new HashMap<Integer, Integer>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == 2) {
                    int code = i * columns + j;
                    queue.offer(code);
                    depth.put(code, 0);
                }
            }
        }

        int ans = 0;

        while (!queue.isEmpty()) {
            int code = queue.poll();
            int R = code / columns;
            int C = code % columns;

            for (int k = 0; k < 4; k++) { // for the 4 directions;
                int newR = R + dr[k];
                int newC = C + dc[k];
                if (0 <= newR && newR < rows && 0 <= newC && newC < columns && grid[newR][newC] == 1) { // not out of bounds and orange is fresh
                    grid[newR][newC] = 2; // make it rotten
                    int newCode = newR * columns + newC;
                    queue.offer(newCode);
                    depth.put(newCode, depth.get(code) + 1); // plus 1 more day;
                    ans = depth.get(newCode);
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == 1) { // if there is still fresh orange, meaning cannot rot all fresh oranges;
                    return -1;
                }
            }
        } 
        return ans;
    }


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