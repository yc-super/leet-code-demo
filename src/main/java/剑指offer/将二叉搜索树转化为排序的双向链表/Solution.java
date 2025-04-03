package 剑指offer.将二叉搜索树转化为排序的双向链表;

import 代码随想录.二叉树.TreeNode;
import 代码随想录.二叉树.TreeNodeUtils;

public class Solution {
    public static void main(String[] args) {
        Integer[] in = {4, 2, 5, 1, 3};
        TreeNode treeNode = TreeNodeUtils.getTreeNode(in);
        new Solution().treeToDoublyList(treeNode);
    }

    public TreeNode treeToDoublyList(TreeNode root) {
        TreeNode n = root;
        pre = new TreeNode(1);
        myMethod(root);
        // 操作pre
        TreeNode head = new TreeNode();
        TreeNode h2 = new TreeNode();
        head.left=pre;
        h2=pre;
        TreeNode treeNode = fixPre(pre, head);
        treeNode.left=h2;
        h2.right=treeNode;
        return treeNode;
    }

    private TreeNode fixPre(TreeNode root,TreeNode pre) {
        if(root.left==null)
            return pre;
        root.right=pre;
        pre=root;
        return fixPre(root.left,pre);
    }

    TreeNode pre;

    private void myMethod(TreeNode root) {
        if (root == null)
            return;

        myMethod(root.left);

        root.left = pre;
        pre = root;


        myMethod(root.right);
    }

}
