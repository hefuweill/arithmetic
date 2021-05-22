import java.util.Arrays;

/**
 * 1. 基础法，发现重复元素直接让后面元素向前移动，不过效率太低下了，高效明天再看今天没时间了
 */
public class Q26 {

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int index = 1;
        int max = nums.length;
        while (index < max) {
            if (nums[index] == nums[index - 1]) {
                for (int i = index + 1; i < nums.length; i++) {
                    nums[i-1] = nums[i];
                }
                max--;
            } else {
                index++;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        Q26 q26 = new Q26();
        int[] array = new int[]{0,0,1,1,1,2,2,3,3,4};
        System.out.println(q26.removeDuplicates(array));
        System.out.println(Arrays.toString(array));
    }
}
