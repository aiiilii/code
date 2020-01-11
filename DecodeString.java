import java.util.Stack;

public class DecodeString {

    public String decodeString(String s) {

        Stack<Integer> intStack = new Stack<Integer>();
        Stack<StringBuilder> strStack = new Stack<StringBuilder>();
        StringBuilder cur = new StringBuilder();
        
        int k = 0; // initiallize the number at the front of the brakets

        for (char ch : s.toCharArray()) {
            // if ch is a digit, and the next is also a digit, ex: 23; thus k = (k * k + ch - '0')
            if (Character.isDigit(ch)) {
                k = k * 10 + ch - '0';
            } else if (ch == '[') {
                intStack.push(k);
                strStack.push(cur);
                cur = new StringBuilder();
                k = 0;
            } else if (ch == ']') {
                StringBuilder temp = cur;
                cur = strStack.pop();
                
                for (k = intStack.pop(); k > 0; k--) { // k will become 0 again after this loop ends
                    cur.append(temp);
                }
            } else {
                cur.append(ch);
            }
        }
        return cur.toString();
    }
}