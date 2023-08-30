package 代码随想录.二叉树.对称二叉树;

import 代码随想录.二叉树.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution2 {
    public boolean isSymmetric(TreeNode root) {
        if (root.left == null && root.right == null)
            return true;
        return isSymmetric2(root.left, root.right);
    }

    private boolean isSymmetric2(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;
        if (left == null || right == null || left.val != right.val)
            return false;
        return isSymmetric2(left.left, right.right) && isSymmetric2(left.right, right.left);
    }
}
