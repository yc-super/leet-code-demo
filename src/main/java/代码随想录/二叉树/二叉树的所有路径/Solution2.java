package 代码随想录.二叉树.二叉树的所有路径;

import 代码随想录.二叉树.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

public class Solution2 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        binary(list, root);
        return result;
    }

    private void binary(List<String> list, TreeNode root) {
        if (root.left == null && root.right == null) {
            list.add(root.val + "");
            StringJoiner joiner = new StringJoiner("->");
            for (String ss : list) {
                joiner.add(ss);
            }
            result.add(joiner.toString());
            list.remove(list.size() - 1);
            return;
        }
        list.add(root.val + "");
        if (root.left != null)
            binary(list, root.left);
        if (root.right != null)
            binary(list, root.right);
        list.remove(list.size() - 1);
    }

    List<String> result = new ArrayList<>();

    private void binary2(List<Integer> list, TreeNode root) {
        list.add(root.val);
        if(root.left==null&&root.right==null){
            StringBuilder sb=new StringBuilder();
            int i;
            for (i = 0; i < list.size()-1; i++) {
                sb.append(list.get(i)+"->");
            }
            sb.append(list.get(i));
            result.add(sb.toString());
            return;
        }
        if(root.left!=null){
            binary2(list,root.left);
            list.remove(list.size()-1);
        }
        if(root.right!=null){
            binary2(list,root.right);
            list.remove(list.size()-1);
        }
    }

}
