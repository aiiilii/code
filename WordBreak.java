import java.util.HashSet;
import java.util.Set;
import java.util.List;

public class WordBreak {

    public boolean workBreak(String s, List<String> wordDict) {
        if (s == null || wordDict == null) {
            return false;
        }

        Set<String> dict = new HashSet<String>();
        for (String str : wordDict) {
            dict.add(str);
        }

        boolean[] breakable = new boolean[s.length() + 1];
        breakable[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = i; j > 0; j--) {
                String sub = s.substring(i - j, i);
                if (dict.contains(sub)) {
                    if(breakable[i - j] == true) {
                        breakable[i] = true;
                        break;
                    }
                }
            }
        }
        return breakable[s.length()];
    }


    public boolean workBreak2(String s, List<String> wordDict) {
        Set<String> wordDictSet=new HashSet<String>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                // dp is zero based, therefore dp[j] is actually dp of s.substring(j - 1);
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) { //if dp[j], which is the left segment (s[0, j - 1]), is true and wordDick.contains s[j, i - 1], which means the right segment is true,
                    dp[i] = true; // then dp[i], which is the whole segment, is also true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}