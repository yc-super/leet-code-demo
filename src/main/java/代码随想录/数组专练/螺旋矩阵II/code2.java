package 代码随想录.数组专练.螺旋矩阵II;

public class code2 {
    /*
     *  1  2  3  4
     * 12 13 14  5
     * 11 16 15  6
     * 10  9  8  7
     * */
    public static int[][] generateMatrix(int n) {
        int count = n * n;
        int value = 1;
        int status = 1;//1,从左到右，2从上到下，3从右到左，4从下到上
        int[][] result = new int[n][n];
        int x = 0, y = 0;
        while (count != 0) {
            if (status == 1) {
                result[x][y++] = value;
                if (y == n || result[x][y] != 0) {
                    x++;
                    y--;
                    status = 2;
                }
            } else if (status == 2) {
                result[x++][y] = value;
                if (x == n || result[x][y] != 0) {
                    y--;
                    x--;
                    status = 3;
                }
            } else if (status == 3) {
                result[x][y--] = value;
                if (y == -1 || result[x][y] != 0) {
                    x--;
                    y++;
                    status = 4;
                }
            } else {
                result[x--][y] = value;
                if (result[x][y] != 0) {
                    y++;
                    x++;
                    status = 1;
                }
            }
            count--;
            value++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] result=generateMatrix(4);
        System.out.println();
    }
}
