public class ConvertSortedListToBinarySearchTree {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private ListNode head;
    /**
     * Simulated Inorder Traversal
     * Time - O(n), process each of the nodes in the linkedlist once
     * Space - O(log n), extra space is used by recursion stack and since we are building a height balanced BST, the height is bounded by logN
     * @param head
     * @return
     */
    public TreeNode sortedListToBST(ListNode head) {
        // get the length of the linkedList
        int size = findSize(head);

        this.head = head;

        // form the BST now that we know the size
        return convertListToBST(0, size - 1);
    }

    private int findSize(ListNode head) {
        ListNode temp = head;
        int length = 0;
        while (temp != null) {
            temp = temp.next;
            length ++;
        }
        return length;
    }

    public TreeNode convertListToBST(int l, int r) {
        // invalid case
        if (l > r) {
            return null;
        }

        int mid = l + (r - l) / 2;

        // First step of simulated inorder traversal,
        // recursively form the left half;
        TreeNode left = convertListToBST(l, mid - 1);

        // Once left half is traversed, process the current node;
        TreeNode node = new TreeNode(this.head.val);
        node.left = left;

        // maintain the invariance
        this.head = this.head.next;

        // recurse on the right hand side and form BST out of them
        node.right = convertListToBST(mid + 1, r);
        
        return node;
    }
}