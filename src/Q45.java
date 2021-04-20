/**
 * 这题与 55 题不同，55 题是判断能否到达
 * 而这题肯定能到终点，要求跳到终点最少跳跃次数
 * 还是一样从左到右，贪心的选择下一步要跳到哪
 */
public class Q45 {

    public int jump(int[] nums) {
        int steps = 0;
        int currIndex = 0;
        int maxStep = nums[0];
        while (currIndex < nums.length - 1) {
            if (currIndex + maxStep >= nums.length - 1) {
                return ++steps;
            }
            int maxIndex = currIndex;
            int maxPosition = 0;
            for (int i = 1; i <= maxStep; i++) {
                if (i + nums[currIndex + i] > maxPosition) {
                    maxPosition = i + nums[currIndex + i];
                    maxIndex = currIndex + i;
                }
            }
            currIndex = maxIndex;
            maxStep = nums[currIndex];
            steps++;
        }
        return steps;
    }

    public static void main(String[] args) {
        System.out.println(new Q45().jump(new int[]{1, 1, 1, 1}));
    }
}