import bean.ListNode;
import utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 回文链表
 * 1. 借助 ArrayList 存放元素，然后使用双指针判断是否回文。
 * 2. 借助递归特性，逆序遍历链表，同时全局维护一个指针用于正序遍历链表。这个会多遍历一半，并且也使用虚拟机栈
 * 3. 借助快慢指针，慢指针每次走一步，快指针每次走两步，找到中间点（如果是奇数个中间节点算作左边），然后翻转
 * 右边的链表，完毕后比对右边链表与左边链表，当右边链表比对完毕后完成。恢复链表？
 */
public class Q234 {

    private ListNode frontNode;

    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode currNode = head;
        while (currNode != null) {
            list.add(currNode.val);
            currNode = currNode.next;
        }
        int leftIndex = 0;
        int rightIndex = list.size() - 1;
        while (leftIndex < rightIndex) {
            if (!list.get(leftIndex).equals(list.get(rightIndex))) {
                return false;
            }
            leftIndex++;
            rightIndex--;
        }
        return true;
    }

    public boolean isPalindrome2(ListNode head) {
        frontNode = head;
        return recursion(head);
    }

    private boolean recursion(ListNode node) {
        if (node != null) {
            if (!recursion(node.next)) {
                return false;
            }
            if (frontNode.val == node.val) {
                frontNode = frontNode.next;
                return true;
            }
            return false;
        }
        return true;
    }

    public boolean isPalindrome3(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode rightNode = reverse(slow.next);
        ListNode leftNode = head;
        while (rightNode != null) {
            if (rightNode.val != leftNode.val) {
                return false;
            }
            rightNode = rightNode.next;
            leftNode = leftNode.next;
        }
        return true;
    }

    private ListNode reverse(ListNode node) {
        ListNode preNode = null;
        ListNode currNode = node;
        while (currNode != null) {
            ListNode nextNode = currNode.next;
            currNode.next = preNode;
            preNode = currNode;
            currNode = nextNode;
        }
        return preNode;
    }

    public static void main(String[] args) {
        System.out.println(new Q234().isPalindrome3(Utils.createLinkedList(new int[]{8,0,7,1,7,7,9,7,5,2,9,1,7,3,7,0,6,5,1,7,7,9,3,8,1,5,7,7,8,4,0,9,3,7,3,4,5,7,4,8,8,5,8,9,8,5,8,8,4,7,5,4,3,7,3,9,0,4,8,7,7,5,1,8,3,9,7,7,1,5,6,0,7,3,7,1,9,2,5,7,9,7,7,1,7,0,8})));
    }
}
