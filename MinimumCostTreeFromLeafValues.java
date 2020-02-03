import java.util.Stack;

public class MinimumCostTreeFromLeafValues {

    /**
     * Time - O(n)
     * Space - O(n)
     * @param arr
     * @return
     */
    public int mctFromLeafValues(int[] arr) {
        int res = 0;
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(Integer.MAX_VALUE); // put it into the stack so when calling .peek() in the while loop, does not run errors;

        for (int num : arr) {
            while (stack.peek() <= num) {
                int mid = stack.pop(); // smallest number in stack right now, will be eliminated after multiplying the min(left number, right number);
                res += mid * Math.min(stack.peek(), num);
            }
            stack.push(num);
        }
        while (stack.size() > 2) { // has more than 2 leaf nodes, then can combine and multiply one more time;
            res += stack.pop() *stack.peek();
        }
        return res;
    }
}