package LeetCode.二叉树的中序遍历;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
//中序遍历一共有3种解法，递归是最基本的一种
//时间复杂度：O(n),空间复杂度：O(n)
public class code {
    public static void main(String[] args) {
        //[1,null,2,3]
        TreeNode root = new TreeNode(1,null,new TreeNode(2,new TreeNode(3,null,null),null));
//        TreeNode root=new TreeNode(1);
//        TreeNode root=new TreeNode();
        System.out.println(new code().inorderTraversal(root));
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        method(root,list);
        return list;
    }
    private void method(TreeNode root, List<Integer> list) {
        if(root==null)
            return;
        method(root.left,list);
        list.add(root.val);
        method(root.right,list);
    }
}
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }
