import bean.TreeNode;

/**
 * 其实就是翻转二叉树
 */
public class JQ27 {

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode leftNode = root.left;
        TreeNode rightNode = root.right;
        root.left = rightNode;
        root.right = leftNode;
        mirrorTree(root.left);
        mirrorTree(root.right);
        return root;
    }
}
