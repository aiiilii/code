public class RangeSumOfBST {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int res = 0;
    /**
     * Time - O(n), n is the number of nodes in the tree
     * Space - O(h), h is the height of the tree
     * @param root
     * @param L
     * @param R
     * @return
     */
    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) {
            return res;
        }
        dfs(root, L, R);
        return res;
    }

    private void dfs(TreeNode root, int L, int R) {
        if (root == null) {
            return;
        }
        dfs(root.left, L, R);

        if (root.val >= L && root.val <= R) {
            res += root.val;
        }

        dfs(root.right, L, R);
    }
}