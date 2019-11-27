public class PalindromeLinkedList {

    public static class ListNode {
        public int val;
        public ListNode next;
        public ListNode(int x) {
            val = x;
        }
    }

    // 1 2 3 4 3 2 1
    // 1 2 3 4 
    //       1 2 3 4 (after reverse)
    // 1 2 3 1 2 3 (after reverse)
    public boolean isPalindrome(final ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        slow = reversed(slow);
        fast = head;

        while (slow != null) {
            if (slow.val != fast.val) {
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }

    private ListNode reversed(final ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(1);
        l1.next = l2;
        l2.next = l3;

        PalindromeLinkedList solution = new PalindromeLinkedList();
        solution.isPalindrome(l1);
    }
}