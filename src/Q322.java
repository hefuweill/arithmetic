/**
 * 找零问题，对于每个硬币都可以选择 0 ~ N 个
 * 对于每个硬币，可以分别计算下，用和不用，所需的硬币数，取最小的即可，
 */
public class Q322 {

    public int coinChange(int[] coins, int amount) {
        return recursion(coins, new int[amount + 1], amount, 0);
    }

    private int recursion(int[] coins, int[] counts, int amount, int coinAmount) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        if (counts[amount] != 0) {
            return counts[amount];
        }
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int result = recursion(coins, counts, amount - coin, coinAmount);
            if (result != -1) {
                min = Math.min(min, result + 1);
            }
        }
        if (min == Integer.MAX_VALUE) {
            counts[amount] = -1;
            return -1;
        }
        counts[amount] = min;
        return min;
    }

    public static void main(String[] args) {
        System.out.println(new Q322().coinChange(new int[]{1, 2, 5}, 11));
    }
}
