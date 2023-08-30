package 代码随想录.二叉树.前中后序遍历.二叉树的前序遍历;

import 代码随想录.二叉树.TreeNode;

import java.util.ArrayList;
import java.util.List;

//迭代法
public class Solution3 {
    //前序
    public void pre(TreeNode node) {
        if (node == null)
            return;
        System.out.println(node.val);
        pre(node.left);
        pre(node.right);
    }

    //中序
    public void middle(TreeNode node) {
        if (node == null)
            return;
        middle(node.left);
        System.out.println(node.val);
        middle(node.right);
    }

    //后序
    public void post(TreeNode node) {
        if (node == null)
            return;
        post(node.left);
        post(node.right);
        System.out.println(node.val);
    }
}
