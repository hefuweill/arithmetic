import static java.lang.Integer.max;

/**
 * 1. 暴力法 O(n^2)
 * 2. 动态规划
 * 定义 dp[i] 表示以 nums[i] 结尾的最大子数组和，那么
 * dp[i] = max(0, dp[i-1]) + nums[i] 如果前面最大值为负数，那我必须把它抛弃，从头来，注意连续
 * 同最长子序列 300 题
 */
public class Q53 {

    public int maxSubArray(int[] nums) {
        return maxSubArrayWay2(nums);
    }

    public int maxSubArrayWay1(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int total = nums[i];
            max = max(max, total);
            for (int j = i + 1; j < nums.length; j++) {
                int newTotal = total + nums[j];
                max = max(max, newTotal);
                total = newTotal;
            }
        }
        return max;
    }

    public int maxSubArrayWay2(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int maxAns = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = max(0, dp[i-1]) + nums[i];
            maxAns = max(maxAns, dp[i]);
        }
        return maxAns;
    }

    public static void main(String[] args) {
        System.out.println(new Q53().maxSubArray(new int[]{-1, -2}));
    }
}
