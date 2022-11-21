package 代码随想录.二叉树.修剪二叉搜索树;

import 代码随想录.二叉树.TreeNode;

public class Solution {
    //递归法
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root==null)
            return null;

        if(root.val<low){
            return trimBST(root.right,low,high);
        }else if (root.val>high) {
            return trimBST(root.left, low, high);
        }

        root.left=trimBST(root.left,low,high);
        root.right=trimBST(root.right,low,high);

        return root;
    }
//    递归法改进
    public TreeNode trimBST2(TreeNode root, int low, int high) {

        if(root.val<low){
            if(root.right!=null) {
                return trimBST2(root.right, low, high);
            }else {
                return null;
            }
        }else if (root.val>high) {
            if(root.left!=null) {
                return trimBST2(root.left, low, high);
            }else{
                return null;
            }
        }

        if(root.left!=null) {
            root.left = trimBST2(root.left, low, high);
        }
        if(root.right!=null) {
            root.right = trimBST2(root.right, low, high);
        }

        return root;
    }
}
