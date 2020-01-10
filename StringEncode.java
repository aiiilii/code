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
        while (i < s.length() - 1) {
            if (s.charAt(j) == s.charAt(j + 1)) {
                count ++;
                j++;
            } else {
                if (count == 1) {
                    sb.append(s.charAt(i));
                } else if (count == 2) {
                    sb.append(s.charAt(i)).append(s.charAt(i));
                } else if (count > 2) {
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
        System.out.println(encode(s));
    }
}