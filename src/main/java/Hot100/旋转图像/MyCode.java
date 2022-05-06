package Hot100.旋转图像;

public class MyCode {
    /*

输入：matrix =
[
[5,1,9,11],
[2,4,8,10],
[13,3,6,7],
[15,14,12,16]]
输出：
[
[15,13,2,5],
[14,3,4,1],
[12,6,8,9],
[16,7,10,11]]
*/
    public static void main(String[] args) {
        /*int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9}};*/
        /*int[][] matrix = {
                {15,13,2,5},
                {14,3,4,1},
                {12,6,8,9},
                {16,7,10,11}};*/
        int[][] matrix = {{1,2},{3,4}};
        new MyCode().rotate(matrix);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }

    }
    /*
    * [
[15,13,2,5],
[14,3,4,1],
[12,6,8,9],
[16,7,10,11]]
    * */
    public void rotate(int[][] matrix) {
        int len=matrix.length;
        int count=len/2;
        int[] index=new int[len];
        for (int i = 0; i < count; i++) {//i,i开始
            for (int j = i; j < len-i-1; j++) {
                index[j]=matrix[i][j];
                matrix[i][j]=matrix[len-1-j][i];
                matrix[len-1-j][i]=matrix[len-1-i][len-1-j];
                matrix[len-1-i][len-1-j]=matrix[j][len-1-i];
                matrix[j][len-1-i]=index[j];
            }
        }
    }
}
