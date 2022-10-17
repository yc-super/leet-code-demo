package 代码随想录.二叉树.前中后序遍历.二叉树的后序遍历;

import 代码随想录.二叉树.TreeNode;

import java.util.ArrayList;
import java.util.List;

//递归遍历
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        if(root==null)
            return list;
        postorderTraversal(root,list);
        return list;
    }

    private void postorderTraversal(TreeNode root, List<Integer> list) {
        if(root==null)
            return;
        postorderTraversal(root.left,list);
        postorderTraversal(root.right,list);
        list.add(root.val);
    }

    public static void main(String[] args) {
        /*
        *           1
        *       2           5
        *   3      4      6   7
        *                8  9
        * */
//        Integer[] root = {1,null,2,3};
        TreeNode root=new TreeNode(1);
        TreeNode node1=new TreeNode(2);
        TreeNode node2=new TreeNode(3);
        TreeNode node3=new TreeNode(4);
        TreeNode node4=new TreeNode(5);
        TreeNode node5=new TreeNode(6);
        TreeNode node6=new TreeNode(7);
        TreeNode node7=new TreeNode(8);
        TreeNode node8=new TreeNode(9);
        root.left=node1;
        node1.left=node2;
        node1.right=node3;
        root.right=node4;
        node4.left=node5;
        node4.right=node6;

        node5.left=node7;
        node5.right=node8;

        List<Integer> list = new Solution().postorderTraversal(root);
        System.out.println(list);
    }
}
