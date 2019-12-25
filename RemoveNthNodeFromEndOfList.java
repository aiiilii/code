public class RemoveNthNodeFromEndOfList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
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