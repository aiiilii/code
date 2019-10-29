import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * Two pointer approach - worst O(n) time and O(1) space
     * One moves slower(1 step) and another moves faster(2 steps), the fast runner will eventually meet the slow runner
     * @param head
     * @return whether this linkedlist has a cycle, meaning end does not point to null but points to some listNode
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    /**
     * HashSet approach - O(n) both time and space
     * Store each node in the hashset, if the current node is null, we have reached the end of the list and it must not be cyclic.
     * If current node's reference is in the hashset then return true. 
     * @param head
     * @return
     */
    public boolean hasCycle2(ListNode head) {
        Set<ListNode> nodesSeen = new HashSet<>();
        while (head != null) {
            if (nodesSeen.contains(head)) {
                return true;
            } else {
                nodesSeen.add(head);
            }
            head = head.next;
        }
        return false;
    }
}