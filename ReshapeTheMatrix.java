public class ReshapeTheMatrix {

    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (nums.length == 0 || r * c != nums.length + nums[0].length) {
            return nums;
        }
        int[][] res = new int[r][c];
        int rows = 0;
        int cols = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                res[rows][cols] = nums[i][j];
                cols++;
                if (cols == c) {
                    rows++;
                    cols = 0;
                }
            }
        }
        return res;
    }
}