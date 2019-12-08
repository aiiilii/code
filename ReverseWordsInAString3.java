public class ReverseWordsInAString3 {

    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                sb.append(' ');
            } else {
                int end = i;
                while (end < s.length() && s.charAt(end) != ' ') {
                    end ++;
                }
                for (int j = end - 1; j >= i; j --) {
                    sb.append(s.charAt(j));
                }
                i = end - 1;
            }
        }
        return new String(sb);
    }
}