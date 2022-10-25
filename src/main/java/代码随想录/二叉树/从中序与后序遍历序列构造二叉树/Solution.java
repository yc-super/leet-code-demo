package 代码随想录.二叉树.从中序与后序遍历序列构造二叉树;

import sun.reflect.generics.tree.Tree;
import 代码随想录.二叉树.TreeNode;

public class Solution {
    public static void main(String[] args) {
//        int[] inorder={9,3,15,20,7};
//        int[] postorder={9,15,7,20,3};
//        int[] inorder={4,1,5,9,6,2,8,3,15,20,7};
//        int[] postorder={4,5,1,6,8,2,9,15,7,20,3};
//        int[] inorder={2,1};
//        int[] postorder={2,1};
        int[] inorder={1,2,3,4};
        int[] postorder={3,2,4,1};
        TreeNode treeNode = new Solution().buildTree(inorder, postorder);
        System.out.println();
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int right=postorder.length-1;
        return getTree(inorder,postorder,0,right,0,right);
    }

    private TreeNode getTree(int[] inorder, int[] postorder, int left, int right,int left1,int right2) {
        if(left==right) {
            return new TreeNode(inorder[left]);
        }

        TreeNode root=new TreeNode(postorder[right2]);
        int root_index;
        for (root_index = left; root_index <=right ; root_index++) {
            if(inorder[root_index]==postorder[right2])
                break;
        }
        if(root_index-1<left){
            root.left=null;
        }else {
            root.left = getTree(inorder, postorder, left, root_index - 1, left1,left1+(root_index-1-left));
        }
        if(right<root_index+1){
            root.right=null;
        } else {
            root.right = getTree(inorder, postorder, root_index + 1, right, left1+(root_index-1-left)+1,left1+(root_index-1-left)+1+(right-(root_index+1)));
        }

        return root;
    }
}
