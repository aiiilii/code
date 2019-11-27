public class PathSumIII {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        // root + left + right
        return dfs(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private int dfs(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        sum -= root.val;
        //root + left + right
        int count = 0;
        if (sum == 0) {
            count = 1;
        }
        return count +  dfs(root.left, sum) + dfs(root.right, sum);
    }
}