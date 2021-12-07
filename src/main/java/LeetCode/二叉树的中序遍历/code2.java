package LeetCode.二叉树的中序遍历;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
//方法2，迭代，
//时间复杂度：O(n),空间复杂度：O(n)
public class code2 {
    public static void main(String[] args) {
        //[1,null,2,3]
        TreeNode root = new TreeNode(1,null,new TreeNode(2,new TreeNode(3,null,null),null));
//        TreeNode root=new TreeNode(1);
//        TreeNode root=new TreeNode();
        System.out.println(new code2().inorderTraversal(root));
    }
    //简言之就是先放到栈中，再取出来
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        Deque<TreeNode> deque=new LinkedList<>();
        while(root!=null||!deque.isEmpty()){
            while(root!=null){
                deque.push(root);
                root=root.left;
            }
            root=deque.pop();
            list.add(root.val);
            root=root.right;
        }
        return list;
    }


}
