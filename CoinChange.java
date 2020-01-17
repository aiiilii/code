import java.util.Arrays;

public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);

        dp[0] = 0;
        for (int i = 0; i <= amount ; i++) { // our target amount;
            for (int j = 0; j < coins.length; j++) { // the coin that we are taking;
                if (coins[j] <= i) { // if the current coin we are taking is less than the target amount
                    dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]); // if we take that coin, thus +1 to dp[previously taken amount]
                } else {
                    break;
                }
            }
        }
        // have we ever modified dp[amount] to something that is lower than (amount + 1),
        // if we have, return it, if not return -1
        if (dp[amount] <= amount) { // same as (dp[amount] < amount + 1)
            return dp[amount];
        } else {
            return -1;
        }
    }
}