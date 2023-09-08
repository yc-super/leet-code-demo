package 代码随想录.二叉树.修剪二叉搜索树;

import 代码随想录.二叉树.TreeNode;

public class Solution2 {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null)
            return null;
        TreeNode dump = new TreeNode(low);
        dump.left = root;
        trim(dump, low, high);
        return dump.left;
    }

    private TreeNode trim(TreeNode root, int low, int high) {
        if (root == null)
            return null;


        if (root.val < low || root.val > high) {
            if (root.right != null) {
                TreeNode trim = trim(root.right, low, high);
                if (trim != null) {
                    TreeNode temp = trim;
                    while (temp.left != null) {
                        temp = temp.left;
                    }
                    temp.left = trim(root.left, low, high);
                    return trim;
                } else {
                    return trim(root.left, low, high);
                }
            } else if (root.left != null) {
                return trim(root.left, low, high);
            } else {
                return null;
            }
        }

        root.left = trim(root.left, low, high);
        root.right = trim(root.right, low, high);

        return root;
    }


    public TreeNode trimBST2(TreeNode root, int low, int high) {
        if (root == null)
            return null;

        if (root.val < low) {
            return trimBST2(root.right, low, high);
        }
        if (root.val > high) {
            return trimBST2(root.left, low, high);
        }

        root.left = trimBST2(root.left, low, high);
        root.right = trimBST2(root.right, low, high);

        return root;
    }
}
