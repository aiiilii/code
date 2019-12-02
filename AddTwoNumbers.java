public class AddTwoNumbers {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0); // used to point to the head of the result linked list
        ListNode l3 = dummy; // l3 start at the same as dummy, but l3 will traverse as dummy stays pointing to the head
        int carry = 0;

        // 13 + 9 = 22, 12 % 10 = 2, 12 / 10 = 1
        while (l1 != null && l2 != null) {
            int digitValue = (l1.val + l2.val + carry) % 10; // getting the 1st digit
            carry = (l1.val + l2.val + carry) / 10; // deleting the 1st digit, in this case getting the tenth digit, which is added to the carry
            ListNode newNode = new ListNode(digitValue); // create new node with sum digitValue
            l3.next = newNode; // point l3 to the next node, which is the newNode
            l3 = newNode; // move l3 to the next node, aka traversing
            l1 = l1.next;
            l2 = l2.next;
        }

        // if l2 is shorter than l1, and l2 is already finished, so need to add the remaining of l1
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

        return dummy.next; // dummy stays pointing to the head of l3
    }
}