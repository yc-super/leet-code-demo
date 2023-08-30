package 代码随想录.二叉树.层序遍历.二叉树的最大深度;

import 代码随想录.二叉树.TreeNode;

import java.util.*;

public class Solution2 {
    public int maxDepth(TreeNode root) {
        int result = 0;
        if (root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- != 0) {
                TreeNode node = queue.poll();
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            result++;
        }
        return result;
    }
}
