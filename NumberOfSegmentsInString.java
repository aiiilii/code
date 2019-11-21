public class NumberOfSegmentsInString {

    public int countSegments(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            // string index begins at 0 or if it is preceded by whitespace and is not a whitespace itself
            if ((i == 0 || s.charAt(i - 1) == ' ') && s.charAt(i) != ' ') {
                count ++;
            }
        }
        return count;
    }
}