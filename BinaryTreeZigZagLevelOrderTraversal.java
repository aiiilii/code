import java.util.List;
import java.util.ArrayList;

public class BinaryTreeZigZagLevelOrderTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        if (root == null) {
            return res;
        }

        List<TreeNode> list = new ArrayList<TreeNode>();
        boolean leftToRight = true;
        list.add(root);

        while (!list.isEmpty()) {
            int size = list.size();
            List<Integer> templist = new ArrayList<Integer>();
            if (leftToRight) {
                for (int i = 0; i < size; i++) {
                    TreeNode curr = list.remove(0);
                    templist.add(curr.val);
                    if (curr.left != null) {
                        list.add(curr.left); // add to back of the list;
                    }
                    if (curr.right != null) {
                        list.add(curr.right);
                    }
                }
            } else { // right to left;
                for (int i = 0; i < size; i++) {
                    TreeNode curr = list.remove(list.size() - 1);
                    templist.add(curr.val);
                    if (curr.right != null) {
                        list.add(0, curr.right); // add to front of the list;
                    }
                    if (curr.left != null) {
                        list.add(0, curr.left);
                    }
                }
            }
            res.add(templist);
            leftToRight = !leftToRight;
        }
        return res;
    }
}