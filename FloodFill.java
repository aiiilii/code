public class FloodFill {
    
    /**
     * Time - O(m * n), length * width of the matrix
     * Space - O(m * n), for the call stack
     * @param image
     * @param sr
     * @param sc
     * @param newColor
     * @return
     */
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int color = image[sr][sc];
        if (color != newColor) {
            dfs(image, sr, sc, color, newColor);
        }
        return image;
    }

    private void dfs(int[][] image, int r, int c, int color, int newColor) {
        if (image[r][c] == color) {
            image[r][c] = newColor;

            if (r > 0) {
                dfs(image, r - 1, c, color, newColor);
            }
            if (c > 0) {
                dfs(image, r, c - 1, color, newColor);
            }
            if (r < image.length - 1) {
                dfs(image, r + 1, c, color, newColor);
            }
            if (c < image[r].length - 1) {
                dfs(image, r, c + 1, color, newColor);
            }
        }
    }
}