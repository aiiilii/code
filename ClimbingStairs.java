public class ClimbingStairs {

    public int climbStairs(int n) {
        if (n <= 1) {
            return 1;
        }
        int [] ways = new int[n + 1]; // we include the 0th stair
        ways[0] = 1;
        ways[1] = 1;

        for (int i = 2; i <= n; i++) {
            ways[i] = ways[i - 2] + ways[i - 1];
        }
        return ways[n];
    }
}