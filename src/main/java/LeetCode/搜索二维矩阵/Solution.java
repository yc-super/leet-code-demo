package LeetCode.搜索二维矩阵;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int l = 0, r = m * n - 1;
        int middle = 0;
        while (l <= r) {
            middle = (l + r) >>> 1;
            int x = matrix[middle / n][middle % n];
            if (x == target) {
                return true;
            } else if (x < target) {
                l = middle + 1;
            } else {
                r = middle - 1;
            }
        }
        return false;
    }
}
