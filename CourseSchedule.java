import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule {

    /**
     * Time - O(n), process each node exactly once
     * Space - O(n), use queue to keep all nodes with 0 in-depree
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] matrix = new int[numCourses][numCourses]; // Create matrix to represent a directed graph;
        int[] indegree = new int[numCourses]; // Indegree represents how many arrows are pointing at them, meaning the "ready" course; if indegree is 0, no arrow points at them, they are the prerequisites;

        for (int i = 0; i < prerequisites.length; i++) {
            int ready = prerequisites[i][0]; // ready is the course that need to take;
            int pre = prerequisites[i][1]; // pre is the course that is the prerequisite;

            indegree[ready] ++; // increment how many arrows are pointing to "ready" and store it in indegree[ready];
            matrix[pre][ready] = 1; // fill out the directed graph;
        }

        int count = 0;
        Queue<Integer> queue = new LinkedList<Integer>();

        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) { // if they are a prerequisite, add to queue;
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int course = queue.poll();
            count ++;

            for (int i = 0; i < numCourses; i++) {
                if (matrix[course][i] != 0) { // run through all of matrix[course][], if does not equal to 0, means there is a connection in the directed graph,
                    if (--indegree[i] == 0) { // decrement indegree for that next course and if it equals 0, meaning they have become a new prerequisite, then put them into queue;
                        queue.offer(i);
                    }
                }
            }
        }
        return count == numCourses;
    }
}