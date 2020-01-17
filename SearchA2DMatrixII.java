public class SearchA2DMatrixII {

    /**
     * Search Space Reduction Approach
     * Time - O(m + n)
     * Space - O(1)
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // start our pointer in the bottom left;
        int row = matrix.length - 1;
        int col = 0;

        while (row >= 0 && col < matrix[0].length) {
            if (target < matrix[row][col]) {
                row --;
            } else if (target > matrix[row][col]) {
                col ++;
            } else { // found it
                return true;
            }
        } 
        return false;
    }
}