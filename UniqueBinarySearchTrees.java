public class UniqueBinarySearchTrees {

    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int rootNodes = 2; rootNodes <= n; rootNodes ++) {
            for (int left = 0; left < rootNodes; left ++) {
                // rootNodes = number of nodes; left = number of left nodes;
                // thus number of right nodes = rootNodes - left - 1; 1 is for the root
                dp[rootNodes] += dp[rootNodes - left - 1] * dp[left];
            }
        }
        return dp[n];
    }
}