public class RemoveDuplicatesFromSortedListII {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode curr = head;

        while (curr != null) {
            while (curr.next != null && curr.val == curr.next.val) {
                curr = curr.next;
            }

            if (prev.next == curr) { // if curr did not find a duplicate value yet;
                prev = curr;
                curr = curr.next;
            } else {
                prev.next = curr.next;
                curr = prev.next;
            }
        }
        return dummy.next;
    }
}