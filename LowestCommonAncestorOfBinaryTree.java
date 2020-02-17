import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Queue;
import java.util.LinkedList;

public class LowestCommonAncestorOfBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(final int x) { val = x; }
    }

    /**
     * Recursive
     * Time - O(n)
     * Space - O(n)
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(final TreeNode root, final TreeNode p, final TreeNode q) {
        if (root == null || root == p || root == q) { //if root == p or root == q, meaning p or q will be the lowest common ancestor respectively;
            return root;
        }
        final TreeNode left = lowestCommonAncestor(root.left, p, q);
        final TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            return root;
        }
    }


    /**
     * Iterative
     * Time - O(n)
     * Space - O(n)
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor1(final TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        final Map<TreeNode, TreeNode> parent = new HashMap<TreeNode, TreeNode>(); // TreeNode KEY is child, TreeNode VALUE is parent;
        final Queue<TreeNode> queue = new LinkedList<TreeNode>();
        parent.put(root, null); // construct the parent hashmap using queue, can also use stack, as long as finish all child-parent relationships;
        queue.offer(root);

        while (!parent.containsKey(p) || !parent.containsKey(q)) {
            final TreeNode node = queue.poll();
            if (node.left != null) {
                parent.put(node.left, node);
                queue.offer(node.left);
            }
            if (node.right != null) {
                parent.put(node.right, node);
                queue.offer(node.right);
            }
        }

        final Set<TreeNode> ancestors = new HashSet<TreeNode>(); // put all ancestors of p into the set;
        while (p != null) {
            ancestors.add(p);
            p = parent.get(p); // traverse p up the parent relationship using the constructed parent hashmap;
        }
        while (!ancestors.contains(q)) { // traverse q up using the hashmap until the ancester set contains q, then return q as the result;
            q = parent.get(q);
        }
        return q;
    }
}