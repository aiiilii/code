public class Sqrt {

    public static int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
       
        long left = 2;
        long right = x / 2;
        while  (left <= right) {
            long mid = left + (right - left) / 2;
            
            if (mid * mid == x) {
                return (int)mid;
            } else if (mid * mid > x) {
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

    public static void main(String[] args) {
        System.out.println(mySqrt(4));
    }
}