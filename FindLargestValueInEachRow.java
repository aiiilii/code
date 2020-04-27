import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindLargestValueInEachRow {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int x) { val = x; }
    }

    /**
     * Iterative approach
     * Time - O(n)
     * Space - O(n)
     * @param root
     * @return
     */
    public List<Integer> largestValue(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            int max = Integer.MIN_VALUE;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.val > max) {
                    max = node.val;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(max);
        }
        return res;
    }
}