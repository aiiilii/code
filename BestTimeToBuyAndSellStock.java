public class BestTimeToBuyAndSellStock {

    /**
     * Brute force approach
     * Given an array of integers that represent prices, you have to buy before you can sell one. Buy at a low price, sell at a high price.
     * The second number(selling price) must be larger than the first number(buying price)
     * @param prices
     * @return the max between two numbers
     */
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }
        return maxProfit;
    }

    /**
     * One Pass approach
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        }
        return maxProfit;
    }
}