import bean.TreeNode;

/**
 * 最大深度，肯定是叶子节点，统计所有叶子节点，计算最大值就行
 * 树的问题，一定要有递归思路，对于每棵树最大深度不就是，左子树最大深度与右子树最大深度中的最大值 + 1 吗？
 * 那么以此写个递归不就解决了？写递归时考虑从 0 个节点到 1 个再到完整的节点。
 */
public class Q104 {

    public int maxDepth(TreeNode root) {
        return recursion(root);
    }

    private int recursion(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(recursion(node.left), recursion(node.right));
    }
}
