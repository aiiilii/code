public class StringToInteger {

    public int stringToInteger(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }
        double res = 0;
        int startIndex = 0;
        boolean isNeg = false;

        // pos and neg signs
        if (str.charAt(0) == '-' || str.charAt(0) == '+') {
            startIndex ++;
            if (str.charAt(0) == '-') {
                isNeg = true;
            }
        }

        // normal case
        for (int i = startIndex; i < str.length(); i ++) {
            // if have non-numerical characters
            if (str.charAt(i) > '9' || str.charAt(i) < '0') {
                break;
            }
            int digitVal = (int)(str.charAt(i) - '0');
            res = res * 10 + digitVal;
        }

        // if neg
        if (isNeg == true) {
            res = -res;
        }

        // if overflow
        if (res > Integer.MAX_VALUE) {
            res = Integer.MAX_VALUE;
        }
        if (res < Integer.MIN_VALUE) {
            res = Integer.MIN_VALUE;
        }

        return (int)res;
    }
}