import java.util.LinkedList;

public class ReverseWordsInAString {

    /**
     * Time - O(n)
     * Space - O(n)
     * @param s
     * @return
     */
    public String reverseWordS(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left <= right && s.charAt(left) == ' ') {
            left ++;
        }
        while (left <= right && s.charAt(right) == ' ') {
            right --;
        }

        LinkedList<String> list = new LinkedList<String>();
        StringBuilder word = new StringBuilder();

        while (left <= right) {
            char c = s.charAt(left);

            if (word.length() != 0 && c == ' ') {
                list.offerFirst(word.toString());
                word = new StringBuilder();
            } else if (c != ' ') {
                word.append(c);
            }
            left ++;
        }
        list.offerFirst(word.toString());

        return String.join(" ", list);
    }
}