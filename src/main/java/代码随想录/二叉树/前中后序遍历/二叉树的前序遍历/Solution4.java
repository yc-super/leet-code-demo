package 代码随想录.二叉树.前中后序遍历.二叉树的前序遍历;

import 代码随想录.二叉树.TreeNode;

import java.util.*;

public class Solution4 {
    public void pre(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        if (root != null)
            stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.println(node);
            if (node.right != null)
                stack.push(node.right);
            if (node.left != null)
                stack.push(node.left);
        }
    }


    public void middle(TreeNode root) {
        TreeNode temp = root;
        Stack<TreeNode> stack = new Stack<>();
        while (temp != null || !stack.isEmpty()) {
            if (temp != null) {
                stack.push(temp);
                temp = temp.left;
            } else {
                temp = stack.pop();
                System.out.println(temp.val);
                temp = temp.right;
            }
        }
    }

    public void post(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result=new ArrayList<>();
        if (root != null)
            stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if(node.left!=null){
                stack.push(node.left);
            }
            if(node.right!=null){
                stack.push(node.right);
            }
        }
        Collections.reverse(result);
    }
}
