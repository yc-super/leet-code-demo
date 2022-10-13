package 代码随想录.二叉树.二叉树的后序遍历;

import 代码随想录.二叉树.TreeNode;

import java.util.*;

//迭代遍历
public class Solution2 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null)
            return list;

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.push(root);
        while (!deque.isEmpty()) {
            TreeNode node = deque.pop();
            list.add(node.val);
            if (node.left != null) {
                deque.push(node.left);
            }
            if (node.right != null) {
                deque.push(node.right);
            }
        }
        Collections.reverse(list);
        return list;
    }

    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        if(root==null)
            return list;
        Deque<TreeNode> deque=new LinkedList<>();
        deque.push(root);
        while(!deque.isEmpty()){
            TreeNode pop = deque.pop();
            list.add(pop.val);
            if(pop.left!=null)
                deque.push(pop.left);
            if(pop.right!=null)
                deque.push(pop.right);
        }
        Collections.reverse(list);
        return list;
    }

    //迭代遍历复习
    public List<Integer> postorderTraversal3(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        if(root==null)
            return result;
        Deque<TreeNode> deque =new LinkedList<>();
        deque.push(root);
        while(!deque.isEmpty()){
            TreeNode node = deque.pop();
            result.add(node.val);
            if(node.left!=null)
                deque.push(node.left);
            if(node.right!=null)
                deque.push(node.right);
        }
        Collections.reverse(result);
        return result;
    }
    public static void main(String[] args) {
//        Integer[] root = {1,null,2,3};
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(7);
        root.left = node1;
        node1.left = node2;
        node1.right = node3;
        root.right = node4;
        node4.left = node5;
        node4.right = node6;

        List<Integer> list = new Solution2().postorderTraversal(root);
        System.out.println(list);
    }
}
