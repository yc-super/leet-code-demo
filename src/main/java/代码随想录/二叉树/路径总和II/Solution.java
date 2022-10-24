package 代码随想录.二叉树.路径总和II;

import 代码随想录.二叉树.TreeNode;
import 代码随想录.二叉树.TreeNodeUtils;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Integer[] nodes={5,4,8,11,null,13,4,7,2,null,null,null,null,5,1};
        TreeNode root = TreeNodeUtils.getTreeNode(nodes);
        System.out.println(new Solution().pathSum(root,22));
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;
        pathSum(root, targetSum, result, new ArrayList<>());
        return result;
    }

    private void pathSum(TreeNode root, int targetSum, List<List<Integer>> result, ArrayList<Integer> tempList) {
        tempList.add(root.val);
        targetSum -= root.val;
        if (root.left == null && root.right == null && targetSum == 0) {
            List<Integer> list = new ArrayList<>();
            list.addAll(tempList);
            result.add(list);
        }

        if (root.left != null) {
            pathSum(root.left, targetSum, result, tempList);
        }
        if (root.right != null) {
            pathSum(root.right, targetSum, result, tempList);
        }
        tempList.remove(tempList.size() - 1);
    }
}
