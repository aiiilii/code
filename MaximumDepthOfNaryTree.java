import java.util.List;

public class MaximumDepthOfNaryTree {

    public class Node {
        public int val;
        public List<Node> children;

        public Node() {

        }

        public Node(int val) {
            this.val = val;
        }


        public Node(int val, List<Node> children) {
            this.val = val;
            this.children = children;
        }
    }

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int cur = 0;
        for (Node node : root.children) {
            cur = Math.max(cur, maxDepth(node));
        }
        return cur + 1;
    }
}