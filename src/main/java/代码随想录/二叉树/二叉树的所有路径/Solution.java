package 代码随想录.二叉树.二叉树的所有路径;

import 代码随想录.二叉树.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    //思路：前序遍历
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null)
            return result;
        getPath(root, "", result);
        return result;
    }

    private void getPath(TreeNode root, String str, List<String> result) {
        if (root.left == null && root.right == null) {
            result.add(str + root.val);
        }
        str = str + root.val + "->";
        if (root.left != null)
            getPath(root.left, str, result);
        if (root.right != null)
            getPath(root.right, str, result);
    }

    //代码随想录，引入一个LIst，避免字符串频繁创建。此时也变成了回溯
    public List<String> binaryTreePaths1(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null)
            return result;
        List<Integer> paths = new ArrayList<>();
        getPath2(root, paths, result);
        return result;

    }

    private void getPath2(TreeNode root, List<Integer> paths, List<String> result) {
        if (root.left == null && root.right == null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < paths.size() ; i++) {
                sb.append(paths.get(i)).append("->");
            }
            sb.append(root.val);
            result.add(sb.toString());
        }
        paths.add(root.val);
        if (root.left != null) {
            getPath2(root.left, paths, result);
            paths.remove(paths.size() - 1);
        }
        if (root.right != null) {
            getPath2(root.right, paths, result);
            paths.remove(paths.size() - 1);
        }
    }
}
