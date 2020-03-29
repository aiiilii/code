public class RegionsCutBySlashes {

    /**
     * Union Find Class
     */
    public static class DSU {
        int[] parent;
        public DSU(int N) {
            for (int i = 0; i < N; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
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
        DSU dsu = new DSU(4 * N * N);

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                int root = 4 * (r * N + c);
                char val = grid[r].charAt(c);
                if (val != '\\') {
                    dsu.union(root + 0, root + 1);
                    dsu.union(root + 2, root + 3);
                }
                if (val != '/') {
                    dsu.union(root + 0, root + 2);
                    dsu.union(root + 1, root + 3);
                }

                if (r + 1 < N) {
                    dsu.union(root + 3, (root + 4 * N) + 0);
                }
                if (r - 1 >= 0) {
                    dsu.union(root + 0, (root - 4 * N) + 3);
                }
                if (c + 1 < N) {
                    dsu.union(root + 2, (root + 4) + 1);
                }
                if (c - 1 >= 0) {
                    dsu.union(root + 1, (root - 4) + 2);
                }
            }
        }
        int res = 0;
        for (int x = 0; x < 4 * N * N; x++) {
            if (dsu.find(x) == x) {
                res ++;
            }
        }
        return res;
    }
}