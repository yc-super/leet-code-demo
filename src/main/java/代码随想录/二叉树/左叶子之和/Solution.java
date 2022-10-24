package 代码随想录.二叉树.左叶子之和;

import 代码随想录.二叉树.TreeNode;

public class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        preorderTraversal(root);
        return result;
    }

    private int result = 0;

    private void preorderTraversal(TreeNode root) {
        if (root == null)
            return;
        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) {
                result += root.left.val;
            } else {
                preorderTraversal(root.left);
            }
        }
        if (root.right != null) {
            preorderTraversal(root.right);
        }
    }

    public int sumOfLeftLeaves2(TreeNode root) {
        if (root == null)
            return 0;

        int leftResult = sumOfLeftLeaves2(root.left);
        int rightResult = sumOfLeftLeaves2(root.right);

        int middleResult = 0;
        if (root.left != null && root.left.left == null && root.left.right == null)
            middleResult = root.left.val;

        return leftResult + rightResult + middleResult;
    }
}
