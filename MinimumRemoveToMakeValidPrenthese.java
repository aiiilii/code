import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class MinimumRemoveToMakeValidPrenthese {

    /**
     * Time - O(n)
     * Space - O(n)
     * @param s
     * @return
     */
    public String minRemoveToMakeValid(String s) {
        Set<Integer> indexesToRemove = new HashSet<Integer>();
        Stack<Integer> stack = new Stack<Integer>();
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            }
            if (s.charAt(i) == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    indexesToRemove.add(i);
                }
            }
        }

        while (!stack.isEmpty()) {
            indexesToRemove.add(stack.pop());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!indexesToRemove.contains(i)) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}