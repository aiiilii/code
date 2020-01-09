import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {

    /**
     * Super slow
     * @param n
     * @param k
     * @return
     */
    public String getPermutation(int n, int k) {
        List<String> list = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        boolean[] used = new boolean[n + 1];
        int[] ks = new int[1];
        ks[0] = k;
        
        backtracking(list, sb, n, used, ks);
        
        if (ks[0] > 0) {
            return "";
        }
        
        return list.get(0);
    }
    
    private void backtracking(List<String> list, StringBuilder sb, int n, boolean[] used, int[] ks) {
        if (sb.length() == n) {
            ks[0] --;
            if (ks[0] == 0) {
                list.add(sb.toString());
            }
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (used[i]) {
                continue;
            }
            sb.append(i);
            used[i] = true;
            backtracking(list, sb, n, used, ks);
            used[i] = false;
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}