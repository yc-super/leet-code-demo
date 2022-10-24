package 代码随想录.二叉树.找树左下角的值;

import 代码随想录.二叉树.TreeNode;
import 代码随想录.二叉树.TreeNodeUtils;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
         Integer[] nodes={1,2,3,4,null,5,6,null,null,null,null,7};
        TreeNode root = TreeNodeUtils.getTreeNode(nodes);

        System.out.println(new Solution().findBottomLeftValue2(root));
    }
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        int result=0;
        while(!queue.isEmpty()){
            int size = queue.size();
            result=queue.peek().val;

            while(size!=0){
                TreeNode node = queue.poll();
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
                size--;
            }
        }
        return result;
    }

    //代码随想录，递归
    public int findBottomLeftValue2(TreeNode root) {
        findBottomLeftValue3(root,1);
        return result;
    }

    int result=0;
    int max_depth=0;

    private void findBottomLeftValue3(TreeNode root,int depth) {
        if(root.left==null&&root.right==null){
            if(max_depth<depth) {
                max_depth = depth;
                result=root.val;
            }
        }
        if(root.left!=null)
        findBottomLeftValue3(root.left,depth+1);
        if(root.right!=null)
        findBottomLeftValue3(root.right,depth+1);

    }


}
