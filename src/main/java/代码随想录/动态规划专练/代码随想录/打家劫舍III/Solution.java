package 代码随想录.动态规划专练.代码随想录.打家劫舍III;

import 代码随想录.二叉树.TreeNode;

import java.util.Arrays;
import java.util.List;

public class Solution {
    public int rob(TreeNode root) {
        //注意后序遍历
        int[] traversal = traversal(root);
        return traversal[1];
    }

    //动态规划优化，长度为2的数组，下标0存该节点的左右节点的最大可能值的和，下标1存当前节点最大可能值
    private int[] traversal(TreeNode root) {
        if (root == null)
            return new int[]{0, 0};

        if (root.left == null && root.right == null)
            return new int[]{0, root.val};

        int[] leftArr = traversal(root.left);
        int[] rightArr = traversal(root.right);
        return new int[]{leftArr[1]+rightArr[1], Math.max(leftArr[1]+rightArr[1], root.val + leftArr[0]+rightArr[0])};
    }
}
