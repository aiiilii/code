public class PowerOfFour {

    public boolean isPowerOfFour(int n) {
        if (n == 1) {
            return true;
        }
        if (n <= 3) {
            return false;
        }
        while (n > 4) {
            if (n % 4 == 0) {
                n /= 4;
            } else {
                return false;
            }
        }
        if (n == 4) {
            return true;
        } else {
            return false;
        }
    }
}