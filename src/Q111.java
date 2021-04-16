import bean.TreeNode;

/**
 * 注意相比最大深度，这里多了个条件，必须是到叶子节点的深度，因此基本情况
 * 需要考虑好，比如空节点，叶子节点，只有左子树，只有又子树
 */
public class Q111 {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        if (root.left == null) {
            return 1 + minDepth(root.right);
        } else if (root.right == null) {
            return 1 + minDepth(root.left);
        } else {
            return 1 + Math.min(minDepth(root.left), minDepth(root.right));
        }
    }
}
