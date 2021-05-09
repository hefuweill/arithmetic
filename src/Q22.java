import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 常规回溯效率堪忧，只超过了 6% , 判断是否合法其实不需要最终去判断，循环过程中就能判断了
 * 在递归回溯过程中，如果发现一个字符串左括号数量已经小于右括号大小了，那么直接终止。
 */
public class Q22 {

    public List<String> generateParenthesis(int n) {
        return recursion(n, new ArrayList<>(), new StringBuilder());
    }

    private List<String> recursion(int n, List<String> resultList, StringBuilder builder) {
        if (builder.length() == n * 2) {
            if (isLegal(builder)) {
                resultList.add(builder.toString());
            }
        } else {
            for (char c = '('; c <= ')'; c++) {
                builder.append(c);
                recursion(n, resultList, builder);
                builder.deleteCharAt(builder.length() - 1);
            }
        }
        return resultList;
    }

    private boolean isLegal(StringBuilder builder) {
        char[] chars = builder.toString().toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : chars) {
            if (c == '(') {
                stack.push('(');
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new Q22().generateParenthesis(3));
    }
}
