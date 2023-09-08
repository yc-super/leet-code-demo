package 代码随想录.二叉树.二叉搜索树中的众数;

import 代码随想录.二叉树.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    private TreeNode preNode = null;
    private Integer maxCount = 0;
    private Integer nowCount = 0;
    List<Integer> result = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        minimum(root);
        int[] res = new int[result.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = result.get(i);
        }
        return res;
    }

    private void minimum(TreeNode root) {
        if (root == null)
            return;
        minimum(root.left);

        if (preNode == null || root.val != preNode.val) {
            nowCount = 1;
        } else {
            nowCount++;
        }
        if (nowCount > maxCount) {
            result.clear();
            result.add(root.val);
            maxCount = nowCount;
        } else if (nowCount == maxCount) {
            result.add(root.val);
        }
        preNode = root;

        minimum(root.right);
    }
}
