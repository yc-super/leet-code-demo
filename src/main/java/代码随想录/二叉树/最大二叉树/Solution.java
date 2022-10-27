package 代码随想录.二叉树.最大二叉树;

import 代码随想录.二叉树.TreeNode;

public class Solution {
    public static void main(String[] args) {
//        int[] nums={3,2,1,6,0,5};
//        int[] nums={3,2,1};
        int[] nums={3};
        TreeNode treeNode = new Solution().constructMaximumBinaryTree(nums);
        System.out.println();
    }
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return getMaxTreeNode(nums,0,nums.length-1);
    }

    private TreeNode getMaxTreeNode(int[] nums, int left, int right) {
        if(left>right)
            return null;

        int maxIndex = getMaxIndex(left, right, nums);
        TreeNode root=new TreeNode(nums[maxIndex]);
        root.left=getMaxTreeNode(nums,left,maxIndex-1);
        root.right=getMaxTreeNode(nums,maxIndex+1,right);

        return root;
    }

    private int getMaxIndex(int left,int right,int[] nums){
        int max=nums[left];
        int result=left;
        for (int i = left+1; i <= right; i++) {
            if(nums[i]>max){
                max=nums[i];
                result=i;
            }
        }
        return result;
    }
}
