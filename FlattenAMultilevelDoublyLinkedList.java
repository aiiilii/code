import java.util.Stack;

public class FlattenAMultilevelDoublyLinkedList {

    public class Node {

        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node() {}

        public Node(int val, Node prev, Node next, Node child) {
            this.val = val;
            this.prev = prev;
            this.next = next;
            this.child = child;
        }
    }

    /**
     * Iterative
     * Time - O(n)
     * Space - O(n)
     * @param head
     * @return
     */
    public Node flatten(Node head) {
        if (head == null) {
            return head;
        }

        Node dummy = new Node(0, null, head, null);
        Node curr = dummy;
        Node prev = dummy;

        Stack<Node> stack = new Stack<Node>();
        stack.push(head);

        while (!stack.isEmpty()) {
            curr = stack.pop();
            prev.next = curr;
            curr.prev = prev;

            if (curr.next != null) {
                stack.push(curr.next);
            }
            if (curr.child != null) {
                stack.push(curr.child);
                curr.child = null; // remove all child pointers;
            }
            prev = curr;
        }
        // detach dummy from the list
        dummy.next.prev = null;
        return dummy.next;
    }



    /**
     * Recursive
     * Time - O(n)
     * Space - O(n)
     * @param head
     * @return
     */
    public Node flatten1(Node head) {
        if (head == null) {
            return head;
        }

        Node dummy = new Node(0, null, head, null);

        flattenDFS(dummy, head);

        dummy.next.prev = null;
        return dummy.next;
    }

    /**
     * 
     * @param prev
     * @param curr
     * @return the tail of the flattened list
     */
    private Node flattenDFS(Node prev, Node curr) {
        if (curr == null) {
            return prev;
        }
        curr.prev = prev;
        prev.next = curr;

        Node tempNext = curr.next;

        Node tail = flattenDFS(curr, curr.child);
        curr.child = null;

        return flattenDFS(tail, tempNext);
    }
}