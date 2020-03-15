import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {

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