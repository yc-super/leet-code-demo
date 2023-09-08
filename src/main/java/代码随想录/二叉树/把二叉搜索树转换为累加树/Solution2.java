package 代码随想录.二叉树.把二叉搜索树转换为累加树;

import 代码随想录.二叉树.TreeNode;

public class Solution2 {
    public TreeNode convertBST(TreeNode root) {
        if (root == null)
            return null;
        conver(root, null);
        return root;
    }

    private int conver(TreeNode root, TreeNode parent) {
        if (root == null) {
            if (parent != null)
                return parent.val;
            return 0;
        }

        int v1 = 0, v2 = 0;
        v1 = conver(root.right, parent);

        root.val += v1;
//        if (parent != null) {
//            root.val += parent.val;
//        }

        v2 = conver(root.left, root);

        return v2 == 0 ? root.val : v2;
    }


    private int sum = 0;

    public TreeNode convertBST2(TreeNode root) {
        if (root == null)
            return null;
        convertBST2(root.right);

        root.val += sum;
        sum = root.val;

        convertBST2(root.left);

        return root;
    }
}
