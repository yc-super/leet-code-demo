package 宫水三叶.BFS.恢复二叉搜索树;

import 代码随想录.二叉树.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(2);
        n2.right = n3;
        n1.left = n2;
        new Solution().recoverTree(n1);
        System.out.println();
    }

    // 三叶姐的题解
    TreeNode a = null, b = null, last = null;

    public void recoverTree(TreeNode root) {
        dfs(root);
        int val = a.val;
        a.val = b.val;
        b.val = val;
    }

    private void dfs(TreeNode root) {
        if (root == null)
            return;
        dfs(root.left);
        if (last != null && last.val > root.val) {
            if (a == null) {
                a = last;
                b = root;
            } else {
                b = root;
            }
        }
        last=root;// 把当前节点赋值给上一个节点
        dfs(root.right);
    }

    // 321
    // 1324
    // -33,321,55,71,146,231,-13,399
    // -33,321,55,71,146,231,-13,232
    // 我的题解，利用二叉搜索树中序遍历贪心
    public void recoverTree22(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        leftTrack(root, list);
        list.add(Integer.MAX_VALUE);
        // 寻找list中第一个降序的节点，以及接下来第二个降序的节点
        int a1, a2;
        int index = 0;
        int pre = Integer.MIN_VALUE;
        while (list.get(index) >= pre) {
            pre = list.get(index);
            index++;
        }
        a1 = pre;
        while (list.get(index) <= a1) {
            pre = list.get(index);
            index++;
        }
        a2 = pre;
        // 将a1和a2交换值
        leftTrackForValue(root, a1, a2, true, true);
    }

    private boolean leftTrackForValue(TreeNode root, int a, int a2, boolean b1, boolean b2) {
        if (root == null)
            return false;
        boolean bb = leftTrackForValue(root.left, a, a2, b1, b2);
        if (bb) {
            return true;
        }
        if (!b1 && !b2) {
            return true;
        }

        boolean flag = false;
        if (b1) {
            if (root.val == a) {
                root.val = a2;
                b1 = false;
                flag = true;
            }
        }
        if (b2 && !flag) {
            if (root.val == a2) {
                root.val = a;
                b2 = false;
            }
        }
        boolean cc = leftTrackForValue(root.right, a, a2, b1, b2);
        if (cc) {
            return true;
        }
        return false;
    }

    private void leftTrack(TreeNode root, List<Integer> list) {
        if (root == null)
            return;
        leftTrack(root.left, list);
        list.add(root.val);
        leftTrack(root.right, list);
    }
}
