import java.util.Stack;

public class BasicCalculator {

    /**
     * Time - O(n)
     * Space - O(n)
     * @param s
     * @return
     */
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<Integer>();
        int operand = 0;
        int res = 0; // for on-going result
        int sign = 1; // 1 means positive, -1 means negative

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                operand = 10 * operand + (int) (ch - '0'); // operand could be more than 1 digit
            } 
            else if (ch == '+') { // encountered a '+'
                res += sign * operand; // evaluate the expression to the left of the '+'
                sign = 1; // save the recently encountered '+'
                operand = 0;
            } 
            else if (ch == '-') {
                res += sign * operand;
                sign = -1; // save the recently encountered '-'
                operand = 0;
            } 
            else if (ch == '(') {
                // push res and sign into stack for later, res first then sign, so sign is on top
                stack.push(res);
                stack.push(sign);
                // reset sign and res
                sign = 1;
                res = 0;
            } 
            else if (ch == ')') {
                res += sign * operand; // evaluate the expression to the left of the '('

                // ')' marks end of expression within a set of parens
                // Its result is multiplied with sign on top of stack
                // as stack.pop() is the sign
                res *= stack.pop();

                // Then add the next operand on the top
                // as the next stack.pop() is the res calculated before this parens
                // (operand on stack) + (sign on stack * (res from parens))
                res += stack.pop();

                operand = 0; // reset the operand
            }
        }
        return res + (sign * operand);
    }
}