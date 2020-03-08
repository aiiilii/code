public class FlattenBinaryTreeToLinkedlist {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    /**
     * Iterative
     * Time - O(n), process each node twice;
     * Space - O(1)
     * @param root
     */
    public void flatten1(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode node = root;

        while (node != null) {
            if (node.left != null) {
                TreeNode rightMost = node.left;

                while (rightMost.right != null) {
                    rightMost = rightMost.right;
                }
                rightMost.right = node.right;
                node.right = node.left;
                node.left = null;
            }
            node = node.right;
        }
    }



    /**
     * Recursive
     * Time - O(n), process each node once;
     * Space - O(n), call stack;
     * @param root
     */
    public void flatten(TreeNode root) {
        flattenTree(root);
    }

    private TreeNode flattenTree(TreeNode node) {
        if (node == null || (node.left == null || node.right == null)) {
            return node;
        }

        TreeNode leftTail = flattenTree(node.left);
        TreeNode rightTail = flattenTree(node.right);

        if (leftTail != null) {
            leftTail.right = node.right;
            node.right = node.left;
            node.left = null;
        }
        
        if (rightTail == null) {
            return leftTail;
        } else {
            return rightTail;
        }
    }
}