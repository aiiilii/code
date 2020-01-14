import java.util.Map;
import java.util.HashMap;

public class CopyListWithRandomPointer {

    public class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }

        Map<Node, Node> mp = new HashMap<Node, Node>();
        
        Node dummy = new Node(-1);
        Node curr = dummy;
        Node newNode;

        while (head != null) {
            if (mp.containsKey(head)) {
                newNode = mp.get(head);
            } else {
                newNode = new Node(head.val);
                mp.put(head, newNode);
            }

            if (head.random != null) {
                if (mp.containsKey(head.random)) {
                    newNode.random = mp.get(head.random);
                } else {
                    newNode.random = new Node(head.random.val);
                    mp.put(head.random, newNode.random);
                }
            }

            curr.next = newNode;
            curr = curr.next;
            head = head.next;
        }
        return dummy.next;
    }
}