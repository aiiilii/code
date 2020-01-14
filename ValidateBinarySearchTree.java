import java.util.List;
import java.util.ArrayList;

public class ValidateBinarySearchTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x) { val = x; }
    }

    /**
     * Recursion - faster
     * @param root
     * @return
     */
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


    
    List<Integer> res = new ArrayList<Integer>();
    /**
     * Inorder traversal into a sorted array - slower
     * @param root
     * @return
     */
    public boolean isValidBST2(TreeNode root) {
        if (root == null) {
            return true;
        }

        inorder(root);

        for (int i = 0; i < res.size() - 1; i++) {
            if (res.get(i) >= res.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        res.add(root.val);
        inorder(root.right);
    }
}