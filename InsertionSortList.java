public class InsertionSortList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * Time - O(n^2)
     * Space - O(1)
     * @param head
     * @return
     */
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = dummy;

        while (head != null && head.next != null) {
            if (head.val <= head.next.val) {
                head = head.next;
            } else {
                curr = head.next;

                prev = dummy;
                while (prev.next.val < curr.val) {
                    prev = prev.next;
                }

                head.next = curr.next;
                curr.next = prev.next;
                prev.next = curr;
            }
        }
        return dummy.next;
    }
}