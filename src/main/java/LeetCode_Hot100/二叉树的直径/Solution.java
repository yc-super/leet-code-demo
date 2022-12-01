package LeetCode_Hot100.二叉树的直径;

import 代码随想录.二叉树.TreeNode;
import 代码随想录.二叉树.TreeNodeUtils;

public class Solution {
    public static void main(String[] args) {
        Integer[] nodes={1,2,3,4,5};
        TreeNode root = TreeNodeUtils.getTreeNode(nodes);
        System.out.println(new Solution().diameterOfBinaryTree(root));
    }
    //思路：遍历整棵树，统计每个节点左子树和右子树的高，两个高的和的最大值作为最终返回值
    public int diameterOfBinaryTree(TreeNode root) {
        countHigh(root);
        return maxHigh;
    }

    private int countHigh(TreeNode root) {
        if(root==null){
            return 0;
        }
        int leftHigh = countHigh(root.left);
        int rightHigh = countHigh(root.right);
        maxHigh=Math.max(maxHigh,leftHigh+rightHigh);

        return Math.max(leftHigh,rightHigh)+1;
    }

    private int maxHigh=0;
}
