package LeetCode.统计二叉树中好节点的数目;

import 代码随想录.二叉树.TreeNode;

public class Solution {
    private int count = 0;

    public int goodNodes(TreeNode root) {
        getCount(root, -10000);
        return count;
    }

    private void getCount(TreeNode root, int max) {
        if (root == null)
            return;
        if (root.val >= max) {
            count++;
        }
        max = Math.max(max, root.val);
        getCount(root.left, max);
        getCount(root.right, max);
    }


    public int goodNodes2(TreeNode root) {
        return dfs(root, root.val);
    }

    private int dfs(TreeNode root, int val) {
        if (root == null)
            return 0;
        int left = dfs(root.left, Math.max(val, root.val));
        int right = dfs(root.right, Math.max(val, root.val));
        return left + right + (val <= root.val ? 1 : 0);
    }
}
