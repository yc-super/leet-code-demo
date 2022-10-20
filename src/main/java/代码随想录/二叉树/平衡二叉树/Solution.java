package 代码随想录.二叉树.平衡二叉树;

import 代码随想录.二叉树.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);

        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;

        boolean balanced = new Solution().isBalanced(root);
        System.out.println(balanced);
    }

    //思路：层序遍历，找到最低叶子结点的层数，以及最高叶子结点的层数
    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }

    private int getHeight(TreeNode root) {
        if (root == null)
            return 0;
        int leftHeight = getHeight(root.left);
        if (leftHeight == -1)
            return -1;
        int rightHeight = getHeight(root.right);
        if (rightHeight == -1)
            return -1;

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;

    }

}
