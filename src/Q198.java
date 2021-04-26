import static java.lang.Integer.max;

/**
 * 1. 动态规划
 * 状态转移方程 f(n) = max(f(n-2) + nums[n], f(n-1))
 */
public class Q198 {

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = max(dp[i-2] + nums[i], dp[i-1]);
        }
        return dp[nums.length - 1];
    }
}
