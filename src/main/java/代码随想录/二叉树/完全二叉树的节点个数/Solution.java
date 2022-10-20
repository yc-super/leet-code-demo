package 代码随想录.二叉树.完全二叉树的节点个数;

import 代码随想录.二叉树.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    //1.按照普通二叉树来处理
    //递归
    public int countNodes(TreeNode root) {
        countNodes1(root);
        return result;
    }

    private int result=0;
    private void countNodes1(TreeNode root) {
        if(root==null)
            return ;
        result++;
        countNodes1(root.left);
        countNodes1(root.right);
    }
    private int countNodes2(TreeNode root) {
        if(root==null)
            return 0;
        int r1 = countNodes2(root.left);
        int r2 = countNodes2(root.right);

        return r1+r2+1;
    }

    //迭代
    public int countNodes3(TreeNode root) {
        if(root==null)
            return 0;
        Deque<TreeNode> deque=new LinkedList<>();
        deque.push(root);
        int result=0;
        while(!deque.isEmpty()){
            TreeNode node = deque.pop();
            result++;
            if(node.right!=null)
                deque.push(node.right);
            if(node.left!=null)
                deque.push(node.left);
        }
        return result;
    }

    //按照完全二叉树处理，递归
    public int countNodes4(TreeNode root) {
        //出口
        if(root==null)
            return 0;
        int leftDetph=0;
        int rightDetpth=0;
        TreeNode left=root.left;
        TreeNode right=root.right;
        while(left!=null) {
            left = left.left;
            leftDetph++;
        }
        while(right!=null) {
            right = right.right;
            rightDetpth++;
        }

        if(leftDetph==rightDetpth){
            return (2<<leftDetph)-1;
        }

        return countNodes4(root.left)+countNodes4(root.right)+1;

    }
    public int countNodes5(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        if (leftDepth == rightDepth) {// 左子树是满二叉树
            // 2^leftDepth其实是 （2^leftDepth - 1） + 1 ，左子树 + 根结点
            return (1 << leftDepth) + countNodes5(root.right);
        } else {// 右子树是满二叉树
            return (1 << rightDepth) + countNodes5(root.left);
        }
    }

    private int getDepth(TreeNode root) {
        int depth = 0;
        while (root != null) {
            root = root.left;
            depth++;
        }
        return depth;
    }
}
