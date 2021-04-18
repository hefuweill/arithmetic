import bean.TreeNode;
import utils.Utils;

public class Q112 {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        return recursion(root, 0, targetSum);
    }

    private boolean recursion(TreeNode node, int sum, int targetSum) {
        if (node == null) {
            return false;
        }
        int result = sum + node.val;
        if (node.left == null && node.right == null) {
            return result == targetSum;
        }
        return recursion(node.left, result, targetSum) ||
                recursion(node.right, result, targetSum);
    }

    public static void main(String[] args) {
        TreeNode node = Utils.createBinaryTree(new Integer[]{5,4,8,11,null,13,4,7,2,null,null,null,1});
        System.out.println(new Q112().hasPathSum(node, 22));
    }
}
