import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RQ40 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        return backtrace(new ArrayList<>(), new ArrayList<>(), candidates, target, 0);
    }

    public List<List<Integer>> backtrace(List<List<Integer>> resultList, List<Integer> list, int[] candidates, int remain, int startIndex) {
        if (remain == 0) {
            resultList.add(new ArrayList<>(list));
        } else if (remain > 0) {
            for (int i = startIndex; i < candidates.length; i++) {
                if (i != startIndex && candidates[i-1] == candidates[i]) {
                    continue;
                }
                list.add(candidates[i]);
                backtrace(resultList, list, candidates, remain - candidates[i], i + 1);
                list.remove(list.size() - 1);
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        System.out.println(new RQ40().combinationSum(new int[]{2, 3, 5}, 8));
    }
}