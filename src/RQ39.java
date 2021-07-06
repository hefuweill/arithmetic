import java.util.ArrayList;
import java.util.List;

public class RQ39 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        return backtrace(new ArrayList<>(), new ArrayList<>(), candidates, target, 0);
    }

    public List<List<Integer>> backtrace(List<List<Integer>> resultList, List<Integer> list, int[] candidates, int remain, int startIndex) {
        if (remain == 0) {
            resultList.add(new ArrayList<>(list));
        } else if (remain > 0) {
            for (int i = startIndex; i < candidates.length; i++) {
                list.add(candidates[i]);
                backtrace(resultList, list, candidates, remain - candidates[i], i);
                list.remove(list.size() - 1);
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        System.out.println(new RQ39().combinationSum(new int[]{2, 3, 5}, 8));
    }
}
