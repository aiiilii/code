import java.util.ArrayList;
import java.util.List;

public class FindModeInBinarySearchTree {

    TreeNode prev;
    int count = 0;
    int maxCount = 0;

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int[] findMode(TreeNode root) {
        List<Integer> modes = new ArrayList<Integer>();
        inorder(root, modes);
        int[] ret = new int[modes.size()];
        for (int i = 0; i < modes.size(); i ++) {
            ret[i] = modes.get(i);
        }
        return ret;
    }

    // inorder will make binary search tree into a sorted list
    private void inorder(TreeNode root, List<Integer> modes) {
       if (root == null) {
           return;
       }
       inorder(root.left, modes);

       if (prev == null) {
            count = 1;
       } else if (prev.val == root.val) {
           count += 1;
       } else {
           count = 1;
       }
       if (count == maxCount) {
           modes.add(root.val);
       } else if (count > maxCount) {
           modes.clear();
           modes.add(root.val);
           maxCount = count;
       }
       prev = root;

       inorder(root.right, modes);
    }
}