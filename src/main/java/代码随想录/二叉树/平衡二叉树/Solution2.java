package 代码随想录.二叉树.平衡二叉树;

import 代码随想录.二叉树.TreeNode;

public class Solution2 {
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        return countDepth(root) == -1 ? false : true;
    }

    private int countDepth(TreeNode root) {
        if (root == null)
            return 0;
        int leftCount = countDepth(root.left);
        int rightCount = countDepth(root.right);
        if (leftCount == -1 || rightCount == -1) {
            return -1;
        }
        if (Math.abs(leftCount - rightCount) > 1) {
            return -1;
        }
        return Math.max(leftCount, rightCount)+1;
    }

}
