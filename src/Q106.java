import bean.TreeNode;

/**
 * 中序以及后序遍历有什么特点？
 * 1. 中序 左根右
 * 2. 后序 左右根
 * 其实和前序和中序一样，都是先确定根的位置
 */
public class Q106 {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return recursion(
                inorder,
                postorder,
                0, inorder.length - 1,
                0, postorder.length - 1);
    }

    private TreeNode recursion(
            int[] inorder,
            int[] postorder,
            int inorderStartIndex,
            int inorderEndIndex,
            int postorderStartIndex,
            int postorderEndIndex
    ) {
        if (inorderStartIndex > inorderEndIndex || postorderStartIndex > postorderEndIndex) {
            return null;
        }
        TreeNode node = new TreeNode(postorder[postorderEndIndex]);
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
        int postorderLeftEndIndex = postorderStartIndex + leftTreeCount - 1;
        int postorderRightStartIndex = postorderLeftEndIndex + 1;
        int postorderRightEndIndex = postorderEndIndex - 1;
        node.left = recursion(
                inorder,
                postorder,
                inorderStartIndex,
                inorderLeftEndIndex,
                postorderStartIndex,
                postorderLeftEndIndex
        );
        node.right = recursion(
                inorder,
                postorder,
                inorderRightStartIndex,
                inorderEndIndex,
                postorderRightStartIndex,
                postorderRightEndIndex
        );
        return node;
    }

    public static void main(String[] args) {
        TreeNode node = new Q106().buildTree(
                new int[]{9,3,15,20,7},
                new int[]{9,15,7,20,3}
        );
        System.out.println(node);
    }
}
