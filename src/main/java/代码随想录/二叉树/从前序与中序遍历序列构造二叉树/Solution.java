package 代码随想录.二叉树.从前序与中序遍历序列构造二叉树;

import 代码随想录.二叉树.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map=new HashMap<>();
        int index=0;
        for(int num:inorder){
            map.put(num,index++);
        }
        int len=inorder.length-1;
        return beginBuildTree(preorder,inorder,0,len,0,len);
    }

    private TreeNode beginBuildTree(int[] preorder, int[] inorder, int left1, int right1, int left2, int right2) {
        /*
        preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
        * */
        if(left1>right1||left2>right2){
            return null;
        }

        TreeNode root=new TreeNode(preorder[left1]);
        int index=map.get(preorder[left1]);

        root.left=beginBuildTree(preorder,inorder,left1+1,left1+1+index-1-left2,left2,index-1);
        root.right=beginBuildTree(preorder,inorder,left1+1+index-1-left2+1,right1,index+1,right2);

        return root;
    }

    private Map<Integer,Integer> map;
}
