public class DecodeWays {

    public int numDecodings(String s) {
        if (s == null || s.length() <= 0) {
            return 0;
        }
        
        if (s.charAt(0) == '0') {
            return 0;
        }
        int curWays = 1;
        int preWays = 1;

        for (int i = 1; i < s.length(); i++) {
            int temp = curWays;
            if (s.charAt(i) == '0') {
                curWays = preWays;
                if (s.charAt(i - 1) >= '3' || s.charAt(i - 1) <= '0') {
                    return 0;
                }
            } else {
                if (s.charAt(i - 1) != '0' && Integer.valueOf(s.substring(i - 1, i + 1)) <= 26) {
                    curWays += preWays;
                }
            }
            preWays = temp;
        }
        return curWays;
    }
}