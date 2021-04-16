import bean.TreeNode;

/**
 * 树的问题，全部想成递归，判断两颗树是否相同，那从简单开始
 * 两个空节点相同，一个空一个不为空不相同，都不为空判断当前节点值以及左右子树是否相同
 */
public class Q100 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else {
            return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }
}
