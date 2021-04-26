import bean.TreeNode;

public class Q938 {

    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        return recursion(root, low, high);
    }

    private int recursion(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        sum += recursion(root.left, low, high);
        if (root.val >= low && root.val <= high) {
            sum += root.val;
        } else if (root.val > high) {
            return sum;
        }
        sum += recursion(root.right, low, high);
        return sum;
    }
}
