package 代码随想录.二叉树.二叉树的中序遍历;

import 代码随想录.二叉树.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

//迭代遍历
public class Solution2 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        if(root==null)
            return list;
        Deque<TreeNode> deque=new ArrayDeque<>();
        TreeNode cur=root;
        while(!deque.isEmpty()||cur!=null){
            if(cur!=null){
                deque.push(cur);
                cur=cur.left;
            }else{
                cur = deque.pop();
                list.add(cur.val);
                cur=cur.right;
            }
        }
        return list;
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

        List<Integer> list = new Solution2().inorderTraversal(root);
        System.out.println(list);
    }
}
