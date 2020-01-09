import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {

    /**
     * A lot faster
     * Time: O(N^2), because to delete elements from the list in a loop one has to perform N + (N - 1) + ... + 1 = N(N - 1)/2N+(N−1)+...+1=N(N−1)/2 operations.
     * Space: O(n)
     * @param n
     * @param k
     * @return
     */
    public String getPermutation2(int n, int k) {
        StringBuilder sb = new StringBuilder();
        List<Integer> num = new ArrayList<Integer>();
        int fact = 1;

        // create a list of numbers to get indices
        for (int i = 1; i <= n; i++) {
            fact *= i; // 
            num.add(i);
        }

        int l = k - 1; // k - 1 because zero based

        for (int i = 0; i < n; i++) {
            fact /= (n - i);
            int index = (l / fact);
            sb.append(num.remove(index));
            l -= index * fact;
        }
        return sb.toString();
    }

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