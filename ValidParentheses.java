import java.util.Stack;

public class ValidParentheses {

    public boolean isValid(String s) {
        if (s.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<Character>();

        // for (int i = 0; i < s.length(); i++) {
        //     char ch = s.charAt(i);
        // }
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch); // stack only contains the left parens
            } else {
                if (!stack.isEmpty() && isPairParenthesis(stack.peek(), ch)) {
                    stack.pop(); // popping off the left paren(from the top of stack) that found a match
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private boolean isPairParenthesis(char left, char right) {
        return left =='(' && right ==')' || 
        left == '[' && right == ']' || 
        left == '{' && right == '}';
    }
}