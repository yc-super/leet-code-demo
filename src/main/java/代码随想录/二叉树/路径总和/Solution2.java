package 代码随想录.二叉树.路径总和;

import 代码随想录.二叉树.TreeNode;

public class Solution2 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null)
            return false;
        return path(root, 0, targetSum);
    }

    private boolean path(TreeNode root, int sum, int targetSum) {
        sum += root.val;
        if (root.left == null && root.right == null) {
            if (sum == targetSum)
                return true;
        }
        if (root.left != null) {
            boolean leftResult = path(root.left, sum, targetSum);
            if (leftResult)
                return true;
        }
        if (root.right != null) {
            boolean leftResult = path(root.right, sum, targetSum);
            if (leftResult)
                return true;
        }

        return false;
    }


    //不用再定义sum了，直接用targetSum减去当前节点的值，然后判断targetSum是否等于0
    private boolean path2(TreeNode root, int targetSum) {
        targetSum -= root.val;
        if (root.left == null && root.right == null) {
            if (targetSum == 0) {
                return true;
            }
        }
        if (root.left != null) {
            if (path2(root.left, targetSum))
                return true;
        }
        if (root.right != null) {
            if (path2(root.right, targetSum))
                return true;
        }
        return false;
    }
}
