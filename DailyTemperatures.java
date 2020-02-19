import java.util.Stack;

public class DailyTemperatures {

    /**
     * Time - O(n), n is the length of T;
     * Space - O(w), w is the number of allowed values for T[i], bounded as it represents stricktly increasing temperatures;
     * @param T
     * @return
     */
    public int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];

        Stack<Integer> stack = new Stack<Integer>();
        
        for (int i = T.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && T[i] >= T[stack.peek()]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                res[i] = 0;
            } else {
                res[i] = stack.peek() - i;
            }
            stack.push(i);
        }
        return res;
    }
}