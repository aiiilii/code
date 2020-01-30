import java.util.LinkedList;
import java.util.TreeMap;
import java.util.Stack;

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



    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> maxStack = new Stack<Integer>();
    /**
     * Using TWO STACKS
     */
    // public MaxStack() {

    // }

    public void push1(int x) {
        int max = Integer.MIN_VALUE;
        if (maxStack.isEmpty()) {
            max = x;
        } else {
            max = maxStack.peek();
        }
        if (max > x) {
            maxStack.push(max);
        } else {
            maxStack.push(x);
        }
        stack.push(x);
    }

    public int pop1() {
        maxStack.pop();
        return stack.pop();
    }

    public int top1() {
        return stack.peek();
    }

    public int peekMax1() {
        return maxStack.peek();
    }

    public int popMax1() {
        int max = peekMax1();
        Stack<Integer>buffer = new Stack<Integer>();
        while (top1() != max) {
            buffer.push(pop1());
        }
        pop(); // for the top that == max;
        while (!buffer.isEmpty()) {
            push1(buffer.pop());
        }
        return max;
    }
}