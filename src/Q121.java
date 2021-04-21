/**
 * 最多只能买一次卖一次
 * 1. 暴力法，O(n^2) 设想除最后一天每一天都买，然后遍历后面的那些天，看看什么时候卖比较好。LeetCode 上超时了
 * 2. 动态规划，第 i 天卖出利润 f(i) 能否根据 f(i-1) 得出？
 * f(i-1) = prices[i-1] - minValue 其中 minValue 为 [0,i-1] 天股票的最低价格注意 i-1 可以取到，如果 i-1 天为最低价，那么 f(i-1) 就是 0，因为不可能赚钱
 * f(i) = prices[i] - minValue 其中 minValue 为 [0, i-1] 天股票的最低价格注意 i 不能取
 * 联立两式 f(i) = prices[i] - prices[i-1] + f(i-1)
 * 3. 设想每一天都卖，然后假设我是前面最低价买的，以此算出最大利润
 */
public class Q121 {

    public int maxProfit(int[] prices) {
        return maxProfitWay2(prices);
    }

    public int maxProfitWay1(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            int cost = prices[i];
            for (int j = i + 1; j <= prices.length - 1; j++) {
                int earn = prices[j] - cost;
                max = Math.max(max, earn);
            }
        }
        return max;
    }

    public int maxProfitWay2(int[] prices) {
        int[] array = new int[prices.length];
        array[0] = 0;
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            array[i] = Math.max(prices[i] - prices[i - 1] + array[i - 1], 0);
            max = Math.max(array[i], max);
        }
        return max;
    }

    public int maxProfitWay3(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxEarn = 0;
        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            maxEarn = Math.max(maxEarn, price - minPrice);
        }
        return maxEarn;
    }

    public static void main(String[] args) {
        System.out.println(new Q121().maxProfitWay2(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
