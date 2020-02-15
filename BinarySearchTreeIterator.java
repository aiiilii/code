import java.util.Stack;

public class BinarySearchTreeIterator {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x) { val = x; }
    }

    Stack<TreeNode> stack; // stack for the recursion simulation;

    public BinarySearchTreeIterator(TreeNode root) {
        stack = new Stack<TreeNode>();

        this.leftMostInorder(root);
    }

    private void leftMostInorder(TreeNode root) {
        while (root != null) { // for a given node, add all the elements in the leftmost branch of the tree under it to the stack;
            stack.push(root);
            root = root.left;
        }
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        TreeNode topMostNode = stack.pop(); // node at the stop of the stack it the next smaller element;

        if (topMostNode.right != null) {
            this.leftMostInorder(topMostNode.right);
        }
        return topMostNode.val;
    }

     /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return stack.size() > 0;
    }
}