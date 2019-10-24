import java.util.Stack;

public class ValidParentheses {

    public boolean isValid(String s) {
        if (s.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<Character>();

        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {
                if (!stack.isEmpty() && isPairParenthesis(stack.peek(), ch)) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private boolean isPairParenthesis(char left, char right) {
        return left =='(' && right ==')' || left == '[' && right == ']' || left == '{' && right == '}';
    }
}