import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedLists {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * Priority Queue approach
     * Time complexity - O(N log(k)), N is number of nodes in the longest list, k is number of lists
     * Space complexity - O(k)
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length == 0) {
            return null;
        }

        // establish comparing method
        Queue<ListNode> q = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        
        for (ListNode l : lists) {
            if (l != null) {
                q.offer(l);
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode point = dummy;

        while (!q.isEmpty()) {
            point.next = q.poll();
            point = point.next;

            // after poll(), need to fill in the empty space, thus put in point.next
            ListNode nextNode = point.next;
            if (nextNode != null) { // if nextNode == null, list is at the end
                q.offer(nextNode);
            }
        }
        return dummy.next;
    }



    /**
     * Merge two lists approach
     * Time complexity - O(N log(k))
     * Space complexity - O(1)
     * @param lists
     * @return
     */
    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        int interval = 1;
        while (interval < lists.length) {
            System.out.println(lists.length);
            for (int i = 0; i + interval < lists.length; i = i + interval*2) {
                lists[i] = mergeTwoLists(lists[i], lists[i + interval]);
            }
            interval *= 2;
        }
        return lists[0];
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                head.next = l1;
                head = head.next;
                l1 = l1.next;
            } else {
                head.next = l2;
                head = head.next;
                l2 = l2.next;
            }
        }
        if (l1 == null) {
            head.next = l2;
        }
        if (l2 == null) {
            head.next = l1;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode[] newList = new ListNode[0];
        System.out.println(newList.length);
        try {
            ListNode[] nullArray = null;
            System.out.println(nullArray.length);    
        } catch (NullPointerException e) {
            System.out.println("Null array");
        }
        

    }

}