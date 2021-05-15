import bean.ListNode;

import java.util.HashSet;

/**
 * 相交链表，这题得注意相交的链表节点的引用是相等的，而不是其值
 * 1. 暴力法
 * 2. Hash 法
 * 3. 双指针法
 */
public class Q160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode currANode = headA;
        while (currANode != null) {
            ListNode currBNode = headB;
            while (currBNode != null) {
                if (currBNode == currANode) {
                    return currANode;
                }
                currBNode = currBNode.next;
            }
            currANode = currANode.next;
        }
        return null;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode currNode = headA;
        while (currNode != null) {
            set.add(currNode);
            currNode = currNode.next;
        }
        currNode = headB;
        while (currNode != null) {
            if (set.contains(currNode)) {
                return currNode;
            }
            currNode = currNode.next;
        }
        return null;
    }

    public ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode currANode = headA;
        ListNode currBNode = headB;
        while (true) {
            if (currANode == currBNode) {
                return currANode;
            }
            if (currANode.next == null && currBNode.next == null) {
                return null;
            }
            currANode = currANode.next == null ? headB : currANode.next;
            currBNode = currBNode.next == null ? headA : currBNode.next;
        }
    }
}
