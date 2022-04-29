package Hot100.对称二叉树;

import 树.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class MyCode {
    public static void main(String[] args) {

    }
    public boolean isSymmetric(TreeNode root) {
//        return isSymmetric2(root.left,root.right);
        return isSymmetric3(root.left,root.right);
    }

    //递归
    private boolean isSymmetric2(TreeNode left, TreeNode right) {
        if(left==null&&right==null)
            return true;
        if(left==null)
            return false;
        if(right==null)
            return false;
        if(left.val==right.val) {
            if(isSymmetric2(left.left,right.right)){
                return isSymmetric2(left.right,right.left);
            }
        }
        return false;
    }
    //迭代，所谓迭代，就是while循环
    private boolean isSymmetric3(TreeNode left, TreeNode right) {
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(left);
        queue.offer(right);
        while(!queue.isEmpty()){
            left= queue.poll();
            right=queue.poll();

            if(left==null&&right==null)
                continue;
            if(left==null||right==null||left.val!=right.val)
                return false;

            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);
        }
        return true;
    }
}
