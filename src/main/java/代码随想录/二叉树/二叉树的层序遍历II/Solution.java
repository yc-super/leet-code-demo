package 代码随想录.二叉树.二叉树的层序遍历II;

import 代码随想录.二叉树.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
//思路：二叉树的程序遍历，把结果result反转下就行了
public class Solution {
    List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
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
            }
        }
        return result;
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
}
