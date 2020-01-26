import java.util.LinkedList;
import java.util.TreeMap;

public class MaxStack {

    public class ListNode {
        int val;
        ListNode prev;
        ListNode next;
        public ListNode(int x) { val = x; }
    }

    public void deleteNode(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    final ListNode head;
    final TreeMap<Integer, LinkedList<ListNode>> map;

    /**
     * Using TreeMap
     */
    public MaxStack() {
        head = new ListNode(0);
        map = new TreeMap<Integer, LinkedList<ListNode>>();
        head.next = head;
        head.prev = head;
    }

    /**
     * Time - O(log n)
     * @param x
     */
    public void push(int x) {
        ListNode node = new ListNode(x);
        node.next = head;
        node.prev = head.prev;
        head.prev.next = node;
        head.prev = node;
        map.computeIfAbsent(x, k -> new LinkedList<ListNode>()).add(node);
    }

    /**
     * Time - O(log n)
     * @return
     */
    public int pop() {
        ListNode tail = head.prev;
        if (tail == head) {
            return 0;
        }
        deleteNode(tail);

        map.get(tail.val).removeLast();
        if (map.get(tail.val).isEmpty()) {
            map.remove(tail.val);
        }
        return tail.val;
    }

    /**
     * Time - O(1)
     * @return
     */
    public int top() {
        return head.prev.val;
    }

    /**
     * Time - O(log n)
     * @return
     */
    public int peekMax() {
        return map.lastKey();
    }

    /**
     * Time - O(log n)
     * @return
     */
    public int popMax() {
        int max = peekMax();
        ListNode node = map.get(max).removeLast();
        deleteNode(node);
        if (map.get(max).isEmpty()) {
            map.remove(max);
        }
        return max;
    }
}