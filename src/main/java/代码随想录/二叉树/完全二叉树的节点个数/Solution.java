package 代码随想录.二叉树.完全二叉树的节点个数;

import 代码随想录.二叉树.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    //1.按照普通二叉树来处理
    //递归
    public int countNodes(TreeNode root) {
        countNodes1(root);
        return result;
    }

    private int result = 0;

    private void countNodes1(TreeNode root) {
        if (root == null)
            return;
        result++;
        countNodes1(root.left);
        countNodes1(root.right);
    }

    private int countNodes2(TreeNode root) {
        if (root == null)
            return 0;
        int r1 = countNodes2(root.left);
        int r2 = countNodes2(root.right);

        return r1 + r2 + 1;
    }

    //迭代
    public int countNodes3(TreeNode root) {
        if (root == null)
            return 0;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.push(root);
        int result = 0;
        while (!deque.isEmpty()) {
            TreeNode node = deque.pop();
            result++;
            if (node.right != null)
                deque.push(node.right);
            if (node.left != null)
                deque.push(node.left);
        }
        return result;
    }

    //按照完全二叉树处理，递归
    public int countNodes4(TreeNode root) {
        //出口
        if (root == null)
            return 0;
        int leftDetph = 0;
        int rightDetpth = 0;
        TreeNode left = root.left;
        TreeNode right = root.right;
        while (left != null) {
            left = left.left;
            leftDetph++;
        }
        while (right != null) {
            right = right.right;
            rightDetpth++;
        }

        if (leftDetph == rightDetpth) {
            return (2 << leftDetph) - 1;
        }

        return countNodes4(root.left) + countNodes4(root.right) + 1;

    }



    public int countNodes6(TreeNode root) {
        if (root == null)
            return 0;

        TreeNode left = root.left;
        TreeNode right = root.right;
        int depth1 = 1, depth2 = 1;
        while (left != null) {
            depth1++;
            left = left.left;
        }
        while (right != null) {
            depth2++;
            right = right.right;
        }

        if (depth1 == depth2) {
            return (1 << depth1) - 1;
        }
        return countNodes6(root.left) + countNodes6(root.right) + 1;
    }
}
