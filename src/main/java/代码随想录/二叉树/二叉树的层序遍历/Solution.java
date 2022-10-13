package 代码随想录.二叉树.二叉树的层序遍历;

import sun.reflect.generics.tree.Tree;
import 代码随想录.二叉树.TreeNode;
import 代码随想录.链表专练.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(9,new TreeNode(10),new TreeNode(11)), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
//        TreeNode root = new TreeNode(1);
        List<List<Integer>> lists = new Solution().levelOrder3(root);
        System.out.println(lists);
    }

    List<List<Integer>> result=new ArrayList<>();

    public List<List<Integer>> levelOrder1(TreeNode root) {
        //DFS 递归遍历
//        checkFun0(root,0);
        //BFS 迭代方式，借助队列
        checkFun1(root);

        if(result.size()>0){
            int left=0;
            int right=result.size()-1;
            List<Integer> temp;
            while(right>left){
                temp=result.get(left);
                result.set(left,result.get(right));
                result.set(right,temp);

                left++;
                right--;
            }
        }

        return result;
    }

    private void checkFun0(TreeNode root, int deep) {
        if(root==null)
            return;
        deep++;
        if(result.size()<deep){
            List<Integer> list=new ArrayList<>();
            result.add(list);
        }
        result.get(deep-1).add(root.val);

        checkFun0(root.left,deep);
        checkFun0(root.right,deep);
    }

    public void checkFun1(TreeNode root) {
        if(root==null)
            return;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        int len;
        while(!queue.isEmpty()){
            len=queue.size();
            List<Integer> list=new ArrayList<>();
            while(len>0){
                TreeNode node = queue.poll();
                list.add(node.val);

                if(node.left!=null)
                    queue.offer(node.left);
                if(node.right!=null)
                    queue.offer(node.right);

                len--;
            }
            result.add(list);
        }
    }

    //思路：维护一个list,用于记录每层的节点，等记录完它们的val后，记录它们的左右节点，并清除之前的节点
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        if(root==null)
            return result;
        List<TreeNode> nodeList=new ArrayList<>();
        List<TreeNode> temp=new ArrayList<>();
        nodeList.add(root);
        while(nodeList.size()!=0){
            List<Integer> list=new ArrayList<>();
            for(TreeNode node:nodeList){
                list.add(node.val);
            }
            result.add(list);
            temp.clear();
            for(TreeNode node:nodeList){
                if(node.left!=null)
                    temp.add(node.left);
                if(node.right!=null)
                    temp.add(node.right);
            }
            nodeList.clear();
            nodeList.addAll(temp);
        }
        return result;
    }

    //递归遍历复习
    public List<List<Integer>> levelOrder3(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        if(root==null)
            return result;
        checkFun3(root,0,result);
        return result;
    }

    private void checkFun3(TreeNode root, int deep, List<List<Integer>> result) {

        if(root==null)
            return;

        deep++;

        if(result.size()<deep){
            List<Integer> list=new ArrayList<>();
            result.add(list);
        }
        checkFun3(root.left,deep,result);
        //中序遍历，同时记录层数，即可层数遍历
        result.get(deep-1).add(root.val);
        checkFun3(root.right,deep,result);
    }

    //迭代遍历复习
    public List<List<Integer>> levelOrder4(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        if(root==null)
            return result;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        int len;
        while(!queue.isEmpty()){
            List<Integer> list=new ArrayList<>();
            len=queue.size();
            while(len>0){
                TreeNode node = queue.poll();
                list.add(node.val);

                if(node.left!=null)
                    queue.offer(node.left);
                if(node.right!=null)
                    queue.offer(node.right);

                len--;
            }
            result.add(list);
        }
        return result;
    }
}
