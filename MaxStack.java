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
    final ListNode tail;
    final TreeMap<Integer, LinkedList<ListNode>> map;

    /**
     * Using TreeMap
     */
    public MaxStack() {
        head = new ListNode(0);
        tail = new ListNode(0);
        map = new TreeMap<Integer, LinkedList<ListNode>>();
        head.next = tail;
        tail.prev = head;
    }

    /**
     * Time - O(log n)
     * @param x
     */
    public void push(int x) {
        ListNode node = new ListNode(x);
        node.next = head.next;
        head.next.prev = node;
        node.prev = head;
        head.next = node;
        map.computeIfAbsent(x, k -> new LinkedList<ListNode>()).add(node);
    }

    /**
     * Time - O(log n)
     * @return
     */
    public int pop() {
        ListNode popNode = head.next;
        if (popNode == head) {
            return 0;
        }
        deleteNode(popNode);

        map.get(popNode.val).removeLast();
        if (map.get(popNode.val).isEmpty()) {
            map.remove(popNode.val);
        }
        return popNode.val;
    }

    /**
     * Time - O(1)
     * @return
     */
    public int top() {
        return head.next.val;
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