package 代码随想录.二叉树.层序遍历.二叉树的最大深度;

import 代码随想录.二叉树.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int maxDepth(TreeNode root) {
        if(root==null)
            return 0;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        int len;
        int result=0;
        while(!queue.isEmpty()){
            result++;

            len=queue.size();

            while(len>0){
                TreeNode node = queue.poll();

                if(node.left!=null)
                    queue.offer(node.left);
                if(node.right!=null)
                    queue.offer(node.right);

                len--;
            }
        }
        return result;
    }
}
