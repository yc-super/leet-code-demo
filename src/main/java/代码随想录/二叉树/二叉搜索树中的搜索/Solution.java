package 代码随想录.二叉树.二叉搜索树中的搜索;

import 代码随想录.二叉树.TreeNode;

public class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root==null)
            return null;

        if(root.val<val) {
            return searchBST(root.right, val);
        }else if(root.val>val) {
            return searchBST(root.left, val);
        }else{
            return root;
        }
    }

    public TreeNode searchBST2(TreeNode root, int val) {
        while(root!=null){
            if(root.val<val){
                root=root.right;
            }else if(root.val>val){
                root=root.left;
            }else{
                return root;
            }
        }
        return null;
    }
}
