package LeetCode_Hot100.二叉树的层序遍历;

import 树.TreeNode;

import java.util.ArrayList;
import java.util.List;
//思路：遍历一遍，遍历过程中维护一个i变量，用于记录层数，再维护一个list遍历，保存数据
public class MyCode {
    public static void main(String[] args) {
        TreeNode node=new TreeNode(5,new TreeNode(0,new TreeNode(-2,new TreeNode(-4),new TreeNode(-1)),new TreeNode(3,new TreeNode(2),new TreeNode(4))),new TreeNode(10,new TreeNode(7,new TreeNode(6),new TreeNode(8)),new TreeNode(12,new TreeNode(11),new TreeNode(13))));
//        TreeNode node=new TreeNode(2,new TreeNode(1),null);
//        TreeNode node=new TreeNode(1,null,null);
//        TreeNode node=null;
        List<List<Integer>> lists = new MyCode().levelOrder(node);
        System.out.println(lists);
    }
    List<List<Integer>> lists;
    public List<List<Integer>> levelOrder(TreeNode root) {
        lists=new ArrayList<>();
        traveNode(root,1);
        return lists;
    }

    private void traveNode(TreeNode root, int i) {
        if(root==null)
            return;
        if(lists.size()<i){
            ArrayList<Integer> arrayList = new ArrayList<>();
            arrayList.add(root.val);
            lists.add(arrayList);
        }else {
            lists.get(i-1).add(root.val);
        }
        ++i;
        traveNode(root.left,i);
        traveNode(root.right,i);
    }
}

