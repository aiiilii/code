public class ClosestBinarySearchTreeValue {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int closestValue(TreeNode root, double target) {
        int ret = root.val;
        while (root != null) {
            if (Math.abs(target - root.val) < Math.abs(target - ret)) {
                ret = root.val;
                if (Math.abs(target - root.val) <= 0.5) {
                    break;
                }
            }
            root = root.val > target ? root.left : root.right;
        }
        return ret;
    }
}