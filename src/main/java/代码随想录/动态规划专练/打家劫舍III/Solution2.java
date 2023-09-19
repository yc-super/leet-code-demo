package 代码随想录.动态规划专练.打家劫舍III;

import 代码随想录.二叉树.TreeNode;

public class Solution2 {

    public int rob(TreeNode root) {
        return Math.max(backTrack(root, true), backTrack(root, false));
    }

    //回溯，会超时。注意这里是前序遍历，前序遍历会造成重复计算，必须是后序遍历才行
    private int backTrack(TreeNode root, boolean flag) {
        if (root == null)
            return 0;

        if (flag) {
            return backTrack(root.left, false) + backTrack(root.right, false);
        }
        return Math.max(root.val + backTrack(root.left, true) + backTrack(root.right, true),
                backTrack(root.left, false) + backTrack(root.right, false));
    }


    public int rob2(TreeNode root) {
        return backTrack(root)[1];
    }

    // dp  后序遍历
    private int[] backTrack(TreeNode root) {
        if (root == null)
            return new int[]{0, 0};

        int[] left = backTrack(root.left);
        int[] right = backTrack(root.right);

        return new int[]{left[1] + right[1], Math.max(left[1] + right[1], root.val + left[0] + right[0])};
    }
}
