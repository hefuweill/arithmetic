import bean.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 1. 一次性全部合并，时间 341 毫秒  k * (k * n) = k^2n
 * 2. 一个个合并，时间 97 毫秒 (n + 2n + 3n + ... + kn) = (k + 1)n * k / 2 = (k^2n + kn) / 2
 * 3. 使用分治方式，类似归并排序，时间 2 毫秒 (2n * k / 2 + 4n * k / 4 + ...) = kn * logk，空间复杂度 logk
 * 4. 使用优先级队列，处理每个链表当前节点，时间 8 毫秒，优先级队列元素个数 k ，时间复杂度 logk 总元素
 * 个数 kn 个，因此最终时间复杂度为 kn * logk，空间复杂度 k
 */
public class Q23 {

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode headNode = new ListNode();
        ListNode currNode = headNode;
        while (true) {
            int minIndex = -1;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] == null) {
                    continue;
                }
                if (minIndex == -1) {
                    minIndex = i;
                } else {
                    if (lists[i].val < lists[minIndex].val) {
                        minIndex = i;
                    }
                }
            }
            if (minIndex == -1) {
                break;
            }
            currNode.next = new ListNode(lists[minIndex].val);
            currNode = currNode.next;
            lists[minIndex] = lists[minIndex].next;
        }
        return headNode.next;
    }

    public ListNode mergeKLists2(ListNode[] lists) {
        ListNode resultNode = null;
        for (ListNode node: lists) {
            resultNode = merge(resultNode, node);
        }
        return resultNode;
    }

    public ListNode mergeKLists3(ListNode[] lists) {
        return recursion(lists, 0, lists.length - 1);
    }

    public ListNode mergeKLists4(ListNode[] lists) {
        ListNode headNode = new ListNode();
        ListNode currNode = headNode;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for (ListNode node : lists) {
            if (node != null) {
                queue.add(node);
            }
        }
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            currNode.next = new ListNode(node.val);
            currNode = currNode.next;
            if (node.next != null) {
                queue.add(node.next);
            }
        }
        return headNode.next;
    }

    private ListNode recursion(ListNode[] listNodes, int start, int end) {
        if (start == end) {
            return listNodes[start];
        } else if (start > end) {
            return null;
        }
        int middle = (start + end) / 2;
        ListNode firstNode = recursion(listNodes, start, middle);
        ListNode secondNode = recursion(listNodes, middle + 1, end);
        return merge(firstNode, secondNode);
    }

    private ListNode merge(ListNode node1, ListNode node2) {
        ListNode headNode = new ListNode();
        ListNode currNode  = headNode;
        while (node1 != null || node2 != null) {
            if (node1 == null) {
                currNode.next = node2;
                break;
            }
            if (node2 == null) {
                currNode.next = node1;
                break;
            }
            if (node1.val <= node2.val) {
                currNode.next = new ListNode(node1.val);
                node1 = node1.next;
            } else {
                currNode.next = new ListNode(node2.val);
                node2 = node2.next;
            }
            currNode = currNode.next;
        }
        return headNode.next;
    }

    public static void main(String[] args) {
        System.out.println(new Q23().mergeKLists4(new ListNode[]{null}));
    }
}
