import bean.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Q145 {

    public List<Integer> postorderTraversal(TreeNode root) {
        return recursion(root, new ArrayList<>());
    }

    private List<Integer> recursion(TreeNode node, List<Integer> list) {
        if (node == null) {
            return list;
        }
        recursion(node.left, list);
        recursion(node.right, list);
        list.add(node.val);
        return list;
    }
}
