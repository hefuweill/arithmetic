import bean.TreeNode;
import utils.Utils;

public class RQ100 {

    /**、
     * 其实是 DFS 的思路
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        TreeNode p1 = Utils.createBinaryTree(new Integer[]{10, 5, 15});
        TreeNode p2 = Utils.createBinaryTree(new Integer[]{10, 5, null, null, 15});
        System.out.println(new RQ100().isSameTree(p1, p2));
    }
}
