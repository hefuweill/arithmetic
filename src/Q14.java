/**
 * 首先获取最短的字符串长度，然后比对每个字符串相同位置，如果发现有字符不等那么返回
 * 否则将该字符加入 StringBuilder 中继续进行遍历。
 */
public class Q14 {

    public String longestCommonPrefix(String[] strs) {
        StringBuilder builder = new StringBuilder();
        if (strs == null || strs.length == 0) {
            return "";
        }
        int minLen = Integer.MAX_VALUE;
        for (String str : strs) {
            minLen = Math.min(str.length(), minLen);
        }
        for (int i = 0; i < minLen; i++) {
            char c = strs[0].charAt(i);
            for (String str : strs) {
                if (c != str.charAt(i)) {
                    return builder.toString();
                }
            }
            builder.append(c);
        }
        return builder.toString();
    }
}
