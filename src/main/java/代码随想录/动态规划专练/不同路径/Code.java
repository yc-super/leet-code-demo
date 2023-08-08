package 代码随想录.动态规划专练.不同路径;
//思考：前面两道题没做出来，都是卡在了递推公式，原因是不能总结出规律，不能倒推出来
/*
* 可以这么想，到达目的地的前一步一共有两种情况：
* 1.从上往下走一步，到达目的地
* 2.从左往右走一步，到达目的地
* 一共走m+n步
* 那么可以:
* //1.定义动态数组dp[i],i代表走的第几步，dp[i]代表走到当前点有多少种走法，那么dp[m+n]就是最终答案
* 1.定义动态数组dp[i][j],i和j代表下标，dp[i][j]的值代表从起点到i,j这个位置有多少种走法
* 2.dp[i][j]=dp[i-1][j]+dp[i][j-1]
* 3.初始化：dp[0][0]=1,dp[0][1]=1,dp[1][0]=1,dp[1][1]=2,
* dp[0][2]=1
* dp[1][2]=3
* 4.确定遍历顺序：从前往后
* 5.举例推导dp数组
* */
public class Code {
    public static void main(String[] args) {
//        int m=3,n=7;
//        int m=7,n=3;
//        int m=3,n=3;
        int m=2,n=4;
        int num=uniquePaths(m,n);
        System.out.println(num);
    }
    public static int uniquePaths(int m, int n) {
        int[][] dp=new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0]=1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i]=1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }





















    //动态规划
    public int uniquePaths2(int m, int n) {
        //1.k,j代表格子的具体位置，dp[k][j]代表到此位置有多少路径
        int[][] dp=new int[m][n];
        //2.确定递推公式
//        dp[k][j]=dp[k-1][j]+dp[k][j-1];
        //3.初始化
        for (int i = 0; i < n; i++) {
            dp[0][i]=1;
        }
        for (int i = 1; i < m; i++) {
            dp[i][0]=1;
        }
        //4.顺序：从前到后
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        //5.举例推导
        return dp[m-1][n-1];
    }
}
