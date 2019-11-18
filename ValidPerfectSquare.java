public class ValidPerfectSquare {

    /**
     * Binary search approach
     * time: O(logn); space: O(1)
     * @param num
     * @return
     */
    public boolean isPerfectSquare(int num) {
        if (num < 0) {
            return false;
        }
        if (num == 1 || num == 0) {
            return true;
        }
        long square;
        int mid;
        int left = 2;
        int right = num / 2;
        while (left <= right) {
            mid = left + (right - left) / 2;
            square = (long) mid * mid;
            if (square == num) {
                return true;
            } else if (square > num) {
                right = (int) mid - 1;
            } else if (square < num) {
                left = (int) mid + 1;
            }
        }
        return false;
    }

    /**
     * Brute force approach
     * time: O(n); space: O(1)
     * @param num
     * @return
     */
    public boolean isPerfectSquare2(int num) {
        if (num < 0) {
            return false;
        }
        if (num == 1 || num == 0) {
            return true;
        }
        for (int i = 2; i <= num / i; i++) {
            if (i * i == num) {
                return true;
            }
        }
        return false;
    }
}