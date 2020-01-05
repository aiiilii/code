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

        // move preM, mNode and nNode to their respective positions
        for (int i = 0; i < m; i++) {
            preM = mNode;
            mNode = mNode.next;
        }
        for (int i = 0; i < n; i++) {
            nNode = nNode.next;
        }

        // keep moving mNode to after nNode until mNode and nNode meet up
        while (mNode != nNode) { // loops stops when mNode == nNode
            preM.next = mNode.next; // skipping mNode
            mNode.next = nNode.next; // connecting mNode to nNode's next, putting mNode after nNode
            nNode.next = mNode; // connecting nNode's next to mNode
            mNode = preM.next; // re starting the process by making mNode the node that is after preM, which is the node that is connecting to preM after skipping mNode
        }
        return dummy.next;
    }
}