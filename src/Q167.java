import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和，和第一题的区别是元素已经有序了
 * 1. 借助哈希表一趟遍历
 * 不过既然是升序，那么肯定有更加优的方案
 * 2. 双指针，指向头和尾，如果发现两个指针
 * 和等于目标值 => 目标解
 * 和小于目标值 => 左指针右移
 * 和大于目标值 => 右指针左移
 */
public class Q167 {

    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(numbers[i])) {
                return new int[]{map.get(numbers[i]) + 1, i + 1};
            }
            map.put(numbers[i] - target, i);
        }
        return null;
    }

    public int[] twoSum2(int[] numbers, int target) {
        int low = 0;
        int high = numbers.length - 1;
        while (low < high) {
            if (numbers[low] + numbers[high] == target) {
                return new int[]{low + 1, high + 1};
            } else if (numbers[low] + numbers[high] < target) {
                low++;
            } else {
                high--;
            }
        }
        return new int[]{-1, -1};
    }
}
