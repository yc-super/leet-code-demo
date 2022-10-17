package 代码随想录.二叉树.对称二叉树;

import 代码随想录.二叉树.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(3);
        root.left = node1;
        node1.left = node2;
        node1.right = node3;
        root.right = node4;
        node4.left = node5;
        node4.right = node6;

        boolean result = new Solution().isSymmetric3(root);
        System.out.println(result);
    }

    public boolean isSymmetric(TreeNode root) {
        isSymmetric(root.left, root.right);
        return result;
    }

    boolean result = true;

    //递归法，我自己写的
    private void isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return;
        if (left == null || right == null) {
            result = false;
            return;
        }
        if (result && left.val == right.val) {
            isSymmetric(left.left, right.right);
            isSymmetric(left.right, right.left);
        } else {
            result = false;
            return;
        }
    }

    //递归，代码随想录
    private boolean isSymmetric2(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;
        if (left == null || right == null)
            return false;
        if (left.val != right.val)
            return false;

        boolean r1 = isSymmetric2(left.left, right.right);
        boolean r2 = isSymmetric2(left.right, right.left);
        return r1 && r2;
    }

    //迭代，自己写的，两个双端队列，效率好低啊
    public boolean isSymmetric2(TreeNode root) {
        Deque<TreeNode> deque1 = new LinkedList<>();
        Deque<TreeNode> deque2 = new LinkedList<>();
        deque1.push(root.left);
        deque2.addFirst(root.right);

        while (!deque1.isEmpty() && !deque2.isEmpty()) {
            TreeNode n1 = deque1.pop();
            TreeNode n2 = deque2.poll();

            if(n1==null&&n2==null)
                continue;
            if(n1==null||n2==null)
                return false;
            if(n1.val!=n2.val)
                return false;

            deque1.push(n1.left);
            deque2.addFirst(n2.right);
            deque1.push(n1.right);
            deque2.addFirst(n2.left);

        }
        if (!deque1.isEmpty() || !deque2.isEmpty()){
            return false;
        }
        return true;
    }

    //迭代，代码随想录，效率也不高
    public boolean isSymmetric3(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addFirst(root.left);
        deque.addLast(root.right);

        while (!deque.isEmpty()) {
            TreeNode n1 = deque.pollFirst();
            TreeNode n2 = deque.pollLast();

            if(n1==null&&n2==null)
                continue;
            if(n1==null||n2==null)
                return false;
            if(n1.val!=n2.val)
                return false;

            deque.addFirst(n1.left);
            deque.addFirst(n1.right);
            deque.addLast(n2.right);
            deque.addLast(n2.left);

        }
        return true;
    }
}
