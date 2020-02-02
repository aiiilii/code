public class DesignHashMap {

    public class ListNode {
        int key;
        int val;
        ListNode next;
        ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    final ListNode[] nodes; // using array of list nodes to create adjacency list;

    public DesignHashMap() {
        nodes = new ListNode[2069]; // 2069 large prime number to avoid collision; if lots of collisions, then time is O(n);
    }

    /** value will always be non-negative */
    public void put(int key, int value) {
        int idx = getIndex(key);
        ListNode head = nodes[idx];
        ListNode node = head;

        while (node != null) {
            if (node.key == key) {
                node.val = value; // update the node.val = value if found key
                return;
            }
            node = node.next; // keep traversing until found the node.key == key;
        }
        ListNode newNode = new ListNode(key, value); // if node == null, then need to create new ListNode
        newNode.next = head; // add newNode to the front of the list;
        nodes[idx] = newNode; // making this newNode the new nodes[idx], which is the front of the list;
    }

    /** Returns the valuee to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int idx = getIndex(key);
        ListNode node = nodes[idx];

        while (node != null) {
            if (node.key == key) {
                return node.val;
            }
            node = node.next; // keep traversing until find node, then return the node.val;
        }
        return -1; // if not found after traversal;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int idx = getIndex(key);
        ListNode node = nodes[idx];
        ListNode prev = null;

        while (node != null) {
            if (node.key == key) {
                if (prev != null) { // if found node is not the first node,
                    prev.next = node.next; // skip the node by connecting prev to next;
                } else { // if prev == null, meaning this found node is the first node,
                    nodes[idx] = node.next; // then move nodes[idx] to node.next;
                }
                return;
            }
            prev = node;
            node = node.next;
        }
    }

    /**
     * Simplified hashing function - Modulo
     * @param key
     * @return
     */
    public int getIndex(int key) {
        return key % 2069;
        // return Integer.hashCode(key) % nodes.length;
    }
}