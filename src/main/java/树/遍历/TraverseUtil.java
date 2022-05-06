package 树.遍历;

import 树.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/*
*                                       5
*                   0                                       10
*           -2          3                           7               12
*        -4    -1    2     4                   6        8        11     13
*
*
* */
public class TraverseUtil {
    //前序遍历
    public static void preTraverse(TreeNode node){
        if(node==null)
            return;
        System.out.print(node.val+",");
        preTraverse(node.left);
        preTraverse(node.right);
    }

    //中序遍历
    public static void midTraverse(TreeNode node){
        if(node==null)
            return;
        if(node.left!=null){
            midTraverse(node.left);
        }
        System.out.print(node.val+",");
        if(node.right!=null){
            midTraverse(node.right);
        }
    }

    //后续遍历
    public static void postTraverse(TreeNode node){
        if(node==null)
            return;
        if(node.left!=null)
            postTraverse(node.left);
        if(node.right!=null)
            postTraverse(node.right);
        System.out.print(node.val+",");
    }

    //层序遍历
    public static void seqTraverse(TreeNode root){
        //使用了队列
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        TreeNode node;
        while(!queue.isEmpty()){
            node=queue.poll();
            System.out.print(node.val+",");
            if(node.left!=null)
                queue.add(node.left);
            if(node.right!=null)
                queue.add(node.right);
        }

    }

    public static void main(String[] args) {
//        TreeNode node=new TreeNode(5,new TreeNode(0,new TreeNode(-2,new TreeNode(-4),new TreeNode(-1)),new TreeNode(3,new TreeNode(2),new TreeNode(4))),new TreeNode(10,new TreeNode(7,new TreeNode(6),new TreeNode(8)),new TreeNode(12,new TreeNode(11),new TreeNode(13))));
        TreeNode node=new TreeNode(1,new TreeNode(2,new TreeNode(4,new TreeNode(7),null), new TreeNode(5)),new TreeNode(3,null,new TreeNode(6)));
        preTraverse(node);//1247536
        System.out.println();
        midTraverse(node);//7425136
//        postTraverse(node);//7452631
//        seqTraverse(node);//1234567
    }

}



