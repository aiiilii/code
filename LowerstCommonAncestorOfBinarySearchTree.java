public class LowerstCommonAncestorOfBinarySearchTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * Recursive approach
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (p.val > root.val && q.val > root.val) {
            // if both p and q are greater than parents
            return lowestCommonAncestor(root.right, p, q);
        } else if (p.val < root.val && q.val < root.val) { // not <= because assume all numbers are distinct
            // if both p and q are lesser than parents
            return lowestCommonAncestor(root.left, p, q);
        } else {
            // if one is greater and the other is lesser, then we have found the split meaning one is in the left subtree and the other in the right subtree
            return root;
        }
    }

    /**
     * Iterative
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        int pVal = p.val; // value of p
        int qVal = q.val; // value of q
        TreeNode node = root; // start from the root node of the tree

        while(node != null) {
            int parentVal = node.val;

            if (pVal > parentVal && qVal > parentVal) {
                node = node.right;
            } else if (pVal < parentVal && qVal < parentVal) {
                node = node.left;
            } else {
                return node;
            }
        }
        return null;
    }
}