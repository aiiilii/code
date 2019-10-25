public class LongestCommonPrefix {
    
    public LongestCommonPrefix() {
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0 || strs == null) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            String currentString = strs[i];

            while (j < prefix.length() && j < currentString.length() && prefix.charAt(j) == currentString.charAt(j)) {
                j++;
            }
            if (j == 0) {
                return "";
            }
            prefix = prefix.substring(0, j);
        }
        return prefix;
    }

    public static void main(String[] args) {
        String a = "abcdefg";
        String b = a.substring(0,3);
        System.out.println(b);
    }
}