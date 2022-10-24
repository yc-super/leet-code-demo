package 代码随想录.二叉树.路径总和;

import 代码随想录.二叉树.TreeNode;
import 代码随想录.二叉树.TreeNodeUtils;

public class Solution {
    public static void main(String[] args) {
        Integer[] nodes={5,4,8,11,null,13,4,7,2,null,null,null,null,null,1};
        TreeNode root = TreeNodeUtils.getTreeNode(nodes);
        System.out.println(new Solution().hasPathSum3(root,22));
    }
    //思路：求所有路径 变形题
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        hasPathSum2(root, targetSum, 0);
        return flag;
    }

    boolean flag = false;

    private void hasPathSum2(TreeNode root, int targetSum, int sum) {
        sum += root.val;
        if (root.left == null && root.right == null) {
            if (sum == targetSum) {
                flag = true;
                return;
            }
        }
        if (!flag && root.left != null) {
            hasPathSum2(root.left, targetSum, sum);
        }
        if (!flag && root.right != null) {
            hasPathSum2(root.right, targetSum, sum);
        }
    }


    //代码随想录，递归，直接返回结果
    public boolean hasPathSum3(TreeNode root, int targetSum) {
        if(root==null)
            return false;
        return hasPathSum4(root,targetSum);
    }

    private boolean hasPathSum4(TreeNode root, int targetSum) {
        targetSum-=root.val;
        if(root.left==null&&root.right==null&&targetSum==0){
            return true;
        }
        if(root.left!=null){
            if(hasPathSum4(root.left, targetSum))
                return true;
        }
        if(root.right!=null){
            if(hasPathSum4(root.right, targetSum))
                return true;
        }

        return false;
    }


}
