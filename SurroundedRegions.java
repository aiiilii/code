import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SurroundedRegions {

    public class Pair<U, V> {
        public U first;
        public V second;

        public Pair(U first, V second) {
            this.first = first;
            this.second = second;
        }
    }

    protected int rows = 0;
    protected int cols = 0;
    /**
     * BFS
     * Time - O(n), n is the number of cells int he board, worst case we would traverse each cell twice;
     * Space - O(n), queue;
     * @param board
     */
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }

        this.rows = board.length;
        this.cols = board[0].length;

        List<Pair<Integer, Integer>> boarders = new LinkedList<Pair<Integer, Integer>>();

        for (int r = 0; r < rows; r++) {
            boarders.add(new Pair<Integer, Integer>(r, 0));
            boarders.add(new Pair<Integer, Integer>(r, cols - 1));
        }

        for (int c = 0; c < cols; c++) {
            boarders.add(new Pair<Integer,Integer>(0, c));
            boarders.add(new Pair<Integer,Integer>(rows - 1, c));
        }

        for (Pair<Integer, Integer> pair : boarders) {
            bfs(board, pair.first, pair.second);
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == 'E') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    protected void bfs(char[][] board, int r, int c) {
        Queue<Pair<Integer, Integer>> queue = new LinkedList<Pair<Integer, Integer>>();
        queue.offer(new Pair<Integer, Integer>(r, c));

        while (!queue.isEmpty()) {
            Pair<Integer, Integer> pair = queue.poll();
            int row = pair.first;
            int col = pair.second;

            if (board[row][col] != 'O') {
                continue;
            }

            board[row][col] = 'E';

            if (col < cols - 1) {
                queue.offer(new Pair<Integer,Integer>(row, col + 1));
            }
            if (row < rows - 1) {
                queue.offer(new Pair<Integer,Integer>(row + 1, col));
            }
            if (col > 0) {
                queue.offer(new Pair<Integer,Integer>(row, col - 1));
            }
            if (row > 0) {
                queue.offer(new Pair<Integer,Integer>(row - 1, col));
            }
        }
    }
}