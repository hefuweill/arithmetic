/**
 * 1 ~ n 构成的二叉搜索树数量
 * 随机选取 i 做为根节点，于是左子树为 [1, i - 1]，右子树为 [i + 1, n]
 * 1. 动态规划
 * 定义 f(n) 表示 [1, n] 构成的子树数量，最终答案就是 f(n)
 * 定义 g(i) 表示以 i 为根节点的子树数量
 * f(i) = g(1) + ... + g(i)
 * g(i) = f(i-1) * f(n-i)
 * f(n) = f(0) * f(n-1) + ... + f(n-1) * f(0) 因此只要知道 f(0) ~ f(n-1) 就能推导出 f(n)
 * f(0) = 1
 * f(1) = f(0) * f(0) = 1
 * f(2) = f(0) * f(1) + f(1) * f(0) = 2
 */
public class Q96 {

    public int numTrees(int number) {
        int[] dp = new int[number+1];
        dp[0] = 1;
        for (int n = 1; n <= number; n++) { // 求 f(n)
            int total = 0;
            for (int i = 1; i <= n; i++) { // 求 g(i)
                total += dp[i-1] * dp[n-i];
            }
            dp[n] = total; // 算出 f(n)
        }
        return dp[number];
    }

    public static void main(String[] args) {
        System.out.println(new Q96().numTrees(3));
    }
}
