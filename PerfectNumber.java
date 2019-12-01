public class PerfectNumber {

    public boolean checkPerfectNumber(int num) {
        if (num < 2) {
            return false;
        }
        int sum = 1;
        for (int x = 2; x * x <= num; x++) {
            if (num % x == 0) {
                sum += x; // getting x
                sum += num / x; // getting the other number that is also a diviosr of num
            }
        }
        return sum == num;
    }
}