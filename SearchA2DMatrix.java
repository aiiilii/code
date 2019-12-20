public class SearchA2DMatrix {

    /**
     * Binary search approach -  fast
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix2(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) {
            return false;
        }
        int n = matrix[0].length;

        int left = 0;
        int right = m * n - 1; // if a matrix is m * n, the array version of the matrix would have lenght m * n, thus the last index of the array would be m * n - 1
        int pivotIdx;
        int pivotElement;
        while (left <= right) {
            pivotIdx = left + (right - left) / 2;
            pivotElement = matrix[pivotIdx / n][pivotIdx % n]; // row = idx / n; col = idx % n
            if (target == pivotElement) {
                return true;
            }
            else {
                if (target < pivotElement) {
                    right = pivotIdx - 1;
                } else {
                    left = pivotIdx + 1;
                }
            }
        }
        return false;
    }

    /**
     * Brute force approach - slow
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }
}