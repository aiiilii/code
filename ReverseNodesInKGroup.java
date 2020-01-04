public class ReverseNodesInKGroup {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode reverseKGroup1(ListNode head, int k) {
        if (head == null || head.next == null || k == 1) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;

        while (prev != null) {
            prev = reverse1(prev, k);
        }
        return dummy.next;
    }

    private ListNode reverse1(ListNode prev, int k) {
        ListNode last = prev;
        for (int i = 0; i < k + 1; i++) {
            last = last.next;

            // if i == k && last == null, meaning that it is the last k elements, thus still need to reverse.
            // only when i != k  && last == null, the list has less than k elements, thus return null and stop the reversing process.
            if (i != k && last == null) {
                return null;
            }
        }
        ListNode tail = prev.next;
        ListNode curr = prev.next.next;

        while (curr != last) {
            ListNode next = curr.next;
            curr.next = prev.next;
            prev.next = curr;
            tail.next = next;
            curr = next; // curr needs to jump to next because now curr is in front of tail
        }
        // tail will become the next k group's prev
        return tail;
    }


    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode begin = dummy;

        int i = 0;
        while (head != null) {
            i++;
            if (i % k == 0) {
                begin = reverse(begin, head.next);
                head = begin.next;
            } else {
                head = head.next;
            }
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode begin, ListNode end) {
        ListNode curr = begin.next;
        ListNode prev = begin;
        ListNode first = curr;
        ListNode next;

        while (curr != end) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        begin.next = prev;
        first.next = curr;

        return first;
    }
}