public class StringEncode {

    /**
     * Given String "aaaabbbccdddd", return the shotened version of the encoded string.
     * 
     * @param s "aaaabbbccdddd"
     * @return a4b3ccd4
     */
    public static String encode(String s) {
        if (s == null || s.length() <= 2) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        int count = 1;

        int i = 0; //slow pointer
        int j = 0; //fast window creating pointer
        while (i < s.length()) {
            if (j + 1 < s.length() && s.charAt(j) == s.charAt(j + 1)) { // "aaaa"
                count ++;
                j++;
            } else { // all else situations
                if (count == 1) { // "abc"
                    sb.append(s.charAt(i));
                } else if (count == 2) { // "aabbcc"
                    sb.append(s.charAt(i)).append(s.charAt(i));
                } else if (count > 2) { // normal case "aaabbbcccc"
                    sb.append(s.charAt(i)).append(Integer.toString(count));
                }
                count = 1;
                i = j + 1;
                j++;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "aaaabbbccdddd";
        String a = "aabbc";
        System.out.println(encode(a));
        System.out.println(encode(s));
    }
}