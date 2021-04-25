/**
 * 1. 基本解法，每次通过循环计算
 * 2. 动态规划 f(i, j) = S(j) - S(i-1)
 * S(i-1) 表示索引从 [0,i-1] 元素总和，
 * S(j) 表示索引从 [0, j] 元素总和
 * 也就是前缀和
 * 如果需要多次计算那么使用第二种更快
 */
public class Q303 {

    class NumArray {

        private final int[] sums;
        private final int[] nums;

        public NumArray(int[] nums) {
            this.nums = nums;
            sums = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                if (i == 0) {
                    sums[0] = 0;
                } else {
                    sums[i] = sums[i - 1] + nums[i];
                }
            }
        }

        public int sumRange(int left, int right) {
            return sums[right] - sums[left] + nums[left];
        }
    }
}
