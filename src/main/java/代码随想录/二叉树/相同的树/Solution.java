package 代码随想录.二叉树.相同的树;

import 代码随想录.二叉树.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/*
 * 和 对称二叉树 相似
 * */
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p == null)
            return false;
        if (q == null)
            return false;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addFirst(p);
        deque.addLast(q);
        while (!deque.isEmpty()) {
            TreeNode node1 = deque.pollFirst();
            TreeNode node2 = deque.pollLast();
            if (node1.val != node2.val)
                return false;

            if (node1.left != null && node2.left != null) {
                deque.addFirst(node1.left);
                deque.addLast(node2.left);
            } else if (node1.left == null && node2.left == null) {

            } else {
                return false;
            }
            if (node1.right != null && node2.right != null) {
                deque.addFirst(node1.right);
                deque.addLast(node2.right);
            } else if (node1.right == null && node2.right == null) {

            } else {
                return false;
            }
        }
        return true;
    }

    //直接深度优先遍历就好了，不用队列、栈啥的
    public boolean isSameTree2(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p == null | q == null)
            return false;
        if (p.val != q.val)
            return false;
        return isSameTree2(p.left, q.left) && isSameTree2(p.right, q.right);
    }
}
