import java.util.HashMap;

public class FibonacciNumber {

    /**
     * recursion + hashmap approach
     * @param N
     * @return
     */
    public int fib3(int N) {
        if (cache.containsKey(N)) {
            return cache.get(N);
        }

        if (N == 0) {
            return 0;
        }
        if (N == 1) {
            return 1;
        }
        
        int result = fib3(N - 1) + fib3(N - 2);
        cache.put(N, result);
        return result;
    }

    private HashMap<Integer, Integer> cache = new HashMap<Integer, Integer>();


    public int fib1(int N) {
        if (N == 0) {
            return 0;
        }
        if (N == 1) {
            return 1;
        }
        int result = fib1(N - 1) + fib1(N - 2);
        return result;
    }

    public int fib2(int N) {
        if (N <= 1) {
            return N;
        }
        if (N == 2) {
            return 1;
        }
        int curr = 0;
        int prev1 = 1;
        int prev2 = 1;
        for (int i = 3; i <= N; i++) {
            curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        return curr;
    }
}