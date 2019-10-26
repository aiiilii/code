public class MaximumDepthOfBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    /**
     * Trying to find the number of NODES from root to leaf; thus when root == null, return 0; if trying to find edges, then return -1 when root == null.
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0; //
        }
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        return Math.max(leftHeight, rightHeight) + 1; 
    }
}