public class RegionsCutBySlashes {

    /**
     * Union Find Class
     */
    public static class DSU {
        int[] parent;

        public DSU(int N) {
            parent = new int[N];
            for (int i = 0; i < N; i++) {
                parent[i] = i; // initiallize each parent root is itself;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]); // find the parent root by traversing up the tree;
            }
            return parent[x];
        }

        public void union(int x, int y) {
            parent[find(x)] = find(y);
        }
    }

    /**
     * Time - O(N * N * (aN)), N is the length of the grid, aN is Ackermann of N;
     * Space - O(N * N), for the union parent bucket;
     * @param grid
     * @return
     */
    public int regionsBySlashes(String[] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int N = grid.length;
        DSU dsu = new DSU(4 * N * N); // divide each square into 4 triangles X-shaped;

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                int root = 4 * (r * N + c); // (r * N + c) is the index for each triangle; there are 4 triangles in each square, thus * 4 to find the corresponding index;
                char val = grid[r].charAt(c); 

                // if BLANK, then will enter into both of these if statements.
                if (val != '\\') { // if not '\\', then it means can be both '/' or blank,
                    dsu.union(root + 0, root + 1); // unify top and left
                    dsu.union(root + 2, root + 3); // unify right and bottom;
                }
                if (val != '/') { // if not '/', then it mean can be both '\\' or blank,
                    dsu.union(root + 0, root + 2); // unify top and right
                    dsu.union(root + 1, root + 3); // unify left and bottom;
                }

                if (r + 1 < N) { // if there is still blocks on the bottom,
                    dsu.union(root + 3, (root + 4 * N) + 0); // unify 3 to the next row's 0;
                }
                if (r - 1 >= 0) { // if there is still blocks on the top,
                    dsu.union(root + 0, (root - 4 * N) + 3); // unify 0 to the previous row's 3;
                }
                if (c + 1 < N) { // if there is still blocks to the right,
                    dsu.union(root + 2, (root + 4) + 1); // unify 2 to the next block's 1;
                }
                if (c - 1 >= 0) { // if there is still blocks to the left,
                    dsu.union(root + 1, (root - 4) + 2); // unify 1 to the previous block's 2;
                }
            }
        }
        int res = 0; 
        for (int x = 0; x < 4 * N * N; x++) {
            if (dsu.find(x) == x) { // find out and count how many parent roots there are;
                res ++;
            }
        }
        return res;
    }
}