package 代码随想录.二叉树.二叉树的最大深度;

import 代码随想录.二叉树.TreeNode;

public class Solution {
    public int maxDepth(TreeNode root) {
        return getMaxDepth(root);
    }

    private int getMaxDepth(TreeNode root) {
        if (root == null)
            return 0;
        int l1 = getMaxDepth(root.left);
        int l2 = getMaxDepth(root.right);

        return Math.max(l1, l2) + 1;
    }
}
