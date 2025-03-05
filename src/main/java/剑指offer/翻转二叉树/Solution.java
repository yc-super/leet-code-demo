package 剑指offer.翻转二叉树;

import 代码随想录.二叉树.TreeNode;

public class Solution {
    public TreeNode flipTree(TreeNode root) {
        if(root==null)
            return null;
        myFlip(root);
        return root;
    }

    private void myFlip(TreeNode root) {
        if(root==null)
            return;

        TreeNode left = root.left;
        root.left=root.right;
        root.right=left;

        myFlip(root.left);
        myFlip(root.right);
    }
}
