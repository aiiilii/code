public class ReorderList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * Time - O(n)
     * Space - O(1)
     * @param head
     */
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        ListNode l1 = head;

        // step 1. cut the list to two halves
        // prev will be the tail of 1st half
        // slow will be the head of 2nd half
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;

        // step 2. reverse the 2nd half
        ListNode l2 = reverse(slow);

        // step 3. merge the two halves
        merge(l1, l2);
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next;
        
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
        return head;
    }

    private void merge(ListNode l1, ListNode l2) {
        while (l2 != null) {
            ListNode next = l1.next;
            l1.next = l2;
            l1 = l2;
            l2 = next;
        }
    }






    public void reorderList1(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        } 
        
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow = reverse1(slow);
        fast = head;
        
        while (fast != null && slow != null) {
            ListNode fastNext = fast.next;
            fast.next = slow;
            fast = fastNext;
            ListNode slowNext = slow.next;
            slow.next = fastNext;
            slow = slowNext;
        }
        if (fast != null && fast.next != null) {
            fast.next = null;    
        }
        if (slow != null && slow.next != null) {
            slow.next = null;
        }
    }
    
    private ListNode reverse1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverse1(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}