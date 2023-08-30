package 代码随想录.二叉树.完全二叉树的节点个数;

import 代码随想录.二叉树.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class Solution2 {
    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;
        int count1 = getLeftDepth(root);
        int count2 = getRightDepth(root);
        if (count1 == count2) {
            return (int) Math.pow(2, count1) - 1;
        } else {
            return countNodes(root.left) + countNodes(root.right)+1 ;
        }
    }

    private int getRightDepth(TreeNode root) {
        int depth = 0;
        TreeNode temp = root;
        while (temp != null) {
            temp = temp.right;
            depth++;
        }
        return depth;
    }

    private int getLeftDepth(TreeNode root) {
        int depth = 0;
        TreeNode temp = root;
        while (temp != null) {
            temp = temp.left;
            depth++;
        }
        return depth;
    }
}
