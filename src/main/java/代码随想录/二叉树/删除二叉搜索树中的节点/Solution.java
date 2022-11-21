package 代码随想录.二叉树.删除二叉搜索树中的节点;

import 代码随想录.二叉树.TreeNode;

public class Solution {
    //迭代遍历二叉搜索树，记录cur和parent节点，找到val相同的节点后，把cur.right（也可cur.left，选其一）
    // 赋值给parent的left或者right（由flag来记录cur是parent的left还是right）
    //我这里和下面代码随想录递归的方法中，最大的区别是我用flag来记录cur是parent的左节点还是右节点，而下面这种方法通过递归，不需要记录
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;
        TreeNode tempParent = new TreeNode();
        tempParent.left = root;
        TreeNode cur = root;
        TreeNode parent = tempParent;
        int flag = 0;
        while (cur != null) {
            if (cur.val > key) {
                parent = cur;
                cur = cur.left;
                flag = 0;
            } else if (cur.val < key) {
                parent = cur;
                cur = cur.right;
                flag = 1;
            } else {
                //二叉搜索树中包含该key
                if (cur.right == null) {
                    if (flag == 0) {
                        parent.left = cur.left;
                    } else {
                        parent.right = cur.left;
                    }
                } else if (cur.left == null) {
                    if (flag == 0) {
                        parent.left = cur.right;
                    } else {
                        parent.right = cur.right;
                    }
                } else {
                    if (flag == 0) {
                        parent.left = cur.right;
                    } else {
                        parent.right = cur.right;
                    }
                    TreeNode left = cur.left;
                    cur = cur.right;
                    while (cur.left != null) {
                        cur = cur.left;
                    }
                    cur.left = left;
                }
                break;
            }
        }
        return tempParent.left;
    }

    //    递归法（代码随想录），通过递归，不用通过flag记录cur是parent的左子树还是右子树，也不用记录parent
    public TreeNode deleteNode2(TreeNode root, int key) {
        if (root == null)
            return null;
        if (root.val > key) {
            root.left = deleteNode2(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode2(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null)
                return root.left;

            //左右子树都不为空
            TreeNode temp = root.right;
            while (temp.left != null) {
                temp = temp.left;
            }
            temp.left = root.left;
            return root.right;
        }
        return root;
    }

}
