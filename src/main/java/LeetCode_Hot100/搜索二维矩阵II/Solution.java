package LeetCode_Hot100.搜索二维矩阵II;

public class Solution {
    public static void main(String[] args) {
        int[][] mm = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
//        int[][] mm={{1},{3},{5}};
        System.out.println(new Solution().searchMatrix(mm, 15));
    }

    //有序数组，就要立马想到二分法啊。
    //这道题是从左上角开始，左上角大于全部左边的，小于全部下边的，相当于二分法中的中间值
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = 0, n = matrix[0].length - 1;
        while (m < matrix.length && n >= 0) {
            if (matrix[m][n] == target)
                return true;
            if (matrix[m][n] < target) {
                m++;
            } else {
                n--;
            }
        }
        return false;
    }
}
