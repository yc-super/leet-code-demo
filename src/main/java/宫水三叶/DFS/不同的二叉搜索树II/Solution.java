package 宫水三叶.DFS.不同的二叉搜索树II;

import 代码随想录.二叉树.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().generateTrees(4));
    }

    /*
     * 三叶姐的题解
     * */
    public List<TreeNode> generateTrees(int n) {
        return backTrack(1, n);
    }

    private List<TreeNode> backTrack(int start, int end) {
        if (start > end) {
            return new ArrayList<TreeNode>() {{
                add(null);
            }};
        }

        List<TreeNode> ans = new ArrayList<>();

        for (int i = start; i <= end; i++) {
            List<TreeNode> lList = backTrack(start, i - 1);
            List<TreeNode> rList = backTrack(i + 1, end);
            for (TreeNode l : lList) {
                for (TreeNode r : rList) {
                    TreeNode node = new TreeNode(i);
                    node.left = l;
                    node.right = r;
                    ans.add(node);
                }
            }
        }

        return ans;
    }


    /*
     * 我的题解，差一步，没通过
     * */
    List<TreeNode> ans;
    int num = 1;

    public List<TreeNode> generateTrees2(int n) {
        ans = new ArrayList<>();
        TreeNode root = new TreeNode();
        myDFS(root, root, n - 1);
        return ans;
    }

    private void myDFS(TreeNode treeNode, TreeNode root, int count) {
        if (count == 0) {
//            treeNode=new TreeNode();
            // 根据root复制一个二叉搜索树
            TreeNode node = new TreeNode();
            copyTreeNode(root, node);
            num = 1;
            myTreeNode(node);
            ans.add(node);
            return;
        }
        treeNode.left = new TreeNode();
        myDFS(treeNode.left, root, count - 1);
        treeNode.left = null;
        treeNode.right = new TreeNode();
        myDFS(treeNode.right, root, count - 1);
        treeNode.right = null;
        if (count > 1) {
            treeNode.left = new TreeNode();
            treeNode.right = new TreeNode();
            myDFS(treeNode.left, root, count - 2);
            if (count > 2) {
                myDFS(treeNode.right, root, count - 2);
            }
            treeNode.left = null;
            treeNode.right = null;
        }
    }

    private void myTreeNode(TreeNode node) {
        if (node == null)
            return;

        myTreeNode(node.left);

        node.val = num++;

        myTreeNode(node.right);
    }

    private void copyTreeNode(TreeNode root, TreeNode node) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            node.left = new TreeNode();
        }
        if (root.right != null) {
            node.right = new TreeNode();
        }
        copyTreeNode(root.left, node.left);
        copyTreeNode(root.right, node.right);
    }
}
