public class OddEvenLinkedList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * More concise solution
     * Time - O(n)
     * Space - O(1)
     * @param head
     * @return
     */
    public static ListNode oddEvenList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }


    /**
     * Split the linked list into two linked lists and then re-join them
     * Time - O(n)
     * Space - O(1)
     * @param head
     * @return
     */
    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        
        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        ListNode curr = head;
        ListNode prev1 = dummy1;
        ListNode prev2 = dummy2;
        int index = 1;
        
        while (curr != null) {
            if (index % 2 == 1) {
                prev1.next = curr;
                prev1 = prev1.next;
            } else {
                prev2.next = curr;
                prev2 = prev2.next;
            }
            index ++;
            curr = curr.next;
        }
        
        prev1.next = null;
        prev2.next = null;

        ListNode temp = dummy1.next;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = dummy2.next;
        
        return dummy1.next;
    }

    

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        head.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        ListNode newNode = oddEvenList(head);

        while (newNode != null) {
            System.out.println(newNode.val);
            newNode = newNode.next;
        }
    }
}