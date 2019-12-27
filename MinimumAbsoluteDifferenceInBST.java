public class MinimumAbsoluteDifferenceInBST {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    TreeNode prev;
    int ans;
    /**
     * With Global Values
     * @param root
     * @return
     */
    public int getMinimumDifference(TreeNode root) {
        ans = Integer.MAX_VALUE;
        if (root == null) {
            return ans;
        }
        dfs(root);
        return ans;
    }
    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);

        if (prev != null) {
            ans = Math.min(ans, Math.abs(root.val - prev.val));
        }
        prev = root;

        dfs(root.right);
    }

    /**
     * WITHOUT Global Value
     * Wrapping a primitive value using an ARRAY
     * @param root
     * @return
     */
    public int getMinimumDifference2(TreeNode root) {
        int[] a = new int[] {-1, Integer.MAX_VALUE};
        inorder(root, a);
        return a[1];
    }
    private int[] inorder(TreeNode root, int[] a) {
        //int pre = a[0]; // Dont need this line
        int res = a[1];
        if (root == null) {
            return a;
        }
        int[] left = inorder(root.left, a);

        if (left[0] != -1) {
            res = Math.min(left[1], root.val - left[0]);
        }
        a[0] = root.val;
        a[1] = res;
        
        return inorder(root.right, a);
    }
}