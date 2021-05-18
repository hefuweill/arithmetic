import java.util.HashMap;
import java.util.Map;

/**
 * 计算得出以 index = x 并且满足条件的最小子串，然后对比这些子串，得到最短子串。
 * 1. 暴力法，穷举所有可能，时间复杂度O(s^2t) 预估，由于 t 的字符数最多也就是 128，遍历 map 可以忽略，超时了。
 * 2. 滑动窗口，首先右指针往右，找到第一个包含所有 t 字符的位置，接着左指针往右，缩小区间，直到不全包含为止，
 * 记录下该位置（这是一个局部最小子串），接着右指针继续向右，找到包含所有 t 字符的位置，接着左指针移动，以此类推。
 * 这个方法比暴力法高效，因为比如计算 index = 1 的最小子串，可以依赖于 index = 0 的最小子串通过右移左指针
 * 不过我还是超时了，不过超时的用例边长了
 * https://leetcode-cn.com/submissions/detail/178533384/testcase/
 * 太艰难了，不优化根本通不过
 */
public class Q76 {

    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : tChars) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        int minLength = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i <= s.length() - t.length(); i++) {
            for (int j = t.length() - 1; j < s.length(); j++) {
                if (containsV1(map, sChars, i, j)) {
                    if (j - i + 1 < minLength) {
                        minLength = j - i + 1;
                        minIndex = i;
                    }
                    break;
                }
            }
        }
        if (minIndex == -1) {
            return "";
        }
        return s.substring(minIndex, minIndex + minLength);
    }

    public String minWindow2(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> tempMap = new HashMap<>();
        for (char c : tChars) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        int left = 0;
        int right = 0;
        int minIndex = -1;
        int minLength = Integer.MAX_VALUE;
        tempMap.put(sChars[0], 1);
        while (true) {
            if (right - left + 1 < t.length() || !containsV2(map, tempMap)) {
                right++;
                if (right != s.length()) {
                    if (!tempMap.containsKey(sChars[right])) {
                        tempMap.put(sChars[right], 1);
                    } else {
                        tempMap.put(sChars[right], tempMap.get(sChars[right]) + 1);
                    }
                } else {
                    break;
                }
            } else {
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    minIndex = left;
                }
                if (tempMap.get(sChars[left]) == 1) {
                    tempMap.remove(sChars[left]);
                } else {
                    tempMap.put(sChars[left], tempMap.get(sChars[left]) - 1);
                }
                left++;
            }
        }
        if (minIndex == -1) {
            return "";
        }
        return s.substring(minIndex, minIndex + minLength);
    }

    private boolean containsV2(Map<Character, Integer> map, Map<Character, Integer> tempMap) {
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (!tempMap.containsKey(entry.getKey())) {
                return false;
            } else {
                if (tempMap.get(entry.getKey()) < entry.getValue()) {
                    return false;
                }
            }
        }
        return true;
    }


    private boolean containsV1(Map<Character, Integer> map, char[] array, int startIndex, int endIndex) {
        Map<Character, Integer> tempMap = new HashMap<>();
        for (int i = startIndex; i <= endIndex; i++) {
            char c = array[startIndex];
            if (tempMap.containsKey(c)) {
                tempMap.put(c, map.get(c) + 1);
            } else {
                tempMap.put(c, 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (!tempMap.containsKey(entry.getKey())) {
                return false;
            } else {
                if (tempMap.get(entry.getKey()) < entry.getValue()) {
                    return false;
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(new Q76().minWindow2("ADOBECODEBANC", "ABC"));
    }
}
