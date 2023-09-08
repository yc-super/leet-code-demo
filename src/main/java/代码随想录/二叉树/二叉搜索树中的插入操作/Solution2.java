package 代码随想录.二叉树.二叉搜索树中的插入操作;

import 代码随想录.二叉树.TreeNode;

public class Solution2 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val);
        insert(root, val);
        return root;
    }

    private void insert(TreeNode root, int val) {
        if (root.left == null && root.right == null) {
            if (root.val > val) {
                root.left = new TreeNode(val);
            } else {
                root.right = new TreeNode(val);
            }
            return;
        }

        if (root.val > val) {
            if (root.left != null) {
                insert(root.left, val);
            } else {
                root.left = new TreeNode(val);
                return;
            }
        } else {
            if (root.right != null) {
                insert(root.right, val);
            } else {
                root.right = new TreeNode(val);
                return;
            }
        }
    }


    public TreeNode insertIntoBST2(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (root.val > val) {
            root.left = insertIntoBST2(root.left, val);
        } else {
            root.right = insertIntoBST2(root.right, val);
        }

        return root;
    }
}
