import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1. 排序，回溯穷举，时间复杂度 O (n^3) 太慢了
 * 2. 双指针，注意处理重复的，每次移动指针都需要去除重复的
 * 如果做过第 560 题就会发现，计算一个升序数组的两数之和时，如果使用双指针时间复杂度只需要 O(N) 即可
 * 因此本地对于后两层循环就可以使用双指针结果，使总体时间复杂度下降到 O(N^2) 不过还是需要注意
 * 重复问题
 */
public class Q15 {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        return recursion(new ArrayList<>(), new ArrayList<>(), nums, 0);
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                break; // 首个都大于 0 了肯定没解，直接退出
            }
            // 首个字符重复了，跳过
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right] + nums[i];
                if (sum < 0) {
                    left++;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                } else if (sum > 0) {
                    right--;
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    resultList.add(list);
                    // 跳动重复的解
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                }
            }
        }
        return resultList;
    }

    private List<List<Integer>> recursion(List<List<Integer>> resultList, List<Integer> list, int[] nums, int startIndex) {
        if (list.size() == 3) {
            if (list.get(0) + list.get(1) + list.get(2) == 0) {
                resultList.add(new ArrayList<>(list));
            }
        } else {
            for (int i = startIndex; i < nums.length; i++) {
                if (i > startIndex && nums[i] == nums[i-1]) {
                    continue;
                }
                list.add(nums[i]);
                recursion(resultList, list, nums, i+1);
                list.remove(list.size() - 1);
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        System.out.println(new Q15().threeSum2(new int[]{-1,0,1,2,-1,-4}));
    }
}
