import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NestedInteger implements Iterator<Integer> {

    /**
     * // This is the interface that allows for creating nested lists.
     * // You should not implement it, or speculate about its implementation
     * public interface NestedInteger {
     *
     *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
     *     public boolean isInteger();
     *
     *     // @return the single integer that this NestedInteger holds, if it holds a single integer
     *     // Return null if this NestedInteger holds a nested list
     *     public Integer getInteger();
     *
     *     // @return the nested list that this NestedInteger holds, if it holds a nested list
     *     // Return null if this NestedInteger holds a single integer
     *     public List<NestedInteger> getList();
     * }
     */

     private Queue<Integer> queue;

     public NestedInteger(List<NestedInteger> nestedList) {
         queue = new LinkedList<Integer>();

         this.helper(nestedList);
     }

     private void helper(List<NestedInteger> list) {
         if (list == null) {
             return;
         }

        // Uncomment the following to work:
        //  for (NestedInteger in : list) {
        //      if (in.isInteger()) {
        //          queue.offer(in.getInteger());
        //      } else {
        //          helper(in.getList());
        //      }
        //  }
     }

     @Override
     public Integer next() {
         if (hasNext()) {
             return queue.poll();
         } else {
             return -1;
         }
     }

     @Override
     public boolean hasNext() {
         if (!queue.isEmpty()) {
             return true;
         } else {
             return false;
         }
     }
}