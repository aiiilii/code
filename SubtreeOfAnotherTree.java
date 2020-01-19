public class SubtreeOfAnotherTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x) { val = x; }
    }

    /**
     * Comparing Nodes approach
     * Time - O(m * n)
     * Space - O(n), n is number of nodes in s
     * @param s - the bigger tree
     * @param t - the subtree
     * @return
     */
    public boolean isSubtree1(TreeNode s, TreeNode t) {
        return traverse(s, t);
    }

    private boolean traverse(TreeNode s, TreeNode t) {
        return s != null && (equals(s, t) || traverse(s.left, t) || traverse(s.right, t));
    }

    private boolean equals(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        return s.val == t.val && equals(s.left, t.left) && equals(s.right, t.right);
    }



    /**
     * Preorder appraoch - slow
     * Time - O(m^2 + n^2 + m*n), a total of n nodes of the tree s and m nodes of tree t
     * Space - O(max(m, n))
     * @param s
     * @param t
     * @return
     */
    public boolean isSubtree(TreeNode s, TreeNode t) {
        String tree1 = preorder(s, true);
        String tree2 = preorder(t, true);

        return tree1.indexOf(tree2) >= 0;
    }

    private String preorder(TreeNode root, boolean left) {
        if (root == null) {
            if (left) {
                return "lnull";
            } else {
                return "rnull";
            }
        }
        return "#" + root.val + " " + preorder(root.left, true) + " " + preorder(root.right, false);
    }
}