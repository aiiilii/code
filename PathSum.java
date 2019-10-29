import java.util.Stack;

public class PathSum {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        Stack<Integer> sumStack = new Stack<Integer>();
        nodeStack.add(root);
        sumStack.add(sum - root.val);

        while (!nodeStack.isEmpty()) {
            TreeNode currentNode = nodeStack.pop();
            int currentSum = sumStack.pop();

            if (currentNode.left == null && currentNode.right == null && currentSum == 0) {
                return true;
            }
            if (currentNode.left != null) {
                nodeStack.add(currentNode.left);
                sumStack.add(currentSum - currentNode.left.val);
            }
            if (currentNode.right != null) {
                nodeStack.add(currentNode.right);
                sumStack.add(currentSum - currentNode.right.val);
            }
        }
        return false;
    }

    /**
     * Using recursion
     * @param root
     * @param sum
     * @return whether any paths from root to any leaf node traversing through the nodes, has a total that equal to the sum
     */
    public boolean hasPathSum2(TreeNode root, int sum) {
        if (root == null) {
            return false;
        } else if (root.left == null && root.right == null && sum - root.val == 0) {
            return true;
        } else {
            return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
        }
    }
}