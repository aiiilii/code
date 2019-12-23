public class MinDistaceBetweenBSTNodes {

    TreeNode prev;
    int ans;

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    
    public int minDiffInBST(TreeNode root) {
        prev = null;
        ans = Integer.MAX_VALUE;
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);

        if (prev != null) {
            ans = Math.min(ans, node.val - prev.val);
        }
        prev = node;
        
        dfs(node.right);
    }
}