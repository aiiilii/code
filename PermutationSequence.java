import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {

    public String getPermutation1(int n, int k) {
        char[] res = new char[n];
        ArrayList<Integer> nums = new ArrayList<Integer>();
        int[] factorial = new int[n];

        factorial[0] = 1;
        for (int i = 1; i < n; i++) {
            factorial[i] = factorial[i - 1] * i; // 5! = 4! * 5
        }

        // Create a number list that contains all of the possible numbers
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }

        k--; // to make k zero based

        for (int i = 0; i < n; i++) {
            // Adding chars to res from the highest digit to the lowest digit.
            // (n - i - 1) is the number of digits left remaining, factorial of (n - i - 1) will get the number of permutations per subgroup
            // k / factorial[n - i - 1] will give the index at which it is in our nums arraylist, so we remove it from nums arraylist and put it at res[i]
            res[i] = Character.forDigit(nums.remove(k / factorial[n - i - 1]), 10); // changing the removed number into ascii, based 10 system
            k = k % factorial[n - 1 - i]; // update k by k dividing the permutations count in each subgroup, so we can start the next round as we have gotten the highest digit number already;
        }
        return new String(res);
    }

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