package 代码随想录.二叉树.层序遍历.二叉树的最小深度;

import 代码随想录.二叉树.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {

    public int minDepth(TreeNode root) {
        int result = 0;
        if (root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            result++;
            while (size-- != 0) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null)
                    return result;
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
        }
        return result;
    }
}
