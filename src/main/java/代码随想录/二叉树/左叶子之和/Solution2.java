package 代码随想录.二叉树.左叶子之和;

import 代码随想录.二叉树.TreeNode;

public class Solution2 {
    private int sum = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        sum(root);
        return sum;
    }

    private void sum(TreeNode root) {
        if (root == null)
            return;
        if(root.left!=null) {
            if (root.left.left == null && root.left.right == null) {
                sum += root.left.val;
            }
            sum(root.left);
        }
        sum(root.right);
    }
}
