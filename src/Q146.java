import java.util.HashMap;
import java.util.Map;

/**
 * 由于 get、put 都需要在 O(1) 内完成，因此需要使用 HashMap
 * 由于需要根据使用情况维护元素的顺序，因此需要使用 LinkedList
 * 两者一结合就变成了 LinkedHashMap 了
 */
public class Q146 {

    static class LRUCache {

        private final Map<Integer, Node> map = new HashMap<>(); // 快速搜索
        private final LinkedList list = new LinkedList(); // 维护顺序
        private final int capacity;

        public LRUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            if (map.containsKey(key)) {
                Node node = map.get(key);
                removeNodeToLast(node);
                return node.value;
            }
            return -1;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                Node node = map.get(key);
                removeNodeToLast(node);
                node.value = value;
            } else {
                Node node = new Node(key, value);
                addNodeToLast(key, node);
            }
        }

        private void addNodeToLast(int key, Node node) {
            map.put(key, node);
            list.addLast(node);
            if (list.size > capacity) {
                map.remove(list.removeFirst().key);
            }
        }

        private void removeNodeToLast(Node node) {
            list.remove(node);
            list.addLast(node);
        }

    }

    static class Node {
        Node prev;
        Node next;
        int key;
        int value;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    static class LinkedList {
        Node head;
        Node tail;
        int size;
        public LinkedList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
        }
        public void addLast(Node node) {
            node.prev = tail.prev;
            node.next = tail;
            tail.prev.next = node;
            tail.prev = node;
            size++;
        }
        public Node removeFirst() {
            if (size == 0) {
                return null;
            }
            Node node = head.next;
            remove(node);
            return node;
        }
        public void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.prev = null;
            node.next = null;
            size--;
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }
}
