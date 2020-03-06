import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x;}
    }

    /**
     * Time - O(n), visit each node once;
     * Space - O(n), call stack, unbalanced tree would be O(n), balanced tree would be O(log n);
     * @param root
     * @return
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root == null) {
            return paths;
        }
        dfs(root, "", paths);
        return paths;
    }

    private void dfs(TreeNode root, String path, List<String> paths) {
        path += root.val; // in a single path, += val; recursively keep adding += the val to the path string when have not reached the leaf yet
        if (root.left == null && root.right == null) {
            paths.add(path); // add this completed path to paths when this path reaches a leaf node
            return;
        }
        if (root.left != null) {
            dfs(root.left, path + "->", paths);
        }
        if (root.right != null) {
            dfs(root.right, path + "->", paths);
        }
    }
}