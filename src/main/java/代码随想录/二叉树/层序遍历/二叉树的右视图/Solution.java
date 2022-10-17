package 代码随想录.二叉树.层序遍历.二叉树的右视图;

import 代码随想录.二叉树.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//思路 二叉树的程序遍历，只保存每一层的最后一个，可以通过size判断是否是最后一个
public class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        List<Integer> lists = new Solution().rightSideView(root);
        System.out.println(lists);
    }

    List<Integer> result=new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        //BFS 利用队列迭代遍历
        checkFun1(root);
        return result;
    }

    private void checkFun1(TreeNode root) {
        if(root==null)
            return;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        int len;
        while(!queue.isEmpty()){
            len=queue.size();
            while(len>0){
                TreeNode node = queue.poll();
                if(node.left!=null)
                    queue.offer(node.left);
                if(node.right!=null)
                    queue.offer(node.right);

                if(len==1){
                    result.add(node.val);
                }
                len--;
            }
        }
    }
}
