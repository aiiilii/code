import java.util.HashMap;
import java.util.Map;

public class LFUCache {

    public class Node {
        int key;
        int val;
        int count;
        Node prev;
        Node next;
        Node(int k, int v) {
            key = k;
            val = v;
            count = 1;
        }
    }
    
    public class DDList {
        Node head;
        Node tail;
        int len;
        DDList(){
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            len = 0;
        }

        public void addHead(Node node) {
            Node head_next = head.next;
            head.next = node;
            node.prev = head;
            node.next = head_next;
            head_next.prev = node;

            mp.put(node.key, node);
            len ++;
        }

        public void remove(Node node) {
            Node next_node = node.next;
            Node prev_node = node.prev;

            next_node.prev = prev_node;
            prev_node.next = next_node;

            mp.remove(node.key);
            len --;
        }

        public void removeTail() {
            Node prevTail = tail.prev;
            remove(prevTail);
        }
    }

    Map<Integer, Node> mp;
    Map<Integer, DDList> freq;
    int size;
    int capacity;
    int maxFreq;

    public LFUCache(int capacity) {
        mp = new HashMap<>();
        freq = new HashMap<>();
        this.capacity = capacity;
        size = 0;
        maxFreq = 0;
    }

    public int get(int key) {
        if (mp.get(key) == null) {
            return -1;
        }
        Node node = mp.get(key);
        int prevFreq = node.count;
        DDList prevList = freq.get(prevFreq);
        prevList.remove(node);

        int currFreq = prevFreq + 1;
        maxFreq = Math.max(maxFreq, currFreq);
        DDList currList = freq.getOrDefault(currFreq, new DDList());
        node.count ++;
        currList.addHead(node);

        freq.put(prevFreq, prevList);
        freq.put(currFreq, currList);
        return node.val;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        if (mp.get(key) != null) {
            mp.get(key).val = value;
            get(key);
            return;
        }

        Node node = new Node(key, value);
        DDList currList = freq.getOrDefault(1, new DDList());

        currList.addHead(node);
        size++;

        if (size > capacity) {
            if (currList.len > 1) {
                currList.removeTail();
            } else {
                for (int i = 2; i <= maxFreq; i++) {
                    if (freq.get(i) != null && freq.get(i).len > 0) {
                        freq.get(i).removeTail();
                        break;
                    }
                }
            }
            size --;
        }
        freq.put(1, currList);
    }

}