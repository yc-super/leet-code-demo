package LeetCode_Hot100.矩阵置零;

public class Solution {
    public static void main(String[] args) {
        int[][] array={{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        new Solution().setZeroes2(array);
    }

    public void setZeroes(int[][] matrix) {
        boolean[] m = new boolean[matrix.length];
        boolean[] n = new boolean[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    m[i] = true;
                    n[j] = true;
                }
            }
        }
        for (int i = 0; i < m.length; i++) {
            if (m[i]) {
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < n.length; i++) {
            if (n[i]) {
                for (int j = 0; j < matrix.length; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
    }


    public void setZeroes2(int[][] matrix) {
        boolean m=false;
        boolean n=false;
        for (int i = 0; i < matrix[0].length; i++) {
            if(matrix[0][i]==0){
                m=true;
                break;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            if(matrix[i][0]==0){
                n=true;
                break;
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }
        //利用第一行处理其他列
        for (int i = 1; i < matrix[0].length; i++) {
            if(matrix[0][i]==0){
                for (int j = 1; j < matrix.length; j++) {
                    matrix[j][i]=0;
                }
            }
        }
        //利用第一列处理其他行
        for (int i = 1; i < matrix.length; i++) {
            if(matrix[i][0]==0){
                for (int j = 1; j < matrix[0].length; j++) {
                    matrix[i][j]=0;
                }
            }
        }
        //处理第一行
        if(m){
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i]=0;
            }
        }
        //处理第一列
        if(n){
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0]=0;
            }
        }
    }
}
