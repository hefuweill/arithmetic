import bean.ListNode;
import utils.Utils;

/**
 * 排序列表，时间复杂度满足，空间不满足。时间不满足，空间满足。。
 * 1. 插入排序，时间复杂度 O(n^2)，空间复杂度 1，超出时间限制，看来必须 O(nlogn)
 * 2. 自顶向下归并排序，确定中点使用快慢指针，时间复杂度 O(nlogn)，空间复杂度 O(logn)
 * 3. 自底向上归并排序，首先每个子链表长度为 1，然后两两合并，接着子链表长度为 2，然后两两合并，依次类推
 * 时间复杂度 O(nlogn)，空间复杂度 O(1)
 */
public class Q148 {

    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode headNode = head;
        ListNode tailNode = head.next;
        headNode.next = null;
        while (tailNode != null) {
            ListNode nextTailNode = tailNode.next;
            tailNode.next = null;
            ListNode prevNode = null;
            ListNode currNode = headNode;
            boolean isInsert = false;
            while (currNode != null) {
                if (tailNode.val < currNode.val) {
                    tailNode.next = currNode;
                    if (prevNode == null) {
                        headNode = tailNode;
                    } else {
                        prevNode.next = tailNode;
                    }
                    isInsert = true;
                    break;
                } else {
                    prevNode = currNode;
                    currNode = currNode.next;
                }
            }
            if (!isInsert) {
                prevNode.next = tailNode;
            }
            tailNode = nextTailNode;
        }
        return headNode;
    }

    public ListNode sortList2(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode tailNode = head;
        while (tailNode.next != null) {
            tailNode = tailNode.next;
        }
        return recursion(head, tailNode);
    }

    public ListNode sortList3(ListNode head) {
//        int totalLength = 0;
//        ListNode dummyHead = new ListNode();
//        dummyHead.next = head;
//        ListNode currNode = head;
//        ListNode prevNode = dummyHead;
//        while (currNode != null) {
//            totalLength++;
//            currNode = currNode.next;
//        }
//        for (int length = 1; length <= totalLength; length <<= 1) {
//            currNode = head;
//            prevNode = dummyHead;
//            while (currNode != null) {
//                ListNode firstHeadNode = currNode;
//                for (int subLength = 1; subLength < length; subLength++) {
//                    currNode = currNode.next;
//                }
//                ListNode secondHeadNode = currNode.next;
//                currNode.next = null; // 解开前后两个链表之间的联系
//                currNode = secondHeadNode;
//                for (int subLength = 1; subLength < length; subLength++) {
//                    currNode = currNode.next;
//                }
//                prevNode = merge(firstHeadNode, secondHeadNode);
//            }
//        }
//        return dummyHead.next;
        return null;
    }

    private ListNode recursion(ListNode startNode, ListNode endNode) {
        if (startNode == endNode) {
            return startNode;
        }
        ListNode slowNode = startNode;
        ListNode fastNode = startNode.next;
        while (fastNode != null && fastNode.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }
        ListNode startEndNode = slowNode;
        ListNode endStartNode = slowNode.next;
        startEndNode.next = null;
        ListNode leftNode = recursion(startNode, startEndNode);
        ListNode rightNode = recursion(endStartNode, endNode);
        return merge(leftNode, rightNode);
    }

    private ListNode merge(ListNode l1Node, ListNode l2Node) {
        ListNode headNode = new ListNode();
        ListNode currNode = headNode;
        while (l1Node != null || l2Node != null) {
            if (l1Node == null) {
                currNode.next = l2Node;
                break;
            }
            if (l2Node == null) {
                currNode.next = l1Node;
                break;
            }
            if (l1Node.val < l2Node.val) {
                currNode.next = new ListNode(l1Node.val);
                currNode = currNode.next;
                l1Node = l1Node.next;
            } else {
                currNode.next = new ListNode(l2Node.val);
                currNode = currNode.next;
                l2Node = l2Node.next;
            }
        }
        return headNode.next;
    }

    public static void main(String[] args) {
        System.out.println(new Q148().sortList2(Utils.createLinkedList(new int[]{4,3,2,1})));
    }
}
