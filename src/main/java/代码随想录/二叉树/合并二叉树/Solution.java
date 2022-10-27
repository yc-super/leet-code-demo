package 代码随想录.二叉树.合并二叉树;

import 代码随想录.二叉树.TreeNode;

public class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root2!=null){
            if(root1==null){
                return root2;
            }
        }else{
            return root1;
        }
        getTreeNode(root1,root2);
        return root1;
    }

    private void getTreeNode(TreeNode root1, TreeNode root2) {
        root1.val=root1.val+root2.val;

        if(root2.left!=null) {
            if (root1.left == null) {
                root1.left = new TreeNode();
            }
            getTreeNode(root1.left, root2.left);
        }
        if(root2.right!=null) {
            if (root1.right == null) {
                root1.right = new TreeNode();
            }
            getTreeNode(root1.right, root2.right);
        }
    }
    private TreeNode mergeTrees2(TreeNode root1, TreeNode root2) {
        if(root1==null)
            return root2;
        if(root2==null)
            return root1;
        root1.val=root1.val+root2.val;

        root1.left=mergeTrees2(root1.left, root2.left);
        root1.right=mergeTrees2(root1.right, root2.right);

        return root1;
    }
}
