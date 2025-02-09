package 剑指offer.重建二叉树前序中序;

import 代码随想录.二叉树.TreeNode;

public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder,postorder,0,inorder.length-1,0,inorder.length-1);
    }

    private TreeNode buildTree(int[] inorder, int[] postorder, int left, int right,int left2,int right2) {
        if(left==right) {
            return new TreeNode(inorder[left]);
        }else if(left>right){
            return null;
        }

        TreeNode root = new TreeNode(postorder[right2]);
        // 在中序数组中找根节点的位置，将区间一分为二。可以用Map优化
        int middle=0;
        for (int i = left; i <= right; i++) {
            if(inorder[i]==postorder[right]){
                middle=i;
                break;
            }
        }
        int len=right-left+1;

        root.left=buildTree(inorder,postorder,left,middle-1,right2-len+1,right2-len+1+(middle-1-left));
        root.right=buildTree(inorder,postorder,middle+1,right,right2-len+1+(middle-1-left)+1,right2-1);
        return root;
    }
}
