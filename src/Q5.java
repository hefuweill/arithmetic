/**
 * 最长回文子串，注意回文中间两个元素时可以相同的比如 cbbd
 * 1. 中心展开法，回文串有两种，一种是有个字符居中，然后左右对称，另一种两个相同字符居中，然后左右对称，时间复杂度 O(n^2)
 * 解是解出来了，写的代码过长有重复。
 * 2. 动态规划，定义 dp[i][j] 表示为从字符位置 i 到 字符位置 j 的字符串是否是回文串
 * dp[i][j] = dp[i+1][j-1] && dp[i] == dp[j], j - i > 1 注意 dp[i][j] 不能根据 dp[i-1] 推出
 * 所有不能水平的遍历
 */
public class Q5 {

    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        char[] array = s.toCharArray();
        int maxIndex = -1;
        int maxLength = 0;
        for (int i = 0; i < array.length; i++) {
            int left = i - 1;
            int right = i + 1;
            while (left >= 0 && right < array.length) {
                if (array[left] == array[right]) {
                    left--;
                    right++;
                } else {
                    break;
                }
            }
            int length = (right - left) - 1;
            if (length > maxLength) {
                maxIndex = i;
                maxLength = length;
            }
        }
        String result1 = new String(array, maxIndex - maxLength / 2, maxLength);
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] == array[i + 1]) {
                int left = i - 1;
                int right = i + 1 + 1;
                while (left >= 0 && right < array.length) {
                    if (array[left] == array[right]) {
                        left--;
                        right++;
                    } else {
                        break;
                    }
                }
                int length = (right - left) - 1;
                if (length > maxLength) {
                    maxIndex = i;
                    maxLength = length;
                }
            }
        }
        if (maxLength > result1.length()) {
            return new String(array, maxIndex - maxLength / 2 + 1, maxLength);
        }
        return result1;
    }

    /**
     * 还是中心展开法，不过缩减下代码
     */
    public String longestPalindrome1(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        char[] array = s.toCharArray();
        int start = 0;
        int end = 0;
        for (int i = 0; i < array.length; i++) {
            int len1 = expandAroundCenter(array, i, i);
            int len2 = expandAroundCenter(array, i, i+1);
            int maxLen = Math.max(len1, len2);
            if (maxLen > end - start + 1) {
                start = i - (maxLen - 1) / 2; // 关键这两行，得想清楚
                end = i + maxLen / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public String longestPalindrome2(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        char[] array = s.toCharArray();
        boolean[][] dp = new boolean[array.length][array.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i][i] = true;
        }
        int maxLen = 1; // 至少有一个
        int maxIndex = 0;
        for (int column = 1; column < array.length; column++) {
            for (int row = 0; row < column; row++) {
                if (array[column] != array[row]) {
                    continue;
                }
                if (column - row == 1 || dp[row + 1][column - 1]) {
                    // 只有两个元素且相等，或者有多个元素中间是回文串
                    dp[row][column] = true;
                    if (column - row + 1 > maxLen) {
                        maxLen = column - row + 1;
                        maxIndex = row;
                    }
                }
            }
        }
        return s.substring(maxIndex, maxIndex + maxLen);
    }

    private int expandAroundCenter(char[] array, int left, int right) {
        while (left >= 0 && right < array.length && array[left] == array[right]) {
            left --;
            right ++;
        }
        return right - left - 1;
    }

    public static void main(String[] args) {
        System.out.println(new Q5().longestPalindrome2("cbbd"));
    }
}
