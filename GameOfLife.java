public class GameOfLife {

    /**
     * Rules:
     * 1) Any live cell with fewer than two live neighbors dies, as if caused by under-population.
     * 2) Any live cell with two or three live neighbors lives on to the next generation.
     * 3) Any live cell with more than three live neighbors dies, as if by over-population..
     * 4) Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
     * Time - O(m * n)
     * Space - O(m * n)
     * @param board
     */
    public void gameOfLife(int[][] board) {

        int[] neighbors = new int[] {0, 1, -1}; // neighbors array to find 8 neighboring cells for a given cell;

        int rows = board.length;
        int cols = board[0].length;
        
        int[][] copyBoard = new int[rows][cols]; // create a copy of the original board, because cannot update board one value by one value;

        for (int row = 0; row < rows; row ++) {
            for (int col = 0; col < cols; col ++) {
                copyBoard[row][col] = board[row][col];
            }
        }

        for (int row = 0; row < rows; row ++) { // iterate through board cell by cell
            for (int col = 0; col < cols; col ++) {

                int liveNeighbors = 0; // for each cell, count the number of live neighbors

                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (!(neighbors[i] == 0 && neighbors[j] == 0)) { // if does not equal to center self,
                            int r = (row + neighbors[i]); // new row and new col;
                            int c = (col + neighbors[j]);

                            // Check the validity of the neighboring cell
                            // and whether it was originally a live cell
                            // The evaluation is done agains the copy, since that is never updated.
                            if ((r < rows && r >= 0) && (c < cols && c >= 0) && (copyBoard[r][c] == 1)) {
                                liveNeighbors += 1;
                            }
                        }
                    }
                }

                // Rule 1 or Rule 3
                if ((copyBoard[row][col] == 1) && (liveNeighbors < 2 || liveNeighbors > 3)) {
                    board[row][col] = 0;
                }

                // Rule 4
                if (copyBoard[row][col] == 0 && liveNeighbors == 3) {
                    board[row][col] = 1;
                }
            }
        }
    }
}