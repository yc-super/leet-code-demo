package LeetCode.二叉树的序列化与反序列化;

import 代码随想录.二叉树.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;

public class Solution {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return seri(root, "");
    }

    private String seri(TreeNode root, String str) {
        if (root == null) {
            str += "None,";
        } else {
            str += root.val + ",";
            str = seri(root.left, str);
            str = seri(root.right, str);
        }
        return str;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] array = data.split(",");
        LinkedList<String> list = new LinkedList<>(Arrays.asList(array));
        return deseri(list);
    }

    private TreeNode deseri(LinkedList<String> list) {
        if (list.get(0).equals("None")) {
            list.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(list.get(0)));
        list.remove(0);
        root.left = deseri(list);
        root.right = deseri(list);
        return root;
    }
}
