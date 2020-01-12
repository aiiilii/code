public class WordSearch {

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