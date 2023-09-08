package 代码随想录.二叉树.二叉树的最近公共祖先;

import 代码随想录.二叉树.TreeNode;

public class Solution2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
        TreeNode rightNode = lowestCommonAncestor(root.right, p, q);
        if (leftNode == null)
            return rightNode;
        if (rightNode == null)
            return leftNode;
        return root;
    }
}
