package 代码随想录.二叉树.验证二叉搜索树;

import 代码随想录.二叉树.TreeNode;

import java.util.Map;

public class Solution {

    //第一次尝试，失败
    /*public boolean isValidBST(TreeNode root) {
        if (root.left == null && root.right == null)
            return true;
        if (root.left != null && root.left.val >= root.val)
            return false;
        if (root.right != null && root.right.val <= root.val)
            return false;

        return isValidBST2(root.left, root.left.val, root.val) && isValidBST2(root.right, root.val, root.right.val);
    }

    private boolean isValidBST2(TreeNode root, int min, int max) {
        if (root == null)
            return true;


        if (root.left != null) {
            if (root.left.val >= root.val || root.left.val >= max) {
                return false;
            } else {
                return isValidBST2(root.left, Math.min(min, root.val), max);
            }
        }
        if (root.right != null) {
            if (root.right.val <= root.val || root.right.val <= min) {
                return false;
            } else {
                return isValidBST2(root.right, min, Math.max(max, root.val));
            }
        }
        return true;
    }*/

    //第二次尝试，中序遍历,成功了
    public boolean isValidBST2(TreeNode root) {
        temp = Long.valueOf(Integer.MIN_VALUE) - 1;

        return isValidBST3(root);
    }

    private long temp;

    private boolean isValidBST3(TreeNode root) {
        if (root == null)
            return true;

        boolean b1 = isValidBST3(root.left);

        if(!b1)
            return false;

        if (root.val <= temp)
            return false;

        temp = root.val;

        boolean b2 = isValidBST3(root.right);

        return b2;
    }
}
