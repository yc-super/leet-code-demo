package LeetCode_Hot100.二叉树的层序遍历;

import 树.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class bfs {
    public static void main(String[] args) {
        TreeNode node=new TreeNode(5,new TreeNode(0,new TreeNode(-2,new TreeNode(-4),new TreeNode(-1)),new TreeNode(3,new TreeNode(2),new TreeNode(4))),new TreeNode(10,new TreeNode(7,new TreeNode(6),new TreeNode(8)),new TreeNode(12,new TreeNode(11),new TreeNode(13))));
//        TreeNode node=new TreeNode(2,new TreeNode(1),null);
//        TreeNode node=new TreeNode(1,null,null);
//        TreeNode node=null;
        new bfs().bfs(node);
    }
    void bfs(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll(); // Java 的 pop 写作 poll()
            System.out.println(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }
}
