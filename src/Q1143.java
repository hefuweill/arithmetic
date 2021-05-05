/**
 * 子序列问题建立 dp 表
 * 对于任意字符要么在 lcs 中，要么不在
 * 如果 x(i) = y(j) 那么 x(i) 和 y(i) 就一定在 lcs 中
 * 如果 x(i) != y(j) 那么 x(i) 或 y(i) 至少有个不在 lcs 中
 * dp[i][j] =
 * x(i) = y(j) => dp[i-1][j-1] + 1
 * x(i) != y(j) => max(dp[i][j-1], dp[i-1][j])
 */
public class Q1143 {

    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }
}
