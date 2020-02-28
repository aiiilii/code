import java.util.LinkedList;
import java.util.Queue;

public class KangRongTreeQuestion {

    public class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int val, Node left, Node right, Node next) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.next = next;
        }
    }

    /**
     * Linking nodes level by level
     * Not using Queue
     * Time - O(n)
     * Space - O(1)
     * @param root
     * @return
     */
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        
        Node queueStart = root;
        Node queueEnd = root;
        while (queueStart != null) {
            Node n = queueStart;
            if (n.left != null) {
                queueEnd.next = n.left;
                queueEnd = n.left;
            }
            
            if (n.right != null) {
                queueEnd.next = n.right;
                queueEnd = n.right;
            }
            
            queueStart = queueStart.next;
        }
        return root;
    }


    /**
     * Using Queue
     * Time - O(n)
     * Space - O(n)
     * @param root
     * @return
     */
    public Node connect1(Node root) {
        if (root == null) {
            return root;
        }

        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(root);
        Node temp = null;

        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            if (temp == null) {
                temp = curr;
            } else {
                temp.next = curr;
                temp = curr;
            }
            if (curr.left != null) {
                queue.offer(curr.left);
            }
            if (curr.right != null) {
                queue.offer(curr.right);
            } 
        }
        return root;
    }
}