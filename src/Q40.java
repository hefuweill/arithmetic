import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 因为有重复元素，并且每个数字只能用一次，解集需要考虑重复问题，可以先对元素排序，然后过滤相同元素。
 */
public class Q40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        return recursion(new ArrayList<>(), new ArrayList<>(), candidates, target, 0, 0);
    }

    private List<List<Integer>> recursion(List<List<Integer>> resultList, List<Integer> list, int[] candidates, int target, int startIndex, int sum) {
        if (sum == target) {
            resultList.add(new ArrayList<>(list));
        } else if (sum > target) {
            return resultList;
        } else {
            for (int i = startIndex; i < candidates.length; i++) {
                // 保证相同起始元素不被重复选择
                if (i > startIndex && candidates[i] == candidates[i-1]) {
                    continue;
                }
                list.add(candidates[i]);
                sum += candidates[i];
                recursion(resultList, list, candidates, target, i + 1, sum);
                sum -= candidates[i];
                list.remove(list.size() - 1);
            }
        }
        return resultList;
    }
}
