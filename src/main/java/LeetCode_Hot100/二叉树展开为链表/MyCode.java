package LeetCode_Hot100.二叉树展开为链表;

import 树.TreeNode;
import 树.遍历.TraverseUtil;

public class MyCode {
    public static void main(String[] args) {
//        TreeNode node=new TreeNode(5,new TreeNode(0,new TreeNode(-2,new TreeNode(-4),new TreeNode(-1)),new TreeNode(3,new TreeNode(2),new TreeNode(4))),
//                new TreeNode(10,new TreeNode(7,new TreeNode(6),new TreeNode(8)),new TreeNode(12,new TreeNode(11),new TreeNode(13))));
        //[1,null,2,3]
//        TreeNode node = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        TreeNode node = new TreeNode(1, new TreeNode(2, null, null), new TreeNode(3));
        new MyCode().flatten(node);

        TraverseUtil.preTraverse(node);
        System.out.println();
        TraverseUtil.midTraverse(node);
        System.out.println();
    }
    public void flatten(TreeNode root) {
        if(root==null)
            return;
        TreeNode right = root.right;
        root.right=root.left;
        root.left=null;
        flatten(root.right);
        if(root.right!=null) {
            while (root.right != null) {
                root = root.right;
            }
        }
        root.right = right;
        flatten(root.right);
    }

}
