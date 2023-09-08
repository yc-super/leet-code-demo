package LeetCode.序列化和反序列化二叉搜索树;

import org.springframework.util.StringUtils;
import 代码随想录.二叉树.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postOrder(root, list);
        String str = list.toString();
        return str.substring(1, str.length() - 1);
    }

    private void postOrder(TreeNode root, List<Integer> list) {
        if (root == null)
            return;
        postOrder(root.left, list);
        postOrder(root.right, list);
        list.add(root.val);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.isEmpty())
            return null;
        String[] array = data.split(", ");
        return constructTreeNode(array, 0, array.length - 1);
    }

    private TreeNode constructTreeNode(String[] array, int left, int right) {
        if (left > right)
            return null;
        if (left == right)
            return new TreeNode(Integer.valueOf(array[left]));
        TreeNode root = new TreeNode(Integer.valueOf(array[right]));
        int i;
        for (i = left; i <= right; i++) {
            if (Integer.valueOf(array[i]) >= Integer.valueOf(array[right])) {
                break;
            }
        }
        root.left = constructTreeNode(array, left, i - 1);
        root.right = constructTreeNode(array, i, right - 1);
        return root;
    }
}
