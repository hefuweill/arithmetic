import bean.TreeNode;
import utils.Utils;

public class JQ28 {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return check(root.left, root.right);
    }

    private boolean check(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null && rightNode == null) {
            return true;
        } else if (leftNode == null || rightNode == null) {
            return false;
        } else {
            if (leftNode.val == rightNode.val) {
                return check(leftNode.left, rightNode.right) && check(leftNode.right, rightNode.left);
            } else {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode node = Utils.createBinaryTree(new Integer[]{1,2,2,3,4,4,3});
        System.out.println(new JQ28().isSymmetric(node));
    }
}
