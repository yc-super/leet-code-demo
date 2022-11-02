package 代码随想录.二叉树.二叉搜索树的最近公共祖先;

import 代码随想录.二叉树.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    //思路：和 二叉树的最近公共祖先 一样的思路，先遍历两遍，找到p和q的路径，然后倒序比较两个路径。由于是二叉搜索树，找路径会更快
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode temp=root;
        List<TreeNode> pList=getList(temp,p);
        temp=root;
        List<TreeNode> qList=getList(temp,q);
        for (int i = pList.size()-1; i >=0; i--) {
            if(qList.contains(pList.get(i))){
                return pList.get(i);
            }
        }
        return null;
    }

    private List<TreeNode> getList(TreeNode temp, TreeNode p) {
        List<TreeNode> result=new ArrayList<>();
        while(temp!=p){
            result.add(temp);
            if(p.val>temp.val){
                temp=temp.right;
            }else if(p.val<temp.val){
                temp=temp.left;
            }else{
                break;
            }
        }
        result.add(p);
        return result;
    }

    //”二叉树的最近公共祖先”的递归法，二叉搜索树的性质用的不完全
    public TreeNode lowestCommonAncestor4(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null||root==p||root==q){
            return root;
        }

        TreeNode node1 =null;
        TreeNode node2 =null;
        if(root.val>p.val||root.val>q.val) {
            node1 = lowestCommonAncestor4(root.left, p, q);
        }
        if(root.val<p.val||root.val<q.val) {
            node2 = lowestCommonAncestor4(root.right, p, q);
        }

        if(node1==null&&node2==null){
            return null;
        }else if(node1==null){
            return node2;
        }else if(node2==null){
            return node1;
        }else{
            return root;
        }
    }

    //代码随想录递归法，太精妙了！
    public TreeNode lowestCommonAncestor5(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val>p.val&&root.val>q.val){
            return lowestCommonAncestor5(root.left,p,q);
        }
        if(root.val<p.val&&root.val<q.val){
            return lowestCommonAncestor5(root.right,p,q);
        }
        return root;
    }
}
