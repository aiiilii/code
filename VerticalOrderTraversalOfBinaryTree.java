import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class VerticalOrderTraversalOfBinaryTree {
    
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode (int x) { val = x; }
    }

    public static class Point {
        int x;
        int y;
        int val;
        public Point(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }

    /**
     * Time - O(n log n)
     * Space - O(n)
     * @param root
     * @return
     */
    public List<List<Integer>> vertivalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) {
            return res;
        }

        PriorityQueue<Point> pq = new PriorityQueue<Point>(new Comparator<Point>() {
            @Override
            public int compare(Point p1, Point p2) {
                if (p1.x != p2.x) {
                    return p1.x - p2.x;
                } else if (p1.y != p2.y) {
                    return p2.y - p1.y;
                } else {
                    return p1.val - p2.val;
                }
            }
        });

        dfs(root, 0, 0, pq);
        int prevX = Integer.MIN_VALUE;

        while (!pq.isEmpty()) {
            Point p = pq.poll();
            if (p.x > prevX) {
                List<Integer> list = new ArrayList<Integer>();
                list.add(p.val);
                res.add(list);
            } else {
                List<Integer> list = res.get(res.size() - 1);
                list.add(p.val);
            }
            prevX = p.x;
        }
        return res;
    }

    private void dfs(TreeNode root, int x, int y, PriorityQueue<Point> pq) {
        if (root == null) {
            return;
        }
        pq.offer(new Point(x, y, root.val));
        dfs(root.left, x - 1, y - 1, pq);
        dfs(root.right, x + 1, y - 1, pq);
    }
}