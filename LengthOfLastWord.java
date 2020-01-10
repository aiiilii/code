public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int count = 0;

        int startIdx = s.length() - 1;
        if (s.charAt(startIdx) == ' ') {
            while (s.charAt(startIdx) == ' ' && startIdx > 0) {
                startIdx --;
            }
        }

        for (int i = startIdx; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                count ++;
            } else {
                break;
            }
        }
        return count;
    }
}