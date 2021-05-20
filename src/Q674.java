/**
 * 求最长连续递增序列
 * 1. 暴力法，对于每个位置的元素都计算下以其开头的最长连续递增序列，时间复杂度 O(n^2)
 * 2. 动态规划，设 dp[i] 表示以 nums[i] 结尾的最长连续递增序列数，那么
 * dp[i] = dp[i-1] + 1 当 num[i] 大于 nums[i-1] 时，否则 dp[1] = 1
 * 最终结果为 Math.max(dp[0] ... dp[nums.length-1])，时间复杂度 O(n)，由于 dp[i] 只由 dp[i-1] 推导
 * 因此空间复杂度为 O(1)。
 */
public class Q674 {

    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[j-1]) {
                    max = Math.max(max, j - i + 1);
                } else {
                    break;
                }
            }
        }
        return max;
    }

    public int findLengthOfLCIS2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int prev = 1;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i-1]) {
                max = Math.max(max, prev + 1);
                prev++;
            } else {
                prev = 1;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Q674().findLengthOfLCIS2(new int[]{1, 3, 5, 4, 2, 3, 4, 5}));
    }
}
