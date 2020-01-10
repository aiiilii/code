public class StringDecode {

    /**
     * Given String "a4b3ccd4", return decoded version of the String
     * @param s
     * @return "aaaabbbccdddd"
     */
    public static String decode1(String s) {
        if (s == null || s.length() <= 2) {
            return s;
        }

        StringBuilder sb = new StringBuilder();

        int i = 0;
        int j = i + 1;
        while (i < s.length()) {
            if (j >= s.length()) { // taking care of the last char, when j goes out of bound, immediately add charAt(i) and break
                sb.append(s.charAt(i));
                break;
            } else if (s.charAt(j) == s.charAt(i)) {// "aa" or "aabb"
                sb.append(s.substring(i, j + 1));
                i = j + 1;
                j = i + 1;
            } else if (s.charAt(j) < '0' || s.charAt(j) > '9') { // "abc"
                sb.append(s.charAt(i));
                i = j;
                j = j + 1;
            } else {
                while (j < s.length() && s.charAt(j) >= '0' && s.charAt(j) <= '9') { // normal case: "a4b3"
                    j ++;
                }
                String num = s.substring(i + 1, j);
                int val = Integer.valueOf(num);
                for (int n = 0; n < val; n++) {
                    sb.append(s.charAt(i));
                }
                i = j;
                j = j + 1;
            }
        }
        return sb.toString();
    }



    public static String decode(String s) {
        if (s == null || s.length() <= 2) {
            return s;
        }

        StringBuilder sb = new StringBuilder();

        int i = 0;
        int j = 0;
        while (i < s.length()) {
            if (j + 1 < s.length() && s.charAt(j) == s.charAt(j + 1)) {
                j++;
            } else if (j + 1 < s.length() && s.charAt(j) != s.charAt(j + 1) && (s.charAt(j + 1) > '9' || s.charAt(j + 1) < '0')) {
                sb.append(s.substring(i, j + 1));
                i = j + 1;
                j++;
            } else if (j + 1 < s.length() && s.charAt(j) != s.charAt(j + 1) && '0' <= s.charAt(j + 1) && s.charAt(j + 1) <= '9') {
                while (j + 1 < s.length() && '0' <= s.charAt(j + 1) && s.charAt(j + 1) <= '9') {
                    j++;
                }
                String num = s.substring(i + 1, j + 1);
                int val = Integer.valueOf(num);
                for (int k = 0; k < val; k++) {
                    sb.append(s.charAt(i));
                }
                i = j + 1;
                j++;
            } else { // for j + 1 >= s.length()
                sb.append(s.charAt(i));
                i++;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "a4b3ccd4";
        String a = "aab";
        System.out.println(decode1(a));
        System.out.println(decode1(s));
    }
}