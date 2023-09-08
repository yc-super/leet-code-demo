package 代码随想录.二叉树.二叉搜索树的最小绝对差;

import 代码随想录.二叉树.TreeNode;

public class Solution2 {
    private TreeNode preNode = null;
    private Integer minValue = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        minimum(root);
        return minValue;
    }

    private void minimum(TreeNode root) {
        if (root == null)
            return;
        minimum(root.left);

        if (preNode != null) {
            minValue = Math.min(minValue, root.val - preNode.val);
        }
        preNode = root;

        minimum(root.right);
    }
}
