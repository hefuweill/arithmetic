import bean.TreeNode;

import java.util.ArrayList;
import java.util.List;

// 中序遍历
public class Q92 {

    public List<Integer> inorderTraversal(TreeNode root) {
        return traversal(root, new ArrayList<>());
    }

    private List<Integer> traversal(TreeNode node, List<Integer> list) {
        if (node == null) {
            return list;
        }
        traversal(node.left, list);
        list.add(node.val);
        traversal(node.right, list);
        return list;
    }
}
