package LeetCode_Hot100.旋转图像;

class Solution {
    public static void main(String[] args) {
        int[][] matrix = {
                {15,13,2,5},
                {14,3,4,1},
                {12,6,8,9},
                {16,7,10,11}};
//        int[][] matrix = {{1,2},{3,4}};
        new Solution().rotate(matrix);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] matrix_new = new int[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                matrix_new[j][n - i - 1] = matrix[i][j];
            }
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                matrix[i][j] = matrix_new[i][j];
            }
        }
    }
}
