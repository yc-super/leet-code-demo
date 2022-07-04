package 代码随想录.数组专练.螺旋矩阵II;

public class code {
    public static void main(String[] args) {
        int n=5;
       /*   [1,2,3],
            [8,9,4],
            [7,6,5]
            */
        /*
        * 4
        * 1,2,3,4
        *       5
        *       6
        *10,9,8,7
        * */
        int[][] reslut=new code().generateMatrix2(n);
        for(int[]a:reslut){
            for(int b:a){
                System.out.print(b+",");
            }
            System.out.println();
        }
    }
    public int[][] generateMatrix(int n) {
        int[][] result=new int[n][n];
        int a=0,b=-1;
        int right=n-1,down=n-1,left=0,top=1;
        int i=1;
        int c=0;
        int d=1;
        while(i<=n*n){
            if(a==1&&b==3){
//                System.out.print(111);
            }
            a+=c;
            b+=d;
            result[a][b]=i++;
            if(b==right&&a==top-1){
                c=1;
                d=0;
                right--;
            }else if(a==down&&b==right+1){
                c=0;
                d=-1;
                down--;
            }else if(b==left&&a==down+1){
                c=-1;
                d=0;
                left++;
            }else if(a==top&&b==left-1){
                c=0;
                d=1;
                top++;
            }
        }
        return result;
    }

    //代码随想录，答案。想法一样，效率比我高
    public int[][] generateMatrix2(int n) {
        int[][] res = new int[n][n];

        // 循环次数
        int loop = n / 2;

        // 定义每次循环起始位置
        int startX = 0;
        int startY = 0;

        // 定义偏移量
        int offset = 1;

        // 定义填充数字
        int count = 1;

        // 定义中间位置
        int mid = n / 2;
        while (loop > 0) {
            int i = startX;
            int j = startY;

            // 模拟上侧从左到右
            for (; j<startY + n -offset; ++j) {
                res[startX][j] = count++;
            }

            // 模拟右侧从上到下
            for (; i<startX + n -offset; ++i) {
                res[i][j] = count++;
            }

            // 模拟下侧从右到左
            for (; j > startY; j--) {
                res[i][j] = count++;
            }

            // 模拟左侧从下到上
            for (; i > startX; i--) {
                res[i][j] = count++;
            }

            loop--;

            startX += 1;
            startY += 1;

            offset += 2;
        }

        if (n % 2 == 1) {
            res[mid][mid] = count;
        }

        return res;
    }
}
