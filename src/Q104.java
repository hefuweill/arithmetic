import bean.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Q104 {

    public List<Integer> preorderTraversal(TreeNode root) {
        return recursion(root, new ArrayList<>());
    }

    private List<Integer> recursion(TreeNode node, List<Integer> list) {
        if (node == null) {
            return list;
        }
        list.add(node.val);
        recursion(node.left, list);
        recursion(node.right, list);
        return list;
    }
}
