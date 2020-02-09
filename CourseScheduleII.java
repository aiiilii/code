import java.util.Map;
import java.util.Queue;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

public class CourseScheduleII {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        boolean isPossible = true;
        Map<Integer, List<Integer>> adjList = new HashMap<Integer, List<Integer>>();
        int[] indegree = new int[numCourses];
        int[] topologicalOrder = new int[numCourses];

        for (int i = 0; i < prerequisites.length; i++) {
            int ready = prerequisites[i][0];
            int pre = prerequisites[i][1];
            List<Integer> first = adjList.getOrDefault(pre, new ArrayList<Integer>());
            first.add(ready);
            adjList.put(pre, first);

            indegree[ready] += 1;
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int i = 0;
        while (!queue.isEmpty()) {
            int n = queue.poll();
            topologicalOrder[i] = n;
            i ++;

            if (adjList.containsKey(n)) {
                for (Integer neighbor : adjList.get(n)) {
                    indegree[neighbor] --;

                    if (indegree[neighbor] == 0) {
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