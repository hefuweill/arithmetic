import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 全排列，跟顺序有关，元素有重复，不能再用 contains 了，改用标记数组，不过标记了还不够，还需要去重
 */
public class Q47 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        return recursion(new ArrayList<>(), new ArrayList<>(), nums, new boolean[nums.length]);
    }

    private List<List<Integer>> recursion(List<List<Integer>> resultList, List<Integer> list, int[] nums, boolean[] mark) {
        if (list.size() == nums.length) {
            resultList.add(new ArrayList<>(list));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (!mark[i] && (i == 0 || nums[i] != nums[i-1] || !mark[i-1])) {
                    mark[i] = true;
                    list.add(nums[i]);
                    recursion(resultList, list, nums, mark);
                    list.remove(list.size() - 1);
                    mark[i] = false;
                }
            }
        }
        return resultList;
    }

}
