public class RemoveNthNodeFromEndOfList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * Time - O(L), L is the number of nodes, one traversal;
     * Space - O(1), only used pointers;
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        if (head == null || n == 0) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;

        for (int i = 1; i <= n + 1; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }



    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) {
            return null;
        }
        if (head.next.next == null) {
            if (n == 1) {
                head.next = null;
            } else if (n == 2) {
                head = head.next;
            }
            return head;
        }
        ListNode dummy = new ListNode(0);

        dummy.next = head;

        ListNode slow = dummy;
        ListNode fast = dummy;

        while (n + 1 > 0) {
            fast = fast.next;
            n = n - 1;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}