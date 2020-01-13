public class PartitionList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode left = dummy; // marks where the partition should happen;
  
        ListNode curr = head;
        ListNode prev = dummy;

        while (curr != null) {
            if (prev == left) {
                if (curr.val < x) {
                    left = left.next;
                }
                prev = curr;
                curr = curr.next;
            } else {
                if (curr.val >= x) {
                    prev = curr;
                    curr = curr.next;
                } else {
                    prev.next = curr.next;
                    curr.next = left.next;
                    left.next = curr;
                    left = left.next;
                    curr = prev.next;
                }
            }
        }
        return dummy.next;
    }
}