public class IntersectionOfTwoLinkedLists {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * Two pointers approach
     * Because the lengths of the linked lists are difference, so we cannot just set the pointers to the front of each list and traverse.
     * We traverse each list to the end, then we point the end of the list to each other's head, then traverse again. 
     * Both pointers would traverse through both lists and come out of the while loop when they reach the same node
     * Then in the second loop around, if they intersect, the pointers would be pointing to the same node.
     * If no intersection, in the second loop around, they will both hit null and get out of the while loop returning null for pointerA meaning no intersection.
     * @param headA
     * @param headB
     * @return the intersecting node
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pointerA = headA;
        ListNode pointerB = headB;
        while (pointerA != pointerB) {
            if (pointerA == null) {
                pointerA = headB;
            } else {
                pointerA = pointerA.next;
            }
            if (pointerB == null) {
                pointerB = headA;
            } else {
                pointerB = pointerB.next;
            }
        }
        return pointerA;
    }
}