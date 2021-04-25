/**
 * 动态规划 f(m, n) = f(m-1, n) + f(m, n-1)
 * 不过考虑有障碍物，需要排查掉不合法的路径
 * 如果当前节点为障碍物，那么 f(m, n) 等于 0
 */
public class Q63 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = new int[obstacleGrid[0].length];
        }
        for (int i = 0; i < obstacleGrid.length; i++) {
            if (obstacleGrid[i][0] != 1) {
                dp[i][0] = 1;
                continue;
            }
            break;
        }
        for (int i = 0; i < obstacleGrid[0].length; i++) {
            if (obstacleGrid[0][i] != 1) {
                dp[0][i] = 1;
                continue;
            }
            break;
        }
        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[dp.length-1][dp[dp.length-1].length-1];
    }

    public static void main(String[] args) {
        int[] i1 = {0, 0, 0};
        int[] i2 = {0, 1, 0};
        int[] i3 = {0, 0, 0};
        int[][] ii = new int[3][];
        ii[0] = i1;
        ii[1] = i2;
        ii[2] = i3;
        System.out.println(new Q63().uniquePathsWithObstacles(ii));
    }
}
