public class LongestUnivaluePath {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int res;
    /**
     * Time - O(n), n is the number of nodes in the tree and we process every node once;
     * Space - O(h), h is the height of the tree, our recursive call stack could be up to h layers deep;
     * @param root
     * @return
     */
    public int longestUnivaluePath(TreeNode root) {
        res = 0;
        dfs(root);
        return res;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = dfs(node.left);
        int right = dfs(node.right);

        int arrowLeft = 0;
        int arrowRight = 0;

        if (node.left != null && node.left.val == node.val) {
            arrowLeft += left + 1;
        }
        if (node.right != null && node.right.val == node.val) {
            arrowRight += right + 1;
        }
        res = Math.max(res, arrowLeft + arrowRight);

        return Math.max(arrowLeft, arrowRight);
    }
}