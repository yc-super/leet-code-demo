package Hot100.验证二叉搜索树;

public class code1 {
    public static void main(String[] args) {
//        TreeNode node=new TreeNode(2,null,null);
        TreeNode node=new TreeNode(2,new TreeNode(1),new TreeNode(3));
//        TreeNode node=new TreeNode(5,new TreeNode(1),new TreeNode(6,new TreeNode(3,new TreeNode(2),new TreeNode(4)),new TreeNode(7)));
//        TreeNode node=new TreeNode(5,new TreeNode(4),new TreeNode(6,new TreeNode(3),new TreeNode(7)));
//        Integer[] a={5,4,6,null,null,3,7};
//        Integer[] a={5,0,10,-2,3,7,12,-4,-1,2,4,6,8,11,13};
        Integer[] a={120,70,140,50,100,130,160,20,55,75,110,119,135,150,200};
//        TreeNode node=new TreeNode(5,new TreeNode(0,new TreeNode(-2,new TreeNode(-4),new TreeNode(-1)),new TreeNode(3,new TreeNode(2),new TreeNode(4))),new TreeNode(10,new TreeNode(7,new TreeNode(6),new TreeNode(8)),new TreeNode(12,new TreeNode(11),new TreeNode(13))));
        boolean validBST = new code1().isValidBST(node);
        System.out.println(validBST);
    }

    long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 访问左子树
        if (!isValidBST(root.left)) {
            return false;
        }
        // 访问当前节点：如果当前节点小于等于中序遍历的前一个节点，说明不满足BST，返回 false；否则继续遍历。
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;
        // 访问右子树
        return isValidBST(root.right);
    }
}
