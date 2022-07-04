package LeetCode_Hot100.二叉树展开为链表;

import 树.TreeNode;
import 树.遍历.TraverseUtil;

import java.util.ArrayList;
import java.util.List;

//官方答案1，前序遍历，同时用list存储元素，最后遍历list，将left置空，right设置成下一个
public class code {
    public static void main(String[] args) {
        TreeNode node=new TreeNode(5,new TreeNode(0,new TreeNode(-2,new TreeNode(-4),new TreeNode(-1)),new TreeNode(3,new TreeNode(2),new TreeNode(4))),
                new TreeNode(10,new TreeNode(7,new TreeNode(6),new TreeNode(8)),new TreeNode(12,new TreeNode(11),new TreeNode(13))));
        //[1,null,2,3]
//        TreeNode node = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
//        TreeNode node = new TreeNode(1, new TreeNode(2, null, null), new TreeNode(3));
        new code().flatten(node);

        TraverseUtil.preTraverse(node);
        System.out.println();
        TraverseUtil.midTraverse(node);
        System.out.println();
    }
        public void flatten(TreeNode root) {
            if(root==null)
                return;
            List<TreeNode> list=new ArrayList<>();
            preTravserse(list,root);
            for (int i = 1; i < list.size(); i++) {
                TreeNode pre=list.get(i-1),now=list.get(i);
                pre.left=null;
                pre.right=now;
            }
        }

        private void preTravserse(List<TreeNode> list, TreeNode root) {
            if(root==null)
                return;
            list.add(root);
            preTravserse(list,root.left);
            preTravserse(list,root.right);
        }
}
