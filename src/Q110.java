import bean.TreeNode;

/**
 * 平衡二叉树定义为
 * 对于任意节点其左子树与右子树的高度差绝对值小于等于 1
 * 判断当前节点是否满足该定义，如果满足分别判断左右子树
 * 二叉树递归，分为自顶向下以及自底向上两种
 */
public class Q110 {

    public boolean isBalanced(TreeNode root) {
        return isBalancedWay1(root);
    }

    public boolean isBalancedWay1(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(heightWay1(root.left) - heightWay1(root.right)) <= 1
                && isBalancedWay1(root.left) && isBalancedWay1(root.right);
    }

    private int heightWay1(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(heightWay1(node.left), heightWay1(node.right));
    }

    public boolean isBalancedWay2(TreeNode root) {
        if (root == null) {
            return true;
        }
        return heightWay2(root) >= 0;
    }

    private int heightWay2(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = heightWay2(node.left);
        int rightHeight = heightWay2(node.right);
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return Math.max(leftHeight, rightHeight);
    }
}
