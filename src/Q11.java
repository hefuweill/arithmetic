/**
 * 求最大盛水面积
 * 1. 暴力法，计算以 nums[i] 为起点的最大盛水面积，时间复杂度为 O(n^2) 超出时间限制
 * 2. 双指针，每次移动两个指针位置较小的指针，原理是
 * 左右指针表示该区间可能产生最大面积
 * 假设左指针元素较小，那么该左指针需要向右移才有可能得到更大的面积，
 * 不管右指针如何向左移动，都不可能使面积变大，原理是面积与短的那一边有关
 * 假设右指针元素较小，那么该右指针需要向左移才有可能得到更大的面积原理也是一样
 */
public class Q11 {

    public int maxArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            boolean isFirst = true;
            for (int j = height.length - 1; j > i; j--) {
                int area = Math.min(height[j], height[i]) * (j - i);
                if (isFirst && height[j] >= height[i]) {
                    maxArea = Math.max(area, maxArea);
                    break;
                } else {
                    maxArea = Math.max(area, maxArea);
                }
                isFirst = false;
            }
        }
        return maxArea;
    }

    public int maxArea2(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while (left != right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }
}
