import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Comparator;

public class FindMedianFromDataStream {

    // MinHeap stores the larger half of the input array;
    // All the numbers in the min-heap are larger or equal to the top element of the min-heap
    private Queue<Integer> minHeap = new PriorityQueue<Integer>(); 

    // MaxHeap store the smaller half of the input array;
    // All the numbers in the max-heap are smaller or equal to the top element of the max-heap
    private Queue<Integer> maxHeap = new PriorityQueue<Integer>(1, new Comparator<Integer>() { 
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });

    /**
     * Time - O(5 * log n) + O(1) = o(log n), at worst, there are three heap insertions and two heap deletions, each log n time;
     * Space - O(n), linear space to hold inpur in containers;
     */
    public FindMedianFromDataStream() {

    }

    public void addNum(int num) {
        minHeap.offer(num);
        maxHeap.offer(minHeap.poll());

        if (minHeap.size() < maxHeap.size()) { 
            minHeap.offer(maxHeap.poll());
        }
    }

    public double findMedian() {
        if (minHeap.size() > maxHeap.size()) { // size of minHeap is equal or at most 1 bigger than maxHeap;
            return (double) minHeap.peek();
        } else {
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        }
    }
}