public class PerfectSquares {

    /**
     * Math approach - three-square theorem
     * Time - O(sqrt of n)
     * Space - O(1)
     * @param n
     * @return
     */
    public int numSquares(int n) {
        // n = 4k * (8m + 7)
        while (n % 4 == 0) {
            n /= 4;
        }
        if (n % 8 == 7) {
            return 4;
        }

        if (isSquare(n)) {
            return 1;
        }

        for (int i = 0; i * i <= n; i++) {
            if (isSquare(n - i * i)) {
                return 2;
            }
        }
        return 3;
    }

    private boolean isSquare(int n) {
        int sq = (int) Math.sqrt(n);
        return n == sq * sq;
    }
}