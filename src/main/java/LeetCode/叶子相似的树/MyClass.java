package LeetCode.叶子相似的树;

import java.util.ArrayList;
import java.util.List;

/*
* 请考虑一棵二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。
* 举个例子，如上图所示，给定一棵叶值序列为(6, 7, 4, 9, 8)的树。

如果有两棵二叉树的叶值序列是相同，那么我们就认为它们是叶相似的。

如果给定的两个根结点分别为root1 和root2的树是叶相似的，则返回true；否则返回 false 。
*
* 输入：root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
输出：true
*
* 输入：root1 = [1], root2 = [1]
输出：true
*
* 输入：root1 = [1], root2 = [2]
输出：false
*
* 输入：root1 = [1,2], root2 = [2,2]
输出：true
* */
public class MyClass {
    public static void main(String[] args) {
        //中序遍历一次，遍历时判断是否有子节点，如果没有子节点则为叶子，并且按照从左到右的顺序排序
        //如果有子节点，则认为它的父节点也有子节点，这样可以提高效率
        TreeNode tn1 = new TreeNode(3,new TreeNode(5,new TreeNode(6),new TreeNode(2,new TreeNode(7),new TreeNode(4))),new TreeNode(1,new TreeNode(9),new TreeNode(8)));
        TreeNode tn2 = new TreeNode(3,new TreeNode(5,new TreeNode(6),new TreeNode(2,new TreeNode(7),new TreeNode(4))),new TreeNode(1,new TreeNode(9),new TreeNode(8)));

        TreeNode tn3 = new TreeNode(1, new TreeNode(2),null);
        TreeNode tn4 = new TreeNode(2, new TreeNode(2),null);
//        qianxu(tn);
//        zhongxu(tn);
//        houxu(tn);
        boolean result = leafSimilar(tn3, tn4);
        System.out.println(result);

    }

    private static void findYezi(TreeNode tn,List list) {
        //利用中序遍历找叶子
        if(tn==null)
            return ;
        findYezi(tn.left,list);
//        System.out.println(tn.val);
        if(tn.left==null&&tn.right==null){
            list.add(tn.val);
        }
        findYezi(tn.right,list);
    }

    public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List list1=new ArrayList();
        List list2=new ArrayList();
        findYezi(root1,list1);
        findYezi(root2,list2);
       /* if(list1.size()!=list2.size())
            return false;
        for (int i = 0; i < list1.size(); i++) {
            if(list1.get(i)!=list2.get(i)){
                return false;
            }
        }*/
        return list1.equals(list2);
    }

    public static void qianxu(TreeNode root) {
        if(root==null)
            return;
        System.out.println(root.val);
        qianxu(root.left);
        qianxu(root.right);

    }
    public static void zhongxu(TreeNode root) {
        if(root==null)
            return;
        zhongxu(root.left);
        System.out.println(root.val);
        zhongxu(root.right);

    }
    public static void houxu(TreeNode root) {
        if(root==null)
            return;
        houxu(root.left);
        houxu(root.right);
        System.out.println(root.val);

    }

    //官方解法，利用dfs找叶子节点
    public static boolean leafSimilar2(TreeNode root1, TreeNode root2) {
        List<Integer> seq1 = new ArrayList<>();
        if (root1 != null) {
            dfs(root1, seq1);
        }

        List<Integer> seq2 = new ArrayList<>();
        if (root2 != null) {
            dfs(root2, seq2);
        }

        return seq1.equals(seq2);
    }
    public static void dfs(TreeNode node, List<Integer> seq) {
        if (node.left == null && node.right == null) {
            seq.add(node.val);
        } else {
            if (node.left != null) {
                dfs(node.left, seq);
            }
            if (node.right != null) {
                dfs(node.right, seq);
            }
        }
    }

}

