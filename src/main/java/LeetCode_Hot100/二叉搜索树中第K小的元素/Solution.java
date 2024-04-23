package LeetCode_Hot100.二叉搜索树中第K小的元素;

import 代码随想录.二叉树.TreeNode;

import java.time.LocalDate;

public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        return middleTraverse(root, k);
    }
    int count=0;
    private int middleTraverse(TreeNode root, int k) {
        if (count!=k && root.left != null) {
            int value = middleTraverse(root.left, k);
            if (value != 10001)
                return value;
        }
        count++;
        if (k == count) {
            return root.val;
        }
        if (count!=k && root.right != null) {
            return middleTraverse(root.right, k);
        }
        return 10001;
    }

    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        String s = now.toString();
        s+=" 00:00:00";
        System.out.println(s);
    }
}
