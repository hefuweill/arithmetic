import bean.TreeNode;
import utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class Q114 {

    public void flatten(TreeNode root) {
        List<TreeNode> list = recursion(root, new ArrayList<>());
        TreeNode parentNode = null;
        for (TreeNode node : list) {
            if (parentNode != null) {
                parentNode.right = node;
            }
            parentNode = node;
            parentNode.left = null;
        }
    }

    private List<TreeNode> recursion(TreeNode node, List<TreeNode> list) {
        if (node == null) {
            return list;
        }
        list.add(node);
        recursion(node.left, list);
        recursion(node.right, list);
        return list;
    }

    public static void main(String[] args) {
        TreeNode node = Utils.createBinaryTree(new Integer[]{1, 2, 5, 3, 4, null, 6});
        new Q114().flatten(node);
        System.out.println(node);
    }
}
