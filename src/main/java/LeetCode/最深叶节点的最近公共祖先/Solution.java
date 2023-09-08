package LeetCode.最深叶节点的最近公共祖先;

import 代码随想录.二叉树.TreeNode;
import 代码随想录.二叉树.TreeNodeUtils;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    //    public static void main(String[] args) {
//        Integer[] in=new Integer[]{1,2,3,6,7,4,5};
//        TreeNode treeNode = TreeNodeUtils.getTreeNode(in);
//        TreeNode treeNode1 = new Solution().lcaDeepestLeaves(treeNode);
//        System.out.println();
//    }
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        lca(root, new ArrayList<>(), 0);
        int length = lists.get(0).size();
        TreeNode result = null;
        for (int i = 0; i < length; i++) {
            int temp = lists.get(0).get(i).val;
            boolean flag = true;
            for (int j = 1; j < lists.size(); j++) {
                if (temp != lists.get(j).get(i).val) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                result = lists.get(0).get(i);
            } else {
                break;
            }
        }
        return result;
    }

    private void lca(TreeNode root, List<TreeNode> list, int depth) {
        list.add(root);
        if (root.left != null) {
            lca(root.left, list, depth + 1);
            list.remove(list.size() - 1);
        }
        if (root.left == null && root.right == null) {
            if (depth > maxDepth) {
                lists.clear();
                lists.add(new ArrayList<>(list));
                maxDepth = depth;
            } else if (depth == maxDepth) {
                lists.add(new ArrayList<>(list));
            }
        }

        if (root.right != null) {
            lca(root.right, list, depth + 1);
            list.remove(list.size() - 1);
        }
    }

    private List<List<TreeNode>> lists = new ArrayList<>();
    private int maxDepth = -1;


    public TreeNode lcaDeepestLeaves2(TreeNode root) {
        lcade(root, 0);
        return resultNode;
    }

    private int lcade(TreeNode root, int depth) {
        if (root == null) {
            maxDepth = Math.max(maxDepth, depth);
            return depth;
        }
        int leftDepth = lcade(root.left, depth + 1);
        int rightDepth = lcade(root.right, depth + 1);

        if (leftDepth == rightDepth && leftDepth == maxDepth) {
            resultNode = root;
        }

        return Math.max(leftDepth, rightDepth);
    }

    private TreeNode resultNode = null;
}
