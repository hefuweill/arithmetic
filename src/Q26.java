import java.util.Arrays;

/**
 * 1. 基础法，发现重复元素直接让后面元素向前移动，不过效率太低下了，高效明天再看今天没时间了
 * 2. 快慢指针，慢指针指向下一个存储不同元素的索引，快指针指向当前遍历的索引，初始都为 1
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

    public int removeDuplicates2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int fast = 1;
        int slow = 1;
        while (fast < nums.length) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow++] = nums[fast++];
            } else {
                fast++;
            }
        }
        return slow;
    }

    public static void main(String[] args) {
        Q26 q26 = new Q26();
        int[] array = new int[]{0,0,1,1,1,2,2,3,3,4};
        System.out.println(q26.removeDuplicates2(array));
        System.out.println(Arrays.toString(array));
    }
}
