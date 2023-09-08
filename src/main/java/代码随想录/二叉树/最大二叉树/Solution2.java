package 代码随想录.二叉树.最大二叉树;

import sun.reflect.generics.tree.Tree;
import 代码随想录.二叉树.TreeNode;

public class Solution2 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums, 0, nums.length - 1);
    }

    private TreeNode construct(int[] nums, int left, int right) {
        if (left > right)
            return null;
        int max = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] > nums[max]) {
                max = i;
            }
        }
        TreeNode root = new TreeNode(nums[max]);
        root.left = construct(nums, left, max - 1);
        root.right = construct(nums, max + 1, right);

        return root;
    }
}
