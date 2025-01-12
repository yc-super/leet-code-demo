package LeetCode.路径总和III;

import 代码随想录.二叉树.TreeNode;
import 代码随想录.二叉树.TreeNodeUtils;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        Integer[] root = {1000000000,1000000000,null,294967296,null,1000000000,null,1000000000,null,1000000000};
        TreeNode treeNode = TreeNodeUtils.getTreeNode(root);
        System.out.println(new Solution().pathSum(treeNode, 0));
    }

    int count = 0;

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null)
            return 0;
        Map<Long, Integer> map = new HashMap<>();
        map.put(0l, 1);
        batch(root, targetSum, map, 0l);
        return count;
    }

    private void batch(TreeNode root, int targetSum, Map<Long, Integer> map, Long preValue) {
        if (root == null)
            return;
        int val = root.val;
        Long temp = val + preValue;
        count += map.getOrDefault(temp - targetSum, 0);
        map.put(temp, map.getOrDefault(temp, 0) + 1);
        if (root.left != null) {
            batch(root.left, targetSum, map, temp);
        }
        if (root.right != null) {
            batch(root.right, targetSum, map, temp);
        }
        map.put(temp, map.getOrDefault(temp, 0) - 1);// 恢复现场
    }
}
