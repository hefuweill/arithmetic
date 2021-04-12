package utils;

import bean.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Utils {

    /**
     * 根据给定数组构造完全二叉树
     * @param values 层次遍历值
     * @return 根节点
     */
    public static TreeNode createBinaryTree(int[] values) {
        if (values.length <= 0) {
            return null;
        }
        int index = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            node.val = values[index];
            if (2 * index + 1 <= values.length - 1) {
                TreeNode left = new TreeNode();
                node.left = left;
                queue.add(left);
            }
            if (2 * index + 2 <= values.length - 1) {
                TreeNode right = new TreeNode();
                node.right = right;
                queue.add(right);
            }
            index++;
        }
        return root;
    }

    public static void main(String[] args) {
        int[] values = {1, 2, 3, 4, 5, 6};
        TreeNode root = createBinaryTree(values);
        System.out.println(root);
    }
}
