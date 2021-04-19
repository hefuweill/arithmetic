import bean.ListNode;

public class Q21 {

    public ListNode mergeTwoLists(ListNode node1, ListNode node2) {
        if (node1 == null && node2 == null) {
            return null;
        }
        ListNode resultNode = new ListNode();
        ListNode currNode = resultNode;
        while (node1 != null || node2 != null) {
            if (node1 == null) {
                currNode.next = node2;
                node2 = node2.next;
            } else if (node2 == null)  {
                currNode.next = node1;
                node1 = node1.next;
            } else {
                if (node1.val <= node2.val) {
                    currNode.next = node1;
                    node1 = node1.next;
                } else {
                    currNode.next = node2;
                    node2 = node2.next;
                }
            }
            currNode = currNode.next;
        }
        return resultNode.next;
    }
}
