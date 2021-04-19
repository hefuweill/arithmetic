import bean.TreeNode;
import utils.Utils;

/**
 * 判断 B 是否是 A 的子结构，对 A 进行先序遍历，判断当前节点是否相同，相同就判断子树
 * 这道题稍稍难想，改了好多次，以后再来做一做
 */
public class JQ26 {
    public boolean isSubStructure(TreeNode node1, TreeNode node2) {
        if (node1 == null || node2 == null) {
            return false;
        }
        return recursion(node1, node2) || isSubStructure(node1.left, node2) || isSubStructure(node1.right, node2);
    }

    private boolean recursion(TreeNode node1, TreeNode node2) {
        if (node2 == null) {
            return true;
        }
        if (node1 == null) {
            return false;
        }
        if (node1.val != node2.val) {
            return false;
        } else {
            return recursion(node1.left, node2.left) && recursion(node1.right, node2.right);
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = Utils.createBinaryTree(new Integer[]{4,2,3,4,5,6,7,8,9});
        TreeNode node2 = Utils.createBinaryTree(new Integer[]{4,8,9});
        System.out.println(new JQ26().isSubStructure(node1, node2));
    }
}
