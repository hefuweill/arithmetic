import java.util.Stack;

/**
 * 注意判断栈是否为空，关键
 */
public class RQ20 {

    public boolean isValid(String s) {
        char[] array = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : array) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
                continue;
            }
            if (stack.isEmpty()) {
                return false;
            }
            char topChar = stack.pop();
            if (c == ')' && topChar != '(') return false;
            if (c == '}' && topChar != '{') return false;
            if (c == ']' && topChar != '[') return false;
        }
        return stack.isEmpty();
    }
}
