package 剑指offer.子结构判断;

import 代码随想录.二叉树.TreeNode;

/*dfs
* 从这里看出我对dfs已经非常熟悉了
* */
public class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A==null&&B==null)
            return false;
        if(B==null)
            return false;
        myDfs(A,B);
        return res;
    }

    private void myDfs(TreeNode a, TreeNode b) {
        if(a==null||b==null)
            return;
        if(a.val==b.val)
            res=method1(a,b);

        if(res)
            return;

        myDfs(a.left,b);
        myDfs(a.right,b);
    }

    private boolean method1(TreeNode a, TreeNode b) {
        if(a==null){
            return b == null;
        }
        if(b==null){
            return true;
        }
        if(a.val!=b.val)
            return false;
        return method1(a.left,b.left)&&method1(a.right,b.right);
    }

    boolean res=false;
}
