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
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        int index = 0;
        TreeNode root = new TreeNode(values[0]);
        queue1.add(root);
        while (!queue1.isEmpty()) {
            while (!queue1.isEmpty()) {
                TreeNode node = queue1.poll();
                if (node != null) {
                    int leftIndex = 2 * index + 1;
                    int rightIndex = 2 * index + 2;
                    // check sub node exist
                    if (leftIndex < values.length) {
                        if (values[leftIndex] == null) {
                            // left sub node not exist
                            queue2.add(null);
                        } else {
                            // left sub node exist
                            TreeNode left = new TreeNode(values[leftIndex]);
                            node.left = left;
                            queue2.add(left);
                        }
                    }
                    if (rightIndex < values.length) {
                        if (values[rightIndex] == null) {
                            // right sub node not exist
                            queue2.add(null);
                        } else {
                            // right sub node exist
                            TreeNode right = new TreeNode(values[rightIndex]);
                            node.right = right;
                            queue2.add(right);
                        }
                    }
                }
                index++;
            }
            Queue<TreeNode> tempNode = queue1;
            queue1 = queue2;
            queue2 = tempNode;
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
