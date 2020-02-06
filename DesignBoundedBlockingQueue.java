import java.util.List;
import java.util.LinkedList;
import java.util.concurrent.*;

public class DesignBoundedBlockingQueue {

    List<Integer> queue;
    Semaphore mutex;
    Semaphore empty;
    Semaphore full;

    public DesignBoundedBlockingQueue(int capacity) {
        queue = new LinkedList<Integer>();
        mutex = new Semaphore(1); // can aquire before release
        empty = new Semaphore(0); // need to release then acquire
        full = new Semaphore(capacity); // can acquire the capacity number of times then block
    }

    public void enqueue(int element) throws InterruptedException {
        full.acquire(); // -1 for acquire until capacity reaches 0

        mutex.acquire();
        queue.add(element);
        mutex.release();

        empty.release(); // need to release so can be dequeued
    }

    public int dequeue() throws InterruptedException {
        empty.acquire();

        mutex.acquire();
        int ans = queue.remove(0);
        mutex.release();

        full.release();
        return ans;
    }

    public int size() {
        return queue.size();
    }
}