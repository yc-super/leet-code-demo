package 代码随想录.二叉树.删除二叉搜索树中的节点;

import 代码随想录.二叉树.TreeNode;

public class Solution2 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;

        return deleteNode2(root, key);

    }

    private TreeNode deleteNode2(TreeNode root, int key) {
        if (root.val == key) {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                TreeNode temp = new TreeNode();
                temp = root.right;
                while (temp.left != null) {
                    temp = temp.left;
                }
                temp.left = root.left;

                return root.right;
            }
        }

        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }
}