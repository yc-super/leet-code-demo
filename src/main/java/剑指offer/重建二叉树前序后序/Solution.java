package 剑指offer.重建二叉树前序后序;

import 代码随想录.二叉树.TreeNode;
import 代码随想录.二叉树.TreeNodeUtils;

// 考察对二叉树的理解程度，以及编码能力（递归）
public class Solution {
    public static void main(String[] args) {
//        TreeNode treeNode1 = new Solution().buildTree(new int[]{1, 2, 4, 5, 3, 6, 7}, new int[]{4, 5, 2, 6, 7, 3, 1});
        TreeNode treeNode1 = new Solution().buildTree(new int[]{2,1,3}, new int[]{3,1,2});
        System.out.println();
    }

    public TreeNode buildTree(int[] preorder, int[] postorder) {
        if (preorder.length == 1)
            return new TreeNode(preorder[0]);
        TreeNode root = new TreeNode(preorder[0]);
        buildTree(root, preorder, postorder, 0, preorder.length - 1, 0, postorder.length - 1);
        return root;
    }

    private void buildTree(TreeNode root, int[] preorder, int[] postorder, int left1, int right1, int left2, int right2) {
        if (left1 >= right1 || left2 >= right2)
            return;

        root.left = new TreeNode(preorder[left1 + 1]);
        if(preorder[left1 + 1]==postorder[right2 - 1]) {
            root.right = null;
        }else {
            root.right = new TreeNode(postorder[right2 - 1]);
        }

        // 在post找到preorder[left1+1]的位置middle
        int middle = 0;
        for (int i = left2; i <= right2; i++) {
            if (postorder[i] == preorder[left1 + 1]) {
                middle = i;
                break;
            }
        }
        int leftLen = middle - left2;
        buildTree(root.left, preorder, postorder, left1 + 1, left1 + 1 + leftLen, left2, middle);
        if(root.right!=null){
        buildTree(root.right, preorder, postorder, left1 + 1 + leftLen + 1, right1, middle + 1, right2 - 1);
        }
    }
}
