import bean.TreeNode;

import java.util.ArrayList;
import java.util.List;

// 中序遍历
public class Q94 {

    public List<Integer> inorderTraversal(TreeNode root) {
        return recursion(root, new ArrayList<>());
    }

    private List<Integer> recursion(TreeNode node, List<Integer> list) {
        if (node == null) {
            return list;
        }
        recursion(node.left, list);
        list.add(node.val);
        recursion(node.right, list);
        return list;
    }
}
