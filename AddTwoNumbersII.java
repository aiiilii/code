import java.util.Stack;

public class AddTwoNumbersII {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * Using Stacks
     * Time - O(m + n)
     * Space - O(m + n)
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();

        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }

        int sum = 0;
        ListNode l3 = new ListNode(0);

        while (!s1.isEmpty() || !s2.isEmpty()) {
            if (!s1.isEmpty()) {
                sum += s1.pop();
            }
            if (!s2.isEmpty()) {
                sum += s2.pop();
            }
            l3.val = sum % 10;
            ListNode head = new ListNode(sum / 10);
            head.next = l3;
            l3 = head;
            sum = sum / 10;
        }

        if (l3.val == 0) {
            return l3.next;
        } else {
            return l3;
        }
    }
}