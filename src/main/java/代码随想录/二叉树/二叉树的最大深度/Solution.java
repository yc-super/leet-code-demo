package 代码随想录.二叉树.二叉树的最大深度;

import 代码随想录.二叉树.TreeNode;
/*
* 前序求深度，后序求高度
* 本题通过求根节点的高度，来获得二叉树的最大深度（最下往上递增，所以是高度）
* */
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
