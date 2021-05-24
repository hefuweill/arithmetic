import java.util.HashMap;
import java.util.Map;

/**
 * 由于要连续，就别想着排序了
 * 1. 暴力法，直接从数组每个索引出发，计算是否能达到目标数，时间复杂度 O(n^2)，也能过，太慢了
 * 2. 前缀和加哈希表，原理 pre[i] - pre[j-1] = k，对于任意一个位置元素结尾，只要前面有元素
 * 和为 pre[i] - k，那么就是一种解，借助哈希表存储前缀和以及数量。有点难想到
 */
public class Q560 {

    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public int subarraySum2(int[] nums, int k) {
        int pre = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int num : nums) {
            pre += num;
            if (map.containsKey(pre - k)) {
                count += map.get(pre - k);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return count;
    }
}
