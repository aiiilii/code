public class ReverseLinkedListII {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode preM = dummy;
        ListNode mNode = dummy;
        ListNode nNode = dummy;

        for (int i = 0; i < m; i++) {
            preM = mNode;
            mNode = mNode.next;
        }
        for (int i = 0; i < n; i++) {
            nNode = nNode.next;
        }

        while (mNode != nNode) {
            preM.next = mNode.next;
            mNode.next = nNode.next;
            nNode.next = mNode;
            mNode = preM.next;
        }
        return dummy.next;
    }
}