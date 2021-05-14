import bean.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 判断链表是否有环
 * 1. 使用 Set 判断是否有重复节点
 * 2. 快慢指针（如果两个指针相等，那么表示有环，如果快指针走到尾了，那么表示没有环）
 */
public class Q141 {

    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode currNode = head;
        while (currNode != null) {
            if (set.contains(currNode)) {
                return true;
            }
            set.add(currNode);
            currNode = currNode.next;
        }
        return false;
    }

    public boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            if (slow == fast) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
}
