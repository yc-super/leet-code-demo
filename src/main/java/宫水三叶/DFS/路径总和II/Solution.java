package 宫水三叶.DFS.路径总和II;

import 代码随想录.二叉树.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
//        TreeNode root = new TreeNode(5);
//        TreeNode r1 = new TreeNode(1);
//        TreeNode r2 = new TreeNode(2);
//        root.left=r1;
//        root.right=r2;
//        System.out.println(new Solution().pathSum(root,7));
    }
    List<List<Integer>> ans;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ans = new ArrayList<>();
        if(root==null)
            return ans;
        myDFS(root, targetSum, 0, new ArrayList<>());
        return ans;
    }

    private void myDFS(TreeNode root, int targetSum, int total, List<Integer> list) {
        total += root.val;
        list.add(root.val);
        if (root.left == null && root.right == null) {
            if (total == targetSum) {
                ans.add(new ArrayList<>(list));
            }
            return;
        }

        if (root.left != null) {
            myDFS(root.left, targetSum, total, list);
            list.remove(list.size() - 1);
//            total -= root.val;
        }
        if (root.right != null) {
            myDFS(root.right, targetSum, total, list);
            list.remove(list.size() - 1);
        }
    }
}
