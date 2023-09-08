package 代码随想录.二叉树.验证二叉搜索树;

import 代码随想录.二叉树.TreeNode;

public class Solution2 {
    public boolean isValidBST(TreeNode root) {
        return vali(root);
    }

    private long min = (long) Integer.MIN_VALUE - 1;

    private boolean vali(TreeNode root) {
        if (root.left != null) {
            if (!vali(root.left))
                return false;
        }
        if (root.val <= min)
            return false;
        min = root.val;
        if (root.right != null) {
            if (!vali(root.right))
                return false;
        }

        return true;
    }


    //不用初始化最小值，记录前一个节点就行，前一个节点初始化为null，比较时如果前一个节点如果不为null，判断是否大于前一个节点的值
//    private boolean vali(TreeNode root) {
//
//    }
}
