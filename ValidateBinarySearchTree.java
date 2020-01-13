public class ValidateBinarySearchTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x) { val = x; }
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isBST(root, null, null) ;
    }

    private boolean isBST(TreeNode root, Integer max, Integer min) {
        if (root == null) {
            return true;
        }

        if ((max != null && root.val >= max) || (min != null && root.val <= min)) {
            return false;
        }

        return isBST(root.left, root.val, min) && isBST(root.right, max, root.val);
    }
}