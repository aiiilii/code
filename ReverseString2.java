public class ReverseString2 {

    public String reverseStr(String s, int k) {
        char[] cs = s.toCharArray();
        for (int start = 0; start < cs.length; start += 2 * k) {
            int i = start;
            int j = Math.min(start + k - 1, cs.length - 1);
            while (i < j) {
                char temp = cs[i];
                cs[i] = cs[j];
                cs[j] = temp;
                i++;
                j--;
            }
        }
        return String.valueOf(cs);
    }
}