public class MergeTwoSortedLists {

    public class ListNode {
        int value;
        ListNode next;
        ListNode(int x) {value = x;}
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode l3 = head;
        while (l1 != null && l2 != null) {
            if (l1.value <= l2.value) {
                l3.next = l1;
                l1 = l1.next;
            } else {
                l3.next = l2;
                l2 = l2.next;
            }
            l3 = l3.next;
        }
        if (l1 != null) {
            l3.next = l1;
        }
        if (l2 != null) {
            l3.next = l2;
        }
        //we moved l3 to next and next but head stays the same, which is pointing to the first node
        return head.next;
    }
}