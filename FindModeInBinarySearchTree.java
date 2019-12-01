import java.util.ArrayList;
import java.util.List;

public class FindModeInBinarySearchTree {

    TreeNode prev;
    int count = 0;
    int maxCount = -1;

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int[] findMode(TreeNode root) {
        List<Integer> modes = new ArrayList<Integer>();
        prev = root;
        inorder(root, modes);
        int[] ret = new int[modes.size()];
        for (int i = 0; i < modes.size(); i ++) {
            ret[i] = modes.get(i);
        }
        return ret;
    }

    private void inorder(TreeNode root, List<Integer> modes) {
       if (root == null) {
           return;
       }
       inorder(root.left, modes);
       if (prev.val == root.val) {
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