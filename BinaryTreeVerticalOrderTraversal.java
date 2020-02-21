import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BinaryTreeVerticalOrderTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * Time - O(n)
     * Space - O(n)
     * @param root
     * @return
     */
    public List<List<Integer>> vertivalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        if (root == null) {
            return res;
        }

        Map<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Queue<Integer> cols = new LinkedList<Integer>();

        queue.offer(root);
        cols.offer(0);

        int min = 0;
        int max = 0;

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int col = cols.poll();

            if (!map.containsKey(col)) {
                map.put(col, new ArrayList<Integer>());
            }
            map.get(col).add(node.val);

            if (node.left != null) {
                queue.offer(node.left);
                cols.offer(col - 1);
                min = Math.min(min, col - 1);
            }

            if (node.right != null) {
                queue.offer(node.right);
                cols.offer(col + 1);
                max = Math.max(max, col + 1);
            }
        }

        for (int i = min; i <= max; i++) {
            res.add(map.get(i));
        }

        return res;
    }
}