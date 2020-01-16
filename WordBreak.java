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
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}