/**
 * 在 198 题基础上，添加了一个限制， f(n) 不能再简单的推导
 * 因为如果取到 nums[n] 那么必须保证 nums[0] 不能被取到
 * 可以考虑这样 dp[x][y] y 取值为 0、1 分别表示不取 0 号元素以及取 0 号元素
 * 事后发现将环拆成两个队列，一个是从 0 到 n-1，另一个是从 1 到 n 更加好
 */
public class Q213 {

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[][] dp = new int[nums.length][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        dp[1][0] = nums[1];
        dp[1][1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i][0] = Math.max(dp[i-2][0] + nums[i], dp[i-1][0]);
            if (i != nums.length - 1) {
                dp[i][1] = Math.max(dp[i-2][1] + nums[i], dp[i-1][1]);
            } else {
                dp[i][1] = dp[i-1][1];
            }
        }
        return Math.max(dp[nums.length-1][0], dp[nums.length-1][1]);
    }

    public static void main(String[] args) {
        System.out.println(new Q213().rob(new int[]{1, 2, 3}));
    }
}


