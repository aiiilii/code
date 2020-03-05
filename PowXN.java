public class PowXN {

    /**
     * Time - O(log n)
     * Space - O(1)
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        long N = n;

        if (N < 0) {
            x  = 1 / x;
            N = -N;
        }

        double res = 1;
        double currProduct = x;

        for (long i = N; i > 0; i /= 2) {
            if (i % 2 == 1) {
                res = res * currProduct;
            }
            currProduct = currProduct * currProduct;
        }
        return res;
    }
}