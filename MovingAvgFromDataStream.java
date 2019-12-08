import java.util.LinkedList;
import java.util.Queue;

public class MovingAvgFromDataStream {

    Queue<Integer> q;
    int size;
    double sum = 0;

    public MovingAvgFromDataStream(int size) {
        q = new LinkedList<Integer>();
        this.size = size;
    }

    public double next(int val) {
        if (q.size() == size) {
            sum = sum - q.poll();
        }
        q.offer(val);
        sum += val;
        return sum / q.size();
    }
}