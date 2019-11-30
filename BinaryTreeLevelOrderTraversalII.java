import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversalII {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> levelOrderBorrom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        if (root == null) {
            return res;
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        
        while(!q.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>();
            int size = q.size();
            for (int i = 0; i < size; i++){
                TreeNode head = q.poll();
                level.add(head.val);
                if (head.left != null) {
                    q.add(head.left);
                }
                if(head.right != null) {
                    q.add(head.right);
                }
            }
            res.add(0, level);
        }
        return res;
    }
}