package 代码随想录.二叉树.二叉树的最小深度;

import 代码随想录.二叉树.TreeNode;

public class Solution {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        TreeNode node1=new TreeNode(2);
        TreeNode node2=new TreeNode(3);
        TreeNode node3=new TreeNode(4);
        TreeNode node4=new TreeNode(5);
        TreeNode node5=new TreeNode(6);
        TreeNode node6=new TreeNode(7);
        TreeNode node7=new TreeNode(8);
        TreeNode node8=new TreeNode(9);
        TreeNode node9=new TreeNode(9);
        TreeNode node10=new TreeNode(9);
        root.left=node1;
        node1.left=node2;
        node1.right=node3;
//        root.right=node4;
//        node4.left=node5;
//        node4.right=node6;
        node2.left=node7;
        node2.right=node8;
        node3.left=node9;
        node3.right=node10;
        int i = new Solution().minDepth(root);
        System.out.println(i);
    }
    public int minDepth(TreeNode root) {
        if(root==null)
            return 0;
        return getMinDepth(root);
    }

    private int getMinDepth(TreeNode root) {
        if (root.left == null && root.right == null) {
            return 1;
        }

        int r1=Integer.MAX_VALUE,r2=Integer.MAX_VALUE;
        if (root.left != null) {
            r1 = getMinDepth(root.left);
        }
        if (root.right != null) {
            r2 = getMinDepth(root.right);
        }
        return Math.min(r1,r2)+1;
    }

}
