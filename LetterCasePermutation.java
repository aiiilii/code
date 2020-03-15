import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {

    /**
     * Backtracking
     * @param S
     * @return
     */
    public List<String> letterCasePermutation1(String S) {
        if (S == null) {
            return new ArrayList<String>();
        }

        List<String> res = new ArrayList<String>();
        helper(S.toCharArray(), res, 0);
        return res;
    }

    private void helper(char[] chars, List<String> res, int index) {
        if (index == chars.length) {
            res.add(new String(chars));
            return;
        }
        if (chars[index] >= '0' && chars[index] <= '9') {
            helper(chars, res, index + 1);
            return;
        }

        chars[index] = Character.toLowerCase(chars[index]);
        helper(chars, res, index + 1);

        chars[index] = Character.toUpperCase(chars[index]);
        helper(chars, res, index + 1);
    }




    public List<String> letterCasePermutation(String S) {
        List<StringBuilder> res = new ArrayList<StringBuilder>();
        res.add(new StringBuilder());

        for (char c : S.toCharArray()) {
            int n = res.size();
            if (Character.isLetter(c)) {
                for (int i = 0; i < n; i++) {
                    res.add(new StringBuilder(res.get(i)));
                    res.get(i).append(Character.toLowerCase(c));
                    res.get(n + i).append(Character.toUpperCase(c));
                }
            } else {
                for (int i = 0; i < n; i++) {
                    res.get(i).append(c);
                }
            }
        }

        List<String> finalRes = new ArrayList<String>();
        for (StringBuilder sb : res) {
            finalRes.add(sb.toString());
        }
        return finalRes;
    }
}