package 代码随想录.二叉树.二叉树的最近公共祖先;

import 代码随想录.二叉树.TreeNode;
import 代码随想录.二叉树.TreeNodeUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
//        Integer[] nodes = {3, 5, 1, 6, 2, 0, 8, null, null, 7, 4};
        Integer[] nodes = {3, 5, 1, 6, 2, 0, 8, null, null, 7, 4};
        TreeNode root = TreeNodeUtils.getTreeNode(nodes);

        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(4);

        TreeNode treeNode = new Solution().lowestCommonAncestor3(root, p, q);
        System.out.println();

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> list1 = new ArrayList<>();
        getList(root, p, list1);
        List<TreeNode> list2 = new ArrayList<>();
        getList(root, q, list2);

        for (int i = list1.size() - 1; i >= 0; i--) {
            if (list2.contains(list1.get(i)))
                return list1.get(i);
        }
        return list1.get(0);
    }

    private void getList(TreeNode root, TreeNode p, List<TreeNode> list) {
        if (root == null)
            return;

        list.add(root);

        if (root.val == p.val) {
            return;
        }

        if (list.get(list.size() - 1).val != p.val)
            getList(root.left, p, list);
        if (list.get(list.size() - 1).val != p.val)
            getList(root.right, p, list);

        if (list.get(list.size() - 1).val != p.val)
            list.remove(list.size() - 1);

    }


    //代码随想录，后序遍历
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)
            return root;

        TreeNode node1 = lowestCommonAncestor3(root.left, p, q);
        TreeNode node2 = lowestCommonAncestor3(root.right, p, q);

        if (node1 == null && node2 == null) {
            return null;
        } else if (node1 != null && node2 == null) {
            return node1;
        } else if (node1 == null && node2 != null) {
            return node2;
        } else {
            return root;
        }
    }
}
