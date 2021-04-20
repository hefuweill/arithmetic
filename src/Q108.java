import bean.TreeNode;

/**
 * 给定有序数组，构建平衡二叉树
 * 二叉树定义为空树，或者对于任意节点其左子树的值都小于该节点值，右子树都大于该节点值
 * 至于平衡二叉树，需要保证对于任意节点其左子树和右子树的高度差不大于 1
 * 注：这里不考虑相同元素
 */
public class Q108 {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return recursion(nums, 0, nums.length - 1);
    }

    private TreeNode recursion(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int middle = (start + end) / 2;
        TreeNode node = new TreeNode(nums[middle]);
        node.left = recursion(nums, start, middle - 1);
        node.right = recursion(nums, middle + 1, end);
        return node;
    }
}
