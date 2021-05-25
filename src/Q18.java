import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1. 排序，回溯穷举，时间复杂度 O (n^4) 太慢了
 * 2. 双指针，注意处理重复的，每次移动指针都需要去除重复的
 * 如果做过第 560 题就会发现，计算一个升序数组的两数之和时，如果使用双指针时间复杂度只需要 O(N) 即可
 * 因此本地对于后两层循环就可以使用双指针结果，使总体时间复杂度下降到 O(N^3) 不过还是需要注意
 * 重复问题
 */
public class Q18 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return recursion(new ArrayList<>(), new ArrayList<>(), nums, 0, target);
    }

    public List<List<Integer>> fourSum2(int[] nums, int target) {
        List<List<Integer>> resultList = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            // 首个字符重复了，跳过
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 1; j ++) {
                if (j > i + 1 && nums[j] == nums[j-1]) {
                    continue;
                }
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    int sum = nums[left] + nums[right] + nums[i] + nums[j];
                    if (sum < target) {
                        left++;
                        while (left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }
                    } else if (sum > target) {
                        right--;
                        while (left < right && nums[right] == nums[right + 1]) {
                            right--;
                        }
                    } else {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
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
        }
        return resultList;
    }

    private List<List<Integer>> recursion(List<List<Integer>> resultList, List<Integer> list, int[] nums, int startIndex, int target) {
        if (list.size() == 4) {
            if (list.get(0) + list.get(1) + list.get(2) + list.get(3) == target) {
                resultList.add(new ArrayList<>(list));
            }
        } else {
            for (int i = startIndex; i < nums.length; i++) {
                if (i > startIndex && nums[i] == nums[i-1]) {
                    continue;
                }
                list.add(nums[i]);
                recursion(resultList, list, nums, i+1, target);
                list.remove(list.size() - 1);
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        System.out.println(new Q18().fourSum2(new int[]{2,2,2,2}, 8));
    }

}
