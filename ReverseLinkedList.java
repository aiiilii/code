public class ReverseLinkedList {

    public static class ListNode {
        int val;
        public ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * Iterative approach
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode prevNode = null;
        ListNode currNode = head;
        ListNode nextNode;
        while (currNode != null) {
            nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        }
        head = prevNode;
        return head;
    }

    /**
     * Recursive approach
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHeadNode = reverseList(head.next);
        // ListNode backNode = head.next;
        // backNode.next = head;
        head.next.next = head;
        head.next = null;
        return newHeadNode;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        //ListNode result = reverseList(node1);
    }
}