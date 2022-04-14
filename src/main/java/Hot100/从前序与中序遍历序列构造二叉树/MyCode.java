package Hot100.从前序与中序遍历序列构造二叉树;

import 树.遍历.TraverseUtil;
import 树.TreeNode;

import java.util.HashSet;
import java.util.Set;

/*
* 输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
输出: [3,9,20,null,null,15,7]

*
* 1.根据前序数组，根节点：3
* 2.根据中序数组，左子树  9，右子树：15,20,7
* 3.处理左子树：
*       根据前序数组，根节点的后面就是左子树的根节点，9，左子树的其余节点都是9的子节点
*  4. 处理右子树：
*       根据前序数组，根节点后面遍历完了左子树的之后，第一个就是右子树的根节点，20，除了20其他的都是20的子节点
* */


/*
* 写了半天，老是不对，看来我还是没有理解透彻
* */
//×
public class MyCode {
    public static void main(String[] args) {
//        int[] preorder={3,9,20,15,7};
//        int[] inorder={9,3,15,20,7};
        int[] preorder={1,2,4,7,5,3,6};
        int[] inorder={7,4,2,5,1,3,6};
        TreeNode treeNode = new MyCode().buildTree(preorder, inorder);
        TraverseUtil.preTraverse(treeNode);
        System.out.println();
        TraverseUtil.midTraverse(treeNode);
        System.out.println();
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode node = new TreeNode();
        node.val=preorder[0];
        buildTree2(preorder,inorder,node,0,0,inorder.length-1);
        return node;
    }

    private void buildTree2(int[] preorder, int[] inorder, TreeNode node,int preIndex,int left,int right) {
        if(node==null)
            return;
        if(left>right)
            return;
        int i;
        Set<Integer> leftSet=new HashSet<>();
        for (i = left; i <= right; i++) {
            if(inorder[i]==node.val)
                break;
            leftSet.add(inorder[i]);
        }

        preIndex++;
        if(!leftSet.isEmpty()) {
            if (preIndex < preorder.length) {
                TreeNode leftNode = new TreeNode(preorder[preIndex]);

                buildTree2(preorder, inorder, leftNode, preIndex, left, i - 1);
                node.left = leftNode;
            }
        }
        if(preorder[i]==node.val)
            i++;
        if(i<=right) {
            if(!leftSet.isEmpty()) {
                while (leftSet.contains(preorder[preIndex])) {
                    preIndex++;
                }
            }
            TreeNode rightNode = new TreeNode(preorder[preIndex]);
            buildTree2(preorder, inorder, rightNode, preIndex, i + 1, right);
            node.right = rightNode;
        }
    }
}
