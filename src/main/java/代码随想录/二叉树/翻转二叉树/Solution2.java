package 代码随想录.二叉树.翻转二叉树;

import 代码随想录.二叉树.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution2 {
    // 不是中序遍历就行，中序遍历会重复翻转
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return root;
        TreeNode node = root.left;
        root.left = root.right;
        root.right = node;
        root.left = invertTree(root.left);
        root.right = invertTree(root.right);
        return root;
    }
}
