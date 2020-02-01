import java.util.Queue;
import java.util.LinkedList;

public class FriendCircles {

    /**
     * DFS
     * Time - O(n ^ 2)
     * Space - O(n)
     * @param M
     * @return
     */
    public int findCircleNum(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;

        for (int i =0; i < M.length; i++) {
            if (visited[i] == 0) {
                dfs(M, visited, i);
                count ++;
            }
        }
        return count;
    }

    public void dfs(int[][] M, int[] visited, int i) {
        for (int j = 0; j < M[0].length; j++) {
            if (M[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(M, visited, j);
            }
        }
    }



    /**
     * BFS - a bit slower
     * Time - O(n ^ 2)
     * Space - O(n)
     * @param M
     * @return
     */
    public int findCircleNum1(int[][] M) {
        int[] visted = new int[M.length];
        int count = 0;

        Queue<Integer> q = new LinkedList<Integer>();

        for (int i = 0; i < M.length; i++) {
            if (visted[i] == 0) {
                q.offer(i);
                while (!q.isEmpty()) {
                    int s = q.poll();
                    visted[s] = 1;
                    for (int j = 0; j < M[0].length; j++) {
                        if (M[s][j] == 1 && visted[j] == 0) {
                            q.offer(j);
                        }
                    }
                }
                count ++;
            }
        }
        return count;
    }
}