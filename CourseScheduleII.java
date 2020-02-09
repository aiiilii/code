import java.util.Map;
import java.util.Queue;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

public class CourseScheduleII {

    /**
     * Time - O(n), process each node exactly once
     * Space - O(n), use queue to keep all nodes with 0 in-depree
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjList = new HashMap<Integer, List<Integer>>(); // Use map to represent directed graph instead of matrix to save space; map stores the integer and it's neighbors;
        int[] indegree = new int[numCourses]; // Indegree represents how many arrows are pointing at them, meaning the "ready" course; if indegree is 0, no arrow points at them, they are the prerequisites; 
        int[] topologicalOrder = new int[numCourses]; // this is actually the results[];

        for (int i = 0; i < prerequisites.length; i++) {
            int ready = prerequisites[i][0];
            int pre = prerequisites[i][1]; // the prerequisite course;
            List<Integer> first = adjList.getOrDefault(pre, new ArrayList<Integer>());
            first.add(ready);
            adjList.put(pre, first); // put into pre -> first(ready) into map;

            indegree[ready] += 1; // increment how many arrows are pointing to "ready" and store it in indegree[ready];
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) { // indegree[i] == 0 means they are a prerequisite,
                queue.offer(i); // if they are a prerequisite, add to queue;
            }
        }

        int i = 0;
        while (!queue.isEmpty()) {
            int n = queue.poll();
            topologicalOrder[i] = n; // add the poll()ed order into results[]
            i ++;

            if (adjList.containsKey(n)) {
                for (Integer neighbor : adjList.get(n)) { // iterate through all the neighbors of n, which is the poll()ed Integer,

                    if (--indegree[neighbor] == 0) { // decrement indegree for that next course and if it equals 0, meaning they have become a new prerequisite, then put them into queue;
                        queue.offer(neighbor);
                    }
                }
            }
        }

        if (i == numCourses) {
            return topologicalOrder;
        }
        return new int[0];
    }
}