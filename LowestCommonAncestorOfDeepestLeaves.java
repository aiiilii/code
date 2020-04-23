public class LowestCommonAncestorOfDeepestLeaves {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int x) { val = x; }
    }

    int max = 0;
    TreeNode lca;

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        helper(root, 0);
        return lca;
    }

    private int helper(TreeNode node, int depth) {
        max = Math.max(max, depth);

        if (node == null) {
            return depth;
        }

        int maxLeft = helper(node.left, depth + 1);
        int maxRight = helper(node.right, depth + 1);

        if (maxLeft == max && maxRight == max) {
            lca = node;
        }

        return Math.max(maxLeft, maxRight);
    }
}