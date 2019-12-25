import java.util.ArrayList;
import java.util.List;

public class LetterCombinationOfPhoneNumber {

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        
        if (digits == null || digits.length() == 0) {
            return res;
        }

        String[] mapping = {
            "0",
            "1",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
        };
        StringBuilder sb = new StringBuilder();
        combinationHelper(res, sb, mapping, digits);
        return res;
    }

    private void combinationHelper(List<String> res, StringBuilder sb, String[] mapping, String digits) {
        if (sb.length() == digits.length()) {
            res.add(sb.toString());
            return;
        }
        for (char c : mapping[digits.charAt(sb.length()) - '0'].toCharArray()) {
            sb.append(c);
            combinationHelper(res, sb, mapping, digits);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}