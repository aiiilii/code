import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorder {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
    /**
     * Time - O(n)
     * Space - O(n)
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (inorder == null || inorder.length == 0 || preorder == null || preorder.length == 0 || inorder.length != preorder.length) {
            return null;
        }

        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        return buildTreeHelper(preorder, 0, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTreeHelper(int[] preorder, int preStart, int[] inorder, int inStart, int inEnd) {
        if (inStart > inEnd) {
            return null;
        }

        int rootVal = preorder[preStart];
        int inOrderIndex = indexMap.get(rootVal);

        TreeNode root = new TreeNode(rootVal);
        int leftCount = inOrderIndex - inStart;
        // int rightCount = inEnd - inOrderIndex;

        root.left = buildTreeHelper(preorder, preStart + 1, inorder, inStart, inOrderIndex - 1);
        root.right = buildTreeHelper(preorder, preStart + leftCount + 1, inorder, inOrderIndex + 1, inEnd);

        return root;
    }
}