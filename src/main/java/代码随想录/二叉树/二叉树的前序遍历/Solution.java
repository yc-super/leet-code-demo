package 代码随想录.二叉树.二叉树的前序遍历;

import 代码随想录.二叉树.TreeNode;

import java.util.ArrayList;
import java.util.List;

//递归遍历
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        if(root==null)
            return list;
        preorderTraversal(root,list);
        return list;
    }

    private void preorderTraversal(TreeNode root, List<Integer> list) {
        if(root==null)
            return;
        list.add(root.val);
        preorderTraversal(root.left,list);
        preorderTraversal(root.right,list);
    }

    public static void main(String[] args) {
//        Integer[] root = {1,null,2,3};
        TreeNode root=new TreeNode(1);
        TreeNode node1=new TreeNode(2);
        TreeNode node2=new TreeNode(3);
        TreeNode node3=new TreeNode(4);
        TreeNode node4=new TreeNode(5);
        TreeNode node5=new TreeNode(6);
        TreeNode node6=new TreeNode(7);
        root.left=node1;
        node1.left=node2;
        node1.right=node3;
        root.right=node4;
        node4.left=node5;
        node4.right=node6;

        List<Integer> list = new Solution().preorderTraversal(root);
        System.out.println(list);
    }
}
