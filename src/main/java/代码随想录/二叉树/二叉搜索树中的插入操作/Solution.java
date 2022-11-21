package 代码随想录.二叉树.二叉搜索树中的插入操作;

import 代码随想录.二叉树.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    //节点全部重新new出来的，效率果然极其低下
    public TreeNode insertIntoBST(TreeNode root, int val) {
//        insert(root,val);
//        return root;

        TreeNode insertNode = new TreeNode(val);
        if (root == null) {
            return insertNode;
        }
        List<Integer> list = new ArrayList<>();
        getList(root, val, list);


        int index = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > val) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            index = list.size();
        }

        TreeNode temp = insertNode;
        for (int i = index - 1; i >= 0; i--) {
            TreeNode node = new TreeNode(list.get(i));
            temp.left = node;
            temp = node;
        }
        temp = insertNode;
        for (int i = index; i < list.size(); i++) {
            TreeNode node = new TreeNode(list.get(i));
            temp.right = node;
            temp = node;
        }
        return insertNode;
    }


    private void getList(TreeNode root, int val, List<Integer> list) {
        if (root == null)
            return;

        getList(root.left, val, list);

        list.add(root.val);

        getList(root.right, val, list);
    }

    //代码随想录，递归法（带返回值，其实也可不带返回值，稍微麻烦些）
    public TreeNode insertIntoBST2(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (root.val > val)
            root.left = insertIntoBST2(root.left, val);

        if (root.val < val)
            root.right = insertIntoBST2(root.right, val);

        return root;
    }


    //代码随想录，迭代法
    public TreeNode insertIntoBST3(TreeNode root, int val) {
        TreeNode node = new TreeNode(val);
        if (root == null)
            return node;
        TreeNode cur = root;
        TreeNode parent = root;
        while (cur != null) {
            parent = cur;
            if (cur.val > val) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        if (parent.val > val) {
            parent.left = node;
        } else {
            parent.right = node;
        }
        return root;
    }

    public TreeNode insertIntoBST4(TreeNode root, int val) {
        TreeNode node = new TreeNode(val);
        if(root==null)
            return node;

        TreeNode cur=root;
        TreeNode parent=root;
        while(cur!=null){
            parent=cur;
            if(cur.val>val) {
                cur = cur.left;
            }else {
                cur=cur.right;
            }
        }
        if(parent.val>val) {
            parent.left=node;
        }else {
            parent.right=node;
        }
        return root;
    }
}
