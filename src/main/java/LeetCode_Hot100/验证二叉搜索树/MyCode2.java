package LeetCode_Hot100.验证二叉搜索树;

import java.util.ArrayList;
import java.util.List;

//思路2：从树状图形来看，把所有数据都“落到地上”，再去检查是否从小到大排序即可，“落”的过程估计要用递归，然后用一个list存储
public class MyCode2 {
    public static void main(String[] args) {
//        TreeNode node=new TreeNode(2,null,null);
//        TreeNode node=new TreeNode(2,new TreeNode(1),new TreeNode(3));
//        TreeNode node=new TreeNode(5,new TreeNode(1),new TreeNode(6,new TreeNode(3,new TreeNode(2),new TreeNode(4)),new TreeNode(7)));
//        TreeNode node=new TreeNode(5,new TreeNode(4),new TreeNode(6,new TreeNode(3),new TreeNode(7)));
//        Integer[] a={5,4,6,null,null,3,7};
//        Integer[] a={5,0,10,-2,3,7,12,-4,-1,2,4,6,8,11,13};
        Integer[] a={120,70,140,50,100,130,160,20,55,75,110,119,135,150,200};
        TreeNode node=new TreeNode(5,new TreeNode(0,new TreeNode(-2,new TreeNode(-4),new TreeNode(-1)),new TreeNode(3,new TreeNode(2),new TreeNode(4))),new TreeNode(10,new TreeNode(7,new TreeNode(6),new TreeNode(8)),new TreeNode(12,new TreeNode(11),new TreeNode(13))));
        boolean validBST = new MyCode2().isValidBST(node);
        System.out.println(validBST);
    }


    List<Integer> list;
    public boolean isValidBST(TreeNode root) {
        list=new ArrayList<>();
        addVal(root);
        boolean flag=true;
        int a=list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if(list.get(i)<=a){
                flag=false;
                break;
            }
            a=list.get(i);
        }
        return flag;
    }
    private void addVal(TreeNode root) {
        if(root.left==null&&root.right==null){
            list.add(root.val);
            return;
        }
        if(root.left!=null)
            addVal(root.left);
        list.add(root.val);
        if(root.right!=null){
            addVal(root.right);
        }
    }
}
