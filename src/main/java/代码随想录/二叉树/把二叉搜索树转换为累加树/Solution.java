package 代码随想录.二叉树.把二叉搜索树转换为累加树;

import 代码随想录.二叉树.TreeNode;

public class Solution {
    public TreeNode convertBST(TreeNode root) {
        if(root==null)
            return null;

        convertBST(root.right);

        sum+=root.val;
        root.val=sum;

        convertBST(root.left);

        return root;
    }
    private int sum=0;
}
