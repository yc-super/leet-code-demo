package 代码随想录.二叉树.从中序与后序遍历序列构造二叉树;

import 代码随想录.二叉树.TreeNode;

public class Solution2 {
    /*
     *               1
     *            2      3
     *         4    5   6  7
     * 中序：4251637
     * 后序：4526731
     * */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int len1 = inorder.length;
        int len2 = postorder.length;
        return buildTree(inorder, postorder, 0, len1 - 1, 0, len2 - 1);
    }

    private TreeNode buildTree(int[] inorder, int[] postorder, int left, int right, int left1, int right1) {
        if (left > right)
            return null;
        TreeNode root = new TreeNode(postorder[right1]);
        int index;
        for (index = left; index <= right; index++) {
            if (inorder[index] == root.val)
                break;
        }
        root.left = buildTree(inorder, postorder, left, index - 1, left1, left1 + (index - 1 - left));
        root.right = buildTree(inorder, postorder, index + 1, right, left1 + (index - 1 - left) + 1, right1-1);

        return root;
    }
}
