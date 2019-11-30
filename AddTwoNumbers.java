public class AddTwoNumbers {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0); // used to link to the head of the resulte linked list
        ListNode l3 = dummy;
        int carry = 0;

        // 13 + 9 = 22, 12 % 10 = 2, 12 / 10 = 1
        while (l1 != null && l2 != null) {
            int digitValue = (l1.val + l2.val + carry) % 10;
            carry = (l1.val + l2.val + carry) / 10;
            ListNode newNode = new ListNode(digitValue);
            l3.next = newNode;
            l3 = newNode;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int digitValue = (l1.val + carry) % 10;
            carry = (l1.val + carry) / 10;
            ListNode newNode = new ListNode(digitValue);
            l3.next = newNode;
            l3 = newNode;
            l1 = l1.next;
        }

        while (l2 != null) {
            int digitValue = (l2.val + carry) % 10;
            carry = (l2.val + carry) / 10;
            ListNode newNode = new ListNode(digitValue);
            l3.next = newNode;
            l3 = newNode;
            l2 = l2.next;
        }

        // 2 + 9 = 11, extra 1 at 10th digit generated 
        if (carry != 0) {
            ListNode newNode = new ListNode(carry);
            l3.next = newNode;
            l3 = newNode;
        }

        return dummy.next;
    }
}