import java.util.Arrays;
import java.util.Comparator;

/**
 * 题目条件为 满足 w1 < w2 && h1 < h2 那么 信封1 就能放入 信封2 中，
 * 如果对信封根据 w 进行排序，然后再计算每个信封的最长严格递增 h 序列是否就可以？
 * 如果 w 没有重复的那么可以，如果 w 有重复那么计算就有问题，对于 [1,2], [1,3]
 * 计算结果为 2，但是实际上是不满足要求的，因此考虑当两个信封 w 相同，根据其 h 进行逆序排序
 * 这样就得保证相同 w 的信封最多只有一个被选中，考虑如下场景 [2,3],[5,4],[6,7],[6,4],[6,2]
 * 如果 [6,7] 被选中了那么 [6,4] 一定不会被选中，毕竟 4 小于 7，同样的 [6,4] 选中 [6,2] 也不可能选中
 */
public class Q354 {

    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length == 0) {
            return 0;
        }
        Arrays.sort(envelopes, (o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o1[0] - o2[0];
            }
            return o2[1] - o1[1];
        });
        int[] dp = new int[envelopes.length];
        dp[0] = 1;
        int maxAns = 1;
        for (int i = 1; i < envelopes.length; i++) {
            int max = 1;
            for (int j = 0; j < i; j++) {
                if (envelopes[j][1] < envelopes[i][1]) {
                    max = Math.max(max, dp[j] + 1);
                }
            }
            dp[i] = max;
            maxAns = Math.max(maxAns, dp[i]);
        }
        return maxAns;
    }

    public static void main(String[] args) {
        System.out.println(new Q354().maxEnvelopes(new int[][]{{5,4}, {6,4}, {6,7}, {2,3}}));
    }
}
