import bean.TreeNode;

public class Q226 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode leftNode = root.left;
        TreeNode rightNode = root.right;
        root.left = rightNode;
        root.right = leftNode;
        invertTree(leftNode);
        invertTree(rightNode);
        return root;
    }
}
