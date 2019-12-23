import java.util.HashMap;
import java.util.Map;

public class FourSumII {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int res = 0;

        Map<Integer, Integer> mp = new HashMap<Integer, Integer>();

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int sum = A[i] + B[j];
                mp.put(sum, mp.getOrDefault(sum, 0) + 1);
            }
        }
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                res += mp.getOrDefault(-1 * (C[i] + D[j]), 0);
            }
        }
        return res;
    }
}