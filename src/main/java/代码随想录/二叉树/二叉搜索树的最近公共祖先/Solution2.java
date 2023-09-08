package 代码随想录.二叉树.二叉搜索树的最近公共祖先;

import 代码随想录.二叉树.TreeNode;

public class Solution2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode leftNode = null, rightNode = null;
        if (p.val < root.val || q.val < root.val) {
            leftNode = lowestCommonAncestor(root.left, p, q);
        }
        if (p.val > root.val || q.val > root.val) {
            rightNode = lowestCommonAncestor(root.right, p, q);
        }
        if (leftNode == null)
            return rightNode;
        if (rightNode == null)
            return leftNode;
        return root;
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor2(root.left, p, q);
        } else if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor2(root.right, p, q);
        } else {
            return root;
        }
    }
}
