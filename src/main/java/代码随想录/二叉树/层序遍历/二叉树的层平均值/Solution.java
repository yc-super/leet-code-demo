package 代码随想录.二叉树.层序遍历.二叉树的层平均值;

import 代码随想录.二叉树.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        List<Double> lists = new Solution().averageOfLevels(root);
        System.out.println(lists);
    }
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result=new ArrayList<>();
        if(root==null)
            return result;

        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        int len,temp_len;
        double sum;
        while(!queue.isEmpty()){
            sum=0;
            len=queue.size();
            temp_len=len;
            while(len>0){
                TreeNode node = queue.poll();
                sum+=node.val;
                if(node.left!=null)
                    queue.offer(node.left);
                if(node.right!=null)
                    queue.offer(node.right);

                len--;
            }
            result.add(sum/temp_len);
        }
        return result;
    }
}
