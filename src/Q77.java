import java.util.ArrayList;
import java.util.List;

/**
 * 这题与 78 题不同，主要在于元素个数是固定的，其实也是大同小异
 * 注意不要每次循环都新建一个 ArrayList 这会影响效率，只要
 * 在最后需要加入的时候再新建一个就行。
 * 子集可以这么做，是应该循环内每次新建的 ArrayList 其实都是一个解
 * 最后还需要剪枝，因为数量已经不够，再次循环是没有意义的
 */
public class Q77 {

    public List<List<Integer>> combine(int n, int k) {
        return recursion(new ArrayList<>(), new ArrayList<>(), n, k, 1);
    }

    private List<List<Integer>> recursion(List<List<Integer>> resultList, List<Integer> list, int n, int k, int startIndex) {
        if (list.size() == k) {
            resultList.add(new ArrayList<>(list));
        } else if (n - startIndex + 1 + list.size() >= k) {
            for (int i = startIndex; i <= n; i++) {
                list.add(i);
                recursion(resultList, list, n, k, i + 1);
                list.remove(list.size() - 1);
            }
        }
        return resultList;
    }
}
