import java.util.HashSet;
import java.util.Set;

/**
 * 其实就是计算每个字符开始的最长不重复子串
 * 如果采用暴力那么会有很多重复计算，因此考虑使用滑动窗口
 */
public class Q3 {

    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int maxLen = 0;
        Set<Character> set = new HashSet<>();
        char[] array = s.toCharArray();
        while (right < array.length) {
            if (!set.contains(array[right])) {
                set.add(array[right]);
                right++;
            } else {
                set.remove(array[left]);
                left++;
            }
            maxLen = Math.max(maxLen, set.size());
        }
        return maxLen;
    }
}
