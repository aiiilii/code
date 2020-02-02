import java.util.Arrays;

public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1); // initiallize all the values in the dp array to a non-reachable value

        dp[0] = 0;
        for (int i = 1; i <= amount ; i++) { // our target amount;
            for (int j = 0; j < coins.length; j++) { // the coin in the coin array that we are taking;
                if (coins[j] <= i) { // if the current coin we are taking is less than the target amount
                    // if we take that coin, thus +1 to dp[previously taken amount]; 
                    // i is the amount we are on, coins[j] is the coin we are on, i - coins[j] is the amount we would be on without taking the coin of coins[j],
                    // dp[i] keeps being updated to the min + 1;
                    dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]); 
                } else { // if the current coin we are taking is larger than the target amount, meaning 5 cents cannot ever make up 1 cent;
                    break;
                }
            }
        }
        // have we ever modified dp[amount] to something that is lower than (amount + 1)?
        // if we have, return it, if not return -1
        if (dp[amount] < amount + 1) { 
            return dp[amount];
        } else {
            return -1;
        }
    }
}