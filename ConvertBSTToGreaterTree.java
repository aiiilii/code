import java.util.Stack;

public class ConvertBSTToGreaterTree {

    int sum = 0;

    public class TreeNode {
        int val;
        TreeNode right;
        TreeNode left;
        TreeNode(int x) { val = x; }
    }

    /**
     * Recursive approach - O(n) - a bit faster
     * @param root
     * @return
     */
    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        convertBST(root.right);
        root.val += sum;
        sum = root.val;
        convertBST(root.left);
        return root;
    }

    /**
     * Iterative approach - O(n)
     * @param root
     * @return
     */
    public TreeNode convertBST2(TreeNode root) {
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();

        int sum = 0;
        while (node != null || stack.size() > 0) {
            if (node != null) {
                stack.push(node);
                node = node.right;
            } else {
                node = stack.pop();
                sum += node.val;
                node.val = sum;

                node = node.left;
            }
        }
        return root;
    }
}