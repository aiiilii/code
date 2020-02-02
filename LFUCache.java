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
            count = 1; // this is the stored frequency count;
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

    Map<Integer, Node> mp; // stores the key integer, and the node as value;
    Map<Integer, DDList> freq; // stores the frequency integer, and the DLList of nodes that have that same frequency;
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
        int prevFreq = node.count; // get the frequency of the found node;
        DDList prevList = freq.get(prevFreq); // get the DLList based on the prev frequency;
        prevList.remove(node); // remove the node from the prev frequency list;

        int currFreq = prevFreq + 1; // frequency increments;
        maxFreq = Math.max(maxFreq, currFreq); // compare the current freq to the maxFreq and store it as maxFreq;
        DDList currList = freq.getOrDefault(currFreq, new DDList()); // get the curr frequency DLList, if not found, then create default empty new DLList();
        node.count ++; // increment the stored node frequency count;
        currList.addHead(node); // add the found node to the curr frequency DLList;

        freq.put(prevFreq, prevList); // update the prevFreq DLList;
        freq.put(currFreq, currList); // update the currFreq DLList;
        return node.val;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        if (mp.get(key) != null) { // if that key already exist in the nodes map,
            mp.get(key).val = value; // then only need to update the value;
            get(key); // use get(key) to update the frequency lists
            return;
        }

        Node node = new Node(key, value); // if key does not exist, then need to create new node;
        DDList currList = freq.getOrDefault(1, new DDList()); // this new node has just been visited once, thus find the DLList that have frequency of 1, if does not exist, then create empty new DLList;

        currList.addHead(node);
        size++;

        if (size > capacity) { // then we need to delete a node
            if (currList.len > 1) { // only delete from the frequency of 1 DLList if the currList.len > 1, because we don't want to delete the node that we just added in;
                currList.removeTail();
            } else { // if currList.len == 1
                for (int i = 2; i <= maxFreq; i++) { // need to find the next lowest frequency count that is bigger than 1
                    if (freq.get(i) != null && freq.get(i).len > 0) { // if found and not null and length of found DLList is > 0,
                        freq.get(i).removeTail(); // then remove tail from that list;
                        break;
                    }
                }
            }
            size --; // decrement size after deleting a node;
        }
        freq.put(1, currList); // update frequency of 1 DLList in the map;
    }

}