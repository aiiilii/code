public class BasicCalculatorII {

    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        s = s.trim();

        long prevNum = 0;
        int res = 0;
        char prevOp = '+';

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ' ') {
                continue;
            }
            if (Character.isDigit(ch)) {
                int val = ch - '0'; // curVal

                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    val = val * 10 + (s.charAt(i + 1) - '0');
                    i ++;
                }

                if (prevOp == '+') {
                    res += prevNum; // update res
                    prevNum = val;
                } else if (prevOp == '-') {
                    res += prevNum; // update res
                    prevNum = -val;
                } else if (prevOp == '*') {
                    prevNum = prevNum * val; // do not update res, combine preNum & curVal and keep loop
                } else if (prevOp == '/') {
                    prevNum = prevNum / val; // do not update res, combine preNum & curVal and keep loop
                }
            } else {
                prevOp = ch; // get new sign
            }
        }
        res += prevNum;
        return res;
    }
}