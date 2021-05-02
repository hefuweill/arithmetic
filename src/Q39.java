import java.util.ArrayList;
import java.util.List;

/**
 * 因为无重复元素，解集需要不重复只要加上起始索引即可
 */
public class Q39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        return recursion(new ArrayList<>(), new ArrayList<>(), candidates, target, 0, 0);
    }

    private List<List<Integer>> recursion(List<List<Integer>> resultList, List<Integer> list, int[] candidates, int target, int startIndex, int sum) {
        if (sum == target) {
            resultList.add(new ArrayList<>(list));
        } else if (sum > target) {
            return resultList;
        } else {
            for (int i = startIndex; i < candidates.length; i++) {
                list.add(candidates[i]);
                sum += candidates[i];
                recursion(resultList, list, candidates, target, i, sum);
                sum -= candidates[i];
                list.remove(list.size() - 1);
            }
        }
        return resultList;
    }
}
