import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueue {

    Queue<Integer> q;
    int top = -1;

    /** Initialize your data structure here. */
    public ImplementStackUsingQueue() {
        q = new LinkedList<>();
    }
    
    /** Push element x onto stack. 
     * Time Complexity = O(n)
    */
    public void push(int x) {
        q.add(x); // add x to the rear
        int size = q.size(); // size is now 6
        while(size > 1) { // will keep looping and loop out when size is 1, meaning loop 5 times
            q.add(q.remove()); // adding the first number to the rear, keep looping, eventually the last number just added will become the first number
            size--;
        }
    }
    
    /** Removes the element on top of the stack and returns that element. 
     * Time Complexity = O(1)
    */
    public int pop() {
        return q.remove();
    }
    
    /** Get the top element. */
    public int top() {
        return q.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */