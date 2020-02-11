public class Minesweeper {

    public char[][] updateBoard(char[][] board, int[] click) {
        if (board == null || board.length == 0 || board[0].length == 0 || click.length != 2) {
            return board;
        }

        int m = board.length;
        int n = board[0].length;

        int r = click[0];
        int c = click[1];

        if (board[r][c] == 'M') { // clicked mine;
            board[r][c] = 'X';
        } else {
            int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
            dfs(board, r, c, m, n, dirs);
        }
        return board;
    }

    private void dfs(char[][] board, int r, int c, int m, int n, int[][] dirs) {
        if (r < 0 || r >= m || c < 0 || c >= n || board[r][c] != 'E') { // if out of bounds and clicked something that is not an empty square "E", return directly;
            return;
        }
        int mine = adjMine(board, r, c, m, n); // count how many mines are near the curr indices;
        if (mine > 0) {
            board[r][c] = (char) ('0' + mine); // cast change mine number to char;
        } else { // if mine == 0,
            board[r][c] = 'B'; 
            for (int[] d : dirs) { // dfs check neighboring 8 squares;
                dfs(board, r + d[0], c + d[1], m, n, dirs);
            }
        }
    }

    private int adjMine(char[][] board, int r, int c, int m, int n) {
        int count = 0;
        for (int i = r - 1; i <= r + 1; i++) { // check the surrounding 8 square using from 1 previous to 1 after, thus r - 1 and r + 1
            for (int j = c - 1; j <= c + 1; j++) {
                if ((i >= 0 && i < m) && (j >= 0 && j < n) && board[i][j] == 'M') { // if in bounds and find an 'M', count ++;
                    count ++;
                }
            }
        }
        return count;
    }
}