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

    final ListNode[] nodes;

    public DesignHashMap() {
        nodes = new ListNode[10001];
    }

    /** value will always be non-negative */
    public void put(int key, int value) {
        int idx = getIndex(key);
        ListNode head = nodes[idx];
        ListNode node = head;

        while (node != null) {
            if (node.key == key) {
                node.val = value;
                return;
            }
            node = node.next;
        }
        ListNode newNode = new ListNode(key, value);
        newNode.next = head;
        nodes[idx] = newNode;
    }

    /** Returns the valuee to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int idx = getIndex(key);
        ListNode node = nodes[idx];

        while (node != null) {
            if (node.key == key) {
                return node.val;
            }
            node = node.next;
        }
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int idx = getIndex(key);
        ListNode node = nodes[idx];

        while (node != null) {
            if (node.key == key) {
                node.val = -1;
                return;
            }
            node = node.next;
        }
    }

    public int getIndex(int key) {
        return key % 10001;
        // return Integer.hashCode(key) % nodes.length;
    }
}