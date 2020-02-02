public class CountPrimes {

    public int countPrimes(int n) {
        if (n <= 1) {
            return 0;
        }

        boolean[] notPrime = new boolean[n]; // all initiallized to false;
        notPrime[0] = true; // 0 and 1 are not prime numbers;
        notPrime[1] = true;

        for (int i = 2; i < Math.sqrt(n); i++) { // up to the sqrt
            if (!notPrime[i]) { // if notPrime[i] == false, meaning it is Prime
                for (int j = 2; j * i < n; j++) { // all the numbers * a prime number will result in a product that is not a prime number
                    notPrime[i * j] = true;
                }
            }
        }

        int count = 0;
        for (int i = 2; i < notPrime.length; i++) {
            if (!notPrime[i]) {
                count ++;
            }
        }
        return count;
    }
}