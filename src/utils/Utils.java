package utils;

import bean.ListNode;
import bean.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Utils {

    /**
     * 根据给定数组构造二叉树
     * @param values 层次遍历值，值为 null 表示空节点
     * @return 根节点
     */
    public static TreeNode createBinaryTree(Integer[] values) {
        if (values.length <= 0) {
            return null;
        }
        int index = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                node.val = values[index];
                if (2 * index + 1 <= values.length - 1) {
                    if (values[2 * index + 1] == null) {
                        queue.add(null);
                    } else {
                        TreeNode left = new TreeNode();
                        node.left = left;
                        queue.add(left);
                    }
                }
                if (2 * index + 2 <= values.length - 1) {
                    if (values[2 * index + 2] == null) {
                        queue.add(null);
                    } else {
                        TreeNode right = new TreeNode();
                        node.right = right;
                        queue.add(right);
                    }
                }
            }
            index++;
        }
        return root;
    }

    /**
     * 根据给定数组创建链表
     * @param values 链表每个节点值
     * @return 头节点
     */
    public static ListNode createLinkedList(int[] values) {
        if (values == null || values.length == 0) {
            return null;
        }
        ListNode head = new ListNode();
        ListNode curr = head;
        for (int value: values) {
            curr.next = new ListNode(value);
            curr = curr.next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        Integer[] values = {3, 9, 20, null, null, 15, 7};
        TreeNode root = createBinaryTree(values);
        System.out.println(root);
    }
}
