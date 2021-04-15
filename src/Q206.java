import bean.ListNode;

public class Q206 {

    public ListNode reverseList(ListNode head) {
        return iteration(head);
    }

    private ListNode recursion(ListNode prev, ListNode curr) {
        if (curr == null) {
            return prev;
        }
        ListNode next = curr.next;
        curr.next = prev;
        return recursion(curr, next);
    }

    private ListNode iteration(ListNode root) {
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
}
