import java.util.Stack;

/**
 * 这题相对简单，栈存的逆序最后取出要注意
 */
public class Q71 {

    public String simplifyPath(String path) {
        String[] array = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String str : array) {
            if ("".equals(str) || ".".equals(str)) {
                continue;
            }
            if ("..".equals(str)) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
                continue;
            }
            stack.push(str);
        }
        if (stack.isEmpty()) {
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
            sb.insert(0, "/");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Q71().simplifyPath("/home//foo/"));
    }
}
