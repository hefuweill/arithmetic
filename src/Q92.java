import bean.ListNode;
import utils.Utils;

/**
 * 思路为先截取链表然后翻转，接着再拼起来
 */
public class Q92 {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode headNode = new ListNode();
        headNode.next = head;
        ListNode prev = headNode;
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }
        ListNode curr = headNode;
        for (int i = 0; i < right; i++) {
            curr = curr.next;
        }
        ListNode tail = curr.next;
        ListNode tempHead = prev.next;
        prev.next = null;
        curr.next = null;
        prev.next = reverse(tempHead);
        tempHead.next = tail;
        return headNode.next;
    }

    private ListNode reverse(ListNode root) {
        ListNode prev = null;
        ListNode curr = root;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode node = new Q92().reverseBetween(Utils.createLinkedList(new int[]{1, 2, 3, 4, 5}), 2, 4);
        System.out.println(node);
    }
}
