import java.util.Stack;

public class BasicCalculator {

    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<Integer>();
        int operand = 0;
        int res = 0; 
        int sign = 1;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                operand = 10 * operand + (int) (ch - '0');
            } else if (ch == '+') {
                res += sign * operand;
                sign = 1;
                operand = 0;
            } else if (ch == '-') {
                res += sign * operand;
                sign = -1;
                operand = 0;
            } else if (ch == '(') {
                stack.push(res);
                stack.push(sign);
                sign = 1;
                res = 0;
            } else if (ch == ')') {
                res += sign * operand;
                res *= stack.pop();
                res += stack.pop();
                operand = 0;
            }
        }
        return res + (sign * operand);
    }
}