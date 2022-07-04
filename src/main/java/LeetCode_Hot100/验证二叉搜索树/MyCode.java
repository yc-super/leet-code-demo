package LeetCode_Hot100.验证二叉搜索树;

//第一种思路行不通，不能一直记录父节点、父父节点的值，不能一直记录是从左边来的还是右边来的
public class MyCode {
    public static void main(String[] args) {
//        TreeNode node=new TreeNode(2,null,null);
        TreeNode node=new TreeNode(2,new TreeNode(1),new TreeNode(3));
//        TreeNode node=new TreeNode(5,new TreeNode(1),new TreeNode(6,new TreeNode(3,new TreeNode(2),new TreeNode(4)),new TreeNode(7)));
//        TreeNode node=new TreeNode(5,new TreeNode(4),new TreeNode(6,new TreeNode(3),new TreeNode(7)));
//        Integer[] a={5,4,6,null,null,3,7};
//        Integer[] a={5,0,10,-2,3,7,12,-4,-1,2,4,6,8,11,13};
        Integer[] a={120,70,140,50,100,130,160,20,55,75,110,119,135,150,200};
//        TreeNode node=new TreeNode(5,new TreeNode(0,new TreeNode(-2,new TreeNode(-4),new TreeNode(-1)),new TreeNode(3,new TreeNode(2),new TreeNode(4))),new TreeNode(10,new TreeNode(7,new TreeNode(6),new TreeNode(8)),new TreeNode(12,new TreeNode(9),new TreeNode(13))));
        boolean validBST = new MyCode().isValidBST(node);
        System.out.println(validBST);
    }


    boolean flag=true;
    public boolean isValidBST(TreeNode root) {
        isValidBST2(root,root,null,0);
        return flag;
    }
    private void isValidBST2(TreeNode first,TreeNode root,TreeNode parent ,int lr){
        if(!flag)
            return ;
        if(root==null)
            return;
        if(root.left!=null){
            if(root.val<=root.left.val) {
                flag=false;
                return;
            }
            if(parent!=null) {
                if(parent.val< first.val){
                    if (root.left.val >= parent.val) {
                        flag = false;
                        return;
                    }
                }else{
                    if (root.left.val <= parent.val) {
                        flag = false;
                        return;
                    }
                }
                if(lr==0) {
                    if (root.left.val >= parent.val) {
                        flag = false;
                        return;
                    }
                }else{
                    if (root.left.val <= parent.val) {
                        flag = false;
                        return;
                    }
                }
            }
        }
        if(root.right!=null){
            if(root.val>=root.right.val){
                flag=false;
                return;
            }
            if(parent!=null) {
                if(parent.val< first.val){
                    if (root.right.val >= parent.val) {
                        flag = false;
                        return;
                    }
                }else{
                    if (root.right.val <= parent.val) {
                        flag = false;
                        return;
                    }
                }
                if (lr == 0) {
                    if (root.right.val >= parent.val) {
                        flag = false;
                        return;
                    }
                } else {
                    if (root.right.val <= parent.val) {
                        flag = false;
                        return;
                    }
                }
            }
        }
        if(root.left!=null) {
            isValidBST2(first,root.left,root,0);
        if(root.right!=null)
            isValidBST2(first,root.right,root,1);
        }
    }
    
}
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
