package 代码随想录.二叉树.二叉搜索树的最小绝对差;

import 代码随想录.二叉树.TreeNode;

public class Solution {
    //思路：利用二叉搜索树的性质
    public int getMinimumDifference(TreeNode root) {
        minDifference=Integer.MAX_VALUE;
        preValue = -100000;
        getMinimumDifference2(root);
        return minDifference;
    }

    private int minDifference;
    private int preValue;
    private void getMinimumDifference2(TreeNode root) {
        if(root==null)
            return;

        if(root.left!=null){
//            minDifference=Math.min(minDifference,Math.abs(root.val-root.left.val));
            getMinimumDifference2(root.left);
        }

        minDifference=Math.min(minDifference,Math.abs(root.val-preValue));
        preValue=root.val;

        if(root.right!=null){
//            minDifference=Math.min(minDifference,Math.abs(root.val-root.right.val));
            getMinimumDifference2(root.right);
        }
    }
}
