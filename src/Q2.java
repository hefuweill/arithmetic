import bean.ListNode;

/**
 * 本题主要注意下进位、某个链表多余节点、两个链表处理完后检查进位
 */
public class Q2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean needCarry = false;
        ListNode headNode = new ListNode();
        ListNode currNode = headNode;
        while (l1 != null || l2 != null) {
            int left = 0;
            int right = 0;
            if (l1 != null) {
                left = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                right = l2.val;
                l2 = l2.next;
            }
            int result = left + right + (needCarry ? 1 : 0);
            if (result >= 10) {
                result = result - 10;
                needCarry = true;
            } else {
                needCarry = false;
            }
            currNode.next = new ListNode(result);
            currNode = currNode.next;
        }
        if (needCarry) {
            currNode.next = new ListNode(1);
        }
        return headNode.next;
    }
}
