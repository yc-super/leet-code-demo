package Hot100.二叉树的最大深度;

import 树.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MyCode {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        int i = new MyCode().maxDepth(treeNode);
        System.out.println(i);
    }
    //方法1，维护一个全局变量记录最大深度，深度优先搜索
   /* public int maxDepth(TreeNode root) {
        if(root==null)
            return 0;
        findMaxDepth(root,1);
        return max;
    }
    int max=1;
    private void findMaxDepth(TreeNode root, int i) {
        if(root.left==null&&root.right==null) {
            max=Math.max(max,i);
            return ;
        }
        i++;
        if(root.left!=null)
            findMaxDepth(root.left,i);
        if(root.right!=null)
            findMaxDepth(root.right,i);
    }*/
    
    //方法2，维护一个全局变量记录最大深度，广度优先搜索
    
   public int maxDepth(TreeNode root) {
       if(root==null)
           return 0;
       int ans=0;
       Queue<TreeNode> queue=new LinkedList<>();
       queue.offer(root);
       int size;
       while (!queue.isEmpty()){
           size=queue.size();
           while(size>0){
               size--;
               TreeNode node = queue.poll();
               if(node.left!=null)
                   queue.offer(node.left);
               if(node.right!=null)
                   queue.offer(node.right);
           }
           ans++;
       }
       return ans;
   }

}
