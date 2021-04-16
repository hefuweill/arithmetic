import bean.TreeNode;

/**
 * 从前序和中序序列构造二叉树(无重复元素)，分析下什么特点
 * 1. 前序 根左右
 * 2. 中序 左根右
 * 那么是不是可以通过前序获取到根，然后使用根获取到对应的左子树序列，以及右子树序列
 * 然后再通过相同的方式获取到子树序列，最后完成二叉树的构建。
 */
public class Q105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        return recursion(
                preorder,
                inorder,
                0,
                preorder.length - 1,
                0,
                inorder.length - 1);
    }

    private TreeNode recursion(
            int[] preorder,
            int[] inorder,
            int preorderStartIndex,
            int preorderEndIndex,
            int inorderStartIndex,
            int inorderEndIndex
    ) {
        if (preorderStartIndex > preorderEndIndex || inorderStartIndex > inorderEndIndex) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[preorderStartIndex]);
        int inorderLeftEndIndex = 0;
        int inorderRightStartIndex = 0;
        for (int i = inorderStartIndex; i <= inorderEndIndex; i++) {
            if (inorder[i] == node.val) {
                inorderLeftEndIndex = i - 1;
                inorderRightStartIndex = i + 1;
                break;
            }
        }
        int leftTreeCount = inorderLeftEndIndex - inorderStartIndex + 1;
        int preorderLeftStartIndex = preorderStartIndex + 1;
        int preorderLeftEndIndex = preorderStartIndex + leftTreeCount;
        int preorderRightStartIndex = preorderLeftEndIndex + 1;
        node.left = recursion(
                preorder,
                inorder,
                preorderLeftStartIndex,
                preorderLeftEndIndex,
                inorderStartIndex,
                inorderLeftEndIndex
        );
        node.right = recursion(
                preorder,
                inorder,
                preorderRightStartIndex,
                preorderEndIndex,
                inorderRightStartIndex,
                inorderEndIndex
        );
        return node;
    }

    public static void main(String[] args) {
        TreeNode node = new Q105().buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});
        System.out.println(node);
    }
}
