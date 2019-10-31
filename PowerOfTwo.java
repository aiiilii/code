public class PowerOfTwo {

    public boolean isPowerOfTwo(int n) {

        long i = 1;
        while (i < n) {
            i *= 2;
        }
        return i == n;
    }

    /**
     * Bitwise way - O(1)
     * @param n
     * @return
     */
    public boolean isPowerOfTwo2(int n) {
        if (n <= 0) {
            return false;
        }
        return (n & (n - 1)) == 0;
    }
}