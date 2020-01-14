import java.util.Map;
import java.util.HashMap;

public class LRUCache {

    public class DListNode {
        int key;
        int val;
        DListNode prev;
        DListNode next;
    }

    final DListNode head = new DListNode(); // dummy head node
    final DListNode tail = new DListNode(); // dummy tail node
    Map<Integer, DListNode> node_map;
    int cache_capacity;

    public LRUCache(int capacity) {
        node_map = new HashMap<Integer, DListNode>(capacity);
        cache_capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        int result = -1;
        DListNode node = node_map.get(key);
        if (node != null) {
            result = node.val;
            remove(node);
            add(node);
        }
        return result;
    }
    
    public void put(int key, int value) {
        DListNode node = node_map.get(key);
        if (node != null) { // if the node exists, we override the value
            node.val = value;
            remove(node); // remove the node and put it in the front of the list;
            add(node);
        } else { // if the nodes does not exist, we have to make a new one
            if (node_map.size() == cache_capacity) {
                node_map.remove(tail.prev.key); // remove it from the hashmap;
                remove(tail.prev); // remove it from the list
            }

            DListNode new_node = new DListNode();
            new_node.key = key;
            new_node.val = value;

            node_map.put(key, new_node);
            add(new_node);
        }
    }

    // adding nodes in the front of the doubly linked list
    public void add(DListNode node) {
        DListNode head_next = head.next;
        head.next = node;
        node.prev = head;

        node.next = head_next;
        head_next.prev = node;
    }

    // removing nodes from the doubly linked list
    public void remove(DListNode node) {
        DListNode next_node = node.next;
        DListNode prev_node = node.prev;

        next_node.prev = prev_node;
        prev_node.next = next_node;
    }
    
}