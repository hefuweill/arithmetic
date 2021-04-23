/**
 * 爬楼梯，每步只能爬一步或者两步，一共爬 N 步，有几种爬法。
 * 1. 动态规划 f(n) = f(n-1) + f(n-2)
 */
public class Q70 {

    public int climbStairs(int n) {
        int x = 1;
        int y = 2;
        if (n == 1) {
            return x;
        } else if (n == 2) {
            return y;
        }
        for (int i = 3; i <= n; i++) {
            int temp = y;
            int next = x + y;
            x = temp;
            y = next;
        }
        return y;
    }
}
