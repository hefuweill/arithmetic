import java.util.ArrayList;
import java.util.List;

/**
 * 求子集
 * 由于子集长度不限制，因此递归时直接将其放入
 * 由于需要子集不重复，因此需要一个开始索引
 */
public class Q78 {

    public List<List<Integer>> subsets(int[] nums) {
        return recursion(new ArrayList<>(), new ArrayList<>(), nums, 0);
    }

    private List<List<Integer>> recursion(List<List<Integer>> resultList, List<Integer> list, int[] nums, int startIndex) {
        resultList.add(list);
        for (int i = startIndex; i < nums.length; i++) {
            List<Integer> tempList = new ArrayList<>(list);
            tempList.add(nums[i]);
            recursion(resultList, tempList, nums, i + 1);
        }
        return resultList;
    }

    public static void main(String[] args) {
        System.out.println(new Q78().subsets(new int[]{1, 2, 3}));
    }
}
