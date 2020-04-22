public class DiagonalTraverse {

    /**
     * Time - O(m * n)
     * Space - O(1)
     * @param matrix
     * @return
     */
    public static int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }

        int n = matrix.length;
        int m = matrix[0].length;

        int row = 0;
        int col = 0;

        int direction = 1;

        int[] res = new int[m * n];
        int r = 0;

        while (row < n && col < m) {
            res[r] = matrix[row][col];
            r ++;

            int nRow = row + (direction == 1 ? -1 : 1);
            int nCol = col + (direction == 1 ? 1 : -1);

            if (nRow < 0 || nRow == n || nCol < 0 || nCol == m) {
                if (direction == 1) {
                    row += (col == m - 1 ? 1 : 0);
                    col += (col < m - 1 ? 1 : 0);
                } else {
                    col += (row == n - 1 ? 1 : 0);
                    row += (row < n - 1 ? 1 : 0);
                }
                direction = 1 - direction;
            } else {
                row = nRow;
                col = nCol;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[][] matrix = new int[][] {{1,2,3}, {4,5,6}, {7,8,9}};
        int[] res = findDiagonalOrder(matrix);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}