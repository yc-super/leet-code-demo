package 代码随想录.二叉树.找树左下角的值;

import 代码随想录.二叉树.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int result = root.val;
        while (!queue.isEmpty()) {
            int size = queue.size();
            result = queue.peek().val;
            while (size != 0) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
                size--;
            }
        }
        return result;
    }

    public int findBottomLeftValue2(TreeNode root) {
        find(root, 0);
        return res;
    }

    private int depth = -1;
    private int res = 0;

    private void find(TreeNode root, int dep) {
        if (root == null)
            return;
        if (dep > depth) {
            res = root.val;
            depth = dep;
        }
        find(root.left, dep + 1);
        find(root.right, dep + 1);
    }
}
