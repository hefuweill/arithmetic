/**
 * 脑子里一定要先想想 dp[i] 代表什么意思，这个很关键
 * 想出了以后就可以想想怎么根据已知的 dp[0..i-1] 递推出 dp[i]本题 dp[i] 表示以 num[i] 结尾的最长递增子序列数，
 * 那么答案也就是求 dp[0] ~ dp[n] 的最大值，状态转移方程是什么？
 * dp[i] = max(dp[0] ...dp[index]... dp[i-1]) + 1 && nums[i] > nums[index]
 * 还有一种基于二分搜索更优的可续可以看一看
 */
public class Q300 {

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxAns = 1;
        for (int i = 1; i < nums.length; i++) {
            int max = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    max = Math.max(max, dp[j] + 1);
                }
            }
            dp[i] = max;
            maxAns = Math.max(max, maxAns);
        }
        return maxAns;
    }

    public static void main(String[] args) {
        System.out.println(new Q300().lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
    }
}
