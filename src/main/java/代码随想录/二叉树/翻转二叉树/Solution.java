package 代码随想录.二叉树.翻转二叉树;

import 代码随想录.二叉树.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    //深度优先遍历，递归，前序遍历、后序遍历比较适合
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return root;
        invertTree2(root);
        return root;
    }

    private TreeNode temp;

    private void invertTree2(TreeNode root) {
        if (root == null)
            return;

        temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree2(root.left);
        invertTree2(root.right);
    }

    //深度优先遍历，迭代，前序遍历
    public TreeNode invertTree3(TreeNode root) {
        if (root == null)
            return root;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.push(root);
        TreeNode temp;
        while (!deque.isEmpty()) {
            TreeNode node = deque.pop();

            temp = node.left;
            node.left = node.right;
            node.right = temp;

            if (node.right != null)
                deque.push(node.right);
            if (node.left != null)
                deque.push(node.left);
        }
        return root;
    }

    //深度优先遍历，迭代，后序遍历
    public TreeNode invertTree4(TreeNode root) {
        if (root == null)
            return root;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.push(root);
        TreeNode temp;
        while (!deque.isEmpty()) {
            TreeNode node = deque.pop();

            temp = node.left;
            node.left = node.right;
            node.right = temp;

            if (node.left != null)
                deque.push(node.left);
            if (node.right != null) {
                deque.push(node.right);
            }
        }
        return root;
    }

    //复习下中序遍历，迭代遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;
        Deque<TreeNode> deque = new LinkedList<>();
        TreeNode cur = root;
        while (!deque.isEmpty() || cur != null) {
            if (cur != null) {
                deque.push(cur);
                cur = cur.left;
            } else {
                cur = deque.pop();
                result.add(cur.val);
                cur = cur.right;
            }
        }
        return result;
    }

    //复习，深度优先遍历，递归法
    public TreeNode invertTree5(TreeNode root) {
        swap(root);
        return root;
    }

    private void swap(TreeNode node) {
        if (node == null)
            return;

        swap(node.left);
        swap(node.right);
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
    }
}
