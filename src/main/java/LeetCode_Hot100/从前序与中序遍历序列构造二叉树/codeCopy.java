package LeetCode_Hot100.从前序与中序遍历序列构造二叉树;

import 树.TreeNode;
import 树.遍历.TraverseUtil;

import java.util.HashMap;
import java.util.Map;

public class codeCopy {

    public static void main(String[] args) {
//        int[] preorder={3,9,20,15,7};
//        int[] inorder={9,3,15,20,7};
        int[] preorder={1,2,4,7,5,3,6};
        int[] inorder={7,4,2,5,1,3,6};
        TreeNode treeNode = new codeCopy().buildTree(preorder, inorder);
        TraverseUtil.preTraverse(treeNode);
        System.out.println();
        TraverseUtil.midTraverse(treeNode);
        System.out.println();
    }
    Map<Integer,Integer> map=new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n=preorder.length;
        for (int i = 0; i < n; i++) {
            map.put(inorder[i],i);
        }
        return myBuildTree(preorder,0,n-1,0,n-1);
    }

    private TreeNode myBuildTree(int[] preorder, int preLeft, int preRight, int inLeft, int inRight) {
        if(preLeft>preRight)
            return null;
        //前序数组的第一个就是根节点
        int rootIndex=preLeft;
        TreeNode node = new TreeNode(preorder[rootIndex]);
        int in_root_index=map.get(preorder[rootIndex]);
        int left_count=in_root_index-inLeft;
        //左子树
        TreeNode leftNode = myBuildTree(preorder, preLeft + 1, preLeft + left_count, inLeft, in_root_index - 1);
        //右子树
        TreeNode rightNode = myBuildTree(preorder,preLeft+1+left_count,preRight,inLeft+left_count+1,inRight);
        node.left=leftNode;
        node.right=rightNode;
        return node;
    }
}
