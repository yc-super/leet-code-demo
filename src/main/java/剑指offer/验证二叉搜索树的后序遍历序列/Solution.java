package 剑指offer.验证二叉搜索树的后序遍历序列;

public class Solution {
    // 分治法+利用后序遍历的特点（即最后一个是根节点）
    public boolean verifyTreeOrder(int[] postorder) {
        if (postorder.length == 1)
            return true;
        return myMethod(postorder, 0, postorder.length - 1);
    }

    private boolean myMethod(int[] postorder, int left, int right) {
        if (right <= left)
            return true;
        // 找到第一个比根节点大的下标
        int i;
        for (i = left; i < right; i++) {
            if (postorder[i] > postorder[right])
                break;
        }
        // 判断i之后的所有元素是否也都大于根节点，不是的话返回false
        for (int j = i+1; j < right; j++) {
            if(postorder[j]<postorder[right])
                return false;
        }
        return myMethod(postorder, left, i - 1) && myMethod(postorder, i, right - 1);
    }
}