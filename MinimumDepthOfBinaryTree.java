public class MinimumDepthOfBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        // if left subtree is NULL, recur for right subtree
        if (root.left == null) {
            return minDepth(root.right) + 1;
        }
        // if right subtree is NULL, recur for left subtree
        if (root.right == null) {
            return minDepth(root.left) + 1;
        }
        // if both subtrees are not NULL, then find the minimum
        return Math.min(minDepth(root.right), minDepth(root.left)) + 1;
    }
}