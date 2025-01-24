package 剑指offer.二维数组中的查找;

// 考察对二分法的掌握程度
// 实际每个下标的值，都是该下标所在行左边、该下标所在列下面的中间的值，
// 比较是否和该下标大小，相等直接返回，小于则往该下标所在行左移一位，大于则往该下标所在列下移一位
public class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix.length==0||matrix[0].length==0)
            return false;
        int m=0,n=matrix[0].length-1;
        while(m<matrix.length&&n>=0){
            if(matrix[m][n]==target){
                return true;
            }else if (matrix[m][n]<target){
                // 往下走
                m++;
            }else {
                // 往左走
                n--;
            }
        }

        return false;
    }
}
