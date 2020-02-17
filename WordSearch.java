public class WordSearch {

    /**
     * DFS backtracking
     * Time - O(N * 4^L), n is the number of cells in the board, L is the length of the word to be matched;
     * Space - O(L), L is the length of the word, the maximum length of the call stack would be the length of the word;
     * @param board
     * @param word
     * @return
     */
    public boolean exist1(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0 || word.length() == 0) {
            return false;
        }

        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (backtracking(board, rows, cols, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtracking(char[][] board, int rows, int cols, int r, int c, String word, int index) {
        if (index >= word.length()) { // if index at word.length() then means traversing the word has finished and the word has been found;
            return true;
        }

        if (r < 0 || r >= rows || c < 0 || c >= cols || board[r][c] != word.charAt(index)) {
            return false;
        }

        board[r][c] = '#'; // board[r][c] == word.charAt(index); found one and change it to '#' so cannot be reused in the same word;

        int[] dx = new int[] {-1, 0, 0, 1};
        int[] dy = new int[] {0, -1, 1, 0};

        for (int k = 0; k < 4; k++) {
            if (backtracking(board, rows, cols, r + dx[k], c + dy[k], word, index + 1)) {
                return true;
            }
        }
        board[r][c] = word.charAt(index); // change it back after the same round;
        return false;
    }




    /**
     * 
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        boolean[][] used = new boolean[board.length][board[0].length];

        for (int row = 0; row < board.length; row ++) {
            for (int col = 0; col < board[0].length; col ++) {
                if (dfs(board, used, word.toCharArray(), 0, col, row)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, boolean[][] used, char[] wordChars, int idx, int col, int row) {
        if (idx == wordChars.length) {
            return true;
        }
        // if out of bounds
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length) {
            return false;
        }
        if (used[row][col] == true || board[row][col] != wordChars[idx]) {
            return false;
        }
        // To not use the already used ones in this round
        used[row][col] = true;

        boolean exits = dfs(board, used, wordChars, idx + 1, col + 1, row);
        if (exits) {
            return true;
        }

        exits = dfs(board, used, wordChars, idx + 1, col - 1, row);
        if (exits) {
            return true;
        }

        exits = dfs(board, used, wordChars, idx + 1, col, row + 1);
        if (exits) {
            return true;
        }

        exits = dfs(board, used, wordChars, idx + 1, col, row - 1);
        if (exits) {
            return true;
        }

        // Reseting the used[][]
        used[row][col] = false;
        return false;
    }
}