import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和为 0，直接使用回溯穷举，超时了
 * 过些时候考虑如何高效
 */
public class Q15 {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        return recursion(new ArrayList<>(), new ArrayList<>(), nums, 0);
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
}
