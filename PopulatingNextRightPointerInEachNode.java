public class PopulatingNextRightPointerInEachNode {

    public class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int val, Node left, Node right, Node next) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.next = next;
        }
    }

    /**
     * Time - O(n)
     * Space - O(1)
     * @param root
     * @return
     */
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }

        // Start with the root node. 
        // There are no next pointers that need to be set up on the first level.
        Node leftmost = root;

        // Once we reach the final node, we are done.
        while (leftmost.left != null) {

            // Iterate the "linked list" staring from the head node
            // and using the next pointers, establish the corresponding links for the next level.
            Node head = leftmost;

            while (head != null) {
               
                head.left.next = head.right;  // CONNECTION 1

                if (head.next != null) {
                    head.right.next = head.next.left; // CONNECTION 2
                }
                head = head.next; // Progress along the list (nodes on the current level)
            }
            
            leftmost = leftmost.left; // Move to the next level.
        }
        return root;
    }
}