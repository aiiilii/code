public class BalancedBinaryTree {
    
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isBalanced(TreeNode root) {
        int lh; // for height of left subtree
        int rh; // for height of right subtree

        if (root == null) {
            return true;
        }
        lh = height(root.left);
        rh = height(root.right);
        if (Math.abs(lh - rh) <= 1 && isBalanced(root.left) && isBalanced(root.right)) {
            return true;
        }
        return false;
    }

    private int height(TreeNode root) {
        if (root == null) {
            return -1;
        }
        return Math.max(height(root.left), height(root.right)) + 1;
    }
}