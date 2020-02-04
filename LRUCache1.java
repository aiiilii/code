import java.util.Map;
import java.util.HashMap;

public class LRUCache1 {

    public class Node {
        int key;
        int val;
        Node next;
        Node prev;
        Node(int val) {
            this.val = val;
        }
    }
    
    public class DLList {
        Node head;
        Node tail;
        
        public DLList() {
            head = new Node(0);
            tail = new Node(0);
            head.next = tail;
            tail.prev = head;
        }
        
        public void add(Node node) {
            Node head_next = head.next;
            node.next = head_next;
            head_next.prev = node;
            head.next = node;
            node.prev = head;
        }
        
        public void remove(Node node) {
            Node next_node = node.next;
            Node prev_node = node.prev;
            prev_node.next = next_node;
            next_node.prev = prev_node;
        }
    }
    
    Map<Integer, Node> map;
    int capacity;
    DLList dList;

    public LRUCache1(int capacity) {
        map = new HashMap<Integer, Node>(capacity);
        this.capacity = capacity;
        dList = new DLList();
    }
    
    public int get(int key) {
        Node node = map.get(key);
        int res = -1;
        if (node != null) {
            res = node.val;
            dList.remove(node);
            dList.add(node);
        }
        return res;
    }
    
    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            node.val = value;
            dList.remove(node);
            dList.add(node);
            return;
        } else {
            if (capacity == map.size()) {
                map.remove(dList.tail.prev.key);
                dList.remove(dList.tail.prev);
            }
            Node newNode = new Node(value);
            newNode.key = key;
            map.put(key, newNode);
            dList.add(newNode);
        }
    }
}