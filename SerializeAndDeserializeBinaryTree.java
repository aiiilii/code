import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree {

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
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        String n = "null";
        String sep = ",";

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        TreeNode curr;
        StringBuilder sb = new StringBuilder();

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                curr = queue.poll();
                if (curr != null) {
                    sb.append(curr.val);
                    queue.offer(curr.left);
                    queue.offer(curr.right);
                } else {
                    sb.append(n);
                }
                sb.append(sep);
            }
        }
        return sb.toString();
    }

    /**
     * Time - O(n)
     * Space - O(n)
     * @param data
     * @return
     */
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        String[] vals = data.split(",");
        if (vals == null || vals.length == 0) {
            return null;
        }

        String n = "null";
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        TreeNode curr;
        TreeNode next;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        int index = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                curr = queue.poll();

                for (int j = index; j < index + 2 && j < vals.length; j++) {
                    if (vals[j].equals(n)) {
                        if (j % 2 == 1) {
                            curr.left = null;
                        } else {
                            curr.right = null;
                        }
                    } else {
                        next = new TreeNode(Integer.parseInt(vals[j]));
                        queue.offer(next);

                        if (j % 2 == 1) {
                            curr.left = next;
                        } else {
                            curr.right = next;
                        }
                    }
                }
                index += 2;
            }
        }
        return root;
    }
}