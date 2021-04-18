import bean.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 记住，从根节点开始到每个节点都是单一路径
 * 所以递归告诉我前面的路径就行，等到叶子节点到放进去就行。
 */
public class Q257 {

    public List<String> binaryTreePaths(TreeNode root) {
        return recursion(new ArrayList<>(), new StringBuilder(), root);
    }

    private List<String> recursion(List<String> list, StringBuilder builder, TreeNode node) {
        if (node == null) {
            return list;
        }
        builder.append(node.val);
        if (node.left == null && node.right == null) {
            // 叶子节点
            list.add(builder.toString());
        } else {
            // 非叶子节点
            builder.append("->");
            if (node.left != null) {
                recursion(list, new StringBuilder(builder), node.left);
            }
            if (node.right != null) {
                recursion(list, new StringBuilder(builder), node.right);
            }
        }
        return list;
    }
}
