/**
 * 寻找两个正序数组的中位数
 * 1. 暴力法，如果数组长度和为奇数，那么取出 len/2 位置元素返回，如果长度为偶数，那么取出 len/2 - 1 和 len/2 返回
 * 时间复杂度 O((m + n)/2) => O(m + n)
 * 其它的方式较难，以后再说
 */
public class Q4 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int middleLeft = (nums1.length + nums2.length) / 2 - 1;
        int middleRight = middleLeft + 1;
        int leftValue = 0;
        int rightValue = 0;
        int indexI = 0;
        int indexJ = 0;
        for (int i = 0; i <= middleRight; i++) {
            int num;
            if (indexI == nums1.length) {
                num = nums2[indexJ];
                indexJ++;
            } else if (indexJ == nums2.length) {
                num = nums1[indexI];
                indexI++;
            } else if (nums1[indexI] < nums2[indexJ]) {
                num = nums1[indexI];
                indexI++;
            } else {
                num = nums2[indexJ];
                indexJ++;
            }
            if (i == middleLeft) {
                leftValue = num;
            } else if (i == middleRight) {
                rightValue = num;
            }
        }
        return (nums1.length + nums2.length) % 2 == 0 ? (leftValue + rightValue) / 2d : rightValue;
    }

    public static void main(String[] args) {
        System.out.println(new Q4().findMedianSortedArrays(new int[]{}, new int[]{1}));
    }
}
