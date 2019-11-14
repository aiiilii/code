public class PowerOfThree {

    public boolean isPowerOfThree (int n) {
        if (n == 1) {
            return true;
        }
        if (n <= 2) {
            return false;
        }
        while(n > 3) {
            if (n % 3 == 0) {
                n /= 3;
            } else {
                return false;
            }
        }
        if (n == 3) {
            return true;
        } else {
            return false;
        }
    }
}