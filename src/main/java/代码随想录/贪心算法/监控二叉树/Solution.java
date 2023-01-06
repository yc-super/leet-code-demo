package 代码随想录.贪心算法.监控二叉树;

import 代码随想录.二叉树.TreeNode;
import 代码随想录.二叉树.TreeNodeUtils;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
//        Integer[] nodes={0,3,4,5,6,7,8,9,10,11};
        Integer[] nodes={0,0,0,0,0,0,0,0,0};
        TreeNode root = TreeNodeUtils.getTreeNode(nodes);

        System.out.println(new Solution().minCameraCover(root));
    }

    //思路：有叶子节点的节点，一定需要一个摄像头，然后，将该节点从树上移除。不断重复该过程，直到所有有叶子节点的节点都有摄像头
    public int minCameraCover2(TreeNode root) {
        if(root.left==null&&root.right==null)
            return 1;
        getMinCameraCover2(root);
        return result;
    }

    //失败了
    private TreeNode getMinCameraCover2(TreeNode root) {
        if(root.left!=null)
            root.left = getMinCameraCover2(root.left);

        if(root.right!=null)
            root.right = getMinCameraCover2(root.right);


        if(root.left==null&&root.right==null){
            //左右孩子都为空
            //不用装监控
        }else if(root.left==null&&root.right!=null){
            //左孩子为空，右孩子不为空
            if(root.right.val==1){
                //只有1个孩子，并且该孩子被安装了监控，该节点不用装监控
            }else{
                //只有1个孩子，并且该孩子没有被安装监控，该节点需要装监控
                root.val=1;
                result++;
                return root;
            }
            if(root.right.left==null&&root.right.right==null){
                //左孩子的孩子都为空，或者右孩子的孩子都为空，也就是倒数第二层，该节点需要安装监控
                root.val=1;
                result++;
                return root;
            }
        }else if(root.left!=null&&root.right==null){
            //左孩子不为空，右孩子为空
            if(root.left.val==1){
                //只有1个孩子，并且该孩子被安装了监控，该节点不用装监控
            }else{
                //只有1个孩子，并且该孩子没有被安装监控，该节点需要装监控
                root.val=1;
                result++;
                return root;
            }
            if(root.left.left==null&&root.left.right==null){
                //左孩子的孩子都为空，或者右孩子的孩子都为空，也就是倒数第二层，该节点需要安装监控
                root.val=1;
                result++;
                return root;
            }
        }else{
            //左右孩子都不为空
            if(root.left.val==1&&root.right.val==1){
                //左右孩子都被装了监控，该节点不用装监控
            }
            if(root.left.val==0&&root.right.val==0){
                //左右孩子都没安装监控，该节点需要安装监控
                root.val=1;
                result++;
                return root;
            }
            if((root.right.left==null&&root.right.right==null)||(root.left.left==null&&root.left.right==null)){
                //左孩子的孩子都为空，或者右孩子的孩子都为空，也就是倒数第二层，该节点需要安装监控
                root.val=1;
                result++;
                return root;
            }
        }

        return root;
    }

    int result = 0;

    public int minCameraCover(TreeNode root) {
        if(minCame(root)==0){
            result++;
        }
        return result;
    }

    //叶子节点的父节点放一个监控，然后每隔两层放监控
    public int minCame(TreeNode root){
        if(root==null){
            return 2;
        }
        int left=minCame(root.left);
        int right=minCame(root.right);

        if(left==0||right==0){
            result++;
            return 1;
        }else if(left==1||right==1){
            return 2;
        }else{
            //left==2&&right==2
            return 0;
        }

//        if(left==2&&right==2){
//            return 0;
//        }else if(left==0||right==0){
//            result++;
//            return 1;
//        }else{
//            return 2;
//        }
    }
}
