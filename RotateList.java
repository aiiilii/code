public class RotateList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode rotate1(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        int len = 1;

        while (fast.next != null) {
            fast = fast.next;
            len ++;
        }

        fast = head; // fast goes back to head
        
        // fast goes first to (k % len) position then slow follows
        for (int i = 0; i < k % len; i++) { // taking care of cases if k is larger than len
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        fast.next = head;
        head = slow.next;
        slow.next = null;
        return head;
    }

    public ListNode rotate(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode oldTail = head;
        int n;
        for (n = 1; oldTail.next != null; n++) {
            oldTail = oldTail.next;
        }
        oldTail.next = head;

        ListNode newTail = head;
        for (int i = 0; i < n - k % n - 1; i++) {
            newTail = newTail.next;
        }
        ListNode newHead = newTail.next;

        newTail.next = null;

        return newHead;
    }
}