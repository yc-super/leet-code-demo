package 代码随想录.二叉树.从中序与后序遍历序列构造二叉树;

import sun.reflect.generics.tree.Tree;
import 代码随想录.二叉树.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
//        int[] inorder={9,3,15,20,7};
//        int[] postorder={9,15,7,20,3};
        int[] inorder = {4, 1, 5, 9, 6, 2, 8, 3, 15, 20, 7};
        int[] postorder = {4, 5, 1, 6, 8, 2, 9, 15, 7, 20, 3};
//        int[] inorder={2,1};
//        int[] postorder={2,1};
//        int[] inorder={1,2,3,4};
//        int[] postorder={3,2,4,1};
        TreeNode treeNode = new Solution().buildTree2(inorder, postorder);
        System.out.println();
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int right = postorder.length - 1;
        return getTree(inorder, postorder, 0, right, 0, right);
    }

    private TreeNode getTree(int[] inorder, int[] postorder, int left, int right, int left1, int right2) {
        if (left == right) {
            return new TreeNode(inorder[left]);
        }

        TreeNode root = new TreeNode(postorder[right2]);
        int root_index;
        for (root_index = left; root_index <= right; root_index++) {
            if (inorder[root_index] == postorder[right2])
                break;
        }
        if (root_index - 1 < left) {
            root.left = null;
        } else {
            root.left = getTree(inorder, postorder, left, root_index - 1, left1, left1 + (root_index - 1 - left));
        }
        if (right < root_index + 1) {
            root.right = null;
        } else {
            root.right = getTree(inorder, postorder, root_index + 1, right, left1 + (root_index - 1 - left) + 1, left1 + (root_index - 1 - left) + 1 + (right - (root_index + 1)));
        }

        return root;
    }

    //用map优化了下
    public TreeNode buildTree2(int[] inorder, int[] postorder) {
        map = new HashMap<>();
        int index = 0;
        for (int num : inorder) {
            map.put(num, index++);
        }
        int len = inorder.length - 1;
        return beginBuildTree(inorder, postorder, 0, len, 0, len);
    }

    private Map<Integer, Integer> map;

    private TreeNode beginBuildTree(int[] inorder, int[] postorder, int left1, int right1, int left2, int right2) {
        if (left1 > right1)
            return null;

        TreeNode root = new TreeNode(postorder[right2]);

        int index = map.get(postorder[right2]);
       /* for (index = left1; index <= right1; index++) {
            if(inorder[index]==postorder[right2])
                break;
        }*/

        root.left = beginBuildTree(inorder, postorder, left1, index - 1, left2, left2 + index - 1 - left1);
        root.right = beginBuildTree(inorder, postorder, index + 1, right1, left2 + index - left1, left2 - left1 + right1 - 1);

        return root;
    }
}
