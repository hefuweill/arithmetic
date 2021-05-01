import java.util.ArrayList;
import java.util.List;

/**
 * 全排列，跟顺序有关，元素没有重复，直接用 contains 效率较低
 */
public class Q46 {

    public List<List<Integer>> permute(int[] nums) {
        return recursion(new ArrayList<>(), new ArrayList<>(), nums);
    }

    private List<List<Integer>> recursion(List<List<Integer>> resultList, List<Integer> list, int[] nums) {
        if (list.size() == nums.length) {
            resultList.add(new ArrayList<>(list));
        } else {
            for (int num : nums) {
                if (!list.contains(num)) {
                    list.add(num);
                    recursion(resultList, list, nums);
                    list.remove(list.size() - 1);
                }
            }
        }
        return resultList;
    }

}
