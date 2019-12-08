import java.util.List;

public class MaximumDepthOfNaryTree {

    public class Node {
        public int val;
        public List<Node> children;

        public Node() {

        }

        public Node(int _val) {
            val = _val;
        }


        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
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