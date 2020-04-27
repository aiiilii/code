public class SortList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * Merge Sort approach
     * Time - O(n log n)
     * Space - O(log n), for the recursion stack
     * @param head
     * @return
     */
    public ListNode sortList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;

        // Step 1: cut the list to two halves
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;

        // Step 2: sort each half
        ListNode l1 = sortList1(head);
        ListNode l2 = sortList1(slow);

        // Step 3: merge l1 and l2
        return merge(l1, l2);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode l3 = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
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
        return dummy.next;
    }



    
    /**
     * QuickSort approach
     * Time - O(n log n)
     * Space - O(1)
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode[] list = new ListNode[2];
        boolean done = (head == null);

        // Keep partitioning our list into bigger sublists length. Starting with a size of 1 and doubling each time
        for (int step = 1; !done; step*=2) {
            done = true;
            ListNode prev = dummy;
            ListNode remaining = prev.next;

            do {
                // Split off two sublists of size step
                for (int i = 0; i < 2; i++) {
                    list[i] = remaining;
                    ListNode tail = null;
                    for (int j = 0; j < step && remaining != null; j ++, remaining = remaining.next) {
                        tail = remaining;
                    }
                    // Terminate our sublist
                    if (tail != null) {
                        tail.next = null;
                    }
                }

                // We're done if these are the first two sublists in this pass and they
                // encompass the entire primary list
                done &= (remaining == null);

                // If we have two sublists, merge them into one
                if (list[1] != null) {
                    while (list[0] != null || list[1] != null) {
                        int idx = (list[1] == null || list[0] != null && list[0].val <= list[1].val) ? 0 : 1;
                        prev.next = list[idx];
                        list[idx] = list[idx].next;
                        prev = prev.next;
                    }

                    // Terminate our new sublist
                    prev.next = null;
                } else {
                    // Only a single sublist, no need to merge, just attach to the end
                    prev.next = list[0];
                }
            } while (remaining != null);
        }
        return dummy.next;
    }
}