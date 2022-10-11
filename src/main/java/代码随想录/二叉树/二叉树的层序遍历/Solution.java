package 代码随想录.二叉树.二叉树的层序遍历;

import sun.reflect.generics.tree.Tree;
import 代码随想录.二叉树.TreeNode;
import 代码随想录.链表专练.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
//        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        TreeNode root = new TreeNode(1);
        List<List<Integer>> lists = levelOrder(root);
        System.out.println(lists);
    }

    //思路：维护一个list,用于记录每层的节点，等记录完它们的val后，记录它们的左右节点，并清除之前的节点
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        if(root==null)
            return result;
        List<TreeNode> nodeList=new ArrayList<>();
        List<TreeNode> temp=new ArrayList<>();
        nodeList.add(root);
        while(nodeList.size()!=0){
            List<Integer> list=new ArrayList<>();
            for(TreeNode node:nodeList){
                list.add(node.val);
            }
            result.add(list);
            temp.clear();
            for(TreeNode node:nodeList){
                if(node.left!=null)
                    temp.add(node.left);
                if(node.right!=null)
                    temp.add(node.right);
            }
            nodeList.clear();
            nodeList.addAll(temp);
        }
        return result;
    }
}
