package 代码随想录.二叉树.二叉搜索树中的搜索;

import 代码随想录.二叉树.TreeNode;

public class Solution2 {

    public TreeNode searchBST(TreeNode root, int val) {
        if (root.val == val) {
            return root;
        }
        if (root.val > val) {
            if (root.left != null) {
                return searchBST(root.left, val);
            }
        }
        if (root.val < val) {
            if (root.right != null) {
                return searchBST(root.right, val);
            }
        }
        return null;
    }
}
