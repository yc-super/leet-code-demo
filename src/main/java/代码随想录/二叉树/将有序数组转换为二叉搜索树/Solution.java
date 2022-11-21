package 代码随想录.二叉树.将有序数组转换为二叉搜索树;

import 代码随想录.二叉树.TreeNode;

public class Solution {
    //二分法递归
    public TreeNode sortedArrayToBST(int[] nums) {
        return getBST(nums,0,nums.length-1);
    }

    private TreeNode getBST(int[] nums, int left, int right) {
        if(left>right)
            return null;
        if(left==right)
            return new TreeNode(nums[left]);

        int middle=(left+right)/2;
        TreeNode root=new TreeNode(nums[middle]);
        root.left=getBST(nums,left,middle-1);
        root.right=getBST(nums,middle+1,right);

        return root;
    }
}
