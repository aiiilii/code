public class LinkedListCycleII {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * Two-pointer approach
     * Time - O(n), proportional to n;
     * Space - O(1), using pointers, no extra space;
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode intersect = getIntersect(head);
        if (intersect == null) {
            return null;
        }

        ListNode pointer1 = head;
        ListNode pointer2 = intersect;

        while (pointer1 != pointer2) {
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }
        return pointer1;
    }

    private ListNode getIntersect(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return slow;
            }
        }
        return null;
    }
}