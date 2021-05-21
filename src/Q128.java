import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 最长连续序列
 * 1. 排序后使用动态规划计算最长序列，定义 dp[i] 表示以 nums[i] 结尾的最长连续序列长度
 * dp[i] = dp[i-1] + 1 如果 nums[i] = nums[i-1] + 1
 * dp[i] = dp[i-1] 如果 nums[i] != nums[i-1]
 * dp[i] = 1 如果 nums[i] > nums[i-1] + 1
 * 时间复杂度O(n^2)
 * 2. 借助 hash 表，首先将所有元素加入到 set 中，然后遍历所有元素，
 * 如果发现该元素值 - 1 在 set 中则跳过，因为计算它毫无意义，如果不在
 * 那么循环判断该元素值 + 1 是否在 set 中以此类推
 * 时间复杂度O(n) 原因：对于每个元素，如果它不是递增序列的第一个则进入不了循环，
 * 进入了循环后内层循环会将该递增序列的后续序列遍历。
 */
public class Q128 {

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int prev = 1;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1] + 1) {
                max = Math.max(max, ++prev);
            } else if (nums[i] != nums[i-1]) {
                prev = 1;
            }
        }
        return max;
    }

    public int longestConsecutive2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int max = 0;
        for (int num : set) { // 注意这里遍历 set 不要再遍历 nums 了，会多很多重复操作
            if (!set.contains(num - 1)) {
                int curr = 1;
                int value = num;
                while (set.contains(value + 1)) {
                    curr++;
                    value++;
                }
                max = Math.max(max, curr);
            }
        }
        return max;
    }
}
