/**
 * 与 Q121 不同，本题不限制买卖次数
 * 1. 跟现实买股票一样，我要是把一个区间的所有上坡全部吃到，那么我就是赚的最多的
 * 2. 动态规划，对于每一天交易结束无非就两种状态，要么持有股票，要么不持有
 * 也就是 dp[n][0] 以及 dp[n][1]
 * dp[n][0] = max(dp[n-1][0], dp[n-1][1] + price[n])
 * dp[n][1] = max(dp[n-1][1], dp[n-1][0] - price[n])
 */
public class Q122 {

    public int maxProfit(int[] prices) {
        return maxProfitWay2(prices);
    }

    public int maxProfitWay1(int[] prices) {
        int earn = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i-1]) {
                earn += prices[i] - prices[i-1];
            }
        }
        return earn;
    }

    public int maxProfitWay2(int[] prices) {
        int dp0 = 0;
        int dp1 = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            int newDp0 = Math.max(dp0, dp1 + prices[i]);
            int newDp1 = Math.max(dp1, dp0 - prices[i]);
            dp0 = newDp0;
            dp1 = newDp1;
        }
        return dp0;
    }
}
