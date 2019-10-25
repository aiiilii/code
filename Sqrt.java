public class Sqrt {

    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        long square;
        int mid;
        int left = 2;
        int right = x / 2;
        while  (left <= right) {
            mid = left + (right - left) / 2;
            square = (long) mid * mid;
            if (square == x) {
                return mid;
            } else if (square > x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return (int)right;
    }

    public int mySqrt2(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        long i = 1;
        long result = 1;
        while (result <= x) {
            i++;
            result = i * i;
        }
        return (int)i - 1;
    }
}