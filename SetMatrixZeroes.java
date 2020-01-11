public class SetMatrixZeroes {

    /**
     * We cannot change the matrix[i + 1] or matrix[j + 1] to zeroes or else everything will become 0s
     * Time - O(m * n)
     * Space - O(1)
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        boolean firstRow = false;
        boolean firstCol = false;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                // If an element is zero, we set the first element of the CORRESPONDING row and column to 0
                if (matrix[i][j] == 0) {
                    if (i == 0) {
                        firstRow = true;
                    }
                    if (j == 0) {
                        firstCol = true;
                    }
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Iterate over the array once again and using the first row and first column, update the elements
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // See if the first row needs to be set to zero as well
        if (firstRow) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }

        // See if the first column needs to be set to zero as well
        if (firstCol) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}