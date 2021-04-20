/**
 * 跳跃游戏，判断是否能到达终点
 * [2,3,1,1,4]
 * [3,2,1,0,4]
 * 脑子里一想就是逆推法
 * 要到最后一个点，那么我就计算下哪些节点可以直接到
 * 对于能到的节点，再次进行重复计算，只要最终能到
 * 首个下标，那么就算能到达，否则就算到不了
 * n + nums[n] >= nums.length - 1 即可，可惜效率太低了
 * 另一种贪心算法，计算每一步能走到的最大索引，如果发现下一步
 * 在最大索引之外，那么就是不可达，如果发现已经能到最大索引
 * 了那么就是可达到。
 */
public class Q55 {

    public boolean canJump(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return true;
        }
        return canJumpWay2(nums);
    }

    public boolean canJumpWay1(int[] nums) {
        return recursion(nums, nums.length - 1);
    }

    public boolean canJumpWay2(int[] nums) {
        int maxIndex = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (i > maxIndex) {
                return false;
            } else {
                maxIndex = Math.max(maxIndex, i + nums[i]);
            }
        }
        return true;
    }

    private boolean recursion(int[] nums, int target) {
        if (target == 0) {
            return true;
        }
        for (int i = target - 1; i >= 0; i--) {
            if (nums[i] + i >= target) {
                boolean result = recursion(nums, i);
                if (result) {
                    return true;
                }
            }
        }
        return false;
    }
}
