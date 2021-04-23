/**
 * 从 [1][1] => [m][n]
 * 每次只能往右、往下前进一步，一共有几种方式
 * 1. 动态规划
 * f[m][n] = f[m-1][n] + f[m][n-1]
 */
public class Q62 {

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        dp[1][1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[1][i] = 1;
        }
        for (int j = 2; j <= m; j++) {
            dp[j][1] = 1;
        }
        for (int i = 2; i <= m; i++) {
            for (int j = 2; j <= n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(new Q62().uniquePaths(3, 7));
    }
}
