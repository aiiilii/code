import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class TaskScheduler {

    /**
     * Sortin approach - faster
     * Time - O(time)
     * Space - O(1)
     * @param tasks
     * @param n
     * @return
     */
    public int leastInterval(char[] tasks, int n) {
        int[] dict = new int[26];
        for (char c : tasks) {
            dict[c - 'A']++;
        }
        Arrays.sort(dict);

        int i = 25;
        while (i >= 0 && dict[i] == dict[25]) {
            i--;
        }
        return Math.max(tasks.length, (dict[25] - 1) * (n + 1) + 25 - i);
    }


    /**
     * Priority Queue approach
     * Time - O(n)
     * Space - O(1)
     * @param tasks
     * @param n
     * @return
     */
    public int leastInterval1(char[] tasks, int n) {
        int[] dict = new int[26];
        for (char c : tasks) {
            dict[c - 'A']++;
        }

        Queue<Integer> maxHeap = new PriorityQueue<>(26, Collections.reverseOrder());

        for (int f : dict) {
            if (f > 0) {
                maxHeap.offer(f);
            }
        }

        int time = 0;

        while (!maxHeap.isEmpty()) {
            int i =0;
            List<Integer> temp = new ArrayList<Integer>();

            while (i <= n) {
                if (!maxHeap.isEmpty()) {
                    if (maxHeap.peek() > 1) {
                        temp.add(maxHeap.poll() - 1);
                    } else {
                        maxHeap.poll();
                    }
                }
                time ++;
                if (maxHeap.isEmpty() && temp.size() == 0) {
                    break;
                }
                i ++;
            }
            for (int l : temp) {
                maxHeap.add(l);
            }
        }
        return time;
    }
}